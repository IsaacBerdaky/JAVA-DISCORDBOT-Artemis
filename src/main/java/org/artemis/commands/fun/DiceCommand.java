package org.artemis.commands.fun;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.artemis.commands.Command;

import java.util.Random;

public class DiceCommand implements Command {
    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {

        Random r = new Random();
        int diceValue = r.nextInt(20) + 1;

        if (diceValue == 1) {
            event.getChannel().sendMessage("Falha Crítica!\n**" + diceValue + "**").queue();

        } else if (diceValue <= 9) {
            event.getChannel().sendMessage("Falha!\n**" + diceValue + "**").queue();

        } else if (diceValue <= 19) {
            event.getChannel().sendMessage("Sucesso!\n**" + diceValue + "**").queue();

        } else {
            event.getChannel().sendMessage("Sucesso Crítico!!\n**" + diceValue + "**").queue();
        }

    }
}
