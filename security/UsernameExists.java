package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UsernameExists 
{
	private String checkUsername;
	
	public UsernameExists(String checkUsername)
	{
		this.checkUsername = checkUsername;
	}
	
	private Boolean checkUserDatabase() throws FileNotFoundException
	{
		Boolean exists = false;
		
		String filename = "/Users/daniel/Desktop/user.txt";
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		String inputCredentials = checkUsername;
		
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
	
	public Boolean getCheckUserDataBase() throws FileNotFoundException
	{
		return checkUserDatabase();
	}
}
