package edu.agh.wfiis.solid.color_converter;

public class Conversion {

    private Color colorToConvert;
    private String typeOfConversion;

    Conversion(Color colorToConvert, String typeOfConversion) {
        this.colorToConvert = colorToConvert;
        this.typeOfConversion = typeOfConversion;
    }

    public Color getColorToConvert() {
        return colorToConvert;
    }

    public String getTypeOfConversion() {
        return typeOfConversion;
    }
}
