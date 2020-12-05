package it.unimol.game.objects;

import it.unimol.game.logic.RenderableEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Enemy extends RenderableEntity {
    private int x;
    private int y;
    private Image image;
    private String IMGPATH = "space_game/resources/enemy.png";
    private Rectangle rectangle = new Rectangle();
    private int speed = 1;

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
        this.rectangle.setBounds(x, y, 40, 30);
        return rectangle;
    }

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            this.image = ImageIO.read(new File(IMGPATH));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        enemyFalls();

    }

    public void enemyFalls() {

        new Thread(() -> {

            this.y += speed;
            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
        ).start();
    }

}
