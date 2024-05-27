package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {
    private JLabel labelJugadas;
    private JTextField campoInfojugada;
    private JTextField campoInfojugador;
    private JLabel labelJugador;

    public PanelInferior() {
        setLayout(new FlowLayout());

        labelJugadas = new JLabel("Jugadas: ");
        campoInfojugada = new JTextField(10);
        labelJugador = new JLabel("Jugador: ");
        campoInfojugador = new JTextField(10);
        
        add(labelJugadas);
        add(campoInfojugada);
        add(labelJugador);
        add(campoInfojugador);
    }
}
