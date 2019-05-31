package edu.agh.wfiis.solid.color_converter;

import java.util.List;

public class CMYKToRGBConverter implements Converting {
    public RepresentingColor convert(RepresentingColor color) {
        List<Double> components = color.extractNormalizedComponents();
        Double c = components.get(0);
        Double m = components.get(1);
        Double y = components.get(2);
        Double k = components.get(3);

        Double r = (1 - c) * (1 - k);
        Double g = (1 - m) * (1 - k);
        Double b = (1 - y) * (1 - k);

        return new RGB(r, g, b);
    }
}
