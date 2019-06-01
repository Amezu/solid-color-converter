package edu.agh.wfiis.solid.color_converter;

import java.util.ArrayList;
import java.util.List;

public class RGB extends ColorModel {
    {
        numberOfChannels = 3;
        max = 255;
        min = 0;
        suffix = "";
    }

    RGB() {}

    RGB(double r, double g, double b) {
        addChannelValue((int) Math.round(r*max));
        addChannelValue((int) Math.round(g*max));
        addChannelValue((int) Math.round(b*max));
    }
}
