import java.lang.StringBuilder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SVGMaker {
    public final static String githubPath = "C:\\MIKE\\PROGRAMING\\GitHub\\pixel_prismatica_svg_maker\\svg\\";
    
    public static void main(String[] args)
    {
        writeSVGFile("monochrome.svg", new MonochromeColorPicker());
        writeSVGFile("red.svg", new RedColorPicker());
        writeSVGFile("green.svg", new GreenColorPicker());
        writeSVGFile("blue.svg", new BlueColorPicker());
        writeSVGFile("green_blue.svg", new GreenBlueColorPicker());
        writeSVGFile("red_green.svg", new RedGreenColorPicker());
        writeSVGFile("red_blue.svg", new RedBlueColorPicker());
        writeSVGFile("cyan.svg", new CyanColorPicker());
        writeSVGFile("yellow.svg", new YellowColorPicker());
        writeSVGFile("magenta.svg", new MagentaColorPicker());
        writeSVGFile("rainbow_light.svg", new RainbowLightColorPicker());
        writeSVGFile("rainbow_dark.svg", new RainbowDarkColorPicker());
    }
    
    public static void writeSVGFile(String name, RandomColorPicker rcp) {
        String svgString = getStartString() + getContentString(rcp) + getEndString();
        
        Path path = Paths.get(githubPath + name);
        
        byte[] strToBytes = svgString.getBytes();
        try {
            Files.write(path, strToBytes);
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static String getStartString() {
        StringBuilder s = new StringBuilder();
        s.append("<?xml version=\"1.0\"?>").append("\n");
        s.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">").append("\n");
        s.append("<svg xmlns=\"http://www.w3.org/2000/svg\">").append("\n");
        return s.toString();
    }
    
    public static String getEndString() {
        StringBuilder s = new StringBuilder();
        s.append("</svg>");
        return s.toString();
    }
    
    public static String getContentString(RandomColorPicker rcp) {
        int rect_width = 8;
        int rect_height = 8;
        int num_rect_x = 32;
        int num_rect_y = 32;
        
        StringBuilder s = new StringBuilder();
        for(int i_y = 0; i_y < num_rect_y; i_y++) {
            for(int i_x = 0; i_x < num_rect_x; i_x++) {
                int rect_x = i_x * rect_width;
                int rect_y = i_y * rect_height;
                s.append(getRectString(rect_x, rect_y, rect_width, rect_height, rcp)).append("\n");
            }
        }
        return s.toString();
    }
    
    public static String getRectString(int x, int y, int w, int h, RandomColorPicker rcp) {
        int numColors = 30;
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
        
        String dur = "60s";
        
        StringBuilder s = new StringBuilder();
        s.append("    <rect x=\"").append(x).append("\" y=\"").append(y).append("\" width=\"").append(w).append("\" height=\"").append(h).append("\" fill=\"").append(colorStringArray[0]).append("\">").append("\n");
        s.append("        <animate attributeName=\"fill\" values=\"").append(sValues.toString()).append("\" dur=\"").append(dur).append("\" repeatCount=\"indefinite\"/>").append("\n");
        s.append("    </rect>");
        return s.toString();
    }
}
