package com.leahtcodes.plank.provider;

import java.util.List;

public class JsonDialogueNode {
    public void setId(Integer id) {
        this.id = id;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public void setResponseOptions(List responseOptions) {
        this.responseOptions = responseOptions;
    }

    private Integer id;
    private String dialogue;
    private Integer next;
    private List responseOptions;

    public Integer getId() {
        return id;
    }

    public String getDialogue() {
        return dialogue;
    }

    public Integer getNext() {
        return next;
    }

    public List getResponseOptions() {
        return responseOptions;
    }
    public String toString(){
        if(next != null) {
            return "dialogue: " + dialogue + " | id: " + id.toString() + " | next: " + next.toString()+ " | responseOptions: " + responseOptions.toString();
        }else{
            return "dialogue: " + dialogue + " | id: " + id.toString() +  " | responseOptions: " + responseOptions.toString();
        }
    }
}
