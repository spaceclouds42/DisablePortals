package us.spaceclouds42.disableportals.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;
import us.spaceclouds42.disableportals.Config;
import us.spaceclouds42.disableportals.DisablePortals;

import java.io.File;

import static net.minecraft.server.command.CommandManager.literal;
public class DisablePortalsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
            literal("disableportals")
                    .requires(source -> source.hasPermissionLevel(2))
                    .then(
                        CommandManager.literal("allowNether")
                                .then(
                                    CommandManager
                                            .argument("enable", BoolArgumentType.bool())
                                            .executes(ctx -> setNetherPortals(ctx.getSource(), BoolArgumentType.getBool(ctx, "enable")))
                                )
                    )
                    .then(
                        CommandManager.literal("allowEnd")
                                .then(
                                    CommandManager
                                            .argument("enable", BoolArgumentType.bool())
                                            .executes(ctx -> setEndPortals(ctx.getSource(), BoolArgumentType.getBool(ctx, "enable")))
                                )
                    ).then(
                    CommandManager.literal("allowEndGateways")
                            .then(
                                    CommandManager
                                            .argument("enable", BoolArgumentType.bool())
                                            .executes(ctx -> setEndGateways(ctx.getSource(), BoolArgumentType.getBool(ctx, "enable")))
                            )
                    ).then(
                        CommandManager
                                .literal("reloadConfig")
                                .executes(ctx -> reloadConfig(ctx.getSource()))
                    )

        );
    }

    public static int setNetherPortals(ServerCommandSource source, boolean enable) {
        DisablePortals.CONF.main.disableNetherPortals = !enable;
        DisablePortals.CONF.saveConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        if (enable) {
            source.sendFeedback(
                    Text.literal ("Enabled Nether portals").formatted(Formatting.GREEN), false
            );
        } else {
            source.sendFeedback(
                    Text.literal ("Disabled Nether portals").formatted(Formatting.RED),
                    false
            );
        }
        return 1;
    }

    public static int setEndPortals(ServerCommandSource source, boolean enable) {
        DisablePortals.CONF.main.disableEndPortals = !enable;
        DisablePortals.CONF.saveConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        if (enable) {
            source.sendFeedback(
                    Text.literal ("Enabled End portals").formatted(Formatting.GREEN), false
            );
        } else {
            source.sendFeedback(
                    Text.literal ("Enabled End portals").formatted(Formatting.RED), false
            );
        }

        return 1;
    }

    private static int setEndGateways(ServerCommandSource source, boolean enable) {
        DisablePortals.CONF.main.disableEndGateways = !enable;
        DisablePortals.CONF.saveConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        if (enable) {
            source.sendFeedback(
                    Text.literal("Enabled End Gateway Portals").formatted(Formatting.GREEN), false
            );
        } else {
            source.sendFeedback(
                    Text.translatable("Disabled End Gateway Portals").formatted(Formatting.RED), false
            );
        }

        return 1;
    }

    private static int reloadConfig(ServerCommandSource source) {
        DisablePortals.CONF = Config.loadConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        source.sendFeedback(
                Text.translatable("Configuration Reloaded!").formatted(Formatting.GREEN), false
        );

        return 1;
    }
}
