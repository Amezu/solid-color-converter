package edu.agh.wfiis.solid.color_converter;

public class ConversionParser {
    public static Conversion parse(String[] input) {
        String targetRepresentation = input[input.length-1];
        ColorModel color = ColorModelParser.parse(input);

        return new Conversion(color, targetRepresentation);
    }
}
