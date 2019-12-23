package my.company.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties() throws IOException {
        System.setProperty("environment", "application");
        properties.load(new FileInputStream(new File("./" + System.getProperty("environment") + ".properties")));
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new TestProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}
