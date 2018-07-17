package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableEVData;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableData;
import org.spongepowered.api.data.value.ValueFactory;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 12/03/2018.
 */

public class PixelmonImmutableEVData extends AbstractImmutableData<ImmutableEVData, MutableEVData> implements ImmutableEVData {

    public static final ValueFactory VALUEFACTORY = Sponge.getRegistry().getValueFactory();
    final ImmutableValue<Integer> hpEVSValue;
    final ImmutableValue<Integer> attackEVSValue;
    final ImmutableValue<Integer> defenseEVSValue;
    final ImmutableValue<Integer> spAttackEVSValue;
    final ImmutableValue<Integer> spDefenseEVSValue;
    final ImmutableValue<Integer> speedEVSValue;
    private final int hpEVS;
    private final int attackEVS;
    private final int defenseEVS;
    private final int spAttackEVS;
    private final int spDefenseEVS;
    private final int speedEVS;

    public PixelmonImmutableEVData(int hpEVS, int attackEVS, int defenseEVS, int spAttackEVS, int spDefenseEVS, int speedEVS) {
        this.hpEVS = hpEVS;
        this.attackEVS = attackEVS;
        this.defenseEVS = defenseEVS;
        this.spAttackEVS = spAttackEVS;
        this.spDefenseEVS = spDefenseEVS;
        this.speedEVS = speedEVS;
        hpEVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_HP_EVS, hpEVS).asImmutable();
        attackEVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_ATTACK_EVS, attackEVS).asImmutable();
        defenseEVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_DEFENSE_EVS, defenseEVS).asImmutable();
        spAttackEVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, spAttackEVS).asImmutable();
        spDefenseEVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, spDefenseEVS).asImmutable();
        speedEVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SPEED_EVS, speedEVS).asImmutable();
        registerGetters();
    }

    @Override
    protected void registerGetters() {
        registerFieldGetter(PixelmonDataKeys.POKEMON_HP_EVS, () -> this.hpEVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_HP_EVS, this::hpEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_ATTACK_EVS, () -> this.attackEVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_ATTACK_EVS, this::attackEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_DEFENSE_EVS, () -> this.defenseEVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_DEFENSE_EVS, this::defenseEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, () -> this.spAttackEVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, this::spAttackEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, () -> this.spDefenseEVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, this::spDefenseEVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SPEED_EVS, () -> this.speedEVS);
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
    public ImmutableValue<Integer> hpEVS() {
        return hpEVSValue;
    }

    @Override
    public ImmutableValue<Integer> attackEVS() {
        return attackEVSValue;
    }

    @Override
    public ImmutableValue<Integer> defenseEVS() {
        return defenseEVSValue;
    }

    @Override
    public ImmutableValue<Integer> spAttackEVS() {
        return spAttackEVSValue;
    }

    @Override
    public ImmutableValue<Integer> spDefenseEVS() {
        return spDefenseEVSValue;
    }

    @Override
    public ImmutableValue<Integer> speedEVS() {
        return speedEVSValue;
    }

    @Override
    public PixelmonMutableEVData asMutable() {
        return new PixelmonMutableEVData(this.hpEVS, this.attackEVS, this.defenseEVS, this.spAttackEVS, this.spDefenseEVS, this.speedEVS);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

}
