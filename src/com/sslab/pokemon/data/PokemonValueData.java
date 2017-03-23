package com.sslab.pokemon.data;

/**
 * Created by jerry on 2017/3/1.
 */
public class PokemonValueData {
    private int[] valArray;

    public PokemonValueData() {
        valArray = new int[6];
    }

    public PokemonValueData(int[] rawData) {
        valArray = rawData.clone();
    }

    public int[] getValArray() {
        return valArray;
    }
}