package it.unimol.game.objects.objectHandlers;

import it.unimol.game.SpaceHandler;
import it.unimol.game.logic.Handler;
import it.unimol.game.objects.Enemy;
import it.unimol.game.objects.Shot;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EnemyHandler implements Handler {
    private static EnemyHandler ourInstance = new EnemyHandler();

    public static EnemyHandler getInstance() {
        return ourInstance;
    }

    private List<Enemy> enemies = new CopyOnWriteArrayList<>();

    private EnemyHandler() {
    }

    @Override
    public void start() {
        createEnemies();

    }

    private void checkEnemyKilled() {
        for (Enemy enemy : enemies) {
            for (Shot shot : ShotHandler.getInstance().getShots())
                if (enemy.getBounds().intersects(shot.getBounds())) {

                    SpaceHandler.getInstance().deleteCollidedEnemy(enemy);
                    enemies.remove(enemy);

                    SpaceHandler.getInstance().deleteCollidedEnemy(shot);
                    ShotHandler.getInstance().getShots().remove(shot);
                }
        }

    }

    private void createEnemies() {

        for (int i = 0; i < 3; i++) {

            int x = (int) (Math.random() * 400);
            int y = (int) (Math.random() * 100);
            Enemy enemy = new Enemy(x, y);
            enemy.enemyFalls();
            this.enemies.add(enemy);
        }

    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public void keepUpdated() {
        checkEnemyKilled();
    }
}
