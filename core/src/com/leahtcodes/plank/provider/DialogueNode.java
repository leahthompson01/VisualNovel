package com.leahtcodes.plank.provider;

public class DialogueNode {
    private String nodeId;
    private String actor;
    private String text;
    private String nextNode;


    public DialogueNode(String nodeId, String actor, String text, String nextNode) {
        this.nodeId = nodeId;
        this.actor = actor;
        this.text = text;
        this.nextNode = nextNode;
    }


    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNextNode() {
        return nextNode;
    }

    public void setNextNode(String nextNode) {
        this.nextNode = nextNode;
    }
}
