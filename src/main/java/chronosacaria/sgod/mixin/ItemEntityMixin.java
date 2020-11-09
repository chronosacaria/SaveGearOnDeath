package chronosacaria.sgod.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

    @Inject(method = "onPlayerCollision", at = @At(value = "HEAD"), cancellable = true)
    private void dontPickupGearWhenDead(PlayerEntity player, CallbackInfo ci){
        if (!player.isAlive()){
            ci.cancel();
        }
    }
}
