package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    /**
     * Environmental Parameters that are set in the commandline but also has default values.
     */

    public static final String ENV = System.getProperty("env", "test");
    public static final String BROWSER = System.getProperty("browser", "chrome");

    public static String BASE_URL;

    public void loadProperties(String env) {
        try {
            Properties properties = new Properties();
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(getPropertiesFile(env));
            if (inputStream != null) {
                properties.load(inputStream);
                this.BASE_URL = properties.getProperty("URL");
            }
            System.out.println("Loading Data From " + ENV + ".properties");
            System.out.println("BASE_URL = " + BASE_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertiesFile(String env) {
        switch(env.toUpperCase()) {
            case "TEST":
                return "test.properties";
            case "STAGE":
                return "stage.properties";
        }
        return null;
    }

}
