package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(16, 24, 12, 12);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/playerani/catup1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/playerani/catup2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/playerani/catdown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/playerani/catdown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/playerani/catleft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/playerani/catleft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/playerani/catright1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/playerani/catright2.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if(keyH.upPressed == true) {
            direction = "up";
            }
            else if(keyH.downPressed == true) {
                direction = "down";
            }
            else if (keyH.leftPressed == true) {
                direction = "left";
            }
            else if (keyH.rightPressed == true) {
                direction = "right";
            }

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK ITEM COLLISION
            int itemIntex = gp.cChecker.checkItem(this, true);
            pickUpItem(itemIntex);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE

            if(collisionOn == false) {

                switch(direction) {

                    case "up":
                        worldY -= speed;
                        break;
                        
                    case "down":
                        worldY += speed;
                        break;

                    case "left":
                        worldX -= speed;
                        break;

                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;

            if(spriteCounter > 20) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }  
        }
    }

    public void pickUpItem(int i) {

        if(i != 999) {
            
            String itemName = gp.item[i].name;

            switch(itemName) {
                case "Yarn":
                    gp.playSE(1);
                    hasKey++;
                    gp.item[i] = null;
                    gp.ui.showMessage("You got a yarn ball");
                    break;
                case "Feather":
                    gp.playSE(3);
                    if(hasKey > 0) {
                        gp.item[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You moved the feather");
                    } else {
                        gp.ui.showMessage("You need a yarn ball");
                    }
                    break;
                case "Collar":
                    gp.playSE(2);
                    speed += 2;
                    gp.item[i] = null;
                    gp.ui.showMessage("You got a collar");
                    break;
                case "Fish":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(4);
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch(direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
