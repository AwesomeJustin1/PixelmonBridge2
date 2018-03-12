package moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.pixelmon;

import com.google.common.collect.ImmutableMap;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEVData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableEVData;
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

public class EVDataProcessor extends AbstractEntityDataProcessor<EntityPixelmon, MutableEVData, ImmutableEVData> {

    public EVDataProcessor() {
        super(EntityPixelmon.class);
    }

    @Override
    protected boolean doesDataExist(EntityPixelmon dataHolder) {
        return true;
    }

    @Override
    protected boolean set(EntityPixelmon dataHolder, Map<Key<?>, Object> keyValues) {
        dataHolder.stats.EVs.HP = (int) keyValues.get(PixelmonDataKeys.POKEMON_HP_EVS);
        dataHolder.stats.EVs.Attack = (int) keyValues.get(PixelmonDataKeys.POKEMON_ATTACK_EVS);
        dataHolder.stats.EVs.Defence = (int) keyValues.get(PixelmonDataKeys.POKEMON_DEFENSE_EVS);
        dataHolder.stats.EVs.SpecialAttack = (int) keyValues.get(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS);
        dataHolder.stats.EVs.SpecialDefence = (int) keyValues.get(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS);
        dataHolder.stats.EVs.Speed = (int) keyValues.get(PixelmonDataKeys.POKEMON_SPEED_EVS);
        return true;
    }

    @Override
    protected Map<Key<?>, ?> getValues(EntityPixelmon dataHolder) {
        ImmutableMap.Builder<Key<?>, Object> builder = ImmutableMap.builder();
        builder.put(PixelmonDataKeys.POKEMON_HP_EVS, dataHolder.stats.EVs.HP);
        builder.put(PixelmonDataKeys.POKEMON_ATTACK_EVS, dataHolder.stats.EVs.Attack);
        builder.put(PixelmonDataKeys.POKEMON_DEFENSE_EVS, dataHolder.stats.EVs.Defence);
        builder.put(PixelmonDataKeys.POKEMON_SP_ATTACK_EVS, dataHolder.stats.EVs.SpecialAttack);
        builder.put(PixelmonDataKeys.POKEMON_SP_DEFENSE_EVS, dataHolder.stats.EVs.SpecialDefence);
        builder.put(PixelmonDataKeys.POKEMON_SPEED_EVS, dataHolder.stats.EVs.Speed);
        return builder.build();
    }

    @Override
    protected MutableEVData createManipulator() {
        return new PixelmonMutableEVData();
    }

    @Override
    public Optional<MutableEVData> fill(DataContainer container, MutableEVData mutableEVData) {
        System.out.println("evdataprocessr->fill");
        return Optional.empty();
    }

    @Override
    public DataTransactionResult remove(DataHolder dataHolder) {
        return DataTransactionResult.failNoData();
    }

}
