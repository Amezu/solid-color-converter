package edu.agh.wfiis.solid.color_converter;

public class ConversionParser {

    public static Conversion parse(String[] input) {
        if (!isInputFormatValid(input))
            throw new IllegalArgumentException("Wrong input format. Example input: rgb(255, 255, 255) cmyk");

        Color color = ColorParser.parse(input);
        String givenType = input[0].substring(0, input[0].indexOf("("));
        String targetType = input[input.length - 1];
        String typeOfConversion = givenType + " to " + targetType;

        return new Conversion(color, typeOfConversion);
    }

    private static boolean isInputFormatValid(String[] inputArray) {
        String input = String.join(" ", inputArray);
        String inputRegex = "[a-z]+ *\\(\\d+%?(, *\\d+%?)*\\) [a-z]+";
        return input.matches(inputRegex);
    }
}
