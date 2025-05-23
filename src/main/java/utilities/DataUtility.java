package utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class DataUtility {
    private static final String TEST_DATA_PATH = "src/test/resources/TestData/";

    public static String getJsonData(String filename, String... keys) {
        InputStream inputStream = DataUtility.class.getClassLoader().getResourceAsStream("TestData/"+filename + ".json");

        if (inputStream == null) {
            throw new RuntimeException("file is not exist" + filename + ".json");
        }

        JsonElement jsonElement = JsonParser.parseReader(new InputStreamReader(inputStream));
        JsonObject currentObject = jsonElement.getAsJsonObject();

        for (int i = 0; i < keys.length - 1; i++) {
            if (currentObject.has(keys[i])) {
                currentObject = currentObject.getAsJsonObject(keys[i]);
            } else {
                throw new RuntimeException("❌can not access this key " + keys[i]);
            }
        }

        String lastKey = keys[keys.length - 1];
        if (currentObject.has(lastKey)) {
            return currentObject.get(lastKey).getAsString();
        } else {
            throw new RuntimeException("last key is not found " + lastKey);
        }
    }

    // read from properties file
    public static String getPropertyValue(String fileName,String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(TEST_DATA_PATH+ fileName + ".properties"));
        return   properties.getProperty(key);
    }
}
