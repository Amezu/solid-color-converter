package edu.agh.wfiis.solid.color_converter;

import java.util.ArrayList;
import java.util.List;

public class CMYK extends ColorModel {
    {
        numberOfChannels = 4;
        max = 100;
        min = 0;
        suffix = "%";
    }

    CMYK() {}

    CMYK(double c, double m, double y, double k) {
        addChannelValue((int) Math.round(c*max));
        addChannelValue((int) Math.round(m*max));
        addChannelValue((int) Math.round(y*max));
        addChannelValue((int) Math.round(k*max));
    }
}
