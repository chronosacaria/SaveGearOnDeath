package chronosacaria.sgod.compat;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import top.theillusivec4.curios.api.event.DropRulesCallback;
import top.theillusivec4.curios.api.type.component.ICurio;
import top.theillusivec4.curios.api.type.component.ICuriosItemHandler;

import java.util.List;
import java.util.function.Predicate;

public class CuriosCompat {

    public static void init(){
        if (FabricLoader.getInstance().isModLoaded("curios")){
            DropRulesCallback.EVENT.register(new DropRulesCallback() {
                @Override
                public void dropRules(LivingEntity livingEntity, ICuriosItemHandler iCuriosItemHandler, DamageSource damageSource, int i, boolean b, List<Pair<Predicate<ItemStack>, ICurio.DropRule>> list) {
                    list.add(new Pair<Predicate<ItemStack>, ICurio.DropRule>(x -> true, ICurio.DropRule.ALWAYS_KEEP));

                }
            });
        } else {
            return;
        }
    }
}
