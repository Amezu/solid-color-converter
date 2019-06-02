package edu.agh.wfiis.solid.color_converter;

public final class HSL extends Model {

    HSL() {
        super(3, 0, 100, "%");
        setMaxForChannel(0, 360);
        setSuffixForChannel(0, "");
    }
}
