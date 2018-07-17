package moe.clienthax.pixelmonbridge.impl;

import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraftforge.fml.relauncher.CoreModManager;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Map;

/**
 * Created by clienthax on 09/03/2018.
 */
@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.DependsOn("pixelmon")
public class PixelmonBridgeCoreMod implements IFMLLoadingPlugin {
    static File modFile;

    public PixelmonBridgeCoreMod() {

        //TODO nasty hack to get pixelmon up at the same time as the mixins
        try {
            //If the server owner changed the Pixelmon jar name to something other than the default or Pixelmon.jar then its on them :P
            loadModJar(new File("./mods").listFiles(f-> f.getName().startsWith("Pixelmon-1.12.2") || f.getName().equals("Pixelmon.jar"))[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        MixinBootstrap.init();

        //TODO debug options
        MixinEnvironment.getDefaultEnvironment().setOption(MixinEnvironment.Option.DEBUG_EXPORT_DECOMPILE, true);
        MixinEnvironment.getDefaultEnvironment().setOption(MixinEnvironment.Option.DEBUG_EXPORT, true);

        Mixins.addConfiguration("mixins.pixelmonmod.core.json");
        Mixins.addConfiguration("mixins.pixelmonmod.sponge.json");
    }

    private void loadModJar(File jar) throws Exception {
        ((LaunchClassLoader) this.getClass().getClassLoader()).addURL(jar.toURI().toURL());
        CoreModManager.getReparseableCoremods().add(jar.getName());
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        modFile = (File) data.get("coremodLocation");
        if (modFile == null) {
            modFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        }
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
