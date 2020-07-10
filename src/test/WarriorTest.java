package test;

import classes.Warrior;
import org.junit.runner.RunWith;
import com.mscharhag.oleaster.runner.OleasterRunner;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.*;
import static com.mscharhag.oleaster.matcher.Matchers.*;
import classes.Character;


@RunWith(OleasterRunner.class)
public class WarriorTest {
    private Character eren;
    private Character grey;


    public WarriorTest() {
        describe("Warrior test", () -> {
            beforeEach(() -> {
                eren = new Warrior("eren", "swordman");
                grey = new Warrior("grey", "swordman");
            });

            describe("Warrior test : attackCharacter()", () -> {
                it("should attack other character", () -> {
                    grey.setHealth(40);
                    eren.attackCharacter(grey);
                    expect(grey.getHealth()).toBeBetween(31, 40);
                });
            });
        });
    }
}