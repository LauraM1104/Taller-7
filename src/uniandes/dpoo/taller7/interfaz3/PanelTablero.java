package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTablero extends JPanel {
    private int tamanoTablero;

    public PanelTablero() {
        this.tamanoTablero = 5;  // Tamaño por defecto
    }

    public void setTamanoTablero(int tamano) {
        this.tamanoTablero = tamano;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int anchoCelda = getWidth() / tamanoTablero;
        int altoCelda = getHeight() / tamanoTablero;

        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                g2d.drawRect(i * anchoCelda, j * altoCelda, anchoCelda, altoCelda);
            }
        }
    }
}
