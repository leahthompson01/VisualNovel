package com.leahtcodes.plank.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leahtcodes.plank.Plank;
import com.leahtcodes.plank.provider.JSONDialogParser;
import com.leahtcodes.plank.provider.JsonDialogueNode;
import com.leahtcodes.plank.provider.MyScreen;
import com.leahtcodes.plank.provider.ScreenManager;

import java.util.Map;

public class MainScreen extends MyScreen {
    private Plank parent;
    private Stage stage;
    private Skin skin;
    private Dialog dlgName;
    private TextField name;
    private Table table;
    private String dlgText;
    private Map<Integer, JsonDialogueNode>  map;
    private Table table2;
    private Table tableBtn;
    private Label dialogLabel;
    private Table actorTable;
    private int currentId = 1;
    private JSONDialogParser jsonParser;
    private ScreenManager screenManager;

    public MainScreen(Plank game, Map<Integer, JsonDialogueNode>  map2, ScreenManager screenManager2) {
        super(game);
        map = map2;
        screenManager = screenManager2;
        parent = game;
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("dark-hdpi/Holo-dark-hdpi.json"));
        jsonParser = new JSONDialogParser();
//        jsonParser.printJSON();

        System.out.println("you are here in MAIN screen");
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        table2 = new Table();
        actorTable = new Table();
        Texture dialogBox = new Texture("green-background.png");
        TextureRegionDrawable dialogBackground = new TextureRegionDrawable(new TextureRegion(dialogBox));
        table2.setBackground(dialogBackground);
        table.setDebug(true);

        TextureRegionDrawable background = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Library 1.png"))));
        table.setBackground(background);
        tableBtn = new Table();
        table.row();
        table.add(table2).colspan(2);
        table.row();
        table.add(tableBtn);
        table.row();
        table.add(actorTable).size(400,400);
        actorTable.getPadLeft();

        //need to generate buttons for responseOptions but only if responseOptions has a length >= 1

//        Table actorTable = new Table();
//        table.add(actorTable);
//        Actor actor = new Actor();
//        SpriteBatch batch = new SpriteBatch();
//        batch.begin();
//        Texture texture = new Texture(Gdx.files.internal("bossAssBitchHappy.png"));
//        batch.draw(texture,1000,1000,1000,1000);
////        actorTable.add(actor);
//        actorTable.setDebug(true);
//
////        actor.draw(batch,0);
//        stage.addActor(actor);
//        stage.draw();


        Integer currentId = 1;
        System.out.println("this is the current dialogue node " + map);
        JsonDialogueNode currentDialogue = map.get(currentId.toString());
        AddDialogueTable();
        AddDialogueOptionsTable(currentDialogue);
    }
    public void AddDialogueTable(){

        table2.clearChildren();
        actorTable.clearChildren();

        dialogLabel = new Label(map.get("" + currentId).getDialogue(), skin);
        dialogLabel.setWrap(false);
        dialogLabel.setSize(Gdx.graphics.getWidth()/12,Gdx.graphics.getWidth()/12);
        table2.add(dialogLabel);
        // get actor and update on screen with that actor
//        Actor actor = new Actor();
        System.out.println("this is the actor: " + map.get("" + currentId).getActor());

        Texture logo = new Texture(Gdx.files.internal(map.get("" + currentId).getActor()));
        Image image1 = new Image(logo);
        image1.setSize(100,100);
        image1.setPosition(Gdx.graphics.getWidth() /7 - logo.getWidth()/7, Gdx.graphics.getHeight()/9 - logo.getHeight()/9);
        actorTable.add(image1);
//        SpriteBatch batch = new SpriteBatch();
//        batch.begin();
//        Texture texture = new Texture(Gdx.files.internal(map.get("" + currentId).getActor()));
//        batch.draw(texture,1000,1000);
//
////        actor.draw(batch,100);
//        stage.addActor(actor);
//        stage.draw();






    }
    public void AddDialogueOptionsTable(JsonDialogueNode currentDialogue){
        if(!map.get("" + currentId).getResponseOptions().isEmpty()) {
            boolean isEven = true;
            for (JsonDialogueNode option : currentDialogue.getResponseOptions()) {

                System.out.println(option);
                String newString = option.getDialogue();
                TextButton btn = new TextButton(newString, skin);
                if (isEven) {
                    tableBtn.row();
                }
                tableBtn.add(btn).padRight(50);

                btn.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
//                            super.clicked(event, x, y);
                        currentId = option.getNext().intValue();
                        tableBtn.clearChildren();

                        System.out.println(currentId);
                        AddDialogueTable();
                        AddDialogueOptionsTable(map.get("" + currentId));
                    }

                });

                isEven = !isEven;

                }
////
//                table.add(newButton);
            }
        }
    @Override
    public void show(){
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height){
        stage.getViewport().update(width, height, true);
    }
    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        stage.dispose();
    }

}

