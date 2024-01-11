package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ITEM_Collar extends SuperItem {

    public ITEM_Collar() {

        name = "Collar";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/items/collaritem.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
