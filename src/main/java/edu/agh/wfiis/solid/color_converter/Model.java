package edu.agh.wfiis.solid.color_converter;

import java.util.ArrayList;
import java.util.List;

public abstract class Model {

    private final int numberOfChannels;
    private List<Integer> min = new ArrayList<>();
    private List<Integer> max = new ArrayList<>();
    private List<String> suffix = new ArrayList<>();

    Model(int numberOfChannels, Integer min, Integer max, String suffix) {
        this.numberOfChannels = numberOfChannels;
        for(int i=0; i<numberOfChannels; ++i) {
            this.min.add(min);
            this.max.add(max);
            this.suffix.add(suffix);
        }
    }

    public String getName() {
        return getClass().getSimpleName().toLowerCase();
    }

    protected void setMaxForChannel(int index, Integer max) {
        this.max.add(index, max);
    }

    protected void setMinForChannel(int index, Integer min) {
        this.min.add(index, min);
    }

    protected void setSuffixForChannel(int index, String suffix) {
        this.suffix.add(index, suffix);
    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }

    public Integer getMax(int index) {
        return max.get(index);
    }

    public Integer getMin(int index) {
        return min.get(index);
    }

    public String getSuffix(int index) {
        return suffix.get(index);
    }
}
