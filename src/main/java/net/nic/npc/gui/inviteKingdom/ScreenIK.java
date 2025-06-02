package net.nic.npc.gui.inviteKingdom;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class ScreenIK extends AbstractContainerScreen<MenuIK> {

    private Button acceptButton;
    private Button dismissButton;

    public ScreenIK(MenuIK menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();

        int x = this.width / 2;
        int y = this.height / 2;

        this.acceptButton = Button.builder(Component.translatable("mco.invites.button.accept"), btn -> {
            this.menu.joinKingdom(minecraft.player, minecraft.player.getUUID());
            onClose();
        }).size(70, 20).pos(x - 80, y + 10).build();

        this.dismissButton = Button.builder(Component.translatable("gui.npc.menur.dismiss"), btn -> {
            this.menu.destroyInvite(minecraft.player);
            onClose();
        }).size(70, 20).pos(x + 10, y + 10).build();

        addRenderableWidget(this.acceptButton);
        addRenderableWidget(this.dismissButton);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        //sdguiGraphics.drawCenteredString(this.font, Component.translatable("gui.npc.menu.title.invite"), this.width / 2, this.height / 2 - 30, 0xFFFFFF);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {

    }
}
