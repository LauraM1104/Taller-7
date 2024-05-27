package uniandes.dpoo.taller7.interfaz4;

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
        campoInfojugada.setEditable(false);
        labelJugador = new JLabel("Jugador: ");
        campoInfojugador = new JTextField(10);
        campoInfojugador.setEditable(false);
        setBackground(Color.LIGHT_GRAY);
        labelJugadas.setForeground(Color.BLACK);
        labelJugador.setForeground(Color.BLACK);
        
        add(labelJugadas);
        add(campoInfojugada);
        add(labelJugador);
        add(campoInfojugador);
    }

    public void setJugadas(int jugadas) {
        campoInfojugada.setText(String.valueOf(jugadas));
    }

    public void setJugador(String jugador) {
        campoInfojugador.setText(jugador);
    }
}
