package com.udacity.sandwichclub.utils;


import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {


    public static Sandwich parseSandwichJson(String json) {

        /*

            root
                        name
                        alsoKnownAs []
            placeOfOrigin
            description
            image
            ingredients []

         */


        String mainName = "";
        ArrayList<String> alsoKnownAs = new ArrayList<>();
        String placeOfOrigin = "";
        String description = "";
        String image = "";
        ArrayList<String> ingredients = new ArrayList<>();

        try {

            JSONObject rootObject = new JSONObject(json);

            JSONObject nameObject = rootObject.optJSONObject(Constants.KEY_NAME);

            // mainName
            mainName = nameObject.optString(Constants.KEY_MAIN_NAME);

            // alsoKnownAs
            JSONArray arrayAlsoKnownAs = nameObject.optJSONArray(Constants.KEY_ALSO_KNOWN_AS);

            for (int i = 0; i < arrayAlsoKnownAs.length(); i++) {

                alsoKnownAs.add(arrayAlsoKnownAs.optString(i));

            }
            //placeOfOrigin
            placeOfOrigin = rootObject.optString(Constants.KEY_PLACE_OF_ORIGIN);

            // description
            description = rootObject.optString(Constants.KEY_DESCRIPTION);

            // image
            image = rootObject.optString(Constants.KEY_IMAGE);

            // ingredients
            JSONArray arrayIngredients = rootObject.optJSONArray(Constants.KEY_INGREDIENTS);

            for (int i = 0; i < arrayIngredients.length(); i++) {

                ingredients.add(arrayIngredients.optString(i));

            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
