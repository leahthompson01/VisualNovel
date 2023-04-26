package com.leahtcodes.plank.provider;

import java.util.HashMap;
import java.util.Map;

public class DialogManager {
    private Map<String, DialogueNode> dialogueNodes;
    private IDialogParser dialogParser;


    public DialogManager(String filePath, IDialogParser dialogParser) {
        dialogueNodes = new HashMap<String, DialogueNode>();
        this.dialogParser = dialogParser;
        loadDialogue(filePath);

    }

    private void loadDialogue(String filePath) {
        dialogueNodes = dialogParser.parseDialogueFile(filePath);
    }


    public DialogueNode getNode(String nodeId){
        return dialogueNodes.get(nodeId);
    }

    public DialogueNode getNextNode(String currentNodeId) {
        DialogueNode currentNode = dialogueNodes.get(currentNodeId);
        return dialogueNodes.get(currentNode.getNextNode());


    }

}
