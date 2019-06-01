package edu.agh.wfiis.solid.color_converter;

import java.util.HashMap;

public class ConverterChooser {
    private static final HashMap<String, Converting> CONVERTER_BY_TYPES = new HashMap<>();

    static {
        CONVERTER_BY_TYPES.put("rgb to cmyk", new RGBToCMYKConverter());
        CONVERTER_BY_TYPES.put("cmyk to rgb", new CMYKToRGBConverter());
    }

    public static Converting choose(String typeOfConversion) {
        Converting converter = CONVERTER_BY_TYPES.get(typeOfConversion);
        if (converter != null) {
            return converter;
        }
        else {
            throw new IllegalArgumentException("Conversion from " + typeOfConversion + " is not supported");
        }
    }
}
