package com.leahtcodes.plank.provider;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.util.List;

//something funky is going on in here, please investigate
@JsonPropertyOrder({"id","dialogue","next","responseOptions"})
public class JsonDialogueNode {
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("dialogue")
    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    @JsonProperty("actor")
    public void setActor(String actor){
        this.actor = actor;
    }
    @JsonProperty("next")
    public void setNext(Integer next) {
        this.next = next;
    }

    @JsonProperty("responseOptions")
    public void setResponseOptions(List<JsonDialogueNode> responseOptions) {
        this.responseOptions = responseOptions;
    }
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("dialogue")
    public String dialogue;
    @JsonProperty("next")
    private Integer next;
    @JsonProperty("responseOptions")
    private List<JsonDialogueNode> responseOptions;

    @JsonProperty("actor")
    private String actor;
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("dialogue")
    public String getDialogue() {
        return dialogue;
    }

    @JsonProperty("next")
    public Integer getNext() {
        return next;
    }

    @JsonProperty("responseOptions")
    public List<JsonDialogueNode> getResponseOptions() {
        return responseOptions;
    }

    @JsonProperty("actor")
    public String getActor(){
        return actor;
    }

    public String toString(){
        if(next != null) {
            return "dialogue: " + dialogue + " | id: " + id.toString() + " | next: " + next.toString()+ " | responseOptions: " + responseOptions.toString();
        }else{
            return "dialogue: " + dialogue + " | id: " + id.toString() +  " | responseOptions: " + responseOptions.toString();
        }
    }
}
