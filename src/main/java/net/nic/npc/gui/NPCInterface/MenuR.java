package net.nic.npc.gui.NPCInterface;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.nic.npc.entity.customEntity.npc.NPC;
import net.nic.npc.gui.MMenus;
import net.nic.npc.kingdom.Kingdom;
import net.nic.npc.kingdom.events.KingdomEventManager;
import net.nic.npc.kingdom.users.KingdomUser;

import java.util.UUID;

public class MenuR extends AbstractContainerMenu {

    public Player player;
    public Kingdom playerKingdom;
    private NPC npc;

    public MenuR(int containerId, Inventory pInv) {
        super(MMenus.MENUR.get(), containerId);
        this.player = pInv.player;
        getKingdom();
        setNpc((NPC) player.getLastHurtMob());
    }

    protected void addCitizen(UUID ownerID, NPC citizen) {

        if (KingdomEventManager.getInstance().isInKingdom(ownerID)) {

            KingdomEventManager.getInstance().recruitNPC(ownerID, citizen.getUUID());

            Kingdom kingdom = KingdomEventManager.getInstance().getKingdom(KingdomEventManager.getInstance().getUser(ownerID).getKingdomID());
            citizen.setRecruited();
            kingdom.addCitizen(citizen);
            kingdom.setFoodNeeded();
        }
        else player.displayClientMessage(Component.translatable("npc.gui.recruit.failed.kingdom.false"),true);
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

    public void setNpc(NPC npc) {
        this.npc = npc;
    }
    protected NPC getNpc() {
        return npc;
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
