package budget;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class SavingsPieGraph 
{
	private String user;
	private PieChart savingsPieChart;
	
	public SavingsPieGraph(String user)
	{
		this.user = user;
	}
	
	private void createSavingsChart()
	{
		double saved = 137000;
		double goal = 500000;
		double amountTillGoal = goal - saved;
		
		DecimalFormat dollarFormat = new DecimalFormat("###,###,###.00");
		
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Saved ($" + dollarFormat.format(saved) + ")", saved),
                new PieChart.Data("Goal ($" + dollarFormat.format(amountTillGoal) + ")", amountTillGoal));
        savingsPieChart = new PieChart(pieChartData);
        savingsPieChart.setTitle("Savings Goal ($" + dollarFormat.format(goal) + ")");
        savingsPieChart.setLegendVisible(false);
        savingsPieChart.setStartAngle(180);
	}
	
	public PieChart getSavingsPieChart()
	{
		createSavingsChart();
		return savingsPieChart;
	}
}
