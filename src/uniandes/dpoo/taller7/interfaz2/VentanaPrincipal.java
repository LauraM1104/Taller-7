package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import com.formdev.flatlaf.FlatLightLaf;

public class VentanaPrincipal extends JFrame {

    private PanelSuperior panelSuperior;
    private PanelDerecho panelDerecho;
    private PanelInferior panelInferior;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(800, 600);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        panelSuperior = new PanelSuperior();
        panelDerecho = new PanelDerecho();
        panelInferior = new PanelInferior();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecho, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        new VentanaPrincipal();
    }
}
