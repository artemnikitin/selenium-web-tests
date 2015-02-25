package news360;

import com.typesafe.config.ConfigFactory;

import java.io.File;

public class Config {

    private static com.typesafe.config.Config config = ConfigFactory.parseFile(new File("test.conf"));

    public static String getBaseUrl() {
        return config.getString("selenium-tests.artemnikitin.url");
    }

}
