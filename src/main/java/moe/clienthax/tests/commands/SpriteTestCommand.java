package moe.clienthax.tests.commands;

import moe.clienthax.pixelmonbridge.impl.items.PixelmonItemList;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;

import static moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys.SPRITE_NAME;

/**
 * Created by clienthax on 05/03/2018.
 */
public class SpriteTestCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(!(src instanceof Player))
            return CommandResult.success();

        Player player = (Player) src;

        ItemStack spriteStack = ItemStack.of(PixelmonItemList.SPRITE_ITEM, 1);
        spriteStack.offer(SPRITE_NAME, "pixelmon:sprites/pokemon/150");
        player.setItemInHand(HandTypes.MAIN_HAND, spriteStack);

        return CommandResult.success();
    }


}
