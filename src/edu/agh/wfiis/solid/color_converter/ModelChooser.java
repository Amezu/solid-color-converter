package edu.agh.wfiis.solid.color_converter;

import java.util.HashMap;

public class ModelChooser {
    private static final HashMap<String, RepresentingColor> MODELS_BY_NAMES = new HashMap<>();

    static {
        MODELS_BY_NAMES.put("RGB", new RGB());
        MODELS_BY_NAMES.put("CMYK", new CMYK());
    }

    public static RepresentingColor choose(String string) {
        RepresentingColor model = MODELS_BY_NAMES.get(string.toUpperCase());
        if (model != null) {
            return model;
        }
        else {
            throw new IllegalArgumentException(string.toUpperCase() + " is not supported");
        }
    }
}
