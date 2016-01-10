package ibhub.minecraft.ChatterBotResponder;

import net.minecraft.client.entity.EntityPlayerSP;

public class MinecraftChatterbotThread extends ChatterbotThread
{
	EntityPlayerSP player;
	
	MinecraftChatterbotThread(String message, int timeout, EntityPlayerSP thePlayer)
	{
		super(message, timeout);
		player = thePlayer;
	}
	
	MinecraftChatterbotThread(String message, EntityPlayerSP thePlayer)
	{
		super(message);
		player = thePlayer;
	}

	@Override
	protected void writeResponse(String response)
	{
    	player.sendChatMessage(response);
	}
}
