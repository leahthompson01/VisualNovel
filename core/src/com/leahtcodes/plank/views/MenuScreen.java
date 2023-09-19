package com.leahtcodes.plank.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leahtcodes.plank.Plank;
import com.leahtcodes.plank.provider.MyScreen;
import com.leahtcodes.plank.provider.ScreenManager;

//import sun.awt.www.content.image.png;
public class MenuScreen extends MyScreen{
    private Plank parent;

    private ScreenManager screenManager;
    private Stage stage;
    private Skin skin;
    private Image image1;
    private Texture logo;
    public MenuScreen(Plank game, ScreenManager screenManagerOG){
        super(game);
        screenManager = screenManagerOG;
        parent = game;
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("dark-hdpi/Holo-dark-hdpi.json"));
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        TextureRegionDrawable background = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Greenhouse.png"))));
        Image image = new Image(background);
        table.setBackground(background);
        table.row();
        logo = new Texture(Gdx.files.internal("pirateLogo.png"));
        image1 = new Image(logo);
        image1.setPosition(Gdx.graphics.getWidth() /2 - logo.getWidth()/2, Gdx.graphics.getHeight()/2 - logo.getHeight()/2);
        stage.addActor(image1);
        table.row();
        TextButton newGame = new TextButton("New Game", skin);
        TextButton exit = new TextButton("Exit Game", skin);
        TextButton loadGame = new TextButton("Load Game", skin);
        TextButton gallery = new TextButton("Gallery", skin);

        table.add(newGame).padTop(500).space(10);
        table.add(loadGame).padTop(500).space(10);
        table.add(gallery).padTop(500).space(10);
        table.add(exit).padTop(500).space(10);
//        System.out.println("you are here in menu screen");
       newGame.addListener(new ChangeListener() {
           @Override
           public void changed(ChangeEvent event, Actor actor) {
               table.add(newGame).padTop(500).space(10);
//               System.out.println(screenManager);
               screenManager.changeScreen("main");
           }
       });

       exit.addListener(new ChangeListener() {
           @Override
           public void changed(ChangeEvent event, Actor actor) {
               Gdx.app.exit();
           }
       });

       loadGame.addListener(new ChangeListener() {
           @Override
           public void changed(ChangeEvent event, Actor actor) {
//               screenManager.changeScreen("loading");
           }
       });



        stage.draw();

    }
    @Override
    public void show(){
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height){
        stage.getViewport().update(width, height, true);
        image1.setPosition(Gdx.graphics.getWidth() /2 - logo.getWidth()/2, Gdx.graphics.getHeight()/2 - logo.getHeight()/2);
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
        skin.dispose();
        stage.dispose();

    }

}

