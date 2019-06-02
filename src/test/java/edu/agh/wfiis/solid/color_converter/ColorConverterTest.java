package edu.agh.wfiis.solid.color_converter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ColorConverterTest {

    @Test
    public void shouldConvertFromRGBToCMYK() {
        String input = "rgb(255, 0, 0) cmyk";
        String[] args = input.split(" ");
        Assert.assertEquals("cmyk(0%, 100%, 100%, 0%)", ColorConverter.convert(args).toString());
    }

    @Test
    public void shouldConvertFromCMYKToRGB() {
        String input = "cmyk(0%, 0%, 0%, 100%) rgb";
        String[] args = input.split(" ");
        Assert.assertEquals("rgb(0, 0, 0)", ColorConverter.convert(args).toString());
    }
}