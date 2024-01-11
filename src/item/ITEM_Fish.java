package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ITEM_Fish extends SuperItem {

    public ITEM_Fish() {

        name = "Fish";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/items/fishitem.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
