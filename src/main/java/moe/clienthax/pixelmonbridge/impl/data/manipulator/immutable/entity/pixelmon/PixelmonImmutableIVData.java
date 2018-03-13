package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableIVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableIVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableIVData;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableData;
import org.spongepowered.api.data.value.ValueFactory;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * Created by clienthax on 12/03/2018.
 */

public class PixelmonImmutableIVData extends AbstractImmutableData<ImmutableIVData, MutableIVData> implements ImmutableIVData {

    private final int hpIVS;
    private final int attackIVS;
    private final int defenseIVS;
    private final int spAttackIVS;
    private final int spDefenseIVS;
    private final int speedIVS;
    public static final ValueFactory VALUEFACTORY = Sponge.getRegistry().getValueFactory();

    final ImmutableValue<Integer> hpIVSValue;
    final ImmutableValue<Integer> attackIVSValue;
    final ImmutableValue<Integer> defenseIVSValue;
    final ImmutableValue<Integer> spAttackIVSValue;
    final ImmutableValue<Integer> spDefenseIVSValue;
    final ImmutableValue<Integer> speedIVSValue;

    public PixelmonImmutableIVData(int hpIVS, int attackIVS, int defenseIVS, int spAttackIVS, int spDefenseIVS, int speedIVS) {
        this.hpIVS = hpIVS;
        this.attackIVS = attackIVS;
        this.defenseIVS = defenseIVS;
        this.spAttackIVS = spAttackIVS;
        this.spDefenseIVS = spDefenseIVS;
        this.speedIVS = speedIVS;
        hpIVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_HP_IVS, hpIVS).asImmutable();
        attackIVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_ATTACK_IVS, attackIVS).asImmutable();
        defenseIVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_DEFENSE_IVS, defenseIVS).asImmutable();
        spAttackIVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, spAttackIVS).asImmutable();
        spDefenseIVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, spDefenseIVS).asImmutable();
        speedIVSValue = VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SPEED_IVS, speedIVS).asImmutable();
        registerGetters();
    }

    @Override
    protected void registerGetters() {
        registerFieldGetter(PixelmonDataKeys.POKEMON_HP_IVS, () -> this.hpIVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_HP_IVS, this::hpIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_ATTACK_IVS, () -> this.attackIVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_ATTACK_IVS, this::attackIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_DEFENSE_IVS, () -> this.defenseIVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_DEFENSE_IVS, this::defenseIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, () -> this.spAttackIVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, this::spAttackIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, () -> this.spDefenseIVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, this::spDefenseIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SPEED_IVS, () -> this.speedIVS);
        registerKeyValue(PixelmonDataKeys.POKEMON_SPEED_IVS, this::speedIVS);
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer()
                .set(PixelmonDataKeys.POKEMON_HP_IVS.getQuery(), this.hpIVS)
                .set(PixelmonDataKeys.POKEMON_ATTACK_IVS.getQuery(), this.attackIVS)
                .set(PixelmonDataKeys.POKEMON_DEFENSE_IVS.getQuery(), this.defenseIVS)
                .set(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS.getQuery(), this.spAttackIVS)
                .set(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS.getQuery(), this.spDefenseIVS)
                .set(PixelmonDataKeys.POKEMON_SPEED_IVS.getQuery(), this.speedIVS);
    }

    @Override
    public ImmutableValue<Integer> hpIVS() {
        return hpIVSValue;
    }

    @Override
    public ImmutableValue<Integer> attackIVS() {
        return attackIVSValue;
    }

    @Override
    public ImmutableValue<Integer> defenseIVS() {
        return defenseIVSValue;
    }

    @Override
    public ImmutableValue<Integer> spAttackIVS() {
        return spAttackIVSValue;
    }

    @Override
    public ImmutableValue<Integer> spDefenseIVS() {
        return spDefenseIVSValue;
    }

    @Override
    public ImmutableValue<Integer> speedIVS() {
        return speedIVSValue;
    }

    @Override
    public PixelmonMutableIVData asMutable() {
        return new PixelmonMutableIVData(this.hpIVS, this.attackIVS, this.defenseIVS, this.spAttackIVS, this.spDefenseIVS, this.speedIVS);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

}
