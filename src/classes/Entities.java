package classes;

public class Entities {
    protected String name;
    protected int entityHealth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEntityHealth() {
        return entityHealth;
    }

    public void setEntityHealth(int entityHealth) {
        this.entityHealth = entityHealth;
    }

    public Entities(String name, int entityHealth, int xpGiven) {
        this.name = name;
        this.entityHealth = entityHealth;
    }

    public void takeDamage(int damage) {
        this.setEntityHealth(this.getEntityHealth() - damage);
        if(this.getEntityHealth() < 0){
            this.setEntityHealth(0);
        }
    }
}
