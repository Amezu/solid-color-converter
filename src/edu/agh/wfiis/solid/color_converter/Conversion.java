package edu.agh.wfiis.solid.color_converter;

public class Conversion {

    private ColorModel colorToConvert;
    private String typeOfConversion;

    Conversion(ColorModel colorToConvert, String typeOfConversion) {
        this.colorToConvert = colorToConvert;
        this.typeOfConversion = typeOfConversion;
    }

    public ColorModel getColorToConvert() {
        return colorToConvert;
    }

    public String getTypeOfConversion() {
        return typeOfConversion;
    }
}
