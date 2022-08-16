package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BulletTest {
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Entity player = new Entity();

    private Entity bullet = null;
    private BulletControlSystem bulletControlSystem = null;

    BulletTest(){

    }

    public void createBullet(){
        //We cannot create a new Player instance due to the dependencies
        player.add(new PositionPart(33, 44, 55));
        //Creates a new bullet
        this.bulletControlSystem = new BulletControlSystem();
        this.bullet = this.bulletControlSystem.createBullet(player, gameData);
    }

    @Test
    public void bulletCreation(){
        createBullet();
        this.bulletControlSystem.process(gameData, world);
        assertNotNull(bullet);
    }

    @Test
    public void bulletMovement(){
        createBullet();
        this.bulletControlSystem.process(gameData, world);
        //To test if the bullet has been drawn
        assertNotEquals(this.bullet.getRadius(), 0);

        PositionPart positionPart = this.bullet.getPart(PositionPart.class);
        float positionX = positionPart.getX();
        float positionY = positionPart.getY();

        world.addEntity(bullet);

        //To ensure that the bullet moves
        bulletControlSystem.process(gameData, world);
        assertNotEquals(positionX, positionPart.getX());
        assertNotEquals(positionY, positionPart.getY());
    }
}
