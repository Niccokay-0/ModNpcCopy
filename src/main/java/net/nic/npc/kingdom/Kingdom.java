package net.nic.npc.kingdom;

import net.nic.npc.entity.customEntity.npc.NPC;
import net.nic.npc.kingdom.vars.Government;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Kingdom {

    private Government government;

    private final UUID kingdomUUID;

    private String name;

    private String description;

    public void setGovernment(Government gov){
        this.government = gov;
    }

    public Government getGovernment() {
        return government;
    }

    private final List<NPC> citizens;
    private int happiness;
    private int foodSupply;
    private int foodNeeded;

    public Kingdom(String name, String description) {
        this.kingdomUUID = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.citizens = new ArrayList<>();
        this.happiness = 50;
        this.foodNeeded = 0;
        this.foodSupply = 0;
    }

    public UUID getKingdomUUID() {
        return kingdomUUID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<NPC> getCitizens() {
        return citizens;
    }
    public void addCitizen(NPC npc) {
        if (!citizens.contains(npc)) {
            citizens.add(npc);
        }
    }
    public void removeCitizen(NPC npc) {
        citizens.remove(npc);
    }
    public int getHappiness() {
        return happiness;
    }
    public void setHappiness(int happiness) {
        this.happiness = Math.max(0,Math.max(100,happiness));
    }
    public int getFoodSupply()  {
        return foodSupply;
    }
    public void addFoodSupply(int foodValue) {
        this.foodSupply += foodValue;
    }
    public void removeFoodSupply(int foodValue) {
        addFoodSupply(-foodValue);
    }
    public int getFoodNeeded() {
        return foodNeeded;
    }
    public void setFoodNeeded() {
        this.foodNeeded = getCitizens().size() * 90;
    }
}
