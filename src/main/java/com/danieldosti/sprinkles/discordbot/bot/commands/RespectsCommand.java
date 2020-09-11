package com.danieldosti.sprinkles.discordbot.bot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class RespectsCommand implements Command {

    @Override
    public String getToken() {
        return "f";
    }

    @Override
    public void perform(GuildMessageReceivedEvent event, List<String> args) {
        if(args.size() == 0) {
            event.getChannel().sendMessage(event.getAuthor().getName()+" has paid their respects.").queue();
        } else if(args.size() == 1) {
            event.getChannel().sendMessage(event.getAuthor().getName()+" has paid their respects to "+args.get(0)+".").queue();
        } else {
            event.getChannel().sendMessage("I don't know who to pay respects to!").queue();
        }
        event.getMessage().delete().queue();
    }

}
