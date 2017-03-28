package com.sslab.pokemon;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.sslab.pokemon.data.PokemonIndividualData;
import com.sslab.pokemon.data.PokemonSpeciesData;
import com.sslab.pokemon.sprite.PokemonSprite;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
    Pokedex newpokedex;
    HashMap<JPanel, PokemonIndividualData> pokemonMap;

    public PokeGen() {
        /* Remember to new ArrayList otherwise there will be pointer error */
        statFields = new ArrayList<>();
        pokemonMap = new HashMap<>();
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
        newpokedex = new Pokedex();
        speciesComboBox.addItem(" ----------------- ");
        for(int i = 0; i < pokedex.getPokemonSize(); i++) {
            String name = pokedex.getPokemonData(i).getId() + ": " + pokedex.getPokemonData(i).getSpeciesName();
            speciesComboBox.addItem(name);
        }



        MouseListener handler = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentSelectedPanel = (JPanel) e.getComponent();
                currentSelectedPanel.setBorder(BorderFactory.createLoweredBevelBorder());
                loadPokemon(currentSelectedPanel);
            }

            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) {
                currentSelectedPanel.setBorder(BorderFactory.createEtchedBorder());

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
                setPokemon(currentSelectedPanel);
                try {
                    saveFile("morris_new_pokemon.json");
                } catch (IOException ioexception) {
                    ioexception.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePokemon(currentSelectedPanel);
                loadPokemon(currentSelectedPanel);
                try {
                    saveFile("morris_new_pokemon.json");
                } catch (IOException ioexception) {
                    ioexception.printStackTrace();
                }
            }
        });

    }

    public void setPokemon(JPanel panel) {
        int[] value = new int[6];
        for(int i = 0; i < 6; i++) {
            value[i] = Integer.parseInt(statFields.get(i+1).getText());
        }
        String nickName = nickNameField.getText();
        int comboIndex   = speciesComboBox.getSelectedIndex();
        PokemonSpeciesData speciesData = pokedex.getPokemonData(comboIndex-1);
        PokemonIndividualData individualData = new PokemonIndividualData (speciesData, nickName, value, comboIndex);
        pokemonMap.put(panel, individualData);
        ImageIcon icon = new ImageIcon(PokemonSprite.getSprite(comboIndex));
        JLabel label = (JLabel) panel.getComponent(0);
        label.setIcon(icon);
        newpokedex.addNewPokemon(individualData.getId(), individualData.getSpeciesName(), value, individualData.getType());
    }

    public void loadPokemon(JPanel panel) {
        if(pokemonMap.containsKey(panel)) {
            PokemonIndividualData individualData = pokemonMap.get(panel);
            int[] value = individualData.getSpeciesValue().getValArray();
            speciesComboBox.setSelectedIndex(individualData.getId());
            nickNameField.setText(individualData.getNickName());
            for(int i = 0; i < 6; i++) {
                Integer valstr = value[i];
                statFields.get(i+1).setText(valstr.toString());
            }
        } else {
            for(int i = 0; i < statFields.size(); i++) {
                statFields.get(i).setText(null);
                speciesComboBox.setSelectedIndex(0);
            }
        }
    }
    public void deletePokemon(JPanel panel) {
        if(pokemonMap.containsKey(panel)) {
            JLabel label = (JLabel) panel.getComponent(0);
            label.setIcon(null);
            pokemonMap.remove(panel);
        }
    }

    public void saveFile(String fileName) throws IOException {
        //TODO sort list before save to file
        //Collections.sort(pokemonSpeciesDataList);
        //Create JsonWriter with fileName
        JsonWriter writer = new JsonWriter(new FileWriter(fileName));
        //create a gson object
        Gson gson = new Gson();
        //use gson to write object into json file, remember to convert ArrayList back to normal array first
        gson.toJson(pokemonMap.values().toArray(),PokemonSpeciesData[].class,writer);
        //close the writer, very important!!!
        writer.close();

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("PokeGen");
        frame.setContentPane(new PokeGen().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}