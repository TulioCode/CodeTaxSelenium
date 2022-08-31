package suites;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.UserAdmin;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserAdmin.class
})

public class AdmSuite {

}
