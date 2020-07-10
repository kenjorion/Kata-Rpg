package test;

import classes.Faction;
import org.junit.runner.RunWith;
import com.mscharhag.oleaster.runner.OleasterRunner;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.*;
import static com.mscharhag.oleaster.matcher.Matchers.*;
import classes.Character;

import java.util.ArrayList;

@RunWith(OleasterRunner.class)
public class FactionTest {
    private Faction hunter;
    private Character gon; 
    private Character hisoka;

    public FactionTest() {
        describe("Faction test", () -> {
            hunter = new Faction("faction");
            ArrayList<Faction> brigade = new ArrayList<>();
            ArrayList<Character> members = new ArrayList<Character>();
            beforeEach(() -> {
                hunter.setMembers(members);
                hisoka = new Character("hisoka", "assassin");
                gon = new Character("gon", "hunter");
                gon.setFactions(brigade);
            });

            describe("Faction test : joinFaction()", () -> {
                it("should attack other character", () -> {
                    hunter.joinFaction(gon);
                    expect(gon.getFactions()).toBeNotNull();
                });
            });

            describe("Faction test : leaveFaction()", () -> {
                it("should attack other character", () -> {
                    members.add(hisoka);
                    hisoka.setFactions(brigade);
                    hunter.leaveFaction(hisoka);
                    boolean test = hisoka.getFactions().contains(hunter);
                    expect(test).toBeFalse();
                });
            });
        });




    }

}