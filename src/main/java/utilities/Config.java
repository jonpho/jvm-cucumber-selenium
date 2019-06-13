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

    /**
     * This method loads the property file from the resources folder to set basic environment variables depending on
     * what is needed.
     * @param env The ENV string is actually set in the constant variable on this page. Or it can bet set in CMD.
     */
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

    /**
     * This method returns the string file name of the properties file in the resources folder. This lets us have more
     * then one property file to load.
     * @param env The ENV setting is set by the constant variable on in this file at the top of the page.
     * @return This returns the property file name from the resources folder.
     */
    private String getPropertiesFile(String env) {
        switch(env.toUpperCase()) {
            case "TEST":
                return "test.properties";
            case "STAGE":
                return "stage.properties";
        }
        return null;
    }

}
