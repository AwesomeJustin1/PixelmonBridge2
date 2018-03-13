package moe.clienthax.pixelmonbridge.impl.mixin.core.api;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.enums.EnumType;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonEnumType;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.common.text.translation.SpongeTranslation;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(EnumType.class)
@Implements(@Interface(iface = PixelmonEnumType.class, prefix = "pixelmonenumtype$"))
public abstract class MixinEnumType {

    @Nullable
    private String spongeId;

    public String pixelmonenumtype$getId() {
        if (this.spongeId == null) {
            String name = ((EnumType) (Object) this).name();
            final String gameTypeName = name.equals("") ? "not_set" : name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }


    @Intrinsic
    public String pixelmonenumtype$getName() {
        return ((EnumType) (Object) this).name();
    }

}
