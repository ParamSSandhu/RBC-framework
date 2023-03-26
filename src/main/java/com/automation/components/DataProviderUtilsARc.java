package com.automation.components;

import com.automation.helpers.DataGenerator;
import com.automation.helpers.JsonUtils;
import com.automation.properties.PropertiesLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataProviderUtilsARc {

//    @DataProvider(name = "jsonDataProvider")
//    public static Object[][] getJsonTestData(Method method) throws IOException, ParseException {        //returning 2D array
//        String testCaseName = method.getName();
//        String value = method.getAnnotation(DataProviderArgs.class).value().split("=")[0];
//        String keys =  method.getAnnotation(DataProviderArgs.class).value().split("=")[1];
//        String[] fields = keys.split(",");
//
//        System.out.println(value + "=" + keys); //Load the json file
//        //Load the json file
//        JsonUtils jsonUtils = new JsonUtils();
//        jsonUtils.loadTestDataFile("testData-" + PropertiesLoader.environment + ".json");
//
//        //To support multiple data set handling, using json array instead of jsonObject
//        JSONArray arr = jsonUtils.getJsonArray(jsonUtils.mainJasonObj, value);
//
//
//        Iterator itr = arr.iterator();
//        Object[][] objArray = new Object[arr.size()][fields.length];
//
//        int counter = 0;
//        while (itr.hasNext()){
//            JSONObject obj = (JSONObject) itr.next();
//            List<String> list = Arrays.asList(fields);
//            for(int i = 0; i < list.size();i++){
//                String valueKey = jsonUtils.getJsonObjectValue(obj,list.get(i));
//                valueKey = DataGenerator.generateRandomData(valueKey);
//                objArray[counter][i] = valueKey;
//                System.out.println("objArray[" + counter + "][" + "] =" + valueKey);
//            }
//            counter++;
//        }
//
//        System.out.println(objArray);
//        return objArray;
//
//    }
//    @DataProvider(name = "excelData")
//    public Object[][] excelLoginData() {
//        Object[][] objArr = null;
//        return objArr;
//    }
 }
