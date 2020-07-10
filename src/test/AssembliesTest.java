package test;

import classes.Faction;
import classes.Assemblies;
import classes.Warrior;
import org.junit.runner.RunWith;
import com.mscharhag.oleaster.runner.OleasterRunner;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.*;
import static com.mscharhag.oleaster.matcher.Matchers.*;
import classes.Character;

import java.util.ArrayList;

@RunWith(OleasterRunner.class)
public class AssembliesTest {
    private Assemblies assembly;

    public AssembliesTest() {
        assembly = new Assemblies("shinigami");
        final Warrior kenpachi = new Warrior("kenpachi", "shinigami");
        final Warrior ichigo = new Warrior("ichi", "shinigami");

        describe("Assemblies test : joinAssembly()", () -> {
            ArrayList<Object> allowedRoles = new ArrayList<Object>();
            allowedRoles.add(0, kenpachi);
            /*it("should join the character to the assembly if the character has no assembly", () -> {
                System.out.println(kenpachi.getAssembly());
                System.out.println(allowedRoles);
                assembly.joinAssembly(kenpachi);
                expect(kenpachi.getAssembly()).toBeNotNull();
            });$/

            /*describe("Assemblies test : joinAssemblies()", () -> {
                it("should join an assembly", () -> {
                    ichigo.setAssembly(null);
                    assembly.joinAssembly(ichigo);
                    expect(ichigo.getAssembly()).toBeNotNull();
                });*/
        });
    }
}
