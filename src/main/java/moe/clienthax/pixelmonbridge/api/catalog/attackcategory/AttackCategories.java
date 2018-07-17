package moe.clienthax.pixelmonbridge.api.catalog.attackcategory;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Created by Justin
 */
public class AttackCategories {
    public static final AttackCategory PHYSICAL = DummyObjectProvider.createFor(AttackCategory.class, "PHYSICAL");
    public static final AttackCategory SPECIAL = DummyObjectProvider.createFor(AttackCategory.class, "SPECIAL");
    public static final AttackCategory STATUS = DummyObjectProvider.createFor(AttackCategory.class, "STATUS");
}
