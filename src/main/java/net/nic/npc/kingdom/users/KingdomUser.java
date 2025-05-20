package net.nic.npc.kingdom.users;

import java.util.UUID;

public class KingdomUser extends KingdomCitizen{

    private final UUID playerID;

    public KingdomUser(UUID playerID) {
        this.playerID = playerID;
    }

    public UUID getPlayerID() {
        return this.playerID;
    }

}