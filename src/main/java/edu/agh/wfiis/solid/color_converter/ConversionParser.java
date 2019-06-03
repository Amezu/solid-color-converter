package edu.agh.wfiis.solid.color_converter;

import java.util.regex.Pattern;

public class ConversionParser {

    public static Conversion parse(String[] input) {
        if(!isInputFormatValid(input))
            throw new IllegalArgumentException("Wrong input format (Whitespaces are important!). Example input: rgb(255, 255, 255) cmyk");

        Color color = ColorParser.parse(input);
        String givenType = input[0].substring(0, input[0].indexOf("("));
        String targetType = input[input.length-1];
        String typeOfConversion = givenType + " to " + targetType;

        return new Conversion(color, typeOfConversion);
    }

    private static boolean isInputFormatValid(String[] input) {
        if(input.length < 3)
            return false;

        String suffixesPattern = "[%]?";

        if(!Pattern.matches("\\w+\\(\\-?[\\d]+" + suffixesPattern  + ",", input[0]))
            return false;

        for(int i=1; i<input.length-2; i++) {
            if (!Pattern.matches("\\-?\\d+" + suffixesPattern + ",", input[i]))
                return false;
        }

        if(!Pattern.matches("\\-?\\d+" + suffixesPattern + "\\)", input[input.length-2]))
            return false;

        if(!Pattern.matches("\\w+", input[input.length-1]))
            return false;

        return true;
    }
}
