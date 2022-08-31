package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ImportInvoice;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ImportInvoice.class
})

public final class ImportSuite {

    @AfterClass
    public static void apagaUser(){

    }

}