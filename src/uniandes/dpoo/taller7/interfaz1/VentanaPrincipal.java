package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import com.formdev.flatlaf.FlatLightLaf;

public class VentanaPrincipal extends JFrame {
    

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(800, 600);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        
        new VentanaPrincipal();
    }
}
