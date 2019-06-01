package edu.agh.wfiis.solid.color_converter;

public class ConversionParser {
    public static Conversion parse(String[] input) {
        ColorModel color = ColorModelParser.parse(input);
        String typeOfConversion = input[0].substring(0, input[0].indexOf("(")) + " to " + input[input.length-1];

        return new Conversion(color, typeOfConversion);
    }
}
