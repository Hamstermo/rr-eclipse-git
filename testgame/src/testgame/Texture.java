package testgame;


import java.io.IOException;

public class Texture {
    
    private int id;
    private int width;
    private int height;

    public Texture(String filename) {
        BufferedImage bi;
        try {
            bi = ImageIO.read(new File(filename));
            width = bi.getWidth();
            height = bu.getHeight();

            int[] pixels_raw = new int[width * height * 4];
            pixels_raw = bi.getRDB(0,0,width,height,null,0,width);

            ByteBuffer pixels = BufferUtils.createByteBuffer(width * height * 4);

            for(int i=0; i < width; i++){
                for(int j = 0; j < height; j++){
                    int pixel = pixels_raw[i*width+j];
                    pixels.put((byte)(pixel >> 16) & 0xFF);
                    pixels.put((byte)(pixel >> 8) & 0xFF);
                    pixels.put((byte)(pixel & 0xFF));
                    pixels.put((byte)(pixel >> 24) & 0xFF);
                }
            }
            pixels.flip();

            id = glGenTextures();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}