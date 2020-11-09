package chronosacaria.sgod.mixin;

import chronosacaria.sgod.mixin_methods.DontDropGearMethods;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {

    @Inject(method = "dropAll", at = @At(value = "HEAD"), cancellable = true)
    private void dontDropGear(CallbackInfo ci){
        PlayerInventory inv = (PlayerInventory) (Object) this;
        DontDropGearMethods.on(inv, ci);
    }
}
