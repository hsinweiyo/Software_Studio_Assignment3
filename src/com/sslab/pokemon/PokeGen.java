package com.sslab.pokemon;

import com.sslab.pokemon.data.PokemonIndividualData;
import com.sslab.pokemon.data.PokemonSpeciesData;
import com.sslab.pokemon.sprite.PokemonSprite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jerry on 2017/3/19.
 */
public class PokeGen {
    private JComboBox speciesComboBox;
    private JPanel root;

    private JButton deleteButton;
    private JButton saveButton;

    private JPanel slot0;
    private JPanel slot1;
    private JPanel slot2;
    private JPanel slot3;
    private JPanel slot4;
    private JPanel slot5;
    private JTextField nickNameField;
    private JTextField hpField;
    private JTextField atkField;
    private JTextField defField;
    private JTextField spAtkField;
    private JTextField spDefField;
    private JTextField speedField;
    private JPanel currentSelectedPanel;
    private ArrayList<JTextField> statFields;

    Pokedex pokedex;
    HashMap<JPanel, PokemonIndividualData> pokemonMap;

    public PokeGen() {

    }

    public void setPokemon(JPanel panel) {

    }

    public void loadPokemon(JPanel panel) {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PokeGen");
        frame.setContentPane(new PokeGen().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}