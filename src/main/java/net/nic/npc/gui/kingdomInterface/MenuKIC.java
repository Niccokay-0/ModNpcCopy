package net.nic.npc.gui.kingdomInterface;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.nic.npc.kingdom.Kingdom;
import net.nic.npc.kingdom.events.KingdomEventManager;
import net.nic.npc.kingdom.users.KingdomUser;
import net.nic.npc.kingdom.vars.Government;

import java.util.UUID;

import static net.nic.npc.gui.MMenus.MENUKIC;

public class MenuKIC extends AbstractContainerMenu {

    public Player player;
    public Kingdom playerKingdom;

    public MenuKIC(int containerId, Inventory pInv) {
        super(MENUKIC.get(), containerId);
        this.player = pInv.player;
        user();
        hasKingdom();
        getKingdom();

    }


    public KingdomUser user(){
        KingdomUser user = KingdomEventManager.getInstance().getAllUsers().get(player.getUUID());
        return user;
    }


    public boolean hasKingdom() {
        if (user() != null) {
            return user().isInKingdom();
        } else {
            return false;
        }
    }
    public Kingdom getKingdom() {
        KingdomUser user = user();
        Kingdom kingdom;
        if (user == null) {
            return null;

        } else if (user.isInKingdom()) {
            kingdom = KingdomEventManager.getInstance().getKingdom(user.getKingdomID());
            setKingdom(kingdom);
            return kingdom;
        }
        return null;
    }

    public void setKingdom(Kingdom kingdom) {
        this.playerKingdom = kingdom;
    }

    public void createKingdom(UUID playerID, String name, Government gov){
        KingdomEventManager.getInstance().createKingdom(playerID,name,gov);
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
