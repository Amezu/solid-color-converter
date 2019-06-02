package edu.agh.wfiis.solid.color_converter;

public class ColorConverter {

    public static Color convert(String[] input) {
        Conversion conversion = ConversionParser.parse(input);
        Converting converter = ConverterChooser.choose(conversion.getTypeOfConversion());
        return converter.convert(conversion.getColorToConvert());
    }

    public static void main(String[] args) {
        System.out.println(ColorConverter.convert(args).toString());
    }
}
