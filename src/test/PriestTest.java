package test;

import classes.Faction;
import classes.Priest;
import org.junit.runner.RunWith;
import com.mscharhag.oleaster.runner.OleasterRunner;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.*;
import static com.mscharhag.oleaster.matcher.Matchers.*;
import classes.Character;

import java.util.ArrayList;


@RunWith(OleasterRunner.class)
public class PriestTest {
    private Priest winry;
    private Character grey;
    private ArrayList<Faction> chimic = new ArrayList<>();


    public PriestTest() {
        describe("Priest test", () -> {
            Faction faction = new Faction("faction");
            ArrayList<Faction> lol = new ArrayList<>();
            beforeEach(() -> {
                lol.add(faction);
                winry = new Priest("WINRY", "swordman");
                grey = new Character("grey", "swordman");
                grey.setFactions(lol);
                winry.setFactions(lol);
            });

            describe("Priest test : heal()", () -> {
                it("should attack other character", () -> {
                    grey.setHealth(40);
                    winry.heal(grey);
                    expect(grey.getHealth()).toBeBetween(45, 50);
                });
            });
        });
    }
}