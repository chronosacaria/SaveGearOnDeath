package chronosacaria.sgod.compat;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.event.TrinketDropCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

import static dev.emi.trinkets.api.TrinketEnums.*;

public class TrinketsCompat {

    public static void init(){
        if (FabricLoader.getInstance().isModLoaded("trinkets")){
            TrinketDropCallback.EVENT.register(new TrinketDropCallback() {
                @Override
                public DropRule drop(DropRule rule, ItemStack stack, SlotReference ref, LivingEntity entity) {
                    return DropRule.KEEP;
                }
            });
        }
    }
}
