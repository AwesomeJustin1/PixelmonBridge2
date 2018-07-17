package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.comm.EnumUpdateType;
import com.pixelmonmod.pixelmon.entities.SpawnLocationType;
import com.pixelmonmod.pixelmon.entities.pixelmon.Entity1Base;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender;
import com.pixelmonmod.pixelmon.entities.pokeballs.EntityPokeBall;
import com.pixelmonmod.pixelmon.enums.EnumBossMode;
import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import com.pixelmonmod.pixelmon.enums.EnumNature;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.common.mixin.core.entity.passive.MixinEntityTameable;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by Justin
 */
@Mixin(Entity1Base.class)
public abstract class MixinEntity1Base extends MixinEntityTameable {
    @Shadow
    public EnumPokeballs caughtBall;
    @Shadow
    public EntityPokeBall hitByPokeball;
    @Shadow
    @Deprecated
    public Gender gender;
    @Shadow
    public boolean isInBall;
    @Shadow
    public boolean isFainted;
    @Shadow
    public boolean isInitialised;
    @Shadow
    public String originalTrainer;
    @Shadow
    public boolean canDespawn;
    @Shadow
    protected int entityAge;
    @Shadow
    protected EnumBossMode serverBossMode;
    @Shadow
    private EnumPokemon species;

    @Shadow
    protected static void stripVanillaNBT(NBTTagCompound nbt) {
    }

    @Shadow
    public abstract EnumPokemon getSpecies();

    @Shadow
    protected abstract void init(String name);

    @Shadow
    public abstract String getPokemonName();

    @Shadow
    public abstract String getLocalizedName();

    @Shadow
    public abstract String getLocalizedDescription();

    @Shadow
    public abstract String getNickname();

    @Shadow
    public abstract void setNickname(String nickname);

    @Shadow
    public abstract String getEscapedNickname();

    @Shadow
    public abstract boolean hasNickname();

    @Shadow
    public abstract int[] getPokemonId();

    @Shadow
    public abstract void setPokemonId(int[] id);

    @Shadow
    public abstract EnumBossMode getBossMode();

    @Shadow
    public abstract void setBoss(EnumBossMode mode);

    @Shadow
    public abstract boolean isBossPokemon();

    @Shadow
    public abstract Optional<PlayerStorage> getStorage();

    @Shadow
    public abstract EnumNature getNature();

    @Shadow
    public abstract void setNature(EnumNature nature);

    @Shadow
    public abstract EnumGrowth getGrowth();

    @Shadow
    public abstract void setGrowth(EnumGrowth growth);

    @Shadow
    public abstract Gender getGender();

    @Shadow
    public abstract void setGender(Gender gender);

    @Shadow
    public abstract SpawnLocationType getSpawnLocation();

    @Shadow
    public abstract void setSpawnLocation(SpawnLocationType spawnLocation);

    @Shadow
    public abstract boolean hasOwner();

    @Shadow
    public abstract boolean belongsTo(EntityPlayer player);

    @Shadow
    public abstract void update(EnumUpdateType... types);

    @Shadow
    public abstract void setName(String name);

    @Shadow
    public abstract void getNBTTags(HashMap<String, Class> tags);
}
