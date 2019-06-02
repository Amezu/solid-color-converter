package edu.agh.wfiis.solid.color_converter;

import java.util.ArrayList;
import java.util.List;

public abstract class ColorModel {

    private List<Integer> channels = new ArrayList<>();

    private final int numberOfChannels;
    private final int min;
    private final int max;
    private final String suffix;

    ColorModel(int numberOfChannels, int min, int max, String suffix) {
        this.numberOfChannels = numberOfChannels;
        this.min = min;
        this.max = max;
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }

    public List<Double> extractNormalizedChannels() {
        ArrayList<Double> normalizedChannels = new ArrayList<>();
        for(Integer channel: channels)
            normalizedChannels.add(Double.valueOf(channel)/max);

        return normalizedChannels;
    }

    public void setChannel(int index, Integer value) {
        if(value < min || value > max)
            throw new IllegalArgumentException(String.format("Wrong channel value: %d. Should be between %d and %d", value, min, max));

        channels.add(index, value);
    }

    public void setChannel(int index, Double normalizedValue) {
        Integer value = (int) Math.round(normalizedValue*max);

        if(value < min || value > max)
            throw new IllegalArgumentException(String.format("Wrong channel value: %d. Should be between %d and %d", value, min, max));

        channels.add(index, value);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName().toLowerCase() + "(");
        for(int i = 0; i < numberOfChannels; ++i) {
            stringBuilder.append(channels.get(i));
            stringBuilder.append(suffix);
            stringBuilder.append(i != numberOfChannels-1 ? ", " : ")");
        }
        return stringBuilder.toString();
    }
}
