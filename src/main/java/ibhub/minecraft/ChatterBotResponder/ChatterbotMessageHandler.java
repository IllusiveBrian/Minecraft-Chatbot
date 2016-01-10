package ibhub.minecraft.ChatterBotResponder;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ChatterbotMessageHandler implements IMessageHandler<ChatterbotMessage, IMessage>
{

	@Override
	public IMessage onMessage(ChatterbotMessage message, MessageContext ctx)
	{
		System.out.println(message.theMessage);
		return null;
	}

}
