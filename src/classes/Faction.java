package classes;

import java.util.ArrayList;

public class Faction {
    private String factionName;
    private ArrayList<Character> members = new ArrayList<Character>();
    private ArrayList<Faction> allies = new ArrayList<Faction>();

    public Faction(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public ArrayList<Character> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Character> members) { this.members = members; }

    public ArrayList<Faction> getAllies() {
        return allies;
    }

    public void setAllies(ArrayList<Faction> allies) { this.allies = allies; }


    public void joinFaction(Character character){
        if(!this.containsMember(character)){
            this.getMembers().add(character);
            character.getFactions().add(this);
        }
    }

    public void leaveFaction(Character character){
        if(this.containsMember(character)){
            this.getMembers().remove(character);
            character.getFactions().remove(this);
            System.out.println("gj");
        }
    }

    public boolean containsMember(Character character){
        return this.getMembers().contains(character);
    }


    public void becomeAlly(Faction faction){
        if(!this.isAllies(faction)){
            this.getAllies().add(faction);
            faction.getAllies().add(this);
        }
    }

    public void becomeEnnemy(Faction faction){
        if(this.isAllies(faction)){
            this.getAllies().remove(faction);
            faction.getAllies().remove(this);
        }
    }

    public boolean isAllies(Faction allies) {
        return this.getAllies().contains(allies);
    }
}
