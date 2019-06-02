package edu.agh.wfiis.solid.color_converter;

public class ColorModelParser {

    public static ColorModel parse(String[] input) {
        ColorModel color = ColorModelChooser.choose(input[0].substring(0, input[0].indexOf("(")));
        int numberOfChannels = color.getNumberOfChannels();

        if(numberOfChannels != input.length - 1)
            throw new IllegalArgumentException(String.format("Number of channels: %d. Should be %d", input.length-1, numberOfChannels));

        color.setChannel(0, Integer.valueOf(input[0].substring(input[0].indexOf("(")+1, input[0].indexOf(color.getSuffix() + ","))));
        for(int i=1; i<numberOfChannels-1; ++i)
            color.setChannel(i, Integer.valueOf(input[i].substring(0, input[i].indexOf(color.getSuffix() + ","))));
        color.setChannel(numberOfChannels-1, Integer.valueOf(input[numberOfChannels-1].substring(0, input[numberOfChannels-1].indexOf(color.getSuffix() + ")"))));

        return color;
    }
}
