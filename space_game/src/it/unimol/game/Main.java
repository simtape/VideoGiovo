package it.unimol.game;

import it.unimol.game.gui.GameFrame;
import it.unimol.game.logic.KeyListener;
import it.unimol.game.objects.objectHandlers.EntitiesCreator;


public class Main {

    public static void main(String args[]) {

       GameSpaceCreator.getInstance().startGame();
    }

}
