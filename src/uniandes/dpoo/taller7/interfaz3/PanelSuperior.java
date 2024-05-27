package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelSuperior extends JPanel {
    private JLabel labelDificultad;
    private JLabel labelTamano;
    private JComboBox<String> comboModo;
    private JRadioButton radioFacil;
    private JRadioButton radioMedio;
    private JRadioButton radioDificil;

    public PanelSuperior() {
        setLayout(new FlowLayout());

        labelTamano = new JLabel("Tama�o");
        comboModo = new JComboBox<>(new String[]{"5x5", "3x3"});
        labelDificultad = new JLabel("Dificultad");
        radioFacil = new JRadioButton("F�cil");
        radioMedio = new JRadioButton("Medio");
        radioDificil = new JRadioButton("Dif�cil");

        ButtonGroup group = new ButtonGroup();
        group.add(radioFacil);
        group.add(radioMedio);
        group.add(radioDificil);

        add(labelTamano);
        add(comboModo);
        add(labelDificultad);
        add(radioFacil);
        add(radioMedio);
        add(radioDificil);
    }

    public void addComboBoxListener(ActionListener listener) {
        comboModo.addActionListener(listener);
    }

    public int getSelectedTamano() {
        String selectedItem = (String) comboModo.getSelectedItem();
        return selectedItem.equals("5x5") ? 5 : 3;
    }
}
