package xyz.paiva.nexon.initializers;

import xyz.paiva.nexon.DiscordClient;
import xyz.paiva.nexon.commands.*;
import xyz.paiva.nexon.structures.Command;
import xyz.paiva.nexon.structures.Initializer;

public class CommandInitializer extends Initializer {
	public CommandInitializer(DiscordClient discordClient) {
		super(discordClient);
		this.name = "CommandInitializer";
	}
	
	@Override
	public void start() throws Exception {
		try {
			Boolean ping = this.addCommand(new PingCommand(this.client));
			System.out.println("Was ping command loaded? " + ping);
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean addCommand(Command command) {
		System.out.println("Adding command " + command.getName());
		System.out.println("Command can run? " + command.canRun());
		if (!(command.canRun())) return false;
		return this.client.commands.add(command);
	}
}