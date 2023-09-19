package com.leahtcodes.plank.provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONDialogParser {


//    private static Map<Integer, JsonValue> makeDialogueMap() {
//        JsonValue json = new JsonReader().parse(Gdx.files.internal("dialogue.json"));
//        JsonValue.JsonIterator groupIt = json.iterator();
//        Map<Integer, JsonValue> map = new HashMap<Integer, JsonValue>();
//
//        while (groupIt.hasNext()) {
//            JsonValue nextJson = groupIt.next();
//            Integer value = nextJson.getInt("id");
//            map.put(value, nextJson);
//
//            if( nextJson.getString("next") != null && nextJson.get("responseOptions").size >= 1){
//                JsonValue jsonValue = nextJson.get("responseOptions");
//                for(JsonValue obj: jsonValue){
//                    map.put(obj.getInt("id"),obj);
//
//                }
//
//            }
//        }
////        rename to be informative (mapOfInternalObj)
//        return map;
//    }
//    private static void TraverseDialogueMap(Map<Integer, JsonValue> map){
//        JsonValue currentObj = map.get(1);
//        System.out.println(currentObj.getString("dialogue"));
//        while (currentObj.getString("next") != null) {
//            //need to have input to tell which option user chooses
//            if(currentObj.getString("next") != null && currentObj.get("responseOptions").size >= 1){
//                Scanner userChoice = new Scanner(System.in);
//                System.out.println("Pick a dialogue choice ");
//                Integer choiceId = userChoice.nextInt();
//                currentObj = map.get(choiceId);
//
//            } else {
//                currentObj = map.get(currentObj.getInt("next"));
//            }
//            System.out.println(currentObj.getString("dialogue"));
//        }
//    }
//    Map<Integer, JsonDialogueNode> => Map<Integer, JsonDialogueNode>

    public static Map<Integer, JsonDialogueNode> JsonFileToPojo() throws IOException {
        try {
            File file = new File("dialogue.json");
            TypeReference<HashMap<String, JsonDialogueNode>> typeRef = new TypeReference<>() {
//            Think the error in JsonDialogueNode is coming from using a TypeReference for ObjectMapper in Jackson
                //am ending up with ArrayList of LinkedHashMap
                //only happening when we get to the responseOptions
                // that is becoming an ArrayList<LinkedHashMap>
            };
            System.out.println("this is the file" + file);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<Integer,JsonDialogueNode> map = objectMapper.readValue(file,typeRef);

            System.out.println(map);
            return map;
        } catch(IOException e){
            throw new AssertionError(e.getMessage());
        }

    }
}




