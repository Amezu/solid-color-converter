package edu.agh.wfiis.solid.color_converter;

public class ColorConverter {

    public void convert(String[] input, HandlingResult resultHandler) {
        Conversion conversion = ConversionParser.parse(input);
        Converting converter = ConverterChooser.choose(conversion.getTypeOfConversion());
        ColorModel result = converter.convert(conversion.getColorToConvert());
        resultHandler.handle(result);
    }

    public static void main(String[] args) {
        ColorConverter colorConverter = new ColorConverter();
        colorConverter.convert(args, new ConsolePrinter());
    }
}
