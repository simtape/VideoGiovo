package it.unimol.game.objects;

import it.unimol.game.logic.RenderableEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background extends RenderableEntity {
    private Image image;
    private static Background instance = new Background();
    private String IMG_PATH = "space_game/resources/background.jpg";

    public static Background getInstance(){
        return instance;
    }
    private Background(){


    }
    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void update() {

    }

    public void createBackground() {
        try {
            this.image = ImageIO.read(new File(IMG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}