package com.leahtcodes.plank.provider;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;




public class CSVDialogParser implements IDialogParser {
    @Override
    public Map<String, DialogueNode> parseDialogueFile(String filePath) {
        FileHandle file = Gdx.files.internal(filePath);
        Map<String, DialogueNode> dialogueNodes = new HashMap<String, DialogueNode>();


        try
                (Reader reader = file.reader();
                 CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : parser) {
                //Decouple this into a model
                String nodeID = record.get("nodeID");
                String actor = record.get("actor");
                String text = record.get("text");
                String nextNodeID = record.get("nextNodeID");


                DialogueNode dialogueNode = new DialogueNode(nodeID, actor, text, nextNodeID);
                dialogueNodes.put(nodeID, dialogueNode);
            }
        } catch (IOException e) {
            e.getMessage();
        }

        return dialogueNodes;
    }
}


