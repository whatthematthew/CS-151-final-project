package controller;

public class ReturnToPreviousMessage implements Message
{
	private Page orderPage;
	
	public ReturnToPreviousMessage(Page page)
	{
		orderPage = page;
	}

	public Page getCurrentPage()
	{
		return orderPage;
	}
}
