package net.nic.npc.gui.kingdomInterface;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.nic.npc.entity.customEntity.npc.NPC;
import net.nic.npc.kingdom.ColorStorage;
import net.nic.npc.kingdom.Kingdom;
import net.nic.npc.kingdom.vars.Government;

import java.util.ArrayList;
import java.util.List;


public class ScreenKIC extends AbstractContainerScreen<MenuKIC> {


    /**
     * Translation Variables:
     */
    public static String creationCreate = "npc.gui.kingdom.creation.create";
    public static String creationEditbox = "npc.gui.kingdom.creation.editbox.default";

    public static String governmentMonarchy = "npc.gui.kingdom.government.monarchy";
    public static String governmentFeudalism = "npc.gui.kingdom.government.feudalism";
    public static String governmentDemocracy = "npc.gui.kingdom.government.democracy";
    public static String governmentTheocracy = "npc.gui.kingdom.government.theocracy";
    public static String governmentOligarchy = "npc.gui.kingdom.government.oligarchy";
    public static String governmentDictatorship = "npc.gui.kingdom.government.dictatorship";

    public static String governmentTitleMonarchy = "npc.gui.kingdom.title.government.monarchy";
    public static String governmentTitleFeudalism = "npc.gui.kingdom.title.government.feudalism";
    public static String governmentTitleDemocracy = "npc.gui.kingdom.title.government.democracy";
    public static String governmentTitleTheocracy = "npc.gui.kingdom.title.government.theocracy";
    public static String governmentTitleOligarchy = "npc.gui.kingdom.title.government.oligarchy";
    public static String governmentTitleDictatorship = "npc.gui.kingdom.title.government.dictatorship";

    public static String stringFood = "npc.gui.kingdom.food";
    public static String stringNeededFood = "npc.gui.kingdom.neededfood";



    private EditBox editBox;
    private CycleButton<Object> governmentCycle;
    Government selectedGovernment = Government.MONARCHY;
    private Button createButton;
    private Button cancelButton;
    /**
     * CREATION VARIABLES
     */

    private CycleButton<Integer> pageButton;
    private List<Integer> pageList = new ArrayList<>();
    private int currentPage = 0;
    private final int ITEMS_PER_PAGE = 6;
    private List<Button> buttons = new ArrayList<>();
    private NPC selectedNPC;
    private boolean displayEntity;
    /**
     * Normal Buttons and Variables
     */

    private Kingdom tKingdom;
    private String kingdomName;
    private int population;
    private int foodValue;
    private int neededFood;
    /**
     * Kingdom Variables
     */

    public ScreenKIC(MenuKIC menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }
    @Override
    protected void init() {
        super.init();
        this.buttons.clear();
        this.pageList.clear();
        this.pageButton = null;

        if (getMenu().hasKingdom()) {
            loadKingdom(this.menu.getKingdom());
            normalInit();
        } else {
            creationInit();
        }
    }

    private void normalInit() {
        buildCitizenButtons();

        if (!pageList.isEmpty()) {
            this.pageButton = CycleButton.<Integer>builder(page -> Component.literal(String.valueOf(page))).withValues(this.pageList).withInitialValue(1).create((this.width / 15), (this.height / 10) + 60, 60, 20, Component.translatable("npc.gui.kingdom.page"), (btn, value) -> {
                        currentPage = value - 1;
                        updateDisplayedButtons();
                    });
            this.addRenderableWidget(pageButton);
        }
        updateDisplayedButtons();
    }
    private void buildCitizenButtons() {
        buttons.clear();
        pageList.clear();

        int x = width / 15 + 80;
        int yStart = height / 10 + 60;

        List<NPC> citizens = this.menu.getKingdom().getCitizens();
        for (int i = 0; i < citizens.size(); i++) {
            NPC npc = citizens.get(i);
            String npcInfo = String.format("%s %s %s %s %s",
                    npc.firstName,
                    npc.lastName,
                    npc.happiness + "%",
                    npc.gender,
                    npc.job
            );
            Button button = Button.builder(Component.literal(npcInfo), btn -> {
                        selectedNPC = npc;
                        displayEntity();
                    }).pos(x, yStart + ((i % ITEMS_PER_PAGE) * 25)).size(this.font.width(npcInfo) + 20, 20).build();
            buttons.add(button);
        }
        int totalPages = (int) Math.ceil((double) citizens.size() / ITEMS_PER_PAGE);
        for (int i = 1; i <= totalPages; i++) {
            pageList.add(i);
        }
    }
    private void displayEntity() {
        displayEntity = true;
    }
    private void updateDisplayedButtons() {
        this.renderables.removeIf(w -> buttons.contains(w));
        this.children().removeIf(w -> buttons.contains(w));

        int x = width / 15 + 80;
        int y = height / 10 + 60;

        int startIndex = currentPage * ITEMS_PER_PAGE;
        int endIndex = Math.min(startIndex + ITEMS_PER_PAGE, buttons.size());

        for (int i = startIndex; i < endIndex; i++) {
            Button b = buttons.get(i);
            b.setPosition(x, y);
            y += 25;
            this.addRenderableWidget(b);
        }
    }
    private void loadKingdom(Kingdom kingdom) {
        this.tKingdom = kingdom;
        this.kingdomName = kingdom.getName();
        this.population = kingdom.getCitizens().size();
        this.foodValue = kingdom.getFoodSupply();
        this.neededFood = kingdom.getFoodNeeded();
    }
    private void creationInit() {
        this.createButton = Button.builder(Component.translatable(creationCreate), button -> {

            this.menu.createKingdom(this.menu.player.getUUID(), this.editBox.getValue(), selectedGovernment);

            this.onClose();
        }).pos((this.width / 2) + 10, (this.height / 2) + 50).size(60, 20).build();

        this.cancelButton = Button.builder(Component.translatable("gui.cancel"), button -> {
            this.onClose();
        }).pos((this.width / 2) - 70, (this.height / 2) + 50).size(60, 20).build();

        this.editBox = new EditBox(this.font, this.width / 2, this.height / 2, 150, 20, Component.translatable(creationEditbox));
        this.editBox.setPosition((width / 2) - (editBox.getWidth() / 2), height / 2);
        this.editBox.setFocused(true);
        this.editBox.setMaxLength(16);
        this.governmentCycle = CycleButton.builder(government -> Component.translatable("npc.gui.kingdom.government." + government.toString().toLowerCase())).withValues(Government.values()).withInitialValue(selectedGovernment).create(this.width / 2 - 60, this.height / 2 + 25, 120, 20, Component.empty(), (btn, value) -> {
                    selectedGovernment = (Government) value;
                });

        this.addRenderableWidget(editBox);
        this.addRenderableWidget(governmentCycle);
        this.addRenderableWidget(cancelButton);
        this.addRenderableWidget(createButton);
    }
    @Override
    public void onClose() {
        super.onClose();
    }
    @Override
    public void render(GuiGraphics graphics, int mX, int mY, float partialTick) {
        this.renderBackground(graphics, mX, mY, partialTick);
        super.render(graphics, mX, mY, partialTick);
        int centerX = width / 2;
        int centerY = height / 2;
        if (this.menu.hasKingdom()) {
            normalRender(graphics, mX, mY, partialTick);
        }
        if (displayEntity) {
            InventoryScreen.renderEntityInInventoryFollowsMouse(
                    graphics, centerX + 60, centerY - 45, centerX + 120, centerY + 90,
                    50, 0, mX, mY, selectedNPC
            );

        }
    }
    private void normalRender(GuiGraphics graphics, int mX, int mY, float partialTick) {
        int x = width / 15;
        int y = height / 10;

        String kingdomInfo = String.format(
                "%s %s",
                Component.translatable("npc.gui.kingdom.title.government." + tKingdom.getGovernment().toString().toLowerCase()).getString(),
                kingdomName
        );

        graphics.drawString(this.font, kingdomInfo, x - 12, y, ColorStorage.gold, true);
        graphics.drawString(this.font, Component.translatable("npc.gui.kingdom.government." + tKingdom.getGovernment().toString().toLowerCase()), x, y + 12, ColorStorage.gold, false);
        graphics.drawString(this.font, String.valueOf(population), x, y + 24, ColorStorage.white, false);

        String neededfoodstring = Component.translatable("npc.gui.kingdom.food").getString();
        String foodvaluesstring = Component.translatable("npc.gui.kingdom.neededfood").getString();

        String foodInfo = String.format(
                "%s %s | %s %s",
                neededfoodstring,
                this.foodValue,
                foodvaluesstring,
                this.neededFood
        );
        graphics.drawString(this.font, foodInfo, x, y + 36, 0xffffff, false);

    }
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
    }
    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }
}
