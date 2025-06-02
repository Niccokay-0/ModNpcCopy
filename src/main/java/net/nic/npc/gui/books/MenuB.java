package net.nic.npc.gui.books;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.nic.npc.gui.MMenus;
import net.nic.npc.item.MWrittenBook;

public class MenuB extends AbstractContainerMenu {

    private ResourceLocation bookId;


    public MenuB(int containerId, Inventory pInv) {
        super(MMenus.MENUB.get(), containerId);

        ItemStack stack = pInv.player.getItemInHand(InteractionHand.MAIN_HAND);
        if (stack.getItem() instanceof MWrittenBook mwrittenBook) {
            this.bookId = mwrittenBook.getBookId();
        }
    }

    public ResourceLocation getBookId() {
        return bookId;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return null;
    }
    @Override
    public boolean stillValid(Player player) {
        return true;
    }


}
