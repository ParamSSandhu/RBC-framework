package com.automation.helpers;

import com.automation.components.DataProviderArgs;
import com.automation.properties.PropertiesLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {
    public JSONObject mainJasonObj;

    public JSONObject getMainObject() {
        return mainJasonObj;
    }

    public void loadTestDataFile(String fileName) throws IOException, ParseException {
        File jsonFile = new File(System.getProperty("user.dir") + "//src//test//resources//" + fileName);

        JSONParser parser = new JSONParser();
        Object jsonFileObject = parser.parse(new FileReader(jsonFile));
        this.mainJasonObj = (JSONObject) jsonFileObject;
    }

    public JSONObject getJsonObject(JSONObject jsonObject, String jsonObjectName) {
        return (JSONObject) jsonObject.get(jsonObjectName);
    }

    public String getJsonObjectValue(JSONObject jsonObject, String key) {
        return jsonObject.get(key).toString();
    }


    public JSONArray getJsonArray(JSONObject jsonObject, String jsonObjectName) {
        return (JSONArray) jsonObject.get(jsonObjectName);
    }

}
