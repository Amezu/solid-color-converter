package edu.agh.wfiis.solid.color_converter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorParserTest {

    @Test
    public void shouldParse() {
        String input = "rgb(50, 100, 200) cmyk";
        String[] args = input.split(" ");
        Color color = ColorParser.parse(args);
        Assert.assertEquals("rgb", color.getModel().getName());
        Assert.assertEquals(50, color.getChannel(0));
        Assert.assertEquals(100, color.getChannel(1));
        Assert.assertEquals(200, color.getChannel(2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldFailWhenUnsupportedType() {
        String input = "abc(0) cmyk";
        String[] args = input.split(" ");
        ColorParser.parse(args);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldFailWhenWrongSuffix() {
        String input = "cmyk(0, 0%, 0%, 100%) rgb";
        String[] args = input.split(" ");
        ColorParser.parse(args);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldFailWhenWrongNumberOfChannels() {
        String input = "rgb(0) cmyk";
        String[] args = input.split(" ");
        ColorParser.parse(args);
    }
}