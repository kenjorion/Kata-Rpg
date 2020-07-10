package test;

import classes.Entities;
import classes.Faction;
import org.junit.runner.RunWith;
import com.mscharhag.oleaster.runner.OleasterRunner;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.*;
import static com.mscharhag.oleaster.matcher.Matchers.*;
import classes.Character;

import java.util.ArrayList;


@RunWith(OleasterRunner.class)
public class CharacterTest {
    private Character lloyd;
    private Character zorro;
    private Character saori;
    private Faction swordmans;
    private Faction fighter;


    public CharacterTest() {
        fighter = new Faction("fighter");
        swordmans = new Faction("swordss");
        final ArrayList<Faction> mugiwara = new ArrayList<>();
        final ArrayList<Faction> sylvarant = new ArrayList<>();
        final ArrayList<Faction> allies = new ArrayList<Faction>();
        Entities devoreur = new Entities("Le grand Dévoreur", 100000, 200);
        devoreur.setEntityHealth(5);


        describe("Character test", () -> {
           beforeEach(() -> {
                lloyd = new Character("lloyd", "swordman");
                zorro = new Character("zorro", "swordman");
            });

            describe("Character test : attackCharacter()", () -> {
                it("should attack other character", () -> {
                    lloyd.attackCharacter(zorro);
                    expect(zorro.getHealth()).toBeSmallerThan(100);
                });

                it("should put a KO to other character", () -> {
                    Character gohan = new Character("gohan", "sayen");
                    gohan.setHealth(1);

                    lloyd.attackCharacter(gohan);
                    expect(gohan.getHealth()).toEqual(0);
                });
            });

            describe("Character test : isFaction()", () -> {
                it("should return the right faction", () -> {
                    zorro.setFactions(mugiwara);
                    mugiwara.add(swordmans);
                    boolean result = zorro.isFaction(swordmans);
                    expect(result).toBeTrue();
                });
                it("should return the wrong faction", () -> {
                    zorro.setFactions(mugiwara);
                    mugiwara.add(swordmans);
                    boolean result = lloyd.isFaction(swordmans);
                    expect(result).toBeFalse();
                });
            });

            describe("Character test : verifyCharacterFaction()", () -> {
                it("should return 2 when the character is an enemy", () -> {
                    zorro.setFactions(mugiwara);
                    lloyd.setFactions(sylvarant);
                    int result = zorro.verifyCharacterFaction(lloyd);
                    expect(result).toEqual(2);
                });
                it("should return 1 when the character is same character (3)", () -> {
                    zorro.setFactions(sylvarant);
                    mugiwara.add(swordmans);
                    int result = zorro.verifyCharacterFaction(zorro);
                    expect(result).toEqual(1);
                });
                it("should return 1 when the characters have a faction in common", () -> {
                    mugiwara.add(fighter);
                    sylvarant.add(fighter);
                    System.out.println(sylvarant);
                    fighter.becomeAlly(swordmans);
                    zorro.setFactions(mugiwara);
                    lloyd.setFactions(sylvarant);
                    int result = zorro.verifyCharacterFaction(lloyd);
                    expect(result).toEqual(1);
                });
            });

            describe("Character test : attackEntities()", () -> {
                it("should take damage to entity", () -> {
                    zorro.attackEntities(devoreur);
                    expect(devoreur.getEntityHealth()).toEqual(4);
                });
            });

            describe("Character test : healing()", () -> {
                it("should healing the character and set the health to Max health", () -> {
                    zorro.setHealth(98);
                    zorro.healing(4);
                    expect(zorro.getHealth()).toEqual(100);
                });
            });

            describe("Character test : takeDamage()", () -> {
                it("should take damage to the character and set the health to O, status to dead", () -> {
                    lloyd.setHealth(3);
                    lloyd.takeDamage(4);
                    expect(lloyd.getHealth()).toEqual(0);
                    expect(lloyd.isStatus()).toBeFalse();
                });
            });

        });
    }
}
