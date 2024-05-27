package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelDerecho extends JPanel {
    private JButton botonNuevo;
    private JButton botonReiniciar;
    private JButton botonTop;
    private JButton botonCambio;

    public PanelDerecho() {
        setLayout(new GridLayout(4, 1, 10, 10));
        setBackground(Color.DARK_GRAY);
        botonNuevo = new JButton("NUEVO");
        botonReiniciar = new JButton("REINICIAR");
        botonTop = new JButton("TOP-10");
        botonCambio = new JButton("CAMBIAR JUGADOR");
        botonNuevo.setForeground(Color.WHITE);
        botonNuevo.setBackground(Color.BLUE);

        botonReiniciar.setForeground(Color.WHITE);
        botonReiniciar.setBackground(Color.BLUE);

        botonTop.setForeground(Color.WHITE);
        botonTop.setBackground(Color.BLUE);

        botonCambio.setForeground(Color.WHITE);
        botonCambio.setBackground(Color.BLUE);
        
        add(botonNuevo);
        add(botonReiniciar);
        add(botonTop);
        add(botonCambio);
    }

    public void addNuevoListener(ActionListener listener) {
        botonNuevo.addActionListener(listener);
    }

    public void addReiniciarListener(ActionListener listener) {
        botonReiniciar.addActionListener(listener);
    }

    public void addTop10Listener(ActionListener listener) {
        botonTop.addActionListener(listener);
    }

    public void addCambiarJugadorListener(ActionListener listener) {
        botonCambio.addActionListener(listener);
    }
}
