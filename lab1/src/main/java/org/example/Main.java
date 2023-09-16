package org.example;

import org.example.util.Checker;
import org.example.util.Drawer;
import org.example.util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        Checker checker = new Checker();
        List<Integer> length = new ArrayList<>();
        List<Long> time = new ArrayList<>();

        /*строим гистограмму*/
        Drawer.displayCharacterFrequencyDistribution(generator.createPassword(100));

        /*получаем 6 паролей разной длинны, вычисляем время подбора и строим график*/
        for (int i = 0; i < 6; i++) {
            var password =generator.createPassword(i);
            System.out.println(password);
            var mills = checker.check(password);
            System.out.println(mills+"\n");
            length.add(i);
            time.add(mills);
        }
        Drawer.displayChart(length, time);
    }
}