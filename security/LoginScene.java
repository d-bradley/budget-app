package budget;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScene 
{
	private Stage stage;
	private TextField usernameTextField;
	private PasswordField credentialsPasswordField;
	private static Scene loginScene;
	
	public LoginScene(Stage stage)
	{
		this.stage = stage;
	}
	
	private void createLoginScene()
	{
		CreateNewUserScene createUserScene = new CreateNewUserScene(stage);

		Label usernamePromptLabel = new Label("Username: ");
		usernameTextField = new TextField();
		HBox usernameHBox = new HBox(10, usernamePromptLabel, usernameTextField);
		
		Label credentialsPromptLabel = new Label("Password: ");
		credentialsPasswordField = new PasswordField();
		HBox credentialsHBox = new HBox(10, credentialsPromptLabel, credentialsPasswordField);
		
		Button loginButton = new Button("Login");
		loginButton.setOnAction(e -> validateUser());
		
		Button newUserButton = new Button("New User");
		newUserButton.setOnAction(e -> stage.setScene(createUserScene.getCreateUserScene()));
		
		VBox loginVbox = new VBox(10, usernameHBox, credentialsHBox, loginButton, newUserButton);
		loginVbox.setAlignment(Pos.CENTER);
		loginVbox.setPadding(new Insets(10));
		loginScene = new Scene(loginVbox);
	}
	
	public Scene getLoginScene()
	{
		createLoginScene();
		return loginScene;
	}
	
	private void validateUser()
	{
		String name = usernameTextField.getText();
		String pass = credentialsPasswordField.getText();
		
		Validate credentials = new Validate(name, pass);
		
		try 
		{
			if (credentials.getValidate() == true)
			{
				System.out.println("Valid");
				ViewAccountScene accountScene = new ViewAccountScene(stage, name);
				stage.setScene(accountScene.getAccountScene());
			}
			else
			{
				System.out.println("Not Valid");
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Error");
		}
	}
}
