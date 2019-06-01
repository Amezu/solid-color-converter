package edu.agh.wfiis.solid.color_converter;

import java.util.ArrayList;
import java.util.List;

public abstract class ColorModel {
    protected List<Integer> channels = new ArrayList<>();

    protected int numberOfChannels;
    protected int max;
    protected int min;
    protected String suffix;

    public List<Integer> getChannels() {
        return channels;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public List<Double> extractNormalizedChannels() {
        ArrayList<Double> normalizedChannels = new ArrayList<>();
        for(Integer channel: channels)
            normalizedChannels.add(Double.valueOf(channel)/max);

        return normalizedChannels;
    }

    public void addChannelValue(Integer value) {
        channels.add(value);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName().toLowerCase() + "(");
        for(int i = 0; i < numberOfChannels-1; ++i)
            stringBuilder.append(channels.get(i) + suffix +  ", ");
        stringBuilder.append(channels.get(numberOfChannels-1) + suffix +  ")");
        return stringBuilder.toString();
    }
}
