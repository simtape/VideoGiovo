package it.unimol.game;

import it.unimol.game.logic.Panel;
import it.unimol.game.logic.RenderableEntity;
import it.unimol.game.objects.Enemy;
import it.unimol.game.objects.objectHandlers.EnemyHandler;
import it.unimol.game.objects.objectHandlers.EntitiesCreator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpaceHandler {
    private static SpaceHandler ourInstance = new SpaceHandler();

    private List<RenderableEntity> entities;

    private Panel panel = new Panel();

    public static SpaceHandler getInstance() {
        return ourInstance;
    }

    private SpaceHandler() {
    }

    public void startGame(List<RenderableEntity> entities) {

        this.entities = new CopyOnWriteArrayList<>(entities);
        keepGameAlive();

    }

    public void deleteCollidedEnemy(RenderableEntity entity) {
        entities.remove(entity);
        panel.deleteEntity(entity);
        panel.repaint();

    }


    public void keepGameAlive() {

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(16);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                panel.repaint();
                EnemyHandler.getInstance().keepUpdated();
                EntitiesCreator.getInstance().keepUpdated();

                for (RenderableEntity renderableEntity : entities)
                    renderableEntity.update();

            }

        }
        ).start();

    }

    public List<RenderableEntity> getEntities() {
        return entities;
    }

    public Panel getPanel() {
        return this.panel;
    }


    public void addGameObject(RenderableEntity renderableEntity) {
        renderableEntity.update();

        this.entities.add(renderableEntity);

        this.panel.addRenderable(renderableEntity);
    }
}


