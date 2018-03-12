package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableBaseStatsData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableBaseStatsData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableBaseStatsData;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;

/**
 * Created by clienthax on 12/03/2018.
 */
public class PixelmonImmutableBaseStatsData extends AbstractImmutableData<ImmutableBaseStatsData, MutableBaseStatsData> implements ImmutableBaseStatsData {

    private final int hp;
    private final int attack;
    private final int defense;
    private final int spAttack;
    private final int spDefense;
    private final int speed;

    private final ImmutableValue<Integer> hpValue;
    private final ImmutableValue<Integer> attackValue;
    private final ImmutableValue<Integer> defenseValue;
    private final ImmutableValue<Integer> spAttackValue;
    private final ImmutableValue<Integer> spDefenseValue;
    private final ImmutableValue<Integer> speedValue;

    public PixelmonImmutableBaseStatsData(int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        hpValue = new ImmutableSpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_HP, hp);
        attackValue = new ImmutableSpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, attack);
        defenseValue = new ImmutableSpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, defense);
        spAttackValue = new ImmutableSpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, spAttack);
        spDefenseValue = new ImmutableSpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, spDefense);
        speedValue = new ImmutableSpongeValue<>(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, speed);
        registerGetters();
    }

    @Override
    protected void registerGetters() {
        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_HP, () -> this.hp);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_HP, this::hp);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, () -> this.attack);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, this::attack);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, () -> this.defense);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, this::defense);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, () -> this.spAttack);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, this::spAttack);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, () -> this.spDefense);
        registerKeyValue(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, this::spDefense);

        registerFieldGetter(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, () -> this.speed);
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
    public ImmutableValue<Integer> hp() {
        return hpValue;
    }

    @Override
    public ImmutableValue<Integer> attack() {
        return attackValue;
    }

    @Override
    public ImmutableValue<Integer> defense() {
        return defenseValue;
    }

    @Override
    public ImmutableValue<Integer> spAttack() {
        return spAttackValue;
    }

    @Override
    public ImmutableValue<Integer> spDefense() {
        return spDefenseValue;
    }

    @Override
    public ImmutableValue<Integer> speed() {
        return speedValue;
    }

    @Override
    public PixelmonMutableBaseStatsData asMutable() {
        return new PixelmonMutableBaseStatsData(this.hp, this.attack, this.defense, this.spAttack, this.spDefense, this.speed);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

}
