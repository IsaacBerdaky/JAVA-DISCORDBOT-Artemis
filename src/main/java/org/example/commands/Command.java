package org.example.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {
    void executeCommand(MessageReceivedEvent event, String[] args);
    default void executeSlashCommand(SlashCommandInteractionEvent event) {
        event.reply("Este comando não está disponível como Slash Command ainda.").queue();
    }
}
