package edu.agh.wfiis.solid.color_converter;

import java.util.List;

public class CMYKToRGBConverter implements Converting {

    public ColorModel convert(ColorModel color) {
        List<Double> channels = color.extractNormalizedChannels();
        Double c = channels.get(0);
        Double m = channels.get(1);
        Double y = channels.get(2);
        Double k = channels.get(3);

        RGB result = new RGB();
        result.setChannel(0, (1 - c) * (1 - k));
        result.setChannel(1, (1 - m) * (1 - k));
        result.setChannel(2, (1 - y) * (1 - k));

        return result;
    }
}
