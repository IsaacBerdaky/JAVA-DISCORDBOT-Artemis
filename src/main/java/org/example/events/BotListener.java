package org.example.events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.commands.Command;
import org.example.managers.CommandManager;
import org.example.managers.CooldownManager;

public class BotListener extends ListenerAdapter {

    private final CommandManager commandManager = new CommandManager();
    private final CooldownManager commandCooldown = new CooldownManager(5);

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String PREFIX = "!";

        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentDisplay();
        if (!content.startsWith(PREFIX)) return;

        String[] split = content.substring(1).split(" ");
        String commandFirstSplit = split[0];
        String[] args = java.util.Arrays.copyOfRange(split, 1, split.length);

        Command cmd = commandManager.getCommand(commandFirstSplit);
        String userId = event.getAuthor().getId();

        if (!commandCooldown.canUse(userId)) {
            long timeLeft = commandCooldown.timeLeft(userId);
            event.getChannel().sendMessage("Aguarde " + timeLeft + "s antes de usar este comando!").queue();
            return;
        }

        if (cmd != null) {
            cmd.executeCommand(event, args);
        } else {
            event.getChannel().sendMessage("Comando desconhecido.").queue();
        }
    }
}
