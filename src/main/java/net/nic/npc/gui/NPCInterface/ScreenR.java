package net.nic.npc.gui.NPCInterface;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.nic.npc.entity.customEntity.npc.NPC;
import net.nic.npc.kingdom.vars.TradeEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class ScreenR extends AbstractContainerScreen<MenuR> {

    public static String recruitBuy = "npc.gui.trading.buy";
    public static String recruitRecruit = "gui.npc.menur.recruit";
    public static String recruitDismiss = "gui.npc.menur.dismiss";


    private Button recruitButton;
    private Button dismissButton;
    private Button startTradeButton;
    private Button buyButton;
    NPC npc = this.menu.getNpc();
    private final List<Button> tradeButtons = new ArrayList<>();
    private TradeEntry selectedTrade;

    public ScreenR(MenuR menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();


        if (!npc.isRecruited) {
            initRecruit();
        } else if (npc.getLvl() == 0) {
            this.startTradeButton = Button.builder(Component.literal("Start"), btn -> {
                npc.addLvl();
                clearTradeButtons();
                showTrades();
            }).size(70, 20).pos((width / 2) - 120, (height / 2) + 20).build();

            this.addRenderableWidget(startTradeButton);
        } else {
            showTrades();
        }
    }

    private void clearTradeButtons() {
        for (Button b : tradeButtons) {
            this.removeWidget(b);
        }
        tradeButtons.clear();

        if (buyButton != null) {
            this.removeWidget(buyButton);
            buyButton = null;
        }
    }

    private void showTrades() {
        clearTradeButtons();
        this.removeWidget(startTradeButton); //todo remove
        NPC npc = this.menu.getNpc();
        int startX = width / 8;
        int startY = height / 4;
        int yOffset = 0;

        for (TradeEntry trade : npc.allTrades) {
            int y = startY + yOffset;

            // Arrow button to select the trade
            Button selectButton = Button.builder(Component.literal("→"), btn -> {
                this.selectedTrade = trade;
                if (buyButton != null) {
                    buyButton.active = canAfford(trade);
                }
            }).pos(startX + 60, y).size(20, 20).build();

            this.addRenderableWidget(selectButton);
            tradeButtons.add(selectButton);

            yOffset += 30;
        }

        AtomicInteger buyY = new AtomicInteger(startY + yOffset + 10);
        // Buy button below trades
        buyButton = Button.builder(Component.translatable(recruitBuy), btn -> {
            if (selectedTrade != null && canAfford(selectedTrade)) {
                Inventory inv = this.menu.player.getInventory();
                npc.addXp(selectedTrade.getXp());

                // Give output item
                this.menu.player.addItem(selectedTrade.output.copy());

                // Remove inputs if not in creative
                if (!this.menu.player.isCreative()) {
                    removeItems(inv, selectedTrade.input, selectedTrade.input.getCount());
                    if (selectedTrade.input2 != null) {
                        removeItems(inv, selectedTrade.input2, selectedTrade.input2.getCount());
                    }
                }

                // Refresh UI after trade
                showTrades();

                // Update buy button state
                buyButton.active = canAfford(selectedTrade);
            }
        }).pos(startX, buyY.get()).size(60, 20).build();
        buyButton.active = false;

        this.addRenderableWidget(buyButton);
    }

    private boolean canAfford(TradeEntry trade) {
        Inventory inv = this.menu.player.getInventory();

        int inputCount = inv.countItem(trade.input.getItem());
        int input2Count = trade.input2 != null ? inv.countItem(trade.input2.getItem()) : 0;

        return inputCount >= trade.input.getCount() &&
                (trade.input2 == null || input2Count >= trade.input2.getCount());
    }

    private void removeItems(Inventory inventory, ItemStack itemStack, int count) {
        int remaining = count;
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack slotStack = inventory.getItem(i);
            if (slotStack.getItem() == itemStack.getItem()) {
                int remove = Math.min(remaining, slotStack.getCount());
                slotStack.shrink(remove);
                remaining -= remove;
                if (remaining <= 0) break;
            }
        }
    }

    private void initRecruit() {
        this.recruitButton = Button.builder(Component.translatable(recruitRecruit), btn -> {
            this.menu.addCitizen(this.menu.player.getUUID(), this.menu.getNpc());
            onClose();
        }).size(70, 20).build();
        this.recruitButton.setPosition((width / 2) - 120, (height / 2) - 20);

        this.dismissButton = Button.builder(Component.translatable(recruitDismiss), btn -> {
            onClose();
        }).size(70, 20).build();
        this.dismissButton.setPosition((width / 2) - 120, (height / 2) + 20);

        this.addRenderableWidget(recruitButton);
        this.addRenderableWidget(dismissButton);
    }

    @Override
    public void render(GuiGraphics graphic, int mX, int mY, float partialTick) {
        super.render(graphic, mX, mY, partialTick);

        int centerX = width / 2;
        int centerY = height / 2;
        int textX = centerX - 20;
        int textY = centerY - 16;

        NPC npc = this.menu.getNpc();

        String info;

        if (!npc.firstName.isEmpty()) {
            info = npc.firstName + " " + npc.lastName;
            graphic.drawString(this.font, info, textX, textY, 0xffffff);
            graphic.drawString(this.font, npc.happiness + "   ", textX - 16, textY, 0xffffff);
            graphic.drawString(this.font, npc.gender, textX, textY + 16, 0xffffff);
            graphic.drawString(this.font, capitalize(String.valueOf(npc.job).toLowerCase()), textX, textY + 32, 0xffffff);
        }



        InventoryScreen.renderEntityInInventoryFollowsMouse(
                graphic, centerX + 60, centerY - 45, centerX + 120, centerY + 90,
                50, 0, mX, mY, npc
        );

        // Render trade items (prices + sold)
        if (menu.getNpc().getLvl() > 0) {
            int startX = width / 8;
            int startY = height / 4;
            int yOffset = 0;

            for (TradeEntry trade : menu.getNpc().allTrades) {
                int y = startY + yOffset;

                graphic.renderItem(trade.input, startX, y);
                graphic.drawString(font, String.valueOf(trade.input.getCount()), startX + 16, y + 10, 0xffffff);

                if (trade.input2 != null) {
                    graphic.renderItem(trade.input2, startX + 30, y);
                    if (!(trade.input2.getCount() == 0)){
                        graphic.drawString(font, String.valueOf(trade.input2.getCount()), startX + 46, y + 10, 0xffffff);
                    }
                }

                graphic.renderItem(trade.output, startX + 90, y);
                graphic.drawString(font, "x" + trade.output.getCount(), startX + 106, y + 10, 0xffffff);

                yOffset += 30;
            }
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {}

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {}
}
