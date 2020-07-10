package classes;

import java.util.Random;

public class Priest extends Character {
    private int maxHeal = 5;
    private int minHeal = 10;

    public Priest(String name, String job) {
        super(name, job);
    }

    public int getMaxHeal() { return maxHeal; }

    public void setMaxHeal(int maxHeal) { this.maxHeal = maxHeal; }

    public int getMinHeal() { return minHeal; }

    public void setMinHeal(int minHeal) { this.minHeal = minHeal; }

    public void heal(Character character) {
        if (this.verifyCharacterFaction(character) != 2){
            if (character.isStatus()) {
                int randomHeal = (int) (Math.random() * (this.getMaxHeal() - this.getMinHeal())) + this.getMinHeal();
                character.healing(randomHeal);
            }
        }
    }

    public void attackCharacter(Character ennemy) {
        System.out.println("Priest ne peut que soigner");
    }

}
