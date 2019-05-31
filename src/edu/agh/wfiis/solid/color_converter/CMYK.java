package edu.agh.wfiis.solid.color_converter;

import java.util.ArrayList;
import java.util.List;

public class CMYK implements RepresentingColor {
    private int cyan;
    private int magenta;
    private int yellow;
    private int black;

    private int numberOfComponents = 4;

    private int max = 100;
    private int min = 0;

    CMYK() {}

    CMYK(Double c, Double m, Double y, Double k) {
        cyan = (int) Math.round(c*max);
        magenta = (int) Math.round(m*max);
        yellow = (int) Math.round(y*max);
        black = (int) Math.round(k*max);
    }

    public void retrieveDataFromInput(String[] input) {
        int c = Integer.valueOf(input[0].substring(input[0].indexOf("(")+1, input[0].indexOf("%")));
        int m = Integer.valueOf(input[1].substring(0, input[1].indexOf("%")));
        int y = Integer.valueOf(input[2].substring(0, input[2].indexOf("%")));
        int k = Integer.valueOf(input[3].substring(0, input[3].indexOf("%")));

        cyan = (c < max ? c : max) > min ? c : min;
        magenta = (m < max ? m : max) > min ? m : min;
        yellow = (y < max ? y : max) > min ? y : min;
        black = (k < max ? k : max) > min ? k : min;
    }

    public List<Double> extractNormalizedComponents() {
        List<Double> components = new ArrayList<>();
        components.add(Double.valueOf(cyan)/max);
        components.add(Double.valueOf(magenta)/max);
        components.add(Double.valueOf(yellow)/max);
        components.add(Double.valueOf(black)/max);
        return components;
    }

    public int getNumberOfComponents() {
        return numberOfComponents;
    }

    @Override
    public String toString() {
        return "cmyk(" + cyan + "%, " + magenta + "%, " + yellow + "%, " + black + "%)";
    }
}
