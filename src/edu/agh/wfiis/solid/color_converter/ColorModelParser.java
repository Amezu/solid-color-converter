package edu.agh.wfiis.solid.color_converter;

public class ColorModelParser {
    public static ColorModel parse(String[] input) {
        ColorModel color = ModelChooser.choose(input[0].substring(0, input[0].indexOf("(")));

        if(color.getNumberOfChannels() != input.length - 1)
            System.out.println("Wrong number of channels");

        System.out.println(color.getClass().getSimpleName());

        color.addChannelValue(Integer.valueOf(input[0].substring(input[0].indexOf("(")+1, input[0].indexOf(color.getSuffix() + ","))));
        for(int i=1; i<input.length-2; ++i)
            color.addChannelValue(Integer.valueOf(input[i].substring(0, input[i].indexOf(color.getSuffix() + ","))));
        color.addChannelValue(Integer.valueOf(input[input.length-2].substring(0, input[input.length-2].indexOf(color.getSuffix() + ")"))));

        for(Integer channel : color.getChannels())
            if(channel<color.getMin() || channel>color.getMax())
                System.out.println("Wrong argument number");

        return color;
    }
}
