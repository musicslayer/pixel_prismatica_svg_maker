import java.lang.StringBuilder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class SVGMaker {
    public final static String githubPath = "C:\\MIKE\\PROGRAMING\\GitHub\\pixel_prismatica_svg_maker\\svg\\";
    public final static int numColors = 5;
    public final static int num_rect_x = 2;
    public final static int num_rect_y = 2;
    public final static int rect_width = 20;
    public final static int rect_height = 20;
    public final static int step_duration = 2;
    
    public static void main(String[] args)
    {
        createSVG("rainbow_light", new RainbowLightColorPicker());
        createSVG("rainbow_dark", new RainbowDarkColorPicker());
        createSVG("monochrome", new MonochromeColorPicker());
        createSVG("red", new RedColorPicker());
        createSVG("green", new GreenColorPicker());
        createSVG("blue", new BlueColorPicker());
        createSVG("green_blue", new GreenBlueColorPicker());
        createSVG("red_green", new RedGreenColorPicker());
        createSVG("red_blue", new RedBlueColorPicker());
        createSVG("cyan", new CyanColorPicker());
        createSVG("yellow", new YellowColorPicker());
        createSVG("magenta", new MagentaColorPicker());
    }
    
    public static void createSVG(String name, RandomColorPicker rcp) {
        String svgString = getStartString() + getContentString(rcp) + getEndString();
        
        writeSVGFile(name, svgString);
        writeURIFile(name, svgString);
    }
    
    public static void writeSVGFile(String name, String content) {
        Path path = Paths.get(githubPath + name + ".svg");
        
        byte[] strToBytes = content.getBytes();
        try {
            Files.write(path, strToBytes);
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static void writeURIFile(String name, String content) {
        Path path = Paths.get(githubPath + name + "_uri.txt");
        
        String encodedString = "data:image/svg+xml;base64," + Base64.getEncoder().encodeToString(content.getBytes());
        byte[] strToBytes = encodedString.getBytes();
        try {
            Files.write(path, strToBytes);
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static String getStartString() {
        int width = rect_width * num_rect_x;
        int height = rect_height * num_rect_y;
        
        StringBuilder s = new StringBuilder();
        s.append("<?xml version=\"1.1\"?>").append("\n");
        s.append("<svg width=\"").append(width).append("\" height=\"").append(height).append("\" xmlns=\"http://www.w3.org/2000/svg\">").append("\n");
        s.append("<defs>").append("\n");
        s.append("<rect id=\"box\" width=\"").append(rect_width).append("\" height=\"").append(rect_height).append("\"/>").append("\n");
        s.append("</defs>").append("\n");
        return s.toString();
    }
    
    public static String getEndString() {
        StringBuilder s = new StringBuilder();
        s.append("</svg>");
        return s.toString();
    }
    
    public static String getContentString(RandomColorPicker rcp) {
        StringBuilder s = new StringBuilder();
        for(int i_y = 0; i_y < num_rect_y; i_y++) {
            for(int i_x = 0; i_x < num_rect_x; i_x++) {
                int rect_x = i_x * rect_width;
                int rect_y = i_y * rect_height;
                s.append(getRectString(rect_x, rect_y, rcp));
            }
        }
        return s.toString();
    }
    
    public static String getRectString(int x, int y, RandomColorPicker rcp) {
        String[] colorStringArray = new String[numColors];
        for(int i = 0; i < numColors; i++) {
            colorStringArray[i] = rcp.pickColor();
        }
        
        StringBuilder sValues = new StringBuilder();
        for(int i = 0; i < numColors; i++) {
            sValues.append(colorStringArray[i]);
            sValues.append(";");
        }
        sValues.append(colorStringArray[0]);
        
        String dur = (numColors * step_duration) + "s";
        
        StringBuilder s = new StringBuilder();
        s.append("<use href=\"#box\" x=\"").append(x).append("\" y=\"").append(y).append("\">").append("\n");
        s.append("<animate attributeName=\"fill\" values=\"").append(sValues.toString()).append("\" dur=\"").append(dur).append("\" repeatCount=\"indefinite\"/>").append("\n");
        s.append("</use>").append("\n");
        return s.toString();
    }
}
