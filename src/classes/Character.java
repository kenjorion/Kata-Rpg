package classes;

import java.util.ArrayList;

public class Character {
    private String name;
    private int health = 100;
    private int maxHealth = 100;
    private int damage = 1;
    private ArrayList<Faction> factions = new ArrayList<>();
    private boolean status = true;
    private String job;
    private Assemblies assembly;


    
    public Character(String name, String job) {
        this.name = name;
        this.job = job;
        System.out.print(name + " est dans la place \n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() { 
        return health; 
    }

    public void setHealth(int health) { 
        this.health = health; 
    }

    public int getMaxHealth() { 
        return maxHealth; 
    }

    public void setMaxHealth(int maxHealth) { 
        this.maxHealth = maxHealth; 
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<Faction> getFactions() { 
        return factions; 
    }

    public void setFactions(ArrayList<Faction> factions) {
        this.factions = factions; 
    }

    public void attackCharacter(Character ennemy) {
        if (ennemy != this && ennemy.isStatus()) {
            if (this.verifyCharacterFaction(ennemy) != 1) {
                ennemy.takeDamage(this.getDamage());
                if(ennemy.getHealth() == 0)
                    System.out.println("KO!");
            }
            else {
                System.out.println("Evite d'attaquer tes alliés, on pourrait te prendre pour u traitre :/");
            }
        }
    }
    

    public boolean isFaction(Faction faction) {
        return this.getFactions().contains(faction);
    }

    public int verifyCharacterFaction(Character character) {
        int result = 2;
        if (this.getFactions() == null) {
            //no faction
            result = 0;
        }
        if(this.equals(character)){
            // if it's the same character
            result = 1;
        }
        for (int i = 0; i < character.getFactions().size(); i++) {
            for (int j = 0; j < this.getFactions().size(); j++) {
                if(this.isFaction(character.getFactions().get(i))){
                    // if the two Character have a faction in commun
                    result = 1;
                }
                if (this.getFactions().get(j).isAllies(character.getFactions().get(i))) {
                    // if one of their faction are allies
                    result = 1;
                }
            }
        }
        return result;
    }

    public void attackEntities(Entities entity) {
        if (entity.getEntityHealth() > 0) {
            entity.takeDamage(this.getDamage());
        }
    }

    public void heal(Character character){
        if (this.verifyCharacterFaction(character) != 2){
            if(character.isStatus()){
                character.healing(1);
            }
        }
    }

    public void healing(int healNumber){
        if(this.isStatus()){
            this.setHealth(this.getHealth() + healNumber);
            if (this.getHealth() >= this.maxHealth){
                this.setHealth(this.maxHealth);
            }
        }
    }

    public void takeDamage(int damageTaken){
        this.setHealth(this.getHealth() - damageTaken);
        if(this.getHealth() <= 0){
            this.setHealth(0);
            this.setStatus(false);
        }
    }

    public Assemblies getAssembly() {
        return assembly;
    }

    public void setAssembly(Assemblies assembly) {
        this.assembly = assembly;
    }
}
