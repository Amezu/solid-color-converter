package edu.agh.wfiis.solid.color_converter;

import java.util.HashMap;

public class ColorModelChooser {

    private static final HashMap<String, ColorModel> MODELS_BY_NAMES = new HashMap<>();

    static {
        MODELS_BY_NAMES.put("rgb", new RGB());
        MODELS_BY_NAMES.put("cmyk", new CMYK());
    }

    public static ColorModel choose(String string) {
        ColorModel model = MODELS_BY_NAMES.get(string.toLowerCase());
        if (model != null) {
            return model;
        }
        else {
            throw new IllegalArgumentException(string + " is not supported");
        }
    }
}
