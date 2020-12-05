package it.unimol.game.logic;

import it.unimol.game.SpaceHandler;
import it.unimol.game.objects.SpaceShip;
import it.unimol.game.objects.objectHandlers.ShotHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private int i = 0;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            SpaceShip.getInstance().moveUp();

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            SpaceShip.getInstance().moveDown();

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            SpaceShip.getInstance().moveLeft();

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            SpaceShip.getInstance().moveRight();

        if (e.getKeyCode() == KeyEvent.VK_B)
            if (i < 50) {
                SpaceHandler.getInstance().addGameObject(ShotHandler.getInstance().createShot());
                i++;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
