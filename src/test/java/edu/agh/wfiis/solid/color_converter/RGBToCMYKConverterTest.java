package edu.agh.wfiis.solid.color_converter;

import org.junit.Assert;

public class RGBToCMYKConverterTest {
    private RGBToCMYKConverter underTest;

    @org.junit.Before
    public void setUp() {
        underTest = new RGBToCMYKConverter();
    }

    @org.junit.Test
    public void shouldConvert() {
        Color color = new Color(ModelChooser.choose("rgb"));
        color.setChannel(0, 255);
        color.setChannel(1, 0);
        color.setChannel(2, 0);

        Color result = underTest.convert(color);
        Assert.assertEquals(0, result.getChannel(0));
        Assert.assertEquals(100, result.getChannel(1));
        Assert.assertEquals(100, result.getChannel(2));
        Assert.assertEquals(0, result.getChannel(3));
    }
}