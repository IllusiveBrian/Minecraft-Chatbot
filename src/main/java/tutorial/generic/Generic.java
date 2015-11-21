package tutorial.generic;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import tutorial.generic.proxies.*;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;

@Mod(modid=Generic.MODID, name = Generic.NAME, version = Generic.VERSION)
public class Generic 
{
	public final static String MODID = "bestmodevergeneric";
	public final static String NAME = "Generic Mod";
	public final static String VERSION = "0.0.0.0";
	public final static String CLIENT_PROXY = "tutorial.generic.proxies.ClientProxy";
	public final static String COMMON_PROXY = "tutorial.generic.proxies.CommonProxy";
	public static KeyBinding key;
	
	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new Generic());
		init();
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}	
	
	public static void init()
	{
		key = new KeyBinding("key.key", Keyboard.KEY_N, "key.categories.generic");
		ClientRegistry.registerKeyBinding(key);
	}
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (key.isPressed())
			logging.LogWriter.debug("debug");
	}
}
