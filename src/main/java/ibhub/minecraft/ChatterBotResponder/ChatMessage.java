package ibhub.minecraft.ChatterBotResponder;

import net.minecraft.util.IChatComponent;

public class ChatMessage
{
	public IChatComponent originalMessage;
	public String messageText;
	public Boolean fromPlayer;
	public String playerName;
	public String playerMessageSent;
	
	public ChatMessage(IChatComponent message)
	{
		originalMessage = message;
		messageText = message.getUnformattedText();
		fromPlayer = checkIfFromPlayer(messageText);
		try
		{
			if (fromPlayer)
				parsePlayerMessage();
		}
		catch (Exception ex)
		{
			System.out.println("Error parsing " + messageText);
		}
	}
	
	public static Boolean checkIfFromPlayer(String messageText)
	{
		return messageText.startsWith("<");
	}
	
	private void parsePlayerMessage() throws Exception
	{
		String[] parts = messageText.split(" ");
		if (parts.length < 2)
			throw new Exception("Error parsing player message");
		else
		{
			playerName = parts[0].replaceAll("[\\<\\>]", "");
			playerMessageSent = "";
			for (int i = 1; i < parts.length; ++i)
			{
				playerMessageSent += parts[i];
			}
		}
	}
}
