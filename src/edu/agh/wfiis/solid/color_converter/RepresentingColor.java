package edu.agh.wfiis.solid.color_converter;

import java.util.List;

public interface RepresentingColor {
    int getNumberOfComponents();
    List<Double> extractNormalizedComponents();
    void retrieveDataFromInput(String[] input);
}
