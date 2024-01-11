package main;

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
    }
}
