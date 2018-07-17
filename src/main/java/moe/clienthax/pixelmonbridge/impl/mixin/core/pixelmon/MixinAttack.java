package moe.clienthax.pixelmonbridge.impl.mixin.core.pixelmon;

import com.pixelmonmod.pixelmon.battles.attacks.Attack;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Created by Justin
 */
@Mixin(Attack.class)
public abstract class MixinAttack implements moe.clienthax.pixelmonbridge.api.pixelmon.Attack {
    public MixinAttack() {

    }
}