package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class PanelDerecho extends JPanel {
    private JButton botonNuevo;
    private JButton botonReiniciar;
    private JButton botonTop;
    private JButton botoncambio;

    public PanelDerecho() {
        setLayout(new GridLayout(4, 1, 10, 10));

        botonNuevo = new JButton("NUEVO");
        botonReiniciar= new JButton("REINICIAR");
        botonTop = new JButton("TOP-10");
        botoncambio = new JButton ("CAMBIAR JUGADOR");

        add(botonNuevo);
        add(botonReiniciar);
        add(botonTop);
        add(botoncambio);
    }
}
