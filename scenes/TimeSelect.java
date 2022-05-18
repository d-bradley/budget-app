package budget;

import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TimeSelect 
{
	private Stage stage;
	private HBox selectTime;
	
	public TimeSelect(Stage stage)
	{
		this.stage = stage;
	}
	
	private void userTimeSelection()
	{
        Button savingsWeek = new Button("7D");
        Button savingsMonth = new Button("1M");
        Button savingsSixMonth = new Button("6M");
        Button savingsYear = new Button("1Y");
        Button savingsFiveYear = new Button("5Y");
        Button savingsMax = new Button("MAX");

        selectTime = new HBox(savingsWeek, savingsMonth, savingsSixMonth, savingsYear, savingsFiveYear, savingsMax);
        
        /**
        savingsWeek.setOnAction(e -> 
		{
			try 
			{
				stage.setScene(AccountScene.getAccountScene());
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
		});
		*/
	}
	
	public HBox getTimeHBox()
	{
		userTimeSelection();
		return selectTime;
	}
}
