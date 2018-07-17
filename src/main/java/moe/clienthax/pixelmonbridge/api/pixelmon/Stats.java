package moe.clienthax.pixelmonbridge.api.pixelmon;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.BaseStats;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import com.pixelmonmod.pixelmon.enums.EnumNature;

/**
 * Created by Justin
 */
public interface Stats {

    int calculateHP(BaseStats baseStats, int level);


    com.pixelmonmod.pixelmon.entities.pixelmon.stats.Stats setLevelStats(EnumNature nature, BaseStats baseStats, int level);


    int calculateStat(StatsType stat, EnumNature nature, BaseStats baseStats, int level);


    int get(StatsType stat);

    IVStore getIVs();

    void setIVs(IVStore ivs);

    EVStore getEVs();

    void setEVs(EVStore store);
}
