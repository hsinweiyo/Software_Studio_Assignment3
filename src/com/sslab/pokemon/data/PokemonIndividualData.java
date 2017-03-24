package com.sslab.pokemon.data;

/**
 * Created by jerry on 2017/3/21.
 */
public class PokemonIndividualData {
    //TODO create variables and constructor for this class
    private int speciesID;
    private String nickName;
    private PokemonValueData pokemonValueData;

    public PokemonIndividualData(String nickName, int speciesID, int[] valueData) {
        this.nickName = nickName;
        this.speciesID = speciesID;
        PokemonValueData data = new PokemonValueData(valueData);
        this.pokemonValueData = data;
    }

    public String getNickName() {
        return nickName;
    }

    public int getSpeciesID() {
        return speciesID;
    }

    public int[] getValueData() {
        return pokemonValueData.getValArray();
    }
}
