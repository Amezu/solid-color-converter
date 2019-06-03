package edu.agh.wfiis.solid.color_converter;

import java.util.HashMap;

public class ModelChooser {

    private static final HashMap<String, Model> MODELS_BY_NAME = new HashMap<>();

    static {
        MODELS_BY_NAME.put("rgb", new RGB());
        MODELS_BY_NAME.put("cmyk", new CMYK());
        MODELS_BY_NAME.put("hsl", new HSL());
    }

    public static Model choose(String string) {
        Model model = MODELS_BY_NAME.get(string.toLowerCase());
        if (model != null) {
            return model;
        }
        else {
            throw new IllegalArgumentException(string + " is not supported");
        }
    }
}
