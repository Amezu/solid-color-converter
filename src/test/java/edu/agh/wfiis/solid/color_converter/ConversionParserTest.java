package edu.agh.wfiis.solid.color_converter;

import org.junit.Assert;
import org.junit.Test;

public class ConversionParserTest {

    @Test
    public void shouldParseTypeOfConversion() {
        String input = "rgb(255, 0, 0) cmyk";
        String[] args = input.split(" ");
        Conversion conversion = ConversionParser.parse(args);
        Assert.assertEquals("rgb to cmyk", conversion.getTypeOfConversion());
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldFailWhenWrongInputFormat() {
        String input = "cmyk(0%,0%, 0%, 100%) rgb";
        String[] args = input.split(" ");
        ConversionParser.parse(args);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldFailWhenNoInput() {
        String[] args = {};
        ConversionParser.parse(args);
    }
}