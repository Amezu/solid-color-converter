package edu.agh.wfiis.solid.color_converter;

import java.util.List;

public class RGBToCMYKConverter implements Converting {
    public ColorModel convert(ColorModel color) {
        List<Double> channels = color.extractNormalizedChannels();
        Double r = channels.get(0);
        Double g = channels.get(1);
        Double b = channels.get(2);

        Double max = Math.max(Math.max(r, g), b);
        Double k = 1 - max;
        Double c = (1 - r - k) / (1 - k);
        Double m = (1 - g - k) / (1 - k);
        Double y = (1 - b - k) / (1 - k);

        return new CMYK(c,m,y,k);
    }
}
