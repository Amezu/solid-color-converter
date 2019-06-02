package edu.agh.wfiis.solid.color_converter;

public class ColorConverter {

    public static Color convert(String[] input) {
        Conversion conversion = ConversionParser.parse(input);
        Converting converter = ConverterChooser.choose(conversion.getTypeOfConversion());
        return converter.convert(conversion.getColorToConvert());
    }

    public static void main(String[] args) {
        Color result = ColorConverter.convert(args);
        System.out.println(result);
    }
}
