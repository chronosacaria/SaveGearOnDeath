package chronosacaria.sgod;

import chronosacaria.sgod.compat.CuriosCompat;
import net.fabricmc.api.ModInitializer;

public class Sgod implements ModInitializer {
    @Override
    public void onInitialize() {
        CuriosCompat.init();
    }
}
