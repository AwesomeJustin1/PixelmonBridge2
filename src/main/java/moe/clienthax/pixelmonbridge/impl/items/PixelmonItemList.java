package moe.clienthax.pixelmonbridge.impl.items;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.item.ItemType;

/**
 * Created by clienthax on 09/03/2018.
 */
public class PixelmonItemList {

    //TODO move to api package~
    public static ItemType SPRITE_ITEM = Sponge.getRegistry().getType(ItemType.class, "pixelmon:pixelmon_sprite").get();

    public static BlockType PC_BLOCK = Sponge.getRegistry().getType(BlockType.class, "pixelmon:pc").get();



}
