package net.nic.npc.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.level.Level;
import net.nic.npc.gui.books.MenuB;

public class MWrittenBook extends WrittenBookItem {
    private final ResourceLocation bookId;


    public MWrittenBook(ResourceLocation name, Item.Properties properties, ResourceLocation bookId) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, name)));
        this.bookId = bookId;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(getMenu());
        }
        return InteractionResult.SUCCESS;
    }

    public ResourceLocation getBookId() {
        return bookId;
    }

    protected MenuProvider getMenu() {
        MenuProvider menuProvider = new SimpleMenuProvider((containerId, playerInventory, player1) -> {
            MenuB menuB = new MenuB(containerId, playerInventory);
            return menuB;
        }, Component.translatable("npc.gui.menu.menub"));
        return menuProvider;
    }
}