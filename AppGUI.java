package budget;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppGUI extends Application
{
	public static void main(String args [])
	{	
		launch(args);
	}
	
	public void start(Stage primaryStage)
	{
		createLogin(primaryStage);
	}
	
	private void createLogin(Stage stage)
	{
		LoginScene loginScene = new LoginScene(stage);
		
		stage.setScene(loginScene.getLoginScene());
		stage.setTitle("Personal Budget Application");
		stage.show();
	}
}
