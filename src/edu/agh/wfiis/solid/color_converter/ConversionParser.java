package edu.agh.wfiis.solid.color_converter;

public class ConversionParser {
    public static Conversion parse(String[] input) {
        String targetRepresentation = input[input.length-1];
        RepresentingColor color = ModelChooser.choose(input[0].substring(0, input[0].indexOf("(")));

        if(color.getNumberOfComponents() != input.length-1)
            throw new IllegalArgumentException(String.format("Wrong input length or format, example input: \"cmyk(100%%, 25%%, 0%%, 0%%) rgb\""));

        color.retrieveDataFromInput(input);

        return new Conversion(color, targetRepresentation);
    }
}
