package edu.agh.wfiis.solid.color_converter;

public class ConsolePrinter implements HandlingResult {
    public void handle(ColorModel color) {
        System.out.println(color);
    }
}
