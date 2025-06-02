package net.nic.npc.gui;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.gui.NPCInterface.MenuR;
import net.nic.npc.gui.books.MenuB;
import net.nic.npc.gui.inviteKingdom.MenuIK;
import net.nic.npc.gui.kingdomInterface.MenuKIC;

import java.util.function.Supplier;


public class MMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, NpcMain.MODID);

    public static final Supplier<MenuType<MenuKIC>> MENUKIC =
            MENUS.register("menukic",
                    ()-> new MenuType<>(MenuKIC::new, FeatureFlags.DEFAULT_FLAGS));

    public static final Supplier<MenuType<MenuR>> MENUR =
            MENUS.register("menur",
                    ()-> new MenuType<>(MenuR::new, FeatureFlags.DEFAULT_FLAGS));

    public static final Supplier<MenuType<MenuB>> MENUB =
            MENUS.register("menub",
                    ()-> new MenuType<>(MenuB::new, FeatureFlags.DEFAULT_FLAGS));

    public static final Supplier<MenuType<MenuIK>> MENUIK =
            MENUS.register("menuik",
                    ()-> new MenuType<>(MenuIK::new, FeatureFlags.DEFAULT_FLAGS));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

}
