package suites;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ImportInvoice;
import tests.Landing;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Landing.class,
})


public final class LandingSuites {

    @BeforeClass
    public static void apagaUser(){
        //Lugar usado para apagar usuário criado na sessão (preservar massa de dados)
    }

}
