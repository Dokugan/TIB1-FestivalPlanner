package assets.tiled;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
* Created by Michel on 20-2-2017.
*/
public class TileLayer extends Layer {
    private int[][] data;
    private int height;
    private int width;
    private TileMap map;
    private BufferedImage image;
    private int tileWidth;
    private int tileHeight;

    public TileLayer(JsonObject layer, TileMap map, int tileWidth, int tileHeight)
    {
        super(layer, map);

        this.map = map;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        JsonArray array = layer.getJsonArray("data");

        this.height = layer.getInt("height");
        this.width = layer.getInt("width");

        this.data = new int[this.height][this.width];

        int i = 0;
        for(int x = 0; x < this.width; x++)
        {
            for(int y = 0; y < this.height; y++)
            {
                this.data[x][y] = array.getInt(i);
                i++;
            }
        }

        this.image = createImage();
    }

    /**
     * Create a new instance of the TileLayer
     * Uses predefined tile width/height of 32 pixels/32 pixels
     *
     * @param object
     * @param map
     */
    public TileLayer(JsonObject object, TileMap map)
    {
        this(object, map, 32, 32);
    }

    public BufferedImage createImage()
    {
        BufferedImage img = new BufferedImage(this.tileWidth * this.width, this.tileHeight * this.height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = img.createGraphics();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) this.opacity));
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                g2.drawImage(this.map.getTiles()[this.data[y][x]], x * this.tileWidth, y * this.tileHeight, null);
            }
        }
        return img;
    }

    public BufferedImage getImage()
    {
        return this.image;
    }

    public int[][] getData()
    {
        return this.data;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getWidth()
    {
        return this.width;
    }

    @Override
    public void draw(Graphics2D g) {
        if(this.forceRedraw)
        {
            this.forceRedraw = false;
            this.image = createImage();
        }

        g.drawImage(image, null, null);
    }

    @Override
    public void update() {

    }

    public boolean hasCollision(int x, int y)
    {
        return !(this.getData()[y][x] == 257 // Green
               || this.getData()[y][x] == 258 // Green
               || this.getData()[y][x] == 286 // Green
               || this.getData()[y][x] == 287 // Green
               || this.getData()[y][x] == 514 // Green
               || this.getData()[y][x] == 1273 // Blue
               || this.getData()[y][x] == 1301 // Blue
               || this.getData()[y][x] == 1302); // Blue
    }
}