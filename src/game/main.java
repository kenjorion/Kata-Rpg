package game;

import classes.Character;
import classes.Entities;
import classes.Faction;
import classes.Priest;
import classes.Warrior;

public class main {
    public static void main(String[] args) {
        start();
    }

    static void start() {
        Priest dende = new Priest("Dende", "dieu namek");
        Warrior ed = new Warrior("Edward", "alchimiste d'état");
        Character pnj = new Character("PNJ", "il donne des quêtes");
        Faction namek = new Faction("peuple namek");
        Faction brotherhood = new Faction("Fullmetal alchemist brotherhood");
        Entities devoreur = new Entities("Le grand Dévoreur", 100000, 200);
        attackPlayer(dende, ed);
        ed.attackEntities(devoreur);
        brotherhood.joinFaction(ed);
        brotherhood.becomeAlly(namek);
        attackPlayer(ed, pnj);
    }

    public static void attackPlayer(Character player, Character chara) {
        if (chara.isStatus()) {
            if (player.equals(chara)) {
                System.out.println("Ne t'attaque pas toi même \n");
            }
            System.out.println("Tu as de mauvaises intentions envers " + chara.getName() + "\n");
            player.attackCharacter(chara);
            if (chara.getHealth() == 0) {
                System.out.println("Tu as tué  " + chara.getName()+ " , une victoire de plus!\n");
            }
        }else {
            System.out.println("Le joueur " + chara.getName() + " est déjà mort, calm down !!\n");
        }
    }

    public static void attackEntity(Character player, Entities entity) {
        if(entity.getEntityHealth() > 0) {
            System.out.println("Tu attaques " + entity.getName()+ " ne retourne plus en arrière ! \n");
            player.attackEntities(entity);
            if (entity.getEntityHealth() == 0) {
                System.out.println("Tu as exterminé " + entity.getName()
                        + ". Quelle victoire glorieuse ! \n");

            }
        }else {
            System.out.println("The "+entity.getName()+" tu attaques les etres morts...? \n");
        }
    }

    public static void heal(Character healer, Character chara){
        if(chara.isStatus()){
            if(healer.equals(chara)){
                System.out.println("tu te soignes \n");
            }else{
                System.out.println("tu vas soigner "+chara.getName()+ "\n");
            }
            healer.heal(chara);
            System.out.println("les PV  "+chara.getName()+ " sont " + chara.getHealth()+ "\n");
        }else {
            System.out.println("Le joueur "+chara.getName()+" est dèja mort ! Trop tard...." + "\n");
        }
    }

    public static void joinFaction(Character player, Faction faction){
        if(!faction.containsMember(player)){
            faction.joinFaction(player);
            System.out.printf("Tu as rejoins la faction " + faction.getFactionName() + "\n");
        }else {
            System.out.printf("Tu es dèjà un membre de" + faction.getFactionName() + " \n");
        }
    }

    public static void leaveFaction(Character player, Faction faction){
        if(faction.containsMember(player)){
            faction.leaveFaction(player);
            System.out.printf("Tu as quitté " + faction.getFactionName() + "\n");
        }else {
            System.out.printf("Tu n'es pas un membre de  " + faction.getFactionName() +"\n");
        }
    }

    public static void factionsBecomingAllies(Faction faction1,Faction faction2){
        if(!faction1.isAllies(faction2)){
            faction1.becomeAlly(faction2);
            System.out.println(" La faction "+faction1.getFactionName()+" et la faction"+faction2.getFactionName()  +" deviennent alliés\n");
        }else {
            System.out.println("La faction "+faction1.getFactionName()+" et la faction "+faction2.getFactionName()  +" sont déjà alliés \n");
        }
    }

    public static void factionsBecomingEnnemy(Faction faction1, Faction faction2){
        if(faction1.isAllies(faction2)){
            faction1.becomeEnnemy(faction2);
            System.out.println("La faction "+faction1.getFactionName()+" et la faction "+faction2.getFactionName()
                    +" sont maintenant ennemis ! Let's fight! \n");
        }else {
            System.out.println("La faction "+faction1.getFactionName()+" et la faction "+faction2.getFactionName()
                    +" sont déjà ennemis\n");
        }
    }
}

