package net.nic.npc.kingdom.users;

import java.util.UUID;

public class KingdomNPC extends KingdomCitizen{

    public UUID NPCID;

    public KingdomNPC(UUID npcID) {
        this.NPCID = npcID;
    }

    public UUID getNPCID(){
        return this.NPCID;
    }

}
