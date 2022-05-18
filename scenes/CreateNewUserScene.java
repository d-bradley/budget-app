package budget;

import java.io.FileNotFoundException;

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

public class CreateNewUserScene 
{
	private static Scene createUserScene;
	private TextField createEmailTextField;
	private TextField createUsernameTextField;
	private PasswordField createPasswordPasswordField;
	private PasswordField checkCreatedPasswordField;
	private Stage stage;
	
	public CreateNewUserScene(Stage stage)
	{
		this.stage = stage;
	}
	
	private void createCreateUserScene()
	{
		Label createEmailPromptLabel = new Label("E-mail: ");
		createEmailTextField = new TextField();
		HBox createEmailHBox = new HBox(10, createEmailPromptLabel, createEmailTextField);
		
		Label createUsernamePromptLabel = new Label("Username: ");
		createUsernameTextField = new TextField();
		HBox createUsernameHBox = new HBox(10, createUsernamePromptLabel, createUsernameTextField);
		
		Label createPasswordPromptLabel = new Label("Password: ");
		createPasswordPasswordField = new PasswordField();
		HBox createPasswordHBox = new HBox(10, createPasswordPromptLabel, createPasswordPasswordField);
		
		Label checkCreatedPasswordPromptLabel = new Label("Confirm Password: ");
		checkCreatedPasswordField = new PasswordField();
		HBox checkCreatedPasswordHBox = new HBox(10, checkCreatedPasswordPromptLabel, checkCreatedPasswordField);
		
		Button createUserButton = new Button("Create Account");
		createUserButton.setOnAction(e -> createUser(createEmailTextField.getText(), createUsernameTextField.getText()));

		Button backButton = new Button("Back");
		backButton.setOnAction(e -> 
			{
				LoginScene loginScene = new LoginScene(stage);
				stage.setScene(loginScene.getLoginScene());
			});
		
		VBox createUserVBox = new VBox(10, createEmailHBox, createUsernameHBox, createPasswordHBox, checkCreatedPasswordHBox, createUserButton, backButton);
		createUserVBox.setAlignment(Pos.CENTER);
		createUserVBox.setPadding(new Insets(10));
		createUserScene = new Scene(createUserVBox);
	}
	
	public Scene getCreateUserScene()
	{
		createCreateUserScene();
		return createUserScene;
	}
	
	private void createUser(String emailString, String nameString)
	{		
		Boolean emailValid = false;
		Boolean usernameValid = false;
		
		/**
		String newEmail = createEmailTextField.getText();
		String newName = createUsernameTextField.getText();
		String newPass = createPasswordTextField.getText();
		String checkPass = checkCreatedPasswordTextField.getText();
		*/
		
		EmailExists validateNewEmail = new EmailExists(emailString);
		try 
		{
			emailValid = validateNewEmail.getCheckEmailDataBase();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		UsernameExists validateNewUsername = new UsernameExists(nameString);
		try 
		{
			usernameValid = validateNewUsername.getCheckUserDataBase();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		if (!emailValid && !usernameValid)
		{
			GetUserInfoScene userInfoScene = new GetUserInfoScene(stage, createUsernameTextField.getText());
			stage.setScene(userInfoScene.getUserInfoScene());
		}
		else if (emailValid)
		{
			InvalidCreateScene invalidCreateScene = new InvalidCreateScene(stage);
			stage.setScene(invalidCreateScene.getInvalidCreateScene());
		}
	}
}
