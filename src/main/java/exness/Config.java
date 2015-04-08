package exness;

import com.typesafe.config.ConfigFactory;

import java.io.File;

public class Config {

    private static com.typesafe.config.Config config = ConfigFactory.parseFile(new File("test.conf"));

    public static String getBaseUrl() {
        return config.getString("selenium-tests.exness.url");
    }

    public static String getSection(Sections section) {
        return config.getString("selenium-tests.exness.sections." + section.getType());
    }

}
