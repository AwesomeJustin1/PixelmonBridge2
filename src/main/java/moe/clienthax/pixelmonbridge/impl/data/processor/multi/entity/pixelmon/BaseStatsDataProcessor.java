package moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.pixelmon;

import com.google.common.collect.ImmutableMap;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableBaseStatsData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableBaseStatsData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableBaseStatsData;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.common.data.processor.common.AbstractEntityDataProcessor;

import java.util.Map;
import java.util.Optional;

/**
 * Created by clienthax on 12/03/2018.
 */
public class BaseStatsDataProcessor extends AbstractEntityDataProcessor<EntityPixelmon, MutableBaseStatsData, ImmutableBaseStatsData> {

    public BaseStatsDataProcessor() {
        super(EntityPixelmon.class);
    }

    @Override
    protected boolean doesDataExist(EntityPixelmon dataHolder) {
        return true;
    }

    @Override
    protected boolean set(EntityPixelmon dataHolder, Map<Key<?>, Object> keyValues) {
        dataHolder.baseStats.stats.put(StatsType.HP, (int) keyValues.get(PixelmonDataKeys.POKEMON_BASESTATS_HP));
        dataHolder.baseStats.attack = (int) keyValues.get(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK);
        dataHolder.baseStats.defence = (int) keyValues.get(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE);
        dataHolder.baseStats.spAtt = (int) keyValues.get(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK);
        dataHolder.baseStats.spDef = (int) keyValues.get(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE);
        dataHolder.baseStats.speed = (int) keyValues.get(PixelmonDataKeys.POKEMON_BASESTATS_SPEED);
        return true;
    }

    @Override
    protected Map<Key<?>, ?> getValues(EntityPixelmon dataHolder) {
        ImmutableMap.Builder<Key<?>, Object> builder = ImmutableMap.builder();
        builder.put(PixelmonDataKeys.POKEMON_BASESTATS_HP, dataHolder.baseStats.hp);
        builder.put(PixelmonDataKeys.POKEMON_BASESTATS_ATTACK, dataHolder.baseStats.attack);
        builder.put(PixelmonDataKeys.POKEMON_BASESTATS_DEFENSE, dataHolder.baseStats.defence);
        builder.put(PixelmonDataKeys.POKEMON_BASESTATS_SP_ATTACK, dataHolder.baseStats.spAtt);
        builder.put(PixelmonDataKeys.POKEMON_BASESTATS_SP_DEFENSE, dataHolder.baseStats.spDef);
        builder.put(PixelmonDataKeys.POKEMON_BASESTATS_SPEED, dataHolder.baseStats.speed);
        return builder.build();
    }

    @Override
    protected MutableBaseStatsData createManipulator() {
        return new PixelmonMutableBaseStatsData();
    }

    @Override
    public Optional<MutableBaseStatsData> fill(DataContainer container, MutableBaseStatsData mutableIVData) {
        System.out.println("basestats->fill");

        return Optional.empty();
    }

    @Override
    public DataTransactionResult remove(DataHolder dataHolder) {
        return DataTransactionResult.failNoData();
    }


}
