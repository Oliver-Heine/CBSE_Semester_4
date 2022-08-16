package dk.sdu.mmmi.osgiplayer;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {

        PlayerPlugin playerPlugin = new PlayerPlugin();
        context.registerService(IGamePluginService.class, playerPlugin, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }

}
