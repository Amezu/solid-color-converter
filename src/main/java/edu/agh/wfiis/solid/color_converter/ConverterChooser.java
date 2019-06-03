package edu.agh.wfiis.solid.color_converter;

import java.util.HashMap;

public class ConverterChooser {

    private static final HashMap<String, Converting> CONVERTERS_BY_TYPES = new HashMap<>();

    static {
        CONVERTERS_BY_TYPES.put("rgb to cmyk", new RGBToCMYKConverter());
        CONVERTERS_BY_TYPES.put("cmyk to rgb", new CMYKToRGBConverter());
    }

    public static Converting choose(String typeOfConversion) {
        Converting converter = CONVERTERS_BY_TYPES.get(typeOfConversion);
        if (converter != null) {
            return converter;
        }
        else {
            throw new UnsupportedOperationException("Conversion from " + typeOfConversion + " is not supported");
        }
    }
}
