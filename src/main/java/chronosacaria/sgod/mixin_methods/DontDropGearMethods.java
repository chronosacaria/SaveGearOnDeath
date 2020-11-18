package chronosacaria.sgod.mixin_methods;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class DontDropGearMethods {
    public static void on(PlayerInventory inv, CallbackInfo ci){
        for (int i = 0; i < inv.main.size(); i++){

            if (i < 9) {
                continue; // dont drop hotbar.
            }
            ItemStack stack = inv.main.get(i);

            if (!stack.isEmpty()){
                inv.player.dropItem(stack, true, false);
                inv.main.set(i, ItemStack.EMPTY); // needed to prevent duplication of some items
            }
            ci.cancel();
        }
    }
}
