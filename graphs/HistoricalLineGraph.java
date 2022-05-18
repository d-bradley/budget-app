package budget;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class HistoricalLineGraph 
{
	private String username;
	private LineChart lineChart;
	
	public HistoricalLineGraph(String username)
	{
		this.username = username;
	}
	
	private void createHistoricalGraph()
	{
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Historical Savings");
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        series.getData().add(new XYChart.Data(1, 5000));
        series.getData().add(new XYChart.Data(2, 12000));
        series.getData().add(new XYChart.Data(3, 26000));
        series.getData().add(new XYChart.Data(4, 23000));
        series.getData().add(new XYChart.Data(5, 28000));
        series.getData().add(new XYChart.Data(6, 50000));
        series.getData().add(new XYChart.Data(7, 69000));
        series.getData().add(new XYChart.Data(8, 92000));
        series.getData().add(new XYChart.Data(9, 100000));
        series.getData().add(new XYChart.Data(10, 97000));
        series.getData().add(new XYChart.Data(11,125000));
        series.getData().add(new XYChart.Data(12, 137000));
        
        lineChart.getData().add(series);
	}
	
	public LineChart getHistoricalChart()
	{
		createHistoricalGraph();
		return lineChart;
	}
}
