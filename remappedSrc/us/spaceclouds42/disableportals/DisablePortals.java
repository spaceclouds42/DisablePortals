package us.spaceclouds42.disableportals;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import us.spaceclouds42.disableportals.commands.DisablePortalsCommand;

import java.io.File;

public class DisablePortals implements ModInitializer {
    public static Config CONF;

    @Override
    public void onInitialize() {
        CONF = Config.loadConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            DisablePortalsCommand.register(dispatcher);
        });
    }
}
