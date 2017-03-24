package com.sslab.pokemon;

import com.sslab.pokemon.data.PokemonIndividualData;
import com.sslab.pokemon.data.PokemonSpeciesData;
import com.sslab.pokemon.sprite.PokemonSprite;

import javax.swing.*;
import java.awt.event.*;
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
        /* Remember to new ArrayList otherwise there will be pointer error */
        statFields = new ArrayList<>();
        currentSelectedPanel = new JPanel();
        /* Add the "stat" labels into statLabels */
        statFields.add(nickNameField);
        statFields.add(hpField);
        statFields.add(atkField);
        statFields.add(defField);
        statFields.add(spAtkField);
        statFields.add(spDefField);
        statFields.add(speedField);
        /* Use Pokedex to get pokemon species data */
        pokedex = new Pokedex("bin/pokemonData.json");
        for(int i = 0; i <= 800; i++) {
            String name = i+1 + ": " + pokedex.getPokemonData(i).getSpeciesName();
            speciesComboBox.addItem(name);
        }

        MouseListener handler = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentSelectedPanel = (JPanel) e.getComponent();
                System.out.println("set currentPanel");

                ((JPanel) e.getComponent()).setBorder(BorderFactory.createLoweredBevelBorder());
                //currentSelectedPanel.setBorder(BorderFactory.createEtchedBorder(1));
            }

            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) {
                currentSelectedPanel = (JPanel) e.getComponent();
                System.out.println("released currentPanel");
            }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }

        };

        slot0.addMouseListener(handler);
        slot1.addMouseListener(handler);
        slot2.addMouseListener(handler);
        slot3.addMouseListener(handler);
        slot4.addMouseListener(handler);
        slot5.addMouseListener(handler);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] value = new int[6];
                value[0] = Integer.parseInt(hpField.getText());
                value[1] = Integer.parseInt(atkField.getText());
                value[2] = Integer.parseInt(defField.getText());
                value[3] = Integer.parseInt(spAtkField.getText());
                value[4] = Integer.parseInt(spDefField.getText());
                value[5] = Integer.parseInt(speedField.getText());
                String nickName = nickNameField.getName();
                int speciesID = speciesComboBox.getSelectedIndex();
                PokemonIndividualData individualData = new PokemonIndividualData(nickName, speciesID, value);
                pokemonMap.put(currentSelectedPanel, individualData);
                for(int i = 0; i <= 5; i++) {
                    System.out.println(value[i]);

                }
            }
        });

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