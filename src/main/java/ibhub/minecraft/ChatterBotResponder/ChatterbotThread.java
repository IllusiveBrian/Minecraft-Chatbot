package ibhub.minecraft.ChatterBotResponder;

import com.google.code.chatterbotapi.*;

public abstract class ChatterbotThread implements Runnable
{
	private String messageReceived;
	private int timeout; //timeout in milliseconds
	private static final int timeoutDefault = 5000;
	
	public ChatterbotThread(String msg)
	{
		messageReceived = msg;
		timeout = timeoutDefault;
	}
	
	public ChatterbotThread(String msg, int timeout)
	{
		messageReceived = msg;
		this.timeout = timeout;
	}
	
	@Override
	public void run()
	{
		String response = sendToService();
		if (response != "")
			writeResponse(response);
	}
	
	protected abstract void writeResponse(String response);
	
	private String sendToService()
	{
		try
		{
			return sendToService(messageReceived, timeout);
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return "";
		}
	}
	
	public static String sendToService(String msg, int timeout) throws Exception
	{
		ChatterBotFactory factory = new ChatterBotFactory();
        ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
        ChatterBotSession bot1session = bot1.createSession();
        
        return bot1session.think(msg);
	}

}
