package net.nic.npc.gui.books;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.nic.npc.NpcMain;

import java.util.List;

public class ScreenB extends AbstractContainerScreen<MenuB> {
    public static final ResourceLocation BOOK_LOCATION = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID,"textures/gui/era0bookgui.png");
    private List<Component> pages;
    private int currentPage = 0;
    private PageButton nextButton;
    private PageButton prevButton;



    public ScreenB(MenuB menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        // Load pages from the bookId in the menu
        ResourceLocation bookId = menu.getBookId();
        pages = BookLoader.loadBook(bookId);
    }

    @Override
    protected void init() {
        super.init();
        int i = (this.width - 192) / 2;
        int j = (this.height+ 192) / 2;
        this.prevButton = this.addRenderableWidget(new PageButton(i + 40, j - 42, false, btn -> this.pageBack(), true));
        this.nextButton = this.addRenderableWidget(new PageButton( i + 120, j - 42, true, btn -> this.pageFowrward(), true));
        updateButtonVisibility();
    }

    private void pageBack(){

        if (this.currentPage > 0) {
            this.currentPage--;
        }
        this.updateButtonVisibility();

    }

    private void pageFowrward(){

        if (this.currentPage < this.pages.size() - 1) {
            this.currentPage++;
        }
        this.updateButtonVisibility();

    }


    private int getNumPages() {
        return this.pages.size();
    }


    private void updateButtonVisibility() {
        this.nextButton.visible = this.currentPage < this.getNumPages() - 1;
        this.prevButton.visible = this.currentPage > 0;
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        this.renderTransparentBackground(guiGraphics);
        guiGraphics.blit(RenderType::guiTextured, BOOK_LOCATION, (this.width - 192) / 2, (this.height- 192)/2, 0.0F, 0.0F, 192, 192, 256, 256);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        if (pages != null && !pages.isEmpty()) {
            int textX = leftPos + 25;
            int textY = topPos + 40;
            int maxWidth = imageWidth - 50;

            guiGraphics.drawWordWrap(font, pages.get(currentPage), textX, textY, maxWidth, 0x4A4A4A,false);
        }

        int textX = leftPos + 25;
        int textY = topPos + 5;
        int maxWidth = imageWidth - 60;

        guiGraphics.drawWordWrap(font, Component.translatable(menu.getBookId().toString()), textX, textY, maxWidth, 0x2A2A2A,false);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }
}
