package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import com.formdev.flatlaf.FlatLightLaf;

public class VentanaPrincipal extends JFrame {
    private PanelSuperior panelSuperior;
    private PanelDerecho panelDerecho;
    private PanelInferior panelInferior;
    private PanelTablero panelTablero;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(800, 600);  // Tamaño por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar componentes y añadirlos al frame
        inicializarComponentes();

        // Hacer visible la ventana
        setVisible(true);
    }

    private void inicializarComponentes() {
        panelSuperior = new PanelSuperior();
        panelDerecho = new PanelDerecho();
        panelInferior = new PanelInferior();
        panelTablero = new PanelTablero();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecho, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelTablero, BorderLayout.CENTER);

        panelSuperior.addComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nuevoTamano = panelSuperior.getSelectedTamano();
                panelTablero.setTamanoTablero(nuevoTamano);
            }
        });
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        new VentanaPrincipal();
    }
}
