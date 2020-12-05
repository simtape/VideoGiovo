package it.unimol.game.logic;

import java.awt.*;

public abstract class RenderableEntity {

    public abstract Image getImage();

    public abstract int getX();

    public abstract int getY();

    public abstract Rectangle getBounds();

    public abstract void update();

}
