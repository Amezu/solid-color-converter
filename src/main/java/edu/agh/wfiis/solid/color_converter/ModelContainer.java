package edu.agh.wfiis.solid.color_converter;

import java.util.HashMap;

public class ModelContainer {

    private static final HashMap<String, Model> MODELS_BY_NAMES = new HashMap<>();

    static {
        Model rgb = new Model("rgb", 3, 0, 255, "");
        Model cmyk = new Model("cmyk", 4, 0, 100, "%");
        Model hsl = new Model("hsl", 3, 0, 100, "%");
        hsl.setMaxForChannel(0, 360);
        hsl.setSuffixForChannel(0, "");

        MODELS_BY_NAMES.put("rgb", rgb);
        MODELS_BY_NAMES.put("cmyk", cmyk);
        MODELS_BY_NAMES.put("hsl", hsl);
    }

    public static Model find(String string) {
        Model model = MODELS_BY_NAMES.get(string.toLowerCase());
        if (model != null) {
            return model;
        }
        else {
            throw new IllegalArgumentException(string + " is not supported");
        }
    }
}
