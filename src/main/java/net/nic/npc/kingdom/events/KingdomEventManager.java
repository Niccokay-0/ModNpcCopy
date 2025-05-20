package net.nic.npc.kingdom.events;

import net.minecraft.world.item.ItemStack;
import net.nic.npc.NpcMain;
import net.nic.npc.entity.customEntity.npc.NPC;
import net.nic.npc.kingdom.Kingdom;
import net.nic.npc.kingdom.users.KingdomNPC;
import net.nic.npc.kingdom.users.KingdomUser;
import net.nic.npc.kingdom.vars.Government;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KingdomEventManager {

    private static final KingdomEventManager INSTANCE = new KingdomEventManager();

    public static KingdomEventManager getInstance() {
        return INSTANCE;
    }

    public final Map<UUID, Kingdom> kingdoms = new HashMap<>();
    public final Map<UUID, KingdomUser> users = new HashMap<>();
    public final Map<UUID, KingdomNPC> npcs = new HashMap<>();

    //create a kingdom and assign player as a CHIEF
    public boolean createKingdom(UUID playerID, String name, Government government) {

        KingdomUser user = users.computeIfAbsent(playerID, KingdomUser::new);

        if (user.isInKingdom()) {
            NpcMain.LOGGER.error("COULDN'T CREATE KINGDOM: {} for the player:  With Gov: {}", name, government);
            return false;
        } else {
            String description = "Kingdom!";

            Kingdom newKingdom = new Kingdom(name, description);
            kingdoms.put(newKingdom.getKingdomUUID(), newKingdom);
            newKingdom.setGovernment(government);

            user.joinKingdom(newKingdom.getKingdomUUID(), government, true);
            NpcMain.LOGGER.debug("CREATED KINGDOM: {} for the player:  With Gov: {}", name, government);
            return true;
        }
    }

    public boolean disbandKingdom(UUID playerID) {
        KingdomUser user = users.get(playerID);

        if (user == null || !user.isInKingdom()) return false;
        UUID kingdomID = user.getKingdomID();
        Kingdom kingdom = kingdoms.get(kingdomID);

        if (!user.isLeader(kingdom.getGovernment())) return false;

        for (KingdomUser u : users.values()) {
            if (kingdomID.equals(u.getKingdomID())) {
                u.leaveKingdom();
            }
        }

        kingdoms.remove(kingdomID);
        return true;
    }

    public boolean addFood(UUID playerID, int foodvalue, ItemStack iStack) {
        KingdomUser user = users.get(playerID);

        if (user == null || !user.isInKingdom()) return false;
        UUID kingdomID = user.getKingdomID();
        Kingdom kingdom = kingdoms.get(kingdomID);

        if (!user.isLeader(kingdom.getGovernment()) || !user.isVice(kingdom.getGovernment())) return false;
        kingdom.addFoodSupply(foodvalue);
        iStack.shrink(1);
        return true;
    }

    public boolean removeFood(UUID playerID) {
        KingdomUser user = users.get(playerID);

        if (user == null || !user.isInKingdom()) return false;
        UUID kingdomID = user.getKingdomID();
        Kingdom kingdom = kingdoms.get(kingdomID);

        int foodtoremove = kingdom.getCitizens().size() * 10;

        kingdom.removeFoodSupply(foodtoremove);
        return true;
    }

    public boolean recruitPlayer(UUID recruiterID, UUID recruited) {
        KingdomUser user = users.get(recruiterID);

        if (user == null || !user.isInKingdom()) return false;
        UUID kingdomID = user.getKingdomID();
        Kingdom kingdom = kingdoms.get(kingdomID);

        if (!user.isLeader(kingdom.getGovernment()) || !user.isVice(kingdom.getGovernment())) return false;

        KingdomUser recruitedUser = users.computeIfAbsent(recruiterID, KingdomUser::new);
        recruitedUser.joinKingdom(kingdomID, kingdom.getGovernment(), false);
        return true;
    }

    public boolean recruitNPC(UUID recruiterID, UUID recruited) {
        KingdomUser user = users.get(recruiterID);

        if (user == null || !user.isInKingdom()) return false;
        UUID kingdomID = user.getKingdomID();
        Kingdom kingdom = kingdoms.get(kingdomID);

        if (!user.isLeader(kingdom.getGovernment()) && !user.isVice(kingdom.getGovernment())) return false;
        KingdomNPC npc = npcs.computeIfAbsent(recruited, KingdomNPC::new);

        if (!npc.isInKingdom())
        npc.joinKingdom(kingdomID,kingdom.getGovernment(),false);
        kingdom.setFoodNeeded();
        return true;
    }

    public boolean leaveNPC(NPC npctID){
        KingdomNPC npc = npcs.get(npctID.getUUID());

        if (npc == null || !npc.isInKingdom()) return false;

        UUID kingdomID = npc.getKingdomID();
        Kingdom kingdom = kingdoms.get(kingdomID);

        kingdom.removeCitizen(npctID);
        npc.leaveKingdom();
        kingdom.setFoodNeeded();
        return true;
    }


    public KingdomUser getUser(UUID playerID) {
        return users.computeIfAbsent(playerID, KingdomUser::new);
    }

    public Kingdom getKingdom(UUID kingdomID) {
        return kingdoms.get(kingdomID);
    }

    public void registerKingdom(Kingdom kingdom) {
        kingdoms.put(kingdom.getKingdomUUID(), kingdom);
    }

    public void unregisterKingdom(UUID kingdomID) {
        kingdoms.remove(kingdomID);
    }

    public Map<UUID, KingdomUser> getAllUsers() {
        return users;
    }
    public Map<UUID, KingdomNPC> getallNPCS() {
        return npcs;
    }

    public boolean isInKingdom(UUID playerID) {
        KingdomUser user = users.get(playerID);
        return user != null && user.isInKingdom();
    }
}