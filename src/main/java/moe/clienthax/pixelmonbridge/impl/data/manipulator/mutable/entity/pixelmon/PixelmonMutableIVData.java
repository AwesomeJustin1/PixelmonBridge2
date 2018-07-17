package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableIVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableIVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutableIVData;
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
public class PixelmonMutableIVData extends AbstractData<MutableIVData, ImmutableIVData> implements MutableIVData {

    public static final ValueFactory VALUEFACTORY = Sponge.getRegistry().getValueFactory();
    private int hpIVS;
    private int attackIVS;
    private int defenseIVS;
    private int spAttackIVS;
    private int spDefenseIVS;
    private int speedIVS;

    public PixelmonMutableIVData() {
        this(0, 0, 0, 0, 0, 0);
    }

    public PixelmonMutableIVData(int hpIVS, int attackIVS, int defenseIVS, int spAttackIVS, int spDefenseIVS, int speedIVS) {
        this.hpIVS = hpIVS;
        this.attackIVS = attackIVS;
        this.defenseIVS = defenseIVS;
        this.spAttackIVS = spAttackIVS;
        this.spDefenseIVS = spDefenseIVS;
        this.speedIVS = speedIVS;
        registerGettersAndSetters();
    }

    @Override
    protected void registerGettersAndSetters() {
        registerFieldGetter(PixelmonDataKeys.POKEMON_HP_IVS, () -> this.hpIVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_HP_IVS, (value) -> this.hpIVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_HP_IVS, this::hpIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_ATTACK_IVS, () -> this.attackIVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_ATTACK_IVS, (value) -> this.attackIVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_ATTACK_IVS, this::attackIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_DEFENSE_IVS, () -> this.defenseIVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_DEFENSE_IVS, (value) -> this.defenseIVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_DEFENSE_IVS, this::defenseIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, () -> this.spAttackIVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, (value) -> this.spAttackIVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, this::spAttackIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, () -> this.spDefenseIVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, (value) -> this.spDefenseIVS = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, this::spDefenseIVS);

        registerFieldGetter(PixelmonDataKeys.POKEMON_SPEED_IVS, () -> this.speedIVS);
        registerFieldSetter(PixelmonDataKeys.POKEMON_SPEED_IVS, (value) -> this.speedIVS = value);
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
    public Value<Integer> hpIVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_HP_IVS, this.hpIVS);
    }

    @Override
    public Value<Integer> attackIVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_ATTACK_IVS, this.attackIVS);
    }

    @Override
    public Value<Integer> defenseIVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_DEFENSE_IVS, this.defenseIVS);
    }

    @Override
    public Value<Integer> spAttackIVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, this.spAttackIVS);
    }

    @Override
    public Value<Integer> spDefenseIVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, this.spDefenseIVS);
    }

    @Override
    public Value<Integer> speedIVS() {
        return VALUEFACTORY.createValue(PixelmonDataKeys.POKEMON_SPEED_IVS, this.speedIVS);
    }

    @Override
    public Optional<MutableIVData> fill(DataHolder dataHolder, MergeFunction overlap) {
        MutableIVData mutableIVData = checkNotNull(checkNotNull(overlap).merge(copy(), from(dataHolder.toContainer()).orElse(null)));
        return Optional.of(mutableIVData
                .set(PixelmonDataKeys.POKEMON_HP_IVS, this.hpIVS)
                .set(PixelmonDataKeys.POKEMON_ATTACK_IVS, this.attackIVS)
                .set(PixelmonDataKeys.POKEMON_SP_DEFENSE_IVS, this.spDefenseIVS)
                .set(PixelmonDataKeys.POKEMON_DEFENSE_IVS, this.defenseIVS)
                .set(PixelmonDataKeys.POKEMON_SP_ATTACK_IVS, this.spAttackIVS)
                .set(PixelmonDataKeys.POKEMON_SPEED_IVS, this.spAttackIVS)
        );
    }

    @Override
    public Optional<MutableIVData> from(DataContainer container) {
        System.out.println("MutableIVDATA from??");
        return Optional.empty();
    }

    @Override
    public PixelmonMutableIVData copy() {
        return new PixelmonMutableIVData(this.hpIVS, this.attackIVS, this.defenseIVS, this.spAttackIVS, this.spDefenseIVS, this.speedIVS);
    }

    @Override
    public PixelmonImmutableIVData asImmutable() {
        return new PixelmonImmutableIVData(this.hpIVS, this.attackIVS, this.defenseIVS, this.spAttackIVS, this.spDefenseIVS, this.speedIVS);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

}