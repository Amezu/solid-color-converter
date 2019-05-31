package edu.agh.wfiis.solid.color_converter;

import java.util.HashMap;

public class ConverterChooser {
    private static final HashMap<String, Converting> CONVERTER_BY_TYPES = new HashMap<>();

    static {
        CONVERTER_BY_TYPES.put("RGB to CMYK", new RGBToCMYKConverter());
        CONVERTER_BY_TYPES.put("CMYK to RGB", new CMYKToRGBConverter());
    }

    public static Converting choose(Conversion conversion) {
        Converting converter = CONVERTER_BY_TYPES.get(conversion.toString());
        if (converter != null) {
            return converter;
        }
        else {
            throw new IllegalArgumentException("Conversion from " + conversion.toString() + " is not supported");
        }
    }
}
