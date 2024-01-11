package main;

import item.ITEM_Collar;
import item.ITEM_Feather;
import item.ITEM_Fish;
import item.ITEM_Yarn;

public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setItem() {

        gp.item[0] = new ITEM_Yarn();
        gp.item[0].worldX = 23 * gp.tileSize;
        gp.item[0].worldY = 7 * gp.tileSize;

        gp.item[1] = new ITEM_Yarn();
        gp.item[1].worldX = 23 * gp.tileSize;
        gp.item[1].worldY = 40 * gp.tileSize;

        gp.item[2] = new ITEM_Collar();
        gp.item[2].worldX = 37 * gp.tileSize;
        gp.item[2].worldY = 7 * gp.tileSize;

        gp.item[3] = new ITEM_Fish();
        gp.item[3].worldX = 10 * gp.tileSize;
        gp.item[3].worldY = 9 * gp.tileSize;

        gp.item[4] = new ITEM_Feather();
        gp.item[4].worldX = 8 * gp.tileSize;
        gp.item[4].worldY = 28 * gp.tileSize;
    }
}
