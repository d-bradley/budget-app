package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class ExpensesPieGraph 
{
	private String name;
	private PieChart expensesPieChart;
	
	public ExpensesPieGraph(String name)
	{
		this.name = name;
	}
	
	private void createExpensesChart() throws FileNotFoundException
	{
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        DecimalFormat dollarFormat = new DecimalFormat("###,###,###.00");
        
		String filename = "/Users/daniel/Desktop/database.txt";
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		while (inputFile.hasNext())
		{
			String check = inputFile.nextLine();
			String[] stringInput = check.split(" ");
			
			if (stringInput[0].equals(name))
			{	
				Double income = Double.parseDouble(stringInput[1]);
				Double housing = Double.parseDouble(stringInput[2]);
				Double food = Double.parseDouble(stringInput[3]);
				Double utility = Double.parseDouble(stringInput[4]);
				Double insurance = Double.parseDouble(stringInput[5]);
				Double transport = Double.parseDouble(stringInput[6]);
				Double totalExpenses = housing + food + utility + insurance + transport;
				Double availableFunds = income - totalExpenses;
				
				for (int i = 1; i <= stringInput.length; i++)
				{					
					switch (i)
					{
						case 1:
							data.add(new PieChart.Data("Available Funds ($" + dollarFormat.format(availableFunds) + ")", availableFunds));
							break;
						case 2:
							data.add(new PieChart.Data("Housing ($" + dollarFormat.format(housing) + ")", housing));
							break;
						case 3:
							data.add(new PieChart.Data("Food ($" + dollarFormat.format(food) + ")", food));
							break;
						case 4:
							data.add(new PieChart.Data("Utilities ($" + dollarFormat.format(utility) + ")", utility));
							break;
						case 5:
							data.add(new PieChart.Data("Insurance ($" + dollarFormat.format(insurance) + ")", insurance));
							break;
						case 6:
							data.add(new PieChart.Data("Transportation ($" + dollarFormat.format(transport) + ")", transport));
							break;
					}
				}
			}
		}
       
        expensesPieChart = new PieChart(data);
        expensesPieChart.setTitle("Expenses");
        expensesPieChart.setLegendVisible(false);
        expensesPieChart.setStartAngle(180);
	}
	
	public PieChart getExepensesPieChart() throws FileNotFoundException
	{
		createExpensesChart();
		return expensesPieChart;
	}
}
