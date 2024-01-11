package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ITEM_Yarn extends SuperItem {

    public ITEM_Yarn() {

        name = "Yarn";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/items/yarnitem.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
