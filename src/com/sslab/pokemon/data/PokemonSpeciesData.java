package com.sslab.pokemon.data;

/**
 * Created by jerry on 2017/3/1.
 */

public class PokemonSpeciesData// implements Comparable<PokemonSpeciesData>
{
    private int id;
    private String speciesName;
    private PokemonValueData speciesValue;
    private String[] type;

    //HashMap<Integer,MoveData> learnMoveTable;
    public PokemonSpeciesData(int id, String speciesName,PokemonValueData valueData,String[] type)
    {
        this.id = id;
        this.speciesName = speciesName;
        this.speciesValue = valueData;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public PokemonValueData getSpeciesValue() {
        return speciesValue;
    }
    public String getType()
    {
        String s = "";
        for(int i=0;i<type.length;i++)
            s+=type[i];
        return s;
    }

}

//https://wiki.52poke.com/wiki/种族值