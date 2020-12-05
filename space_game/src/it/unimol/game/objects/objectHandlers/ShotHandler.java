package it.unimol.game.objects.objectHandlers;

import it.unimol.game.logic.Handler;
import it.unimol.game.objects.Shot;
import it.unimol.game.objects.SpaceShip;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShotHandler implements Handler {
    private static ShotHandler ourInstance = new ShotHandler();

    public static ShotHandler getInstance() {
        return ourInstance;
    }


    private List<Shot>shots = new CopyOnWriteArrayList<>();

    private ShotHandler() {
    }

    @Override
    public void start() {

    }

    @Override
    public void keepUpdated() {

    }

    public Shot createShot(){

        Shot shot = new Shot(SpaceShip.getInstance().getX(), SpaceShip.getInstance().getY());
        this.shots.add(shot);
        return shot;

    }

    public List<Shot> getShots() {
        return shots;
    }
}
