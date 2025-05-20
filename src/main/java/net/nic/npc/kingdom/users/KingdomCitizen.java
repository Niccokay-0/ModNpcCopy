package net.nic.npc.kingdom.users;

import net.nic.npc.kingdom.events.KingdomEventManager;
import net.nic.npc.kingdom.vars.Government;
import net.nic.npc.kingdom.vars.Roles;

import java.util.UUID;

public class KingdomCitizen {

    private Roles role = null;
    private UUID kingdomID = null;

    public boolean isInKingdom(){
        return kingdomID != null;
    }

    public UUID getKingdomID() {
        return kingdomID;
    }

    public void joinKingdom(UUID kID, Government gov, boolean isLeader){
        this.kingdomID = kID;
        if (isLeader) this.role = getLeaderRole(gov);
        else this.role = Roles.CIVIL;
    }

    public void leaveKingdom() {
        this.kingdomID = null;
        this.role = null;
    }

    public Roles getRole() {
        return role;
    }

    public boolean isVice(Government government){
        return this.getRole() == getViceRole(government);
    }
    public boolean isLeader(Government government){
        return this.getRole() == getLeaderRole(government);
    }
    public boolean isSlave(){
        return getRole() == Roles.SLAVE;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
    public void setLeader(Government gov) {
        this.role = getLeaderRole(gov);
    }
    public void setVice(Government gov){
        this.role = getViceRole(gov);
    }
    public void setSpecialTroop() {
        if (kingdomID != null) {
            Government government = KingdomEventManager.getInstance().getKingdom(kingdomID).getGovernment();
            if (govHasSpecialTroop(government)) {
                this.role = getSpecialTroopRole(government);

            }
        }
    }
    public void setTroop(){
        this.role = Roles.TROOP;
    }
    public void enslave(){
        this.role = Roles.SLAVE;
    }
    public void setCitizen(){
        this.role = Roles.CIVIL;
    }

    public Roles getSpecialTroopRole(Government gov)  {
        switch(gov) {
            case FEUDALISM -> {return Roles.KNIGHT;}
            case THEOCRACY -> {return Roles.PALADIN;}
            case OLIGARCHY -> {return Roles.ENFORCER;}
            case DICTATORSHIP -> {return Roles.SOLDIER;}
        }
        return Roles.TROOP;
    }
    public Roles getLeaderRole(Government gov)  {
        switch(gov) {
            case FEUDALISM -> {return Roles.LORD;}
            case DEMOCRACY -> {return Roles.PRESIDENT;}
            case THEOCRACY -> {return Roles.PREACHER;}
            case OLIGARCHY -> {return Roles.COUNSELOR;}
            case DICTATORSHIP -> {return Roles.GENERAL;}
            default -> {return Roles.CHIEF;}
        }
    }
    public Roles getViceRole(Government gov) {
        switch(gov) {
            case FEUDALISM -> {return Roles.VASSAL;}
            case DEMOCRACY -> {return Roles.VICE;}
            case THEOCRACY -> {return Roles.CLERIC;}
            case OLIGARCHY -> {return Roles.SPEAKER;}
            case DICTATORSHIP -> {return Roles.OFFICER;}
            default -> {return Roles.HEIR;}
        }
    }
    public boolean govHasSpecialTroop(Government gov)  {
        switch(gov) {
            case FEUDALISM, OLIGARCHY, DICTATORSHIP, THEOCRACY -> {return true;}
            default -> {return false;}
        }
    }

}
