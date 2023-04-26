package com.leahtcodes.plank.provider;

import java.util.Map;

public interface IDialogParser {
    Map<String, DialogueNode> parseDialogueFile(String filePath);
}
