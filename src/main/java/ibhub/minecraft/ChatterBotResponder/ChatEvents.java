package ibhub.minecraft.ChatterBotResponder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatEvents
{
    //@SubscribeEvent
    public void onServer(ServerChatEvent event)
    {
    	System.out.println("onServer");
    	System.out.println(event.message);
    	//MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText("Hello"));
    }
    
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event)
    {
    	//System.out.println("onChat");
    	ChatMessage message = new ChatMessage(event.message);
    	EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
    	if (message.fromPlayer && !message.playerName.equals(player.getName()))
    	{
    		Thread botThread = new Thread(new MinecraftChatterbotThread(message.playerMessageSent, player));
    		botThread.start();
    	}
    }
}
