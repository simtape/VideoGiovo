package it.unimol.game.objects;

import it.unimol.game.SpaceHandler;
import it.unimol.game.logic.RenderableEntity;
import it.unimol.game.objects.objectHandlers.EnemyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SpaceShip extends RenderableEntity {
    private static SpaceShip ourInstance = new SpaceShip();

    public static SpaceShip getInstance() {
        return ourInstance;
    }

    private Image image;
    private int x;
    private int y;
    private int speed = 10;
    private String IMG_PATH = "space_game/resources/spaceship.png";
    private Rectangle rectangle = new Rectangle();
    private Boolean isStillAlive = true;

    private SpaceShip() {
    }

    @Override
    public Image getImage() {
        return this.image;
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
        rectangle.setBounds(x, y, 50, 50);
        return rectangle;
    }

    @Override
    public void update() {
        checkShipKilled();

    }

    public void setTheShip() {

        try {
            this.image = ImageIO.read(new File(IMG_PATH));

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.x = 300;
        this.y = 500;
    }

    public void moveUp() {
        if (isStillAlive)
            this.y -= speed;
    }

    public void moveDown() {
        if (isStillAlive)
            this.y += speed;
    }

    public void moveLeft() {
        if (isStillAlive)
            this.x -= speed;


    }

    public void moveRight() {
        if (isStillAlive)
            this.x += speed;

    }

    private void checkShipKilled() {
        for (Enemy enemy : EnemyHandler.getInstance().getEnemies()) {
            if (this.getBounds().intersects(enemy.getBounds()))
                SpaceHandler.getInstance().deleteCollidedEnemy(this.getInstance());
        }

    }

}
