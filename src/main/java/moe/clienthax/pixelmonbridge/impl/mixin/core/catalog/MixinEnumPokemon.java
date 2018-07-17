package moe.clienthax.pixelmonbridge.impl.mixin.core.catalog;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import moe.clienthax.pixelmonbridge.api.catalog.pixelmon.PixelmonType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.common.text.translation.SpongeTranslation;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(EnumPokemon.class)
@Implements(@Interface(iface = PixelmonType.class, prefix = "pixelmontype$"))
public abstract class MixinEnumPokemon {

    @Shadow(remap = false)
    public String name;
    @Nullable
    private String spongeId;

    public String pixelmontype$getId() {
        if (this.spongeId == null) {
            final String gameTypeName = this.name.equals("") ? "not_set" : this.name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }

    @Intrinsic
    public String pixelmontype$getName() {
        return name;
    }

    public Translation pixelmontype$getTranslation() {
        return new SpongeTranslation("pixelmontype." + this.name.toLowerCase(Locale.ENGLISH));
    }

    public Class<? extends Entity> pixelmontype$getEntityClass() {
        return (Class<? extends org.spongepowered.api.entity.Entity>) (Object) EntityPixelmon.class;
    }

}
