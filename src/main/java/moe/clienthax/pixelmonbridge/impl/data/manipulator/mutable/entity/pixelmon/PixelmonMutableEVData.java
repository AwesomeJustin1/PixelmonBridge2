package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutableEVData;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.ValueFactory;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by clienthax on 12/03/2018.
 */
public class PixelmonMutableEVData extends AbstractData<MutableEVData, ImmutableEVData> implements MutableEVData {

    public static final ValueFactory VALUEFACTORY = Sponge.getRegistry().getValueFactory();
    private int hpEVS;
    private int attackEVS;
    private int defenseEVS;
    private int spAttackEVS;
    private int spDefenseEVS;
    private int speedEVS;

    public PixelmonMutableEVData() {
        this(0, 0, 0, 0, 0, 0);
    }

    public PixelmonMutableEVData(int hpEVS, int attackEVS, int defenseEVS, int spAttackEVS, int spDefenseEVS, int speedEVS) {
        this.hpEVS = hpEVS;
        this.attackEVS = attackEVS;
        this.defenseEVS = defenseEVS;
        this.spAttackEVS = spAttackEVS;
        this.spDefenseEVS = spDefenseEVS;
        this.speedEVS = speedEVS;
        registerGettersAndSetters();
    }

    @Override
    protected void registerGettersAndSetters() {
        registerFieldGetter(PixelmonDataKeys.POKEMON_HP_EVS, () -> this.hpEVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_HP_EVS, (value) -> this.hpEVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_HP_EVS, this::hpEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_ATTACK_EVS, () -> this.attackEVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_ATTACK_EVS, (value) -> this.attackEVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_ATTACK_EVS, this::attackEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_DEFENSE_EVS, () -> this.defenseEVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_DEFENSE_EVS, (value) -> this.defenseEVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_DEFENSE_EVS, this::defenseEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, () -> this.spAttackEVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, (value) -> this.spAttackEVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, this::spAttackEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, () -> this.spDefenseEVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, (value) -> this.spDefenseEVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, this::spDefenseEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SPEED_EVS, () -> this.speedEVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_SPEED_EVS, (value) -> this.speedEVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_SPEED_EVS, this::speedEVS);
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer()
                .set(PixelmonDataKeys.POKEMON_HP_EVS.getQuery(), this.hpEVS)
                .set(PixelmonDataKeys.POKEMON_ATTACK_EVS.getQuery(), this.attackEVS)
                .set(PixelmonDataKeys.POKEMON_DEFENSE_EVS.getQuery(), this.defenseEVS)
                .set(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS.getQuery(), this.spAttackEVS)
                .set(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS.getQuery(), this.spDefenseEVS)
                .set(PixelmonDataKeys.POKEMON_SPEED_EVS.getQuery(), this.speedEVS);
    }

    @Override
    public Value<Integer> hpEVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_HP_EVS, this.hpEVS);
    }

    @Override
    public Value<Integer> attackEVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_ATTACK_EVS, this.attackEVS);
    }

    @Override
    public Value<Integer> defenseEVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_DEFENSE_EVS, this.defenseEVS);
    }

    @Override
    public Value<Integer> spAttackEVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, this.spAttackEVS);
    }

    @Override
    public Value<Integer> spDefenseEVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, this.spDefenseEVS);
    }

    @Override
    public Value<Integer> speedEVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SPEED_EVS, this.speedEVS);
    }

    @Override
    public Optional<MutableEVData> fill(DataHolder dataHolder, MergeFunction overlap) {
        MutableEVData mutableEVData = checkNotNull(checkNotNull(overlap).merge(copy(), from(dataHolder.toContainer()).orElse(null)));
        return Optional.of(mutableEVData
                .set(PixelmonDataKeys.POKEMON_HP_EVS, this.hpEVS)
                .set(PixelmonDataKeys.POKEMON_ATTACK_EVS, this.attackEVS)
                .set(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, this.spDefenseEVS)
                .set(PixelmonDataKeys.POKEMON_DEFENSE_EVS, this.defenseEVS)
                .set(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, this.spAttackEVS)
                .set(PixelmonDataKeys.POKEMON_SPEED_EVS, this.spAttackEVS)
        );
    }

    @Override
    public Optional<MutableEVData> from(DataContainer container) {
        System.out.println("MutableEVDATA from??");
        return Optional.empty();
    }

    @Override
    public PixelmonMutableEVData copy() {
        return new PixelmonMutableEVData(this.hpEVS, this.attackEVS, this.defenseEVS, this.spAttackEVS, this.spDefenseEVS, this.speedEVS);
    }

    @Override
    public PixelmonImmutableEVData asImmutable() {
        return new PixelmonImmutableEVData(this.hpEVS, this.attackEVS, this.defenseEVS, this.spAttackEVS, this.spDefenseEVS, this.speedEVS);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

}