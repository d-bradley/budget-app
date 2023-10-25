package budget;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GetUserInfoScene 
{
	private Stage stage;
	private TextField incomeTextField;
	private TextField housingTextField;
	private TextField foodTextField;
	private TextField utilitiesTextField;
	private TextField insuranceTextField;
	private TextField transportationTextField;
	private TextField savingsGoalTextField;
	private TextField yearsTillRetirementTextField;
	private Scene userInfoScene;
	private String username;
	
	public GetUserInfoScene(Stage stage, String username)
	{
		this.stage = stage;
		this.username = username;
	}
	
	private void createUserInfoScene()
	{
		LoginScene loginScene = new LoginScene(stage);
		
		Label incomePromptLabel = new Label("Monthly income: ");
		incomeTextField = new TextField();
		HBox incomeHBox = new HBox(10, incomePromptLabel, incomeTextField);
		
		Label housingPromptLabel = new Label("Monthly rent/mortgage: ");
		housingTextField = new TextField();
		HBox housingHBox = new HBox(10, housingPromptLabel, housingTextField);
		
		Label foodPromptLabel = new Label("Monthly food expenses: ");
		foodTextField = new TextField();
		HBox foodHBox = new HBox(10, foodPromptLabel, foodTextField);
		
		Label utilitiesPromptLabel = new Label("Monthly utilities: ");
		utilitiesTextField = new TextField();
		HBox utilitiesHBox = new HBox(10, utilitiesPromptLabel, utilitiesTextField);
		
		Label insurancePromptLabel = new Label("Monthly insurance: ");
		insuranceTextField = new TextField();
		HBox insuranceHBox = new HBox(10, insurancePromptLabel, insuranceTextField);
		
		Label transportationPromptLabel = new Label("Monthly transportation: ");
		transportationTextField = new TextField();
		HBox transportationHBox = new HBox(10, transportationPromptLabel, transportationTextField);
		
		Label savingsGoalPromptLabel = new Label("Savings Goal: ");
		savingsGoalTextField = new TextField();
		HBox savingsGoalHBox = new HBox(10, savingsGoalPromptLabel, savingsGoalTextField);
		
		Label yearsTillRetirementPromptLabel = new Label("Years till retirement: ");
		yearsTillRetirementTextField = new TextField();
		HBox yearsTillRetirementHBox = new HBox(10, yearsTillRetirementPromptLabel, yearsTillRetirementTextField);
		
		Button finishButton = new Button("Done");
		finishButton.setOnAction(e -> 
		{
			addInfo(incomeTextField.getText(), housingTextField.getText(), foodTextField.getText(), utilitiesTextField.getText(),
					insuranceTextField.getText(), transportationTextField.getText(), savingsGoalTextField.getText(),
					yearsTillRetirementTextField.getText());
			stage.setScene(loginScene.getLoginScene());
		});
		VBox userinfoVBox = new VBox(10, incomeHBox, housingHBox, foodHBox, utilitiesHBox, insuranceHBox, 
									transportationHBox, savingsGoalHBox, yearsTillRetirementHBox, finishButton);
		userinfoVBox.setAlignment(Pos.CENTER);
		userinfoVBox.setPadding(new Insets(10));
		userInfoScene = new Scene(userinfoVBox);
	}
	
	private void addInfo(String income, String housing, String food, String utility, 
						String insurance, String transport, String goal, String retirement)
	{
		String url = "jdbc:mysql://localhost:3000/user_info";
		String username = "root";
		String password = "password";
		
		try 
		{
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to MySQL database");
			String sql = "INSERT INTO info (income, housing, food, utility, insurance, transport, goal, retirement)"
						+ " VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, income);
			statement.setString(2, housing);
			statement.setString(3, food);
			statement.setString(4, utility);
			statement.setString(5, insurance);
			statement.setString(6, transport);
			statement.setString(7, goal);
			statement.setString(8, retirement);
			
			int rows = statement.executeUpdate();
			if (rows > 0)
			{
				System.out.println("Complete.");
			}
			
			statement.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Unable to connect to MySQL database.");
			e.printStackTrace();
		}
	}
	
	public Scene getUserInfoScene()
	{
		createUserInfoScene();
		return userInfoScene;
	}
}
