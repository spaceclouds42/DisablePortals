package us.spaceclouds42.disableportals;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.spaceclouds42.disableportals.commands.DisablePortalsCommand;

import java.io.File;
import java.util.logging.Level;

public class DisablePortals implements ModInitializer {
    public static Config CONF;

    public static final Logger LOGGER = LoggerFactory.getLogger("DisablePortals");



    @Override
    public void onInitialize() {
        CONF = Config.loadConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        LOGGER.info("Initializing Mod");
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            DisablePortalsCommand.register(dispatcher);
        });
    }

}
