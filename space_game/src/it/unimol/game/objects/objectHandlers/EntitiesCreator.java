package it.unimol.game.objects.objectHandlers;

import it.unimol.game.logic.Handler;
import it.unimol.game.logic.RenderableEntity;
import it.unimol.game.objects.Background;
import it.unimol.game.objects.Enemy;
import it.unimol.game.objects.SpaceShip;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntitiesCreator implements Handler {
    private static EntitiesCreator ourInstance = new EntitiesCreator();

    public static EntitiesCreator getInstance() {
        return ourInstance;
    }

    private List<RenderableEntity> renderableEntityList = new CopyOnWriteArrayList<>();
    private List<Enemy>enemies = new CopyOnWriteArrayList<>();


    private EntitiesCreator() {
    }


    public List<RenderableEntity> getRenderableEntityList() {
        return renderableEntityList;
    }

    public void createEntities(){

        creatingTheUniverse();
        creatingTheSpaceShip();
        creatingTheEnemies();

    }

    public void creatingTheUniverse(){
        Background.getInstance().createBackground();
        renderableEntityList.add(Background.getInstance());
    }

    public void creatingTheSpaceShip(){

        SpaceShip.getInstance().setTheShip();
        renderableEntityList.add(SpaceShip.getInstance());

    }


    public void creatingTheEnemies(){
        EnemyHandler.getInstance().start();
        this.enemies = EnemyHandler.getInstance().getEnemies();
        for(Enemy enemy: this.enemies)
        {
            this.renderableEntityList.add(enemy);

        }
    }


    @Override
    public void start() {

    }

    @Override
    public void keepUpdated() {
        this.enemies = EnemyHandler.getInstance().getEnemies();
    }
}
