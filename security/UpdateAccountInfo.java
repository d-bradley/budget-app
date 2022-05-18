package budget;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateAccountInfo 
{
	private Stage stage;
	private String username;
	private VBox updateVBox;
	private TextField incomeTextField;
	private TextField housingTextField;
	private TextField foodTextField;
	private TextField utilitiesTextField;
	private TextField insuranceTextField;
	private TextField transportationTextField;
	private TextField savingsGoalTextField;
	private TextField yearsTillRetirementTextField;
	
	public UpdateAccountInfo(Stage stage, String username)
	{
		this.stage = stage;
		this.username = username;
	}
	
	private void createUpdatePane() throws FileNotFoundException
	{
		String filename = "/Users/daniel/Desktop/database.txt";
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);

		String income = null;
		String housing = null;
		String food = null;
		String utility = null;
		String insurance = null;
		String transport = null;
		String savingsGoal = null;
		String retirement = null;
		
		while (inputFile.hasNext())
		{
			String check = inputFile.nextLine();
			String[] stringInput = check.split(" ");
			
			if (stringInput[0].equals(username))
			{	
				income = stringInput[1];
				housing = stringInput[2];
				food = stringInput[3];
				utility = stringInput[4];
				insurance = stringInput[5];
				transport = stringInput[6];
				savingsGoal = stringInput[7];
				retirement = stringInput[8];
			}
		}
		
		Label incomePromptLabel = new Label("Monthly income: ");
		incomeTextField = new TextField();
		incomeTextField.setPromptText(income);
		HBox incomeHBox = new HBox(10, incomePromptLabel, incomeTextField);
		
		Label housingPromptLabel = new Label("Monthly rent/mortgage: ");
		housingTextField = new TextField();
		housingTextField.setPromptText(housing);
		HBox housingHBox = new HBox(10, housingPromptLabel, housingTextField);
		
		Label foodPromptLabel = new Label("Monthly food expenses: ");
		foodTextField = new TextField();
		foodTextField.setPromptText(food);
		HBox foodHBox = new HBox(10, foodPromptLabel, foodTextField);
		
		Label utilitiesPromptLabel = new Label("Monthly utilities: ");
		utilitiesTextField = new TextField();
		utilitiesTextField.setPromptText(utility);
		HBox utilitiesHBox = new HBox(10, utilitiesPromptLabel, utilitiesTextField);
		
		Label insurancePromptLabel = new Label("Monthly insurance: ");
		insuranceTextField = new TextField();
		insuranceTextField.setPromptText(insurance);
		HBox insuranceHBox = new HBox(10, insurancePromptLabel, insuranceTextField);
		
		Label transportationPromptLabel = new Label("Monthly transportation: ");
		transportationTextField = new TextField();
		transportationTextField.setPromptText(transport);
		HBox transportationHBox = new HBox(10, transportationPromptLabel, transportationTextField);
		
		Label savingsGoalPromptLabel = new Label("Savings Goal: ");
		savingsGoalTextField = new TextField();
		savingsGoalTextField.setPromptText(savingsGoal);
		HBox savingsGoalHBox = new HBox(10, savingsGoalPromptLabel, savingsGoalTextField);
		
		Label retirementPromptLabel = new Label("Years till retirement: ");
		yearsTillRetirementTextField = new TextField();
		yearsTillRetirementTextField.setPromptText(retirement);
		HBox retirementHBox = new HBox(10, retirementPromptLabel, yearsTillRetirementTextField);
		
		Button updateButton = new Button("Update");
		
		updateButton.setOnAction(e -> 
		{
			ViewAccountScene updateCurrentScene = new ViewAccountScene(stage, username);
			try 
			{	
				stage.setScene(updateCurrentScene.getAccountScene());
				updateInfo(incomeTextField.getText(), housingTextField.getText(), foodTextField.getText(), utilitiesTextField.getText(),
						insuranceTextField.getText(), transportationTextField.getText(), savingsGoalTextField.getText(),
						yearsTillRetirementTextField.getText());
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
		});
		
		updateVBox = new VBox(10, incomeHBox, housingHBox, foodHBox, utilitiesHBox, insuranceHBox, transportationHBox,
							savingsGoalHBox, retirementHBox, updateButton);
		updateVBox.setAlignment(Pos.CENTER);
	}
	
	private void updateInfo(String income, String housing, String food, String utilities, 
						String insurance, String tranportation, String goal, String retirement)
	{
	      try 
	      {
	          String userInfo = username + " " + income + " " + housing + " " + food + " " + 
	        		  			utilities + " " + insurance + " " + tranportation + " " + goal +
	        		  			" " + retirement + "\n";
	          System.out.println(userInfo);
	          FileWriter fileWritter = new FileWriter("/Users/daniel/Desktop/database.txt", true);
	          BufferedWriter bw = new BufferedWriter(fileWritter);
	          bw.write(userInfo);
	          bw.close();
	          System.out.println("Done");
	      } 
	      catch(IOException e)
	      {
	          e.printStackTrace();
	      }
	}
	
	public VBox getUpdateVBox() throws FileNotFoundException
	{
		createUpdatePane();
		return updateVBox;
	}
}
