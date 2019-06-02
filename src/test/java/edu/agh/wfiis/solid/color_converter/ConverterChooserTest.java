package edu.agh.wfiis.solid.color_converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterChooserTest {

    @Test
    public void shouldChooseConverter() {
        ConverterChooser.choose("rgb to cmyk");
    }

    @Test (expected = UnsupportedOperationException.class)
    public void shouldFailWhenUnsupportedOperation() {
        ConverterChooser.choose("hsv to cmyk");
    }
}