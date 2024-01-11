package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ITEM_Feather extends SuperItem {

    public ITEM_Feather() {

        name = "Feather";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/items/featheritem.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
    
}
