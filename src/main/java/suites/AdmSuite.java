package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.UserAdmin;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserAdmin.class
})

public class AdmSuite {
}
