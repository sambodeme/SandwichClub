package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        String parseMainName = null;
        List<String> parseAlsoKnownAs = null;
        String parsePlaceOfOrigin= null;
        String parseDescription = null;
        String parseImage = null;
        List<String> parseIngredients = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameJsonObject = jsonObject.getJSONObject("name");
            parseMainName = nameJsonObject.getString("mainName");
            parseAlsoKnownAs = makeArrayList(nameJsonObject.getJSONArray("alsoKnownAs"));
            parsePlaceOfOrigin = jsonObject.getString("placeOfOrigin");
            parseDescription = jsonObject.getString("description");
            parseImage = jsonObject.getString("image");
            parseIngredients = makeArrayList(jsonObject.getJSONArray("ingredients"));
            } catch (JSONException e) {
            e.printStackTrace();
        }

        return new Sandwich(parseMainName, parseAlsoKnownAs, parsePlaceOfOrigin,
                parseDescription, parseImage, parseIngredients) ;
    }
//makeArrayList() will convert a JSONArray into a List
    private static List<String> makeArrayList(JSONArray jsonArray){
        List<String> myArrayList = new ArrayList<String>();

        for(int i =0; i <jsonArray.length(); i++)
            try {
                myArrayList.add(jsonArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return myArrayList;
    }
}
