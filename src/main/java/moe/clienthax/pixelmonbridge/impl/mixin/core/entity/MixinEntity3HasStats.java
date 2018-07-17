package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.SpawnLocationType;
import com.pixelmonmod.pixelmon.entities.pixelmon.Entity3HasStats;
import com.pixelmonmod.pixelmon.entities.pixelmon.abilities.AbilityBase;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.*;
import com.pixelmonmod.pixelmon.entities.pixelmon.tickHandlers.TickHandlerBase;
import com.pixelmonmod.pixelmon.enums.EnumType;
import com.pixelmonmod.pixelmon.enums.forms.IEnumForm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Justin
 */
@Mixin(Entity3HasStats.class)
public abstract class MixinEntity3HasStats extends MixinEntity2HasModel {
    @Shadow
    public Stats stats;

    @Shadow
    public BaseStats baseStats;

    @Shadow
    public FriendShip friendship;

    @Shadow
    public ArrayList<EnumType> type;

    @Shadow
    public float length;

    @Shadow
    public boolean doesLevel;

    @Shadow
    public ExtraStats extraStats;

    @Shadow
    public boolean isMega;

    @Shadow
    protected Level level;

    @Shadow
    private String oldName;

    @Shadow
    private int oldForm;

    @Shadow
    private AbilityBase ability;

    @Shadow
    private Integer abilitySlot;

    @Shadow
    private TickHandlerBase tickHandler;

    public MixinEntity3HasStats() {

    }

    @Shadow
    public abstract int getCatchRate();

    @Shadow
    public abstract Level getLvl();

    @Shadow
    protected abstract ExtraStats getExtraStats(String name);

    @Shadow
    abstract float getMoveSpeed();

    @Shadow
    protected abstract void setType();

    @Shadow
    public abstract void updateHealth();

    @Shadow
    public abstract float getPixelmonScale();

    @Shadow
    public abstract void setPixelmonScale(float scale);

    @Shadow
    public abstract void updateStats();

    @Shadow
    public abstract AbilityBase getAbility();

    @Shadow
    public abstract void setAbility(String abilityName);

    @Shadow
    public abstract void setAbility(AbilityBase newAbility);

    @Shadow
    protected abstract void giveAbility();

    @Shadow
    public abstract Integer getAbilitySlot();

    @Shadow
    public abstract void setAbilitySlot(Integer slot);

    @Shadow
    public abstract void giveAbilitySlot();

    @Shadow
    public abstract void setRandomAbilityUniform();

    @Shadow
    public abstract int getForm();

    @Shadow
    public abstract void setForm(int form);

    @Shadow
    public abstract Optional<Pokerus> getPokerus();

    @Shadow
    public abstract void setPokerus(Pokerus pokerus);

    @Shadow
    public abstract IEnumForm getFormEnum();

    @Shadow
    public abstract void setForm(int form, boolean update);

    @Shadow
    public abstract boolean hasForms();

    @Shadow
    public abstract int getNumForms();

    @Shadow
    public abstract int getFormIncludeTransformed();

    @Shadow
    public abstract int getPartyPosition();

    @Shadow
    public abstract boolean isAvailableGeneration();

    @Shadow
    public abstract void chooseRandomGender();

    @Shadow
    public abstract SpawnLocationType getDefaultSpawnLocation();

    @Shadow
    public abstract FlyingParameters getFlyingParameters();

    @Shadow
    public abstract SwimmingParameters getSwimmingParameters();

    @Shadow
    public abstract BaseStats initializeBaseStatsIfNull();
}