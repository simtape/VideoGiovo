
package it.unimol.game.objects;

import it.unimol.game.logic.RenderableEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Shot extends RenderableEntity {
    private int x;
    private int y;
    private Image image;
    private String IMGPATH="space_game/resources/shot.png";
    private Rectangle rectangle = new Rectangle();
    private int speed = 5;


    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Rectangle getBounds() {
        rectangle.setBounds(x, y, 10, 10);
        return rectangle;
    }

    @Override
    public void update() {
        shotFalls();
    }

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.image = ImageIO.read(new File(IMGPATH));

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void shotFalls() {

        //thread per far partire il colpo
        //non funziona
        new Thread(() -> {
            y -= speed;

        }).start();

    }


}

