package edu.agh.wfiis.solid.color_converter;

public class Converter {

    public static void convert(String[] input, HandlingResult resultHandler) {
        Conversion conversion = ConversionParser.parse(input);
        Converting converter = ConverterChooser.choose(conversion.getTypeOfConversion());
        Color result = converter.convert(conversion.getColorToConvert());
        resultHandler.handle(result);
    }

    public static void main(String[] args) {
        Converter.convert(args, new ConsolePrinter());
    }
}
