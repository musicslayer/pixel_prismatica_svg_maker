import java.util.concurrent.ThreadLocalRandom;

abstract public class RandomColorPicker {
    abstract public String pickColor();
}

class MonochromeColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", randomNum, randomNum, randomNum);
    }
}

class RedColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", randomNum, 0, 0);
    }
}

class GreenColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", 0, randomNum, 0);
    }
}

class BlueColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", 0, 0, randomNum);
    }
}

class GreenBlueColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNumA = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumB = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", 0, randomNumA, randomNumB);
    }
}

class RedGreenColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNumA = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumB = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", randomNumA, randomNumB, 0);
    }
}

class RedBlueColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNumA = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumB = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", randomNumA, 0, randomNumB);
    }
}

class CyanColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", 0, randomNum, randomNum);
    }
}

class YellowColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", randomNum, randomNum, 0);
    }
}

class MagentaColorPicker extends RandomColorPicker {
    public String pickColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return String.format("#%02X%02X%02X", randomNum, 0, randomNum);
    }
}

class RainbowLightColorPicker extends RandomColorPicker {
    public String pickColor() {
        int c = 255;
        
        String s;
        int r = ThreadLocalRandom.current().nextInt(0, 6);
        switch(r) {
            case 0:
                s = String.format("#%02X%02X%02X", c, 0, 0);
                break;
            case 1:
                s = String.format("#%02X%02X%02X", 0, c, 0);
                break;
            case 2:
                s = String.format("#%02X%02X%02X", 0, 0, c);
                break;
            case 3:
                s = String.format("#%02X%02X%02X", 0, c, c);
                break;
            case 4:
                s = String.format("#%02X%02X%02X", c, c, 0);
                break;
            case 5:
                s = String.format("#%02X%02X%02X", c, 0, c);
                break;
            default:
                s = "?";
        }

        return s;
    }
}

class RainbowDarkColorPicker extends RandomColorPicker {
    public String pickColor() {
        int c = 128;
        
        String s;
        int r = ThreadLocalRandom.current().nextInt(0, 6);
        switch(r) {
            case 0:
                s = String.format("#%02X%02X%02X", c, 0, 0);
                break;
            case 1:
                s = String.format("#%02X%02X%02X", 0, c, 0);
                break;
            case 2:
                s = String.format("#%02X%02X%02X", 0, 0, c);
                break;
            case 3:
                s = String.format("#%02X%02X%02X", 0, c, c);
                break;
            case 4:
                s = String.format("#%02X%02X%02X", c, c, 0);
                break;
            case 5:
                s = String.format("#%02X%02X%02X", c, 0, c);
                break;
            default:
                s = "?";
        }

        return s;
    }
}