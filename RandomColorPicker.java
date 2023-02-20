import java.util.concurrent.ThreadLocalRandom;

abstract public class RandomColorPicker {
    abstract public int[] pickColorInt();
    
    public String pickColor() {
        int[] cArray = pickColorInt();
        return String.format("#%02X%02X%02X", cArray[0], cArray[1], cArray[2]);
    }
}

class RainbowLightColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int c = 255;
        
        int[] cArray;
        int r = ThreadLocalRandom.current().nextInt(0, 6);
        switch(r) {
            case 0:
                cArray = new int[]{c, 0, 0};
                break;
            case 1:
                cArray = new int[]{0, c, 0};
                break;
            case 2:
                cArray = new int[]{0, 0, c};
                break;
            case 3:
                cArray = new int[]{0, c, c};
                break;
            case 4:
                cArray = new int[]{c, c, 0};
                break;
            case 5:
                cArray = new int[]{c, 0, c};
                break;
            default:
                cArray = new int[]{0, 0, 0};
        }

        return cArray;
    }
}

class RainbowDarkColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int c = 128;
        
        int[] cArray;
        int r = ThreadLocalRandom.current().nextInt(0, 6);
        switch(r) {
            case 0:
                cArray = new int[]{c, 0, 0};
                break;
            case 1:
                cArray = new int[]{0, c, 0};
                break;
            case 2:
                cArray = new int[]{0, 0, c};
                break;
            case 3:
                cArray = new int[]{0, c, c};
                break;
            case 4:
                cArray = new int[]{c, c, 0};
                break;
            case 5:
                cArray = new int[]{c, 0, c};
                break;
            default:
                cArray = new int[]{0, 0, 0};
        }

        return cArray;
    }
}

class MonochromeColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{randomNum, randomNum, randomNum};
    }
}

class RedColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{randomNum, 0, 0};
    }
}

class GreenColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{0, randomNum, 0};
    }
}

class BlueColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{0, 0, randomNum};
    }
}

class GreenBlueColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNumA = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumB = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{0, randomNumA, randomNumB};
    }
}

class RedGreenColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNumA = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumB = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{randomNumA, randomNumB, 0};
    }
}

class RedBlueColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNumA = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumB = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{randomNumA, 0, randomNumB};
    }
}

class CyanColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{0, randomNum, randomNum};
    }
}

class YellowColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{randomNum, randomNum, 0};
    }
}

class MagentaColorPicker extends RandomColorPicker {
    public int[] pickColorInt() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 256);
        return new int[]{randomNum, 0, randomNum};
    }
}