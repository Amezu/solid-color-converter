package edu.agh.wfiis.solid.color_converter;

public class Conversion {
    private RepresentingColor color;
    private String targetRepresentation;

    Conversion(RepresentingColor color, String targetRepresentation) {
        this.color = color;
        this.targetRepresentation = targetRepresentation;
    }

    public RepresentingColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color.getClass().getSimpleName() + " to " + targetRepresentation.toUpperCase();
    }
}
