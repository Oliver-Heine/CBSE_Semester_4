package dk.sdu.mmmi.cbse.bulletsystem.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        System.out.println("The plugin is started");
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity bullet: world.getEntities(Bullet.class)){
            world.removeEntity(bullet);
        }
    }
}
