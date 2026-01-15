package org.example.commands.basic;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.example.commands.Command;

import java.awt.*;

public class InfoCommand implements Command {
    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("🤖 Informações do Bot");
        embed.setColor(Color.BLUE);
        embed.setThumbnail(event.getJDA().getSelfUser().getAvatarUrl());

        embed.addField("Nome", event.getJDA().getSelfUser().getName(), true);
        embed.addField("Ping", event.getJDA().getGatewayPing() + "ms", true);
        embed.addField("Servidores", String.valueOf(event.getJDA().getGuilds().size()), true);

        String uptime = formatUptime(event.getJDA().getGatewayPing());
        embed.addField("Uptime", uptime, false);

        embed.setFooter("Pedido por " + event.getAuthor().getName(), event.getAuthor().getAvatarUrl());
        embed.setTimestamp(java.time.Instant.now());

        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }
    private String formatUptime(long ms) {
        long hours = ms / 3600000;
        long minutes = (ms % 3600000) / 60000;
        long seconds = (ms % 60000) / 1000;

        return hours + "h " + minutes + "m " + seconds + "s";
    }
}

