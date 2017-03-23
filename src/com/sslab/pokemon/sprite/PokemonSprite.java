package com.sslab.pokemon.sprite;

/**
 * Created by jerry on 2017/3/19.
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PokemonSprite {

    private static BufferedImage spriteSheet;
    private static final int TILE_SIZE = 40;
    private static final int TILE_HEIGHT = 30;

    public static BufferedImage loadSprite(String file) {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("res/" + file + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }


    public static BufferedImage getSprite(int id) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite("pokemonAll");
        }

        int xGrid = id%16;
        int yGrid = id/16;

        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_HEIGHT, TILE_SIZE, TILE_HEIGHT);
    }

}