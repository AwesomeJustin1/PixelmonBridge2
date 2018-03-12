package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableBaseStatsData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableBaseStatsData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon.PixelmonImmutableBaseStatsData;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.value.mutable.SpongeValue;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by clienthax on 12/03/2018.
 */

public class PixelmonMutableBaseStatsData extends AbstractData<MutableBaseStatsData, ImmutableBaseStatsData> implements MutableBaseStatsData {

    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;

    public PixelmonMutableBaseStatsData() {
        this(0, 0, 0, 0, 0, 0);
    }

    public PixelmonMutableBaseStatsData(int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        registerGettersAndSetters();
    }

    @Override
    protected void registerGettersAndSetters() {
        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_HP, () -> this.hp);
        registerFieldSetter(PixelmonDataKeys.POKEMON_BASESTATS_HP, (value) -> this.hp = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_HP, this::hp);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, () -> this.attack);
        registerFieldSetter(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, (value) -> this.attack = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, this::attack);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, () -> this.defense);
        registerFieldSetter(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, (value) -> this.defense = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, this::defense);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, () -> this.spAttack);
        registerFieldSetter(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, (value) -> this.spAttack = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, this::spAttack);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, () -> this.spDefense);
        registerFieldSetter(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, (value) -> this.spDefense = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, this::spDefense);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, () -> this.speed);
        registerFieldSetter(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, (value) -> this.speed = value);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, this::speed);
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer()
                .set(PixelmonDataKeys.POKEMON_BASESTATS_HP.getQuery(), this.hp)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK.getQuery(), this.attack)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE.getQuery(), this.defense)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK.getQuery(), this.spAttack)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE.getQuery(), this.spDefense)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_SPEED.getQuery(), this.speed);
    }

    @Override
    public Value<Integer> hp() {
        return new SpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_HP, this.hp);
    }

    @Override
    public Value<Integer> attack() {
        return new SpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, this.attack);
    }

    @Override
    public Value<Integer> defense() {
        return new SpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, this.defense);
    }

    @Override
    public Value<Integer> spAttack() {
        return new SpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, this.spAttack);
    }

    @Override
    public Value<Integer> spDefense() {
        return new SpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, this.spDefense);
    }

    @Override
    public Value<Integer> speed() {
        return new SpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, this.speed);
    }

    @Override
    public Optional<MutableBaseStatsData> fill(DataHolder dataHolder, MergeFunction overlap) {
        MutableBaseStatsData mutableBaseStatsData = checkNotNull(checkNotNull(overlap).merge(copy(), from(dataHolder.toContainer()).orElse(null)));
        return Optional.of(mutableBaseStatsData
                .set(PixelmonDataKeys.POKEMON_BASESTATS_HP, this.hp)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, this.attack)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, this.defense)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, this.spAttack)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, this.spDefense)
                .set(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, this.speed)
        );
    }

    @Override
    public Optional<MutableBaseStatsData> from(DataContainer container) {
        return Optional.empty();
    }

    @Override
    public PixelmonMutableBaseStatsData copy() {
        return new PixelmonMutableBaseStatsData(this.hp, this.attack, this.defense, this.spAttack, this.spDefense, this.speed);
    }

    @Override
    public PixelmonImmutableBaseStatsData asImmutable() {
        return new PixelmonImmutableBaseStatsData(this.hp, this.attack, this.defense, this.spAttack, this.spDefense, this.speed);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

}
