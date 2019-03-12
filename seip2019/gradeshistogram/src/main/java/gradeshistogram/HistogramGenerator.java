package main.java.gradeshistogram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/***
 * @author Ioannis Petropoulos <ionpetro@gmail.com>
 * @version 1.0
 * @since 07/03/2019
 * @purpose The purpose of this class is to generate JFreeChart XYLine chart.
 */

public class HistogramGenerator {

	/**
	 * Receives a single dimension Integer array. From this array the dataset that
	 * will be used for the visualization is generated. Finally, The chart is
	 * generated with the use of the aforementioned dataset and then presented in
	 * the screen.
	 * 
	 * @param dataValues Single dimension integer array
	 */

	public static void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	/**
	 * The main method reads the text file with the grades and creates a frequency
	 * table. Each index of the table corresponds to the sum of the occurrences of
	 * the corresponding grade.
	 * 
	 * @param text file with grades
	 */

	public static void main(String[] args) throws FileNotFoundException {

		int freq[] = new int[11];

		Scanner scanner = new Scanner(new File(args[0])); // the first command line argument
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			int number = Integer.parseInt(line);
			freq[number] += 1;
		}

		generateChart(freq); // call generateChart methon with freq table as a parameter

	}

}
