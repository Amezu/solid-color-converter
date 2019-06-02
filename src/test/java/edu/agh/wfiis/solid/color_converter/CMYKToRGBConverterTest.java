package edu.agh.wfiis.solid.color_converter;

import org.junit.Assert;

public class CMYKToRGBConverterTest {
    private CMYKToRGBConverter underTest;

    @org.junit.Before
    public void setUp() {
        underTest = new CMYKToRGBConverter();
    }

    @org.junit.Test
    public void shouldConvert() {
        Color color = new Color(ModelChooser.choose("cmyk"));
        color.setChannel(0, 100);
        color.setChannel(1, 0);
        color.setChannel(2, 0);
        color.setChannel(3, 0);

        Color result = underTest.convert(color);
        Assert.assertEquals(0, result.getChannel(0));
        Assert.assertEquals(255, result.getChannel(1));
        Assert.assertEquals(255, result.getChannel(2));
    }
}