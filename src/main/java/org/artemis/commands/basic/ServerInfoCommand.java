package org.artemis.commands.basic;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.artemis.commands.Command;

import java.awt.*;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ServerInfoCommand implements Command {
    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {
        var guild = event.getGuild();

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("🛡️ Informações do Servidor");
        embed.setColor(Color.BLUE);

        embed.addField("🌐 Nome", guild.getName(), false);
        embed.addField("👑 Dono", guild.getOwner() != null ? guild.getOwner().getAsMention() + guild.getOwnerId() : "Desconhecido", false);
        embed.addField("🆔 ID", guild.getId(), false);
        embed.addField("👥 Membros", String.valueOf(guild.getMemberCount()), false);
        embed.addField("💬 Total de Canais", String.valueOf(guild.getChannels().size()), false);

        OffsetDateTime criadoEm = guild.getTimeCreated();
        String dataFormatada = criadoEm.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        embed.addField("\uD83D\uDCC5 Criado em", dataFormatada, false);

        if (guild.getBoostCount() > 0) {
            embed.addField("🚀 Boosts", String.valueOf(guild.getBoostCount()), false);
            embed.addField("⭐ Nível Boost", String.valueOf(guild.getBoostTier().getKey()), false);
        }

        embed.setThumbnail(guild.getIconUrl());
        embed.setFooter("Solicitado por " + event.getAuthor().getName(), event.getAuthor().getAvatarUrl());

        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }
}
