package chronosacaria.sgod;

import chronosacaria.sgod.compat.TrinketsCompat;
import net.fabricmc.api.ModInitializer;

public class Sgod implements ModInitializer {
    @Override
    public void onInitialize() {
        TrinketsCompat.init();
    }
}
