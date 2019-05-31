package edu.agh.wfiis.solid.color_converter;

import java.util.ArrayList;
import java.util.List;

public class RGB implements RepresentingColor {
    private int red;
    private int green;
    private int blue;
    //    walidacja: <0,255>

    private int numberOfComponents = 3;

    private int max = 255;
    private int min = 0;

    RGB() {}

    RGB(double r, double g, double b) {
        red = (int) Math.round(r*max);
        green = (int) Math.round(g*max);
        blue = (int) Math.round(b*max);
    }

    public void retrieveDataFromInput(String[] input) {
        int r = Integer.valueOf(input[0].substring(input[0].indexOf("(")+1, input[0].indexOf(",")));
        int g = Integer.valueOf(input[1].substring(0, input[1].indexOf(",")));
        int b = Integer.valueOf(input[2].substring(0, input[2].indexOf(")")));

        red = (r < max ? r : max) > min ? r : min;
        green = (g < max ? g : max) > min ? g : min;
        blue = (b < max ? b : max) > min ? b : min;
    }

    public int getNumberOfComponents() {
        return numberOfComponents;
    }

    public List<Double> extractNormalizedComponents() {
        List<Double> components = new ArrayList<>();
        components.add(Double.valueOf(red)/max);
        components.add(Double.valueOf(green)/max);
        components.add(Double.valueOf(blue)/max);
        return components;
    }



    @Override
    public String toString() {
        return "rgb(" + red + ", " + green + ", " + blue + ")";
    }
}
