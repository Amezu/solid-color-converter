package edu.agh.wfiis.solid.color_converter;

import java.util.regex.Pattern;

public class ConversionParser {

    public static Conversion parse(String[] input) {
        if(!isInputFormatRight(input))
            throw new IllegalArgumentException("Wrong input format (Whitespaces are important!). Example input: rgb(255, 255, 255) cmyk");

        ColorModel color = ColorModelParser.parse(input);
        String givenType = input[0].substring(0, input[0].indexOf("("));
        String targetType = input[input.length-1];
        String typeOfConversion = givenType + " to " + targetType;

        return new Conversion(color, typeOfConversion);
    }

    private static boolean isInputFormatRight(String[] input) {
        if(!Pattern.matches("\\w+\\(\\-?[\\d]+,", input[0]))
            return false;

        for(int i=1; i<input.length-2; i++) {
            if (!Pattern.matches("\\-?\\d+,", input[i]))
                return false;
        }

        if(!Pattern.matches("\\-?\\d+\\)", input[input.length-2]))
            return false;

        if(!Pattern.matches("\\w+", input[input.length-1]))
            return false;

        return true;
    }
}
