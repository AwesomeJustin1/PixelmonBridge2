package moe.clienthax.pixelmonbridge.impl.data.processor.multi.entity.player;

import com.google.common.collect.Maps;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerNotLoadedException;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableBaseStatsData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.player.ImmutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableBaseStatsData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.player.PixelmonMutablePartyPokemonData;
import moe.clienthax.tests.Tests;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.common.data.DataProcessor;
import org.spongepowered.common.data.processor.common.AbstractSingleDataSingleTargetProcessor;
import org.spongepowered.common.data.util.DataUtil;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeMapValue;
import org.spongepowered.common.data.value.mutable.SpongeMapValue;
import org.spongepowered.common.entity.SpongeEntitySnapshot;
import org.spongepowered.common.interfaces.data.IMixinCustomDataHolder;

import java.util.Map;
import java.util.Optional;

/**
 * Created by clienthax on 10/03/2018.
 */
public class PartyPokemonProcessor extends AbstractSingleDataSingleTargetProcessor<EntityPlayer, Map<Integer, EntitySnapshot>, MapValue<Integer, EntitySnapshot>, MutablePartyPokemonData, ImmutablePartyPokemonData> {

    public PartyPokemonProcessor() {
        super(PixelmonDataKeys.PARTY_POKEMON, EntityPlayer.class);
    }

    @Override
    protected boolean set(EntityPlayer dataHolder, Map<Integer, EntitySnapshot> value) {
            PlayerStorage playerPartyStorage = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP) dataHolder).get();
            playerPartyStorage.recallAllPokemon();
            playerPartyStorage.setPokemon(new NBTTagCompound[6]);

            NBTTagCompound[] pixelmonNBT = new NBTTagCompound[6];
            value.entrySet().stream().filter(entitySnapshotEntry -> entitySnapshotEntry.getValue() != null && entitySnapshotEntry.getValue().getType().getEntityClass().isAssignableFrom(EntityPixelmon.class)).forEach(entitySnapshotEntry -> {
                pixelmonNBT[entitySnapshotEntry.getKey()] = ((SpongeEntitySnapshot) entitySnapshotEntry.getValue()).getCompound().get();
            });
            playerPartyStorage.setPokemon(pixelmonNBT);
            return true;
    }

    @Override
    protected Optional<Map<Integer, EntitySnapshot>> getVal(EntityPlayer dataHolder) {
        Map<Integer, EntitySnapshot> entitySnapshots = Maps.newHashMap();
            PlayerStorage playerPartyStorage = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP) dataHolder).get();
            NBTTagCompound[] partyNBTs = playerPartyStorage.getList();
            for(int i = 0; i < partyNBTs.length; i++) {
                if (partyNBTs[i] != null) {
                    EntityPixelmon pixelmon = (EntityPixelmon) PixelmonEntityList.createEntityFromNBT(partyNBTs[i], dataHolder.world);
                    pixelmon.setPosition(dataHolder.posX, dataHolder.posY, dataHolder.posZ);//TODO Workaround for entitysnapshot being a dick

                    //TODO manipulators get stripped out here :( (bodged fix)
                    //Tests.getLogger().info("containers in party pokemon processor -> "+((Living) pixelmon).getContainers());

                    //Bodge code
                    EntitySnapshot.Builder snapshotbuilder = EntitySnapshot.builder()
                            .from((Entity) pixelmon);
                    //TODO nasty hack for entitysnapshot not saving manipulators / keys
                    //TODO why the hell doesnt eggdata/namedata show up in here!!??
                    //Tests.getLogger().info("Adding processors");
                    for (DataManipulator<?, ?> dataManipulator : ((Entity) pixelmon).getContainers()) {
                        final Optional<DataProcessor<?, ?>> dataprocessordel = DataUtil.getImmutableProcessor((Class) dataManipulator.getClass());//Returns DataProcessorDelegate
                        Tests.getLogger().info("Processor "+dataManipulator + " supports: "+dataprocessordel.get().supports(((Entity)pixelmon).getType())+" "+dataprocessordel.get().getClass());
                        snapshotbuilder = snapshotbuilder.add(dataManipulator);
                    }
                    for (Key key1 : ((Entity) pixelmon).getKeys()) {
                        snapshotbuilder = snapshotbuilder.add(key1, ((Entity)pixelmon).get(key1).get());
                    }
                    EntitySnapshot snapshot = snapshotbuilder.build();

                    //Tests.getLogger().info("containers in party pokemon processor snapshot -> "+snapshot.getContainers());

                    entitySnapshots.put(i, snapshot);
                }
            }
            return Optional.of(entitySnapshots);
    }

    @Override
    protected ImmutableValue<Map<Integer, EntitySnapshot>> constructImmutableValue(Map<Integer, EntitySnapshot> value) {
        return new ImmutableSpongeMapValue<>(getKey(), value);
    }

    @Override
    protected MapValue<Integer, EntitySnapshot> constructValue(Map<Integer, EntitySnapshot> actualValue) {
        return new SpongeMapValue<>(getKey(), actualValue);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }

    @Override
    protected MutablePartyPokemonData createManipulator() {
        return new PixelmonMutablePartyPokemonData();
    }

}