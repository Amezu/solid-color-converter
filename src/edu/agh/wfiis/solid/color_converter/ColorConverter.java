package edu.agh.wfiis.solid.color_converter;

public class ColorConverter {

    public void convert(String[] input, HandlingResult resultHandler) {
        for(String s: input)
            System.out.println(s);
        Conversion conversion = ConversionParser.parse(input);
        Converting converter = ConverterChooser.choose(conversion);
        ColorModel result = converter.convert(conversion.getColor());
        resultHandler.handle(result);
    }

    public static void main(String[] args) {
        ColorConverter colorConverter = new ColorConverter();
        colorConverter.convert(args, new ConsolePrinter());
    }
}
