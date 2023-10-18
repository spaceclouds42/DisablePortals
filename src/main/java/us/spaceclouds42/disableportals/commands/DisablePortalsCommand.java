package us.spaceclouds42.disableportals.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
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
            MutableText feedback = Text.literal("Enabled nether portals").formatted(Formatting.GREEN);
            source.sendFeedback(() -> feedback, false);
        } else {
            MutableText feedback = Text.literal("Disabled nether portals").formatted(Formatting.RED);
            source.sendFeedback(() -> feedback, false);
        }

        return 1;
    }

    public static int setEndPortals(ServerCommandSource source, boolean enable) {
        DisablePortals.CONF.main.disableEndPortals = !enable;
        DisablePortals.CONF.saveConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        if (enable) {
            MutableText feedback = Text.literal("Enabled end portals").formatted(Formatting.GREEN);
            source.sendFeedback(() -> feedback, false);
        } else {
            MutableText feedback = Text.literal("Disabled end portals").formatted(Formatting.RED);
            source.sendFeedback(() -> feedback, false);
        }

        return 1;
    }

    private static int setEndGateways(ServerCommandSource source, boolean enable) {
        DisablePortals.CONF.main.disableEndGateways = !enable;
        DisablePortals.CONF.saveConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        if (enable) {
            MutableText feedback = Text.literal("Enabled end gateways").formatted(Formatting.GREEN);
            source.sendFeedback(() -> feedback, false);
        } else {
            MutableText feedback = Text.literal("Disabled end gateways").formatted(Formatting.RED);
            source.sendFeedback(() -> feedback, false);
        }

        return 1;
    }

    private static int reloadConfig(ServerCommandSource source) {
        DisablePortals.CONF = Config.loadConfig(new File(FabricLoader.getInstance().getConfigDir() + "/DisablePortals.json"));

        MutableText feedback = Text.literal("Reloaded the config file!").formatted(Formatting.GREEN);
        source.sendFeedback(() -> feedback, false);

        return 1;
    }
}
