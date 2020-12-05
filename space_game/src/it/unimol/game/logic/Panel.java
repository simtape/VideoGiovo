package it.unimol.game.logic;

import it.unimol.game.objects.objectHandlers.EntitiesCreator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Panel extends JComponent {

    private List<RenderableEntity> renderableEntityList;

    public Panel() {
        EntitiesCreator.getInstance().createEntities();
        this.renderableEntityList = EntitiesCreator.getInstance().getRenderableEntityList();

    }

    @Override
    public void paint(Graphics g) {
        this.renderableEntityList = EntitiesCreator.getInstance().getRenderableEntityList();

        super.paint(g);

        for (RenderableEntity renderableEntity : renderableEntityList) {

            g.drawImage(renderableEntity.getImage(), renderableEntity.getX(), renderableEntity.getY(), null);
        }
    }

    public void addRenderable(RenderableEntity entity) {
        this.renderableEntityList.add(entity);

    }

    public void deleteEntity(RenderableEntity entity) {
        renderableEntityList.remove(entity);

    }

    
}
