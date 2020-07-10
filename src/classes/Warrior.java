package classes;

public class Warrior extends Character {
    private int maxDamage = 9;
    private int minDamage = 0;

    public Warrior(String name, String job) {
        super(name, job);
    }

    public int getMaxDamage() { return maxDamage; }

    public void setMaxDamage(int maxDamage) { this.maxDamage = maxDamage; }

    public int getMinDamage() { return minDamage; }

    public void setMinDamage(int minDamage) { this.minDamage = minDamage; }

    public void attackCharacter(Character character) {
        if (character.isStatus()) {
            if (this.verifyCharacterFaction(character) != 1 || this.equals(character)) {
                int random = (int) (Math.random() * (this.getMaxDamage() - this.getMinDamage())) + this.getMinDamage();
                character.takeDamage(random);
            }
        }
    }

    public void heal() {
        if (this.isStatus()) {
            this.healing(1);
        }
    }
}
