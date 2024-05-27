package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    private JLabel labelDificultad;
    private JLabel labelTamano;
    private JComboBox<String> comboTamano;
    private JRadioButton radioFacil;
    private JRadioButton radioMedio;
    private JRadioButton radioDificil;

    public PanelSuperior() {
        setLayout(new FlowLayout());
        setBackground(Color.LIGHT_GRAY);

        labelTamano = new JLabel("Tamaño");
        comboTamano = new JComboBox<>(new String[]{"5x5", "6x6", "7x7", "8x8", "9x9", "10x10"});
        labelDificultad = new JLabel("Dificultad");
        radioFacil = new JRadioButton("Fácil");
        radioMedio = new JRadioButton("Medio");
        radioDificil = new JRadioButton("Difícil");

        ButtonGroup group = new ButtonGroup();
        group.add(radioFacil);
        group.add(radioMedio);
        group.add(radioDificil);

        add(labelTamano);
        add(comboTamano);
        add(labelDificultad);
        add(radioFacil);
        add(radioMedio);
        add(radioDificil);
    }

    public String getDificultad() {
        if (radioFacil.isSelected()) {
            return "Fácil";
        } else if (radioMedio.isSelected()) {
            return "Medio";
        } else if (radioDificil.isSelected()) {
            return "Difícil";
        } else {
            return "Fácil"; // Valor predeterminado
        }
    }

    public int getTamanoTablero() {
        String seleccion = (String) comboTamano.getSelectedItem();
        return Integer.parseInt(seleccion.split("x")[0]);
    }
}
