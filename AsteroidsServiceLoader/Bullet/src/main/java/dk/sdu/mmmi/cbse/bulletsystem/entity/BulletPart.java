package dk.sdu.mmmi.cbse.bulletsystem.entity;

import dk.sdu.mmmi.cbse.bulletsystem.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.EntityPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;

public class BulletPart implements EntityPart {

    @Override
    public void process(GameData gameData, Entity entity) {

    }

    public void createBullet(World world, Entity shooter){
        PositionPart shootersPosition = shooter.getPart(PositionPart.class);
        float shootersX = shootersPosition.getX();
        float shootersY = shootersPosition.getY();
        float shootersRadians = shootersPosition.getRadians();

        float x = (float) (shootersX + Math.cos(shootersRadians) * 10);
        float y = (float) (shootersY + Math.sin(shootersRadians) * 10);
        float acceleration = 3000000;
        float maxSpeed = 500;
        float radians = shootersRadians;

        Bullet bullet = new Bullet();

        bullet.add(new MovingPart(0, acceleration, maxSpeed, 0));
        bullet.add(new PositionPart(x, y, radians));
        bullet.add(new LifePart(1, 200));

        System.out.println("Bullet added");
        world.addEntity(bullet);
    }
}
