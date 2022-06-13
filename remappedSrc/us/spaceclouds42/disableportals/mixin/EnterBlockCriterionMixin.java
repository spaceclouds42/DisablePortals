package us.spaceclouds42.disableportals.mixin;

import net.minecraft.advancement.criterion.EnterBlockCriterion;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import us.spaceclouds42.disableportals.DisablePortals;

@Mixin(EnterBlockCriterion.class)
abstract class EnterBlockCriterionMixin {
    @Inject(
            method = "trigger",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private void preventGatewayAdvancement(ServerPlayerEntity player, BlockState state, CallbackInfo ci) {
        if (state.getBlock() == Blocks.END_GATEWAY && DisablePortals.CONF.main.disableEndGateways) {
            ci.cancel();
        }
    }
}
