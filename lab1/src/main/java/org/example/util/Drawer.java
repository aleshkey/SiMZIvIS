package org.example.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;

public class Drawer {

    private static String password;

    public static void displayCharacterFrequencyDistribution(String text) {
        password = text;
        Map<Character, Integer> frequencies = calculateFrequencies(text);
        displayHistogram(frequencies);
    }

    private static Map<Character, Integer> calculateFrequencies(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        return frequencies;
    }

    private static void displayHistogram(Map<Character, Integer> frequencies) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            dataset.addValue(entry.getValue(), "Frequency", entry.getKey().toString());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Character Frequency Distribution",
                "Character",
                "Frequency",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        JPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame(password);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 600);
        frame.setContentPane(chartPanel);
        frame.setVisible(true);
        saveFile("Character_Frequency_Distribution.png", 1800, 600, chart);
    }

    public static void displayChart(List<Integer> length, List<Long> value){
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data = {length.stream().mapToDouble(i -> i).toArray(), value.stream().mapToDouble(i -> i).toArray()};
        dataset.addSeries("Value", data);

        JFreeChart chart = ChartFactory.createScatterPlot(
                "Graph of the dependence of the average time of password selection on its length.",
                "size",
                "time",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );


        ChartFrame frame = new ChartFrame("Graph of the dependence of the average time of password selection on its length.", chart);
        frame.pack();
        frame.setVisible(true);
        saveFile("Chart.png", 900, 600, chart);
    }

    private static void saveFile(String name, int width, int height, JFreeChart chart){
        File file = new File(name);
        try {
            ChartUtilities.saveChartAsPNG(file, chart, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}