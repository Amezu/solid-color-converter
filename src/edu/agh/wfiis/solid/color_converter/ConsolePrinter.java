package edu.agh.wfiis.solid.color_converter;

public class ConsolePrinter implements HandlingResult {

    public void handle(Color color) {
        System.out.println(color);
    }
}
