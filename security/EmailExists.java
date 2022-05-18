package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmailExists 
{
	private String checkEmail;
	
	public EmailExists(String checkEmail)
	{
		this.checkEmail = checkEmail;
	}
	
	private Boolean checkEmailDatabase() throws FileNotFoundException
	{
		Boolean exists = false;
		
		String filename = "/Users/daniel/Desktop/email.txt";
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		String inputCredentials = checkEmail;
		
		while (inputFile.hasNext())
		{
			String check = inputFile.nextLine();
			
			if (check.equals(inputCredentials))
			{
				exists = true;
				break;
			}
		}
		
		return exists;
	}
	
	public Boolean getCheckEmailDataBase() throws FileNotFoundException
	{
		return checkEmailDatabase();
	}
}
