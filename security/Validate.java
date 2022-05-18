package budget;

import java.io.*;
import java.util.Scanner;

public class Validate 
{
	private String validateUser;
	private String validatePass;
	
	public Validate(String validateUser, String validatePass)
	{
		this.validateUser = validateUser;
		this.validatePass = validatePass;
	}
	
	private Boolean checkCredentials() throws IOException
	{
		Boolean valid = false;
		
		String filename = "/Users/daniel/Desktop/pass.txt";
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		String inputCredentials = validateUser + " " + validatePass;
		
		while (inputFile.hasNext())
		{
			String check = inputFile.nextLine();
			
			if (check.equals(inputCredentials))
			{
				valid = true;
				break;
			}
		}
		
		return valid;
	}
	
	public Boolean getValidate() throws IOException
	{
		return checkCredentials();
	}
}
