package edu.agh.wfiis.solid.color_converter;

public class Conversion {
    private ColorModel color;
    private String targetRepresentation;

    Conversion(ColorModel color, String targetRepresentation) {
        this.color = color;
        this.targetRepresentation = targetRepresentation;
    }

    public ColorModel getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color.getClass().getSimpleName() + " to " + targetRepresentation.toUpperCase();
    }
}
