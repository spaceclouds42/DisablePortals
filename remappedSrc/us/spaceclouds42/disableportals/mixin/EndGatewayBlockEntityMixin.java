package us.spaceclouds42.disableportals.mixin;

import net.minecraft.block.entity.EndGatewayBlockEntity;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import us.spaceclouds42.disableportals.DisablePortals;

@Mixin(EndGatewayBlockEntity.class)
abstract class EndGatewayBlockEntityMixin {
    @Inject(
            method = "tryTeleportingEntity",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private void disableEndGateway(Entity entity, CallbackInfo ci) {
        if (DisablePortals.CONF.main.disableEndGateways) {
            ci.cancel();
        }
    }
}
