package com.sslab.pokemon.data;

/**
 * Created by jerry on 2017/3/21.
 */
public class PokemonIndividualData extends PokemonSpeciesData
{
    //=================================//
    // inherit from PokemonSpeciesData //
    //=================================//
    /* add its own nickname and comboBox index */
    private String nickName;
    private int comboIndex;

    public PokemonIndividualData(PokemonSpeciesData ps, String nickname, int[] value, int combo) {
        super (ps.getId(), ps.getSpeciesName(), ps.getSpeciesValue(), ps.getType());
        this.nickName = nickname;
        this.setSpeciesValue(value);
        this.comboIndex = combo;
    }

    public String getNickName() {
        return nickName;
    }

    public int getComboIndex() {
        return  comboIndex;
    }
}
