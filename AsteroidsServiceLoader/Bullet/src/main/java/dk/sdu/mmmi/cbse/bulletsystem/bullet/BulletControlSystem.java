package dk.sdu.mmmi.cbse.bulletsystem.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity bullet : world.getEntities(Bullet.class)) {
            PositionPart positionPart = bullet.getPart(PositionPart.class);
            MovingPart movingPart = bullet.getPart(MovingPart.class);

            LifePart bulletLifePart = bullet.getPart(LifePart.class);
            bulletLifePart.reduceExpiration(1);

            //move the bullet
            movingPart.setUp(true);


            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);

            System.out.println("Bullet just before update");
            updateShape(bullet);
        }
    }
    /*
    public void updateShape(Entity entity){
        float[] shapeX = entity.getShapeX();
        float[] shapeY = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapeX[0] = (float) (x + Math.cos(radians + 0 * 3.1415f) * 2);
        shapeY[0] = (float) (y + Math.sin(radians + 0 * 3.1415f) * 2);

        shapeX[1] = (float) (x + Math.cos(radians + 0.5 * 3.1415f) * 2);
        shapeY[1] = (float) (y + Math.sin(radians + 0.5 * 3.1415f) * 2);

        shapeX[2] = (float) (x + Math.cos(radians + 1 * 3.1415f) * 2);
        shapeY[2] = (float) (y + Math.sin(radians + 1 * 3.1415f) * 2);

        shapeX[3] = (float) (x + Math.cos(radians + 1.5 * 3.1415f) * 2);
        shapeY[3] = (float) (y + Math.sin(radians + 1.5 * 3.1415f) * 2);

        System.out.println("Bullet just after update");
        entity.setShapeX(shapeX);
        entity.setShapeY(shapeY);
    }*/


    private void updateShape(Entity entity) {
        float[] shapex = new float[2];
        float[] shapey = new float[2];
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 4);
        shapey[0] = (float) (y + Math.sin(radians) * 4);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 4);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 4);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }


}