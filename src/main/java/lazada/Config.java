package lazada;

import com.typesafe.config.ConfigFactory;

import java.io.File;

public class Config {

    private static com.typesafe.config.Config config = ConfigFactory.parseFile(new File("test.conf"));

    public static String getBaseUrl() {
        return config.getString("selenium-tests.lazada.url");
    }

    public static String getUserName() {
        return config.getString("selenium-tests.lazada.user.name");
    }

    public static String getUserEmail() {
        return config.getString("selenium-tests.lazada.user.email");
    }

    public static String getUserPassword() {
        return config.getString("selenium-tests.lazada.user.password");
    }

    public static String getProduct1Page() {
        return config.getString("selenium-tests.lazada.product1");
    }

    public static String getProduct2Page() {
        return config.getString("selenium-tests.lazada.product2");
    }

}
