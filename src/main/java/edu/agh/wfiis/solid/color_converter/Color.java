package edu.agh.wfiis.solid.color_converter;

import java.util.ArrayList;
import java.util.List;

public final class Color {

    private Model model;
    private List<Integer> channels = new ArrayList<>();

    Color(Model model) {
        this.model = model;
        for(int i = 0; i < model.getNumberOfChannels(); ++i)
            channels.add(model.getMin(i));
    }

    public List<Double> extractNormalizedChannels() {
        ArrayList<Double> normalizedChannels = new ArrayList<>();
        for(int i = 0; i < model.getNumberOfChannels(); i++)
            normalizedChannels.add(Double.valueOf(channels.get(i))/model.getMax(i));

        return normalizedChannels;
    }

    public void setChannel(int index, Integer value) {
        if(value < model.getMin(index) || value > model.getMax(index))
            throw new IllegalArgumentException(String.format("Wrong channel value: %d. " +
                    "Should be between %d and %d", value, model.getMin(index), model.getMax(index)));
        channels.add(index, value);
    }

    public void setChannel(int index, Double normalizedValue) {
        Integer value = (int) Math.round(normalizedValue*model.getMax(index));
        setChannel(index, value);
    }

    public int getChannel(int index) {
        return channels.get(index);
    }

    public String getSuffix(int index) {
        return model.getSuffix(index);
    }

    public Model getModel() {
        return model;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(model.getName() + "(");
        for(int i = 0; i < model.getNumberOfChannels(); ++i) {
            stringBuilder.append(channels.get(i));
            stringBuilder.append(model.getSuffix(i));
            stringBuilder.append(i != model.getNumberOfChannels()-1 ? ", " : ")");
        }
        return stringBuilder.toString();
    }
}
