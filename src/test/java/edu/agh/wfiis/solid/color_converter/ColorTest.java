package edu.agh.wfiis.solid.color_converter;

import org.junit.Test;

public class ColorTest {

    @Test (expected = IllegalArgumentException.class)
    public void setChannelShouldFailWhenAddingWrongValue() {
        Color color = new Color(ModelChooser.choose("rgb"));
        color.setChannel(0, 256);
    }
}