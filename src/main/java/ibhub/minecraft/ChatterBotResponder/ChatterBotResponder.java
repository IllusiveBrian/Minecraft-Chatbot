package ibhub.minecraft.ChatterBotResponder;

import logging.LogWriter;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ChatterBotResponder.MODID, version = ChatterBotResponder.VERSION, name = ChatterBotResponder.NAME)
public class ChatterBotResponder
{
    public static final String MODID = "Chatter Bot Responder";
    public static final String VERSION = "0.1";
    public static final String NAME = MODID;
    //public static SimpleNetworkWrapper network;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName())));
    	initializeEventListeners();
    }
    
    public void initializeEventListeners()
    {
    	LogWriter.debug("init");
    	MinecraftForge.EVENT_BUS.register(new ChatEvents());
    	//network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
    	//network.registerMessage(ChatterbotMessageHandler.class, ChatterbotMessage.class, 0, Side.CLIENT);
    }
    
}
