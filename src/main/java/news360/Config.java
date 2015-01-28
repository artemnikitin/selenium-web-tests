package news360;

import com.typesafe.config.ConfigFactory;

import java.io.File;

public class Config {

    private static com.typesafe.config.Config config = ConfigFactory.parseFile(new File("test.conf"));

    public static String getBaseUrl() {
        return config.getString("selenium-tests.news360.url");
    }

    public static String getValidUserEmail() {
        return config.getString("selenium-tests.news360.users.valid.login");
    }

    public static String getValidUserPassword() {
        return config.getString("selenium-tests.news360.users.valid.password");
    }

    public static String getInvalidUserEmail() {
        return config.getString("selenium-tests.news360.users.invalid.login");
    }

    public static String getInvalidUserPassword() {
        return config.getString("selenium-tests.news360.users.invalid.password");
    }


}
