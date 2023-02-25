import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.imageio.ImageIO;

public class PNGMaker {
    public final static String githubPath = "C:\\MIKE\\PROGRAMING\\GitHub\\pixel_prismatica_svg_maker\\png\\";
    public final static int numColors = 5;
    public final static int num_rect_x = 10;
    public final static int num_rect_y = 10;
    public final static int rect_width = 10;
    public final static int rect_height = 10;
    public final static int step_duration = 2;
    
    public static void main(String[] args)
    {
        createPNG("rainbow_light", new RainbowLightColorPicker());
        createPNG("rainbow_dark", new RainbowDarkColorPicker());
        createPNG("monochrome", new MonochromeColorPicker());
        createPNG("red", new RedColorPicker());
        createPNG("green", new GreenColorPicker());
        createPNG("blue", new BlueColorPicker());
        createPNG("green_blue", new GreenBlueColorPicker());
        createPNG("red_green", new RedGreenColorPicker());
        createPNG("red_blue", new RedBlueColorPicker());
        createPNG("cyan", new CyanColorPicker());
        createPNG("yellow", new YellowColorPicker());
        createPNG("magenta", new MagentaColorPicker());
    }
    
    public static void createPNG(String name, RandomColorPicker rcp) {
        BufferedImage pngImage = createImage(rcp);
        
        writePNGFile(name, pngImage);
        writeURIFile(name, pngImage);
    }
    
    public static void writePNGFile(String name, BufferedImage pngImage) {
        File file = new File(githubPath + name + ".png");
        
        try {
            ImageIO.write(pngImage, "png", file);
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static void writeURIFile(String name, BufferedImage pngImage) {
        Path path = Paths.get(githubPath + name + "_uri.txt");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        try {
            ImageIO.write(pngImage, "png", bos);
            byte[] imageBytes = bos.toByteArray();
            String encodedString = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
            byte[] strToBytes = encodedString.getBytes();
            Files.write(path, strToBytes);
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static BufferedImage createImage(RandomColorPicker rcp) {
        int width = rect_width * num_rect_x;
        int height = rect_height * num_rect_y;
        BufferedImage rgbImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        
        for(int i_y = 0; i_y < num_rect_y; i_y++) {
            for(int i_x = 0; i_x < num_rect_x; i_x++) {
                int rect_x = i_x * rect_width;
                int rect_y = i_y * rect_height;
                createTile(rgbImage, rect_x, rect_y, rcp);
            }
        }
        return rgbImage;
    }
    
    public static void createTile(BufferedImage rgbImage, int x, int y, RandomColorPicker rcp) {
        int[] colorArray = rcp.pickColorInt();
        Color color = new Color(colorArray[0], colorArray[1], colorArray[2]);
        int rgb = color.getRGB();

        for(int i_y = 0; i_y < rect_height; i_y++) {
            for(int i_x = 0; i_x < rect_width; i_x++) {
                rgbImage.setRGB(x + i_x, y + i_y, rgb);
            }
        }
    }
}
