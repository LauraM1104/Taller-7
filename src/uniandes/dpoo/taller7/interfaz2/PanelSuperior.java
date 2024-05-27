package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    private JLabel labelDificultad;
    private JLabel labelTamano;
    private JComboBox<String> comboModo;
    private JRadioButton radioFacil;
    private JRadioButton radioMedio;
    private JRadioButton radioDificil;

    public PanelSuperior() {
        setLayout(new FlowLayout());

        labelTamano = new JLabel("Tamaño");
        comboModo = new JComboBox<>(new String[]{"5x5", "3x3"});
        labelDificultad = new JLabel ("Dificultad");
        radioFacil = new JRadioButton("Fácil");
        radioMedio = new JRadioButton("Medio");
        radioDificil = new JRadioButton("Dificil");

        ButtonGroup group = new ButtonGroup();
        group.add(radioFacil);
        group.add(radioMedio);
        group.add((radioDificil));
        
        add(labelTamano);
        add(comboModo);
        add(labelDificultad);
        add(radioFacil);
        add(radioMedio);
        add(radioDificil);
    }
}
