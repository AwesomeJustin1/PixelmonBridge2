package moe.clienthax.pixelmonbridge.api.catalog.attackcategory;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Created by Justin
 */
@CatalogedBy(AttackCategories.class)
public interface AttackCategory extends CatalogType {
    String getLocalizedName();
}
