package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
      Sandwich sandwich = new Sandwich();
      JSONObject obj = new JSONObject(json);
      JSONObject name = obj.getJSONObject("name");
      JSONArray aka = name.getJSONArray("alsoKnownAs");
      JSONArray ingredients = obj.getJSONArray("ingredients");

      sandwich.setMainName(name.getString("mainName"));
      sandwich.setDescription(obj.getString("description"));
      sandwich.setImage(obj.getString("image"));
      sandwich.setPlaceOfOrigin(obj.getString("placeOfOrigin"));
      sandwich.setAlsoKnownAs(new ArrayList<String>());
      sandwich.setIngredients(new ArrayList<String>());

      for (int i = 0; i < aka.length(); i++){
        sandwich.getAlsoKnownAs().add(aka.getString(i));
      }

      for (int i = 0; i < ingredients.length(); i++){
        sandwich.getIngredients().add(ingredients.getString(i));
      }

        return sandwich;
    }
}
