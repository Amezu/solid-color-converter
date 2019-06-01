package edu.agh.wfiis.solid.color_converter;

import java.util.List;

public class CMYKToRGBConverter implements Converting {
    public ColorModel convert(ColorModel color) {
        List<Double> channels = color.extractNormalizedChannels();
        Double c = channels.get(0);
        Double m = channels.get(1);
        Double y = channels.get(2);
        Double k = channels.get(3);

        Double r = (1 - c) * (1 - k);
        Double g = (1 - m) * (1 - k);
        Double b = (1 - y) * (1 - k);

        return new RGB(r, g, b);
    }
}
