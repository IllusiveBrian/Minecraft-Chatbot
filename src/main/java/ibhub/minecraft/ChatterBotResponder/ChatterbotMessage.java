package ibhub.minecraft.ChatterBotResponder;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ChatterbotMessage implements IMessage
{

	public String theMessage;
	
	public ChatterbotMessage()
	{
		
	}
	
	public ChatterbotMessage(String msg)
	{
		theMessage = msg;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, theMessage);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		theMessage = ByteBufUtils.readUTF8String(buf);
	}
	
}
