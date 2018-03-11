package moe.clienthax.tests.commands;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonTypes;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Map;

/**
 * Created by clienthax on 10/03/2018.
 */
public class PartyTestCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Player player = (Player) src;

        Map<Integer, EntitySnapshot> partyPokemon = player.get(PixelmonDataKeys.PARTY_POKEMON).get();

        EntitySnapshot slot1 = partyPokemon.get(0);
        System.out.println(slot1.getType());
        System.out.println(slot1);


        if(slot1.getType().equals(PixelmonTypes.MUDKIP)) {
            System.out.println("yep.. thats a mudkip alright");
        }

        System.out.println(PixelmonTypes.MUDKIP +"<--type");



        return CommandResult.success();
    }

}
