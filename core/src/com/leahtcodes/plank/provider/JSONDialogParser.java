package com.leahtcodes.plank.provider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class JSONDialogParser {
    public static void printJSON() {

        Map<Integer, JsonValue> map = makeDialogueMap();
        TraverseDialogueMap(map);
    }
    private static Map<Integer, JsonValue> makeDialogueMap() {
        JsonValue json = new JsonReader().parse(Gdx.files.internal("dialogue.json"));
        JsonValue.JsonIterator groupIt = json.iterator();
        Map<Integer, JsonValue> map = new HashMap<Integer, JsonValue>();

        while (groupIt.hasNext()) {
            JsonValue nextJson = groupIt.next();
            Integer value = nextJson.getInt("id");
            map.put(value, nextJson);

            if( nextJson.getString("next") != null && nextJson.get("responseOptions").size >= 1){
                JsonValue jsonValue = nextJson.get("responseOptions");
                for(JsonValue obj: jsonValue){
                    map.put(obj.getInt("id"),obj);

                }

            }
        }
//        rename to be informative (mapOfInternalObj)
        return map;
    }
    private static void TraverseDialogueMap(Map<Integer, JsonValue> map){
        JsonValue currentObj = map.get(1);
        System.out.println(currentObj.getString("dialogue"));
        while (currentObj.getString("next") != null) {
            //need to have input to tell which option user chooses
            if(currentObj.getString("next") != null && currentObj.get("responseOptions").size >= 1){
                Scanner userChoice = new Scanner(System.in);
                System.out.println("Pick a dialogue choice ");
                Integer choiceId = userChoice.nextInt();
                currentObj = map.get(choiceId);

            } else {
                currentObj = map.get(currentObj.getInt("next"));
            }
            System.out.println(currentObj.getString("dialogue"));
        }
    }
}



