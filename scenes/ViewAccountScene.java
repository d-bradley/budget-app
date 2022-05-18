package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ViewAccountScene 
{
	private Stage stage;
	private String username;
	private static Scene accountScene;
	
	public ViewAccountScene(Stage stage, String username)
	{
		this.stage = stage;
		this.username = username;
	}
	
	private void createAccountScene() throws FileNotFoundException
	{
		SavingsPieGraph savingsChart = new SavingsPieGraph(username);
		TimeSelect timeHBox = new TimeSelect(stage);
        VBox savingsVBox = new VBox(10, timeHBox.getTimeHBox(), savingsChart.getSavingsPieChart());
        
        ExpensesPieGraph expensesChart = new ExpensesPieGraph(username);
        HBox accountHBox = new HBox(10, expensesChart.getExepensesPieChart(), savingsVBox);
        
        UpdateAccountInfo updateVBox = new UpdateAccountInfo(stage, username);
        HistoricalLineGraph historicalChart = new HistoricalLineGraph(username);
        HBox infoHBox = new HBox(10, updateVBox.getUpdateVBox(), historicalChart.getHistoricalChart());
        infoHBox.setAlignment(Pos.CENTER);
        
		VBox accountVbox = new VBox(10, accountHBox, infoHBox);
		accountVbox.setAlignment(Pos.CENTER);
		accountVbox.setPadding(new Insets(10));
		accountScene = new Scene(accountVbox);
	}
	
	public Scene getAccountScene() throws FileNotFoundException
	{
		createAccountScene();
		return accountScene;
	}
}
