package someassemblyrequired.common.util;

import net.minecraft.util.ResourceLocation;
import someassemblyrequired.SomeAssemblyRequired;

public class Util {

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(SomeAssemblyRequired.MODID, path);
    }
}
