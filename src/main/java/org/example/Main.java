package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.events.BotListener;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String BOT_TOKEN = dotenv.get("DISCORD_TOKEN");

        JDA api = JDABuilder.createDefault(BOT_TOKEN,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new BotListener())
                .build();

        api.awaitReady();
        api.getPresence().setActivity(Activity.customStatus(" \uD83D\uDC41\uFE0F Monitorando toda Night City!"));





















        System.out.println("           :::     ::::::::: ::::::::::: ::::::::::   :::   :::   ::::::::::: :::::::: ");
        System.out.println("        :+: :+:   :+:    :+:    :+:     :+:         :+:+: :+:+:      :+:    :+:    :+: ");
        System.out.println("      +:+   +:+  +:+    +:+    +:+     +:+        +:+ +:+:+ +:+     +:+    +:+         ");
        System.out.println("    +#++:++#++  +#++:++#:     +#+     +#++:++#   +#+  +:+  +#+     +#+    +#++:++#++   ");
        System.out.println("   +#+     +#+ +#+    +#+    +#+     +#+        +#+       +#+     +#+           +#+    ");
        System.out.println("  #+#     #+# #+#    #+#    #+#     #+#        #+#       #+#     #+#    #+#    #+#     ");
        System.out.println(" ###     ### ###    ###    ###     ########## ###       ### ########### ########       ");

        System.out.println("ARTEMIS V1 ESTA ONLINE, O SISTEMA ESTA RODANDO!");
        System.out.println("Atualmente, estou em: " + api.getGuilds().size() + " servidores!");
    }
}
