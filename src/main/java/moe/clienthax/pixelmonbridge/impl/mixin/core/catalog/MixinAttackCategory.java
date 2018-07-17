package moe.clienthax.pixelmonbridge.impl.mixin.core.catalog;

import moe.clienthax.pixelmonbridge.api.catalog.attackcategory.AttackCategory;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Created by Justin
 */
@Mixin(com.pixelmonmod.pixelmon.enums.battle.AttackCategory.class)
@Implements(@Interface(iface = AttackCategory.class, prefix = "attackcategory$"))
public abstract class MixinAttackCategory {

    @Nullable
    private String spongeId;

    public String attackcategory$getId() {
        if (this.spongeId == null) {
            String name = ((com.pixelmonmod.pixelmon.enums.battle.AttackCategory) (Object) this).name();
            final String gameTypeName = name.equals("") ? "not_set" : name.toLowerCase(Locale.ENGLISH);
            this.spongeId = "pixelmon:" + gameTypeName;
        }
        return this.spongeId;
    }


    @Intrinsic
    public String attackcategory$getName() {
        return ((com.pixelmonmod.pixelmon.enums.battle.AttackCategory) (Object) this).name();
    }

}