package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.PixelmonMethods;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Stats;
import com.pixelmonmod.pixelmon.enums.EnumNature;
import com.pixelmonmod.pixelmon.enums.EnumType;
import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import com.pixelmonmod.pixelmon.storage.NbtKeys;
import moe.clienthax.pixelmonbridge.api.catalog.ability.Ability;
import moe.clienthax.pixelmonbridge.api.catalog.aggression.Aggression;
import moe.clienthax.pixelmonbridge.api.catalog.aggression.Aggressions;
import moe.clienthax.pixelmonbridge.api.catalog.ball.Ball;
import moe.clienthax.pixelmonbridge.api.catalog.gender.Gender;
import moe.clienthax.pixelmonbridge.api.catalog.gender.Genders;
import moe.clienthax.pixelmonbridge.api.catalog.growth.Growth;
import moe.clienthax.pixelmonbridge.api.catalog.growth.Growths;
import moe.clienthax.pixelmonbridge.api.catalog.nature.Nature;
import moe.clienthax.pixelmonbridge.api.catalog.type.Type;
import moe.clienthax.pixelmonbridge.api.entity.Player;
import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pokemon;
import moe.clienthax.pixelmonbridge.api.pixelmon.Moveset;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.api.Sponge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Justin
 */
@Mixin(NBTTagCompound.class)
public abstract class MixinNBTTagCompound implements Pokemon {
    @Shadow
    public abstract String getString(String p_getString_1_);

    @Shadow
    public abstract void setString(String p_setString_1_, String p_setString_2_);

    @Shadow
    public abstract int getInteger(String p_getInteger_1_);

    @Shadow
    public abstract short getShort(String p_getShort_1_);

    @Shadow
    public abstract void setInteger(String p_setInteger_1_, int p_setInteger_2_);

    @Shadow
    public abstract void setShort(String p_setShort_1_, short p_setShort_2_);

    @Shadow
    @Nullable
    public abstract UUID getUniqueId(String p_getUniqueId_1_);

    @Shadow
    public abstract void setUniqueId(String p_setUniqueId_1_, UUID p_setUniqueId_2_);

    @Shadow
    public abstract byte getByte(String p_getByte_1_);

    @Shadow
    public abstract void setByte(String p_setByte_1_, byte p_setByte_2_);

    @Shadow
    public abstract boolean getBoolean(String p_getBoolean_1_);

    @Shadow
    public abstract void setBoolean(String p_setBoolean_1_, boolean p_setBoolean_2_);

    @Shadow
    public abstract void removeTag(String p_removeTag_1_);

    @Override
    public String getName() {
        return getString(NbtKeys.NAME);
    }

    @Override
    public Pokemon setName(String name) {
        setString(NbtKeys.NAME, name);
        setString(NbtKeys.ID, name);
        return this;
    }

    @Override
    public Ability getAbility() {
        return Ability.getAbility(getString(NbtKeys.ABILITY)).get();
    }

    @Override
    public Pokemon setAbilityBase(Ability ability) {
        setString(NbtKeys.ABILITY, ability.getName());
        return this;
    }

    @Override
    public Aggression getAggression() {
        try {
            return (Aggression) Aggressions.class.getDeclaredFields()[getInteger(NbtKeys.AGGRESSION)].get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return Aggressions.TIMID;
    }

    @Override
    public Pokemon setAggression(Aggression aggression) {
        setInteger(NbtKeys.AGGRESSION, aggression.getIndex());
        return this;
    }

    @Override
    public Ball getBall() {
        return Ball.fromEnum(EnumPokeballs.getFromIndex(getShort(NbtKeys.CAUGHT_BALL)));
    }

    @Override
    public Pokemon setBall(Ball ball) {
        setShort(NbtKeys.CAUGHT_BALL, (short) ball.getIndex());
        return this;
    }

    @Override
    public int getForm() {
        return getShort(NbtKeys.FORM);
    }

    @Override
    public Pokemon setForm(int form) {
        setShort(NbtKeys.FORM, (short) form);
        return this;
    }

    @Override
    public Optional<Player> getOwner() {
        return Sponge.getServer().getPlayer(getUniqueId(NbtKeys.PIXELMON_OWNER)).map(p -> (Player) p);
    }

    @Override
    public Pokemon setOwner(Player player) {
        setUniqueId(NbtKeys.PIXELMON_OWNER, player.getUniqueId());
        return this;
    }

    @Override
    public Gender getGender() {
        try {
            return (Gender) Genders.class.getDeclaredFields()[getByte(NbtKeys.GENDER)].get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return Genders.NONE;
    }

    @Override
    public Pokemon setGender(Gender gender) {
        setByte(NbtKeys.GENDER, (byte) gender.getIndex());
        return this;
    }

    @Override
    public Growth getGrowth() {
        try {
            return (Growth) Genders.class.getDeclaredFields()[getByte(NbtKeys.GROWTH)].get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return Growths.ORDINARY;
    }

    @Override
    public Pokemon setGrowth(Growth growth) {
        setByte(NbtKeys.GROWTH, (byte) growth.getIndex());
        return this;
    }

    @Override
    public boolean isShiny() {
        return getBoolean(NbtKeys.SHINY);
    }

    @Override
    public Pokemon setIsShiny(boolean shiny) {
        setBoolean(NbtKeys.SHINY, shiny);
        return this;
    }

    @Override
    public int getSlot() {
        return getInteger(NbtKeys.PIXELMON_ORDER);
    }

    @Override
    public int[] getPokemonId() {
        return PixelmonMethods.getID((NBTTagCompound) (Object) this);
    }

    @Override
    public String getOriginalTrainer() {
        return getString(NbtKeys.ORIGINAL_TRAINER);
    }

    @Override
    public Pokemon setOriginalTrainer(String name) {
        setString(NbtKeys.ORIGINAL_TRAINER, name);
        return this;
    }

    @Override
    public Pokemon setOriginalTrainer(Player player) {
        setOriginalTrainer(player.getName());
        return this;
    }

    @Override
    public Pokemon setOriginalTrainer(UUID uuid) {
        setOriginalTrainer((Player) Sponge.getServer().getPlayer(uuid).get());
        return this;
    }

    @Override
    public String getNickname() {
        return getString(NbtKeys.NICKNAME);
    }

    @Override
    public Pokemon setNickname(String nickname) {
        setString(NbtKeys.NICKNAME, nickname);
        return this;
    }

    @Override
    public Moveset getMoveset() {
        com.pixelmonmod.pixelmon.entities.pixelmon.stats.Moveset moveset = new com.pixelmonmod.pixelmon.entities.pixelmon.stats.Moveset((NBTTagCompound) (Object) this);
        moveset.readFromNBT((NBTTagCompound) (Object) this);
        return (Moveset) moveset;
    }

    @Override
    public Pokemon setMoveset(Moveset moveset) {
        ((com.pixelmonmod.pixelmon.entities.pixelmon.stats.Moveset) moveset).writeToNBT((NBTTagCompound) (Object) this);
        return this;
    }

    @Override
    public moe.clienthax.pixelmonbridge.api.pixelmon.Stats getStats() {
        Stats stats = new Stats();
        stats.readFromNBT((NBTTagCompound) (Object) this);
        return (moe.clienthax.pixelmonbridge.api.pixelmon.Stats) stats;
    }

    @Override
    public Pokemon setStats(moe.clienthax.pixelmonbridge.api.pixelmon.Stats stats) {
        ((Stats) stats).writeToNBT((NBTTagCompound) (Object) this);
        return this;
    }

    @Override
    public Pokemon setNature(Nature nature) {
        setByte(NbtKeys.NATURE, (byte) ((EnumNature) (Object) nature).index);
        return this;
    }

    @Override
    public Nature getNature() {
        return (Nature) (Object) EnumNature.getNatureFromIndex(getByte(NbtKeys.NATURE));
    }

    @Override
    public Type getMainType() {
        return (Type) (Object) EnumType.parseType(getInteger(NbtKeys.PIXELMON_TYPE));
    }

    @Override
    public Optional<Type> getSecondaryType() {
        return Optional.ofNullable((Type) (Object) EnumType.parseType(getInteger(NbtKeys.SECONDARY_TYPE)));
    }

    @Override
    public int getFriendship() {
        return (int) getShort(NbtKeys.FRIENDSHIP);
    }

    @Override
    public Pokemon setFriendship(int friendship) {
        setShort(NbtKeys.FRIENDSHIP, (short) friendship);
        return this;
    }

    @Override
    public int getLevel() {
        return (int) getShort(NbtKeys.FRIENDSHIP);
    }

    @Override
    public Pokemon setLevel(int level) {
        setShort(NbtKeys.LEVEL, (short) level);
        return this;
    }
}