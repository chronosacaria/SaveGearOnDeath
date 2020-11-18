package chronosacaria.sgod.mixin;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    //Keep saved inventory items after clicking respawn button
    @Inject(method = "copyFrom", at = @At(value = "HEAD"))
    private void dontDropGear(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
        if (oldPlayer.world.getGameRules().getBoolean(GameRules.KEEP_INVENTORY)) {
            return;
        }
        ServerPlayerEntity p = (ServerPlayerEntity) (Object) this;
        p.inventory.clone(oldPlayer.inventory);
    }
}
