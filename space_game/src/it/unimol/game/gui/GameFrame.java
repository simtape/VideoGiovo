package it.unimol.game.gui;

import it.unimol.game.SpaceHandler;
import it.unimol.game.logic.KeyListener;
import it.unimol.game.objects.SpaceShip;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
/*
        for (RenderableEntity renderableEntity : SpaceHandler.getInstance().getEntities()) {
            this.add(renderableEntity);
        }*/

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(new KeyListener());
        this.setSize(600, 600);


    }

}
