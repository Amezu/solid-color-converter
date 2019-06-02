package edu.agh.wfiis.solid.color_converter;

public class ColorParser {

    public static Color parse(String[] input) {
        Model model = ModelChooser.choose(input[0].substring(0, input[0].indexOf("(")));
        Color color = new Color(model);

        int numberOfChannels = model.getNumberOfChannels();

        if(numberOfChannels != input.length - 1)
            throw new IllegalArgumentException(String.format("Number of channels: %d. Should be %d", input.length-1, numberOfChannels));

        char endingChar;
        int beginOfNumber;
        int endOfNumber;

        for(int i=0; i<numberOfChannels; ++i) {
            endingChar = (i == numberOfChannels-1 ? ')' : ',');
            beginOfNumber = (i == 0 ? input[0].indexOf("(")+1 : 0);

            if(!input[i].contains(color.getSuffix(i) + endingChar)) {
                System.out.print(input[i]);
                String numberFormat = input[i].substring(beginOfNumber, input[i].indexOf(endingChar));
                Color exampleColor = new Color(model);
                throw new IllegalArgumentException(String.format("Channel %d value has wrong format: %s. Example of right formatted color: %s", i+1, numberFormat, exampleColor));
            }

            endOfNumber = input[i].indexOf(color.getSuffix(i) + endingChar);

            color.setChannel(i, Integer.valueOf(input[i].substring(beginOfNumber, endOfNumber)));
        }

        return color;
    }
}
