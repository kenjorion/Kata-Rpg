package classes;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Assemblies {

    private String assemblyName;
    private ArrayList<Character> members = new ArrayList<Character>();
    private ArrayList<Character> allowedRoles = new ArrayList<Character>();

    public Assemblies(String assemblyName) {
        this.assemblyName = assemblyName;
    }

    public String getAssemblyName() {
        return assemblyName;
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
    }

    public ArrayList<Character> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Character> members) {
        this.members = members;
    }

    public ArrayList<Character> getAllowedRoles() {
        return allowedRoles;
    }

    public void joinAssembly(Character character) {
        if(!this.containsMember(character)) {
            if (character.getAssembly() == null || character.getAssembly().getAssemblyName().equals(this.getAssemblyName())) {
                if (containsObjectOfType(character)) {
                    System.out.println("ka");
                    this.getMembers().add(character);
                    character.setAssembly(this);
                }
            }
        }
    }

    public void leaveAssembly(Character character) {
        if(this.containsMember(character)) {
            this.getMembers().remove(character);
            character.setAssembly(null);;
        }
    }

    boolean containsObjectOfType(Object o){
        return IntStream.iterate(0, i -> i < allowedRoles.size(), i -> i + 1).anyMatch(i -> allowedRoles.get(i).getClass().equals(o.getClass()));
    }

    public boolean containsMember(Character character){
        return this.getMembers().contains(character);
    }
}
