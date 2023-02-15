import java.lang.StringBuilder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class SVGMaker {
    public final static String githubPath = "C:\\MIKE\\PROGRAMING\\GitHub\\pixel_prismatica_svg_maker\\svg\\";
    
    public static void main(String[] args)
    {
        String svgString = getStartString() + getContentString() + getEndString();
        
        Path path = Paths.get(githubPath + "rainbow.svg");
        
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
    
    public static String getContentString() {
        /*
        int rect_width = 16;
        int rect_height = 16;
        int num_rect_x = 16;
        int num_rect_y = 16;
        */
        
        int rect_width = 8;
        int rect_height = 8;
        int num_rect_x = 32;
        int num_rect_y = 32;
        
        StringBuilder s = new StringBuilder();
        for(int i_y = 0; i_y < num_rect_y; i_y++) {
            for(int i_x = 0; i_x < num_rect_x; i_x++) {
                int rect_x = i_x * rect_width;
                int rect_y = i_y * rect_height;
                s.append(getRectString(rect_x, rect_y, rect_width, rect_height)).append("\n");
            }
        }
        return s.toString();
    }
    
    public static String getRectString(int x, int y, int w, int h) {
        int randomNumA = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumB = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumC = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumD = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumE = ThreadLocalRandom.current().nextInt(0, 256);
        int randomNumF = ThreadLocalRandom.current().nextInt(0, 256);
        
        int randomNumX = ThreadLocalRandom.current().nextInt(4, 16);
        
        String colorString1 = String.format("#%02X%02X%02X", randomNumA, randomNumB, randomNumC);
        String colorString2 = String.format("#%02X%02X%02X", randomNumD, randomNumE, randomNumF);
        
        String dur = randomNumX + "s";
        StringBuilder s = new StringBuilder();
        s.append("    <rect x=\"").append(x).append("\" y=\"").append(y).append("\" width=\"").append(w).append("\" height=\"").append(h).append("\" fill=\"").append(colorString1).append("\">").append("\n");
        s.append("        <animate attributeName=\"fill\" values=\"").append(colorString1).append(";").append(colorString2).append(";").append(colorString1).append("\" dur=\"").append(dur).append("\" repeatCount=\"indefinite\"/>").append("\n");
        s.append("    </rect>");
        return s.toString();
    }
}