package moe.clienthax.pixelmonbridge.api.catalog.stattype;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Created by Justin
 */
public class StatTypes {
    public static final StatType NONE = DummyObjectProvider.createFor(StatType.class, "NONE");
    public static final StatType HP = DummyObjectProvider.createFor(StatType.class, "HP");
    public static final StatType ATTACK = DummyObjectProvider.createFor(StatType.class, "ATTACK");
    public static final StatType DEFENCE = DummyObjectProvider.createFor(StatType.class, "DEFENCE");
    public static final StatType SPECIAL_DEFENCE = DummyObjectProvider.createFor(StatType.class, "SPECIAL_DEFENCE");
    public static final StatType SPECIAL_ATTACK = DummyObjectProvider.createFor(StatType.class, "SPECIAL_ATTACK");
    public static final StatType SPEED = DummyObjectProvider.createFor(StatType.class, "SPEED");
    public static final StatType ACCURACY = DummyObjectProvider.createFor(StatType.class, "ACCURACY");
    public static final StatType EVASION = DummyObjectProvider.createFor(StatType.class, "EVASION");
}
