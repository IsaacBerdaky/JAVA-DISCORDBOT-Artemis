package org.artemis.commands.basic;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.artemis.commands.Command;

import java.awt.*;

public class AvatarCommand implements Command {
    @Override
    public void executeCommand(MessageReceivedEvent event, String[] args) {
        Member member;

        if(!event.getMessage().getMentions().getMembers().isEmpty()) {
            member = event.getMessage().getMentions().getMembers().get(0);
        } else {
            member = event.getMember();
        }

        String avatarUrl = member.getEffectiveAvatarUrl() + "?size=2048";

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Avatar de " + member.getEffectiveName())
                .setImage(avatarUrl)
                .setColor(0x00ADEF);

        event.getChannel().sendMessageEmbeds(embed.build()).queue();


    }
}


