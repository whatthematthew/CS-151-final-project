package controller;

public class RestartMessage implements Message
{
	private boolean orderComplete;
	
	public RestartMessage(boolean orderStatus)
	{
		orderComplete = orderStatus;
	}
	
	public boolean getStatus()
	{
		return orderComplete;
	}
	
}
