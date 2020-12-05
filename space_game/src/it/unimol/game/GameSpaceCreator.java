package it.unimol.game;

import it.unimol.game.gui.GameFrame;
import it.unimol.game.logic.KeyListener;
import it.unimol.game.objects.objectHandlers.EntitiesCreator;

public class GameSpaceCreator {
    private static GameSpaceCreator ourInstance = new GameSpaceCreator();

    public static GameSpaceCreator getInstance() {
        return ourInstance;
    }

    private GameSpaceCreator() {
    }

    public void startGame() {

        SpaceHandler.getInstance().startGame(EntitiesCreator.getInstance().getRenderableEntityList());

        GameFrame gameFrame = new GameFrame();
        gameFrame.add(SpaceHandler.getInstance().getPanel());
        gameFrame.addKeyListener(new KeyListener());
        gameFrame.setVisible(true);

    }
}
