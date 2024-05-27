package uniandes.dpoo.taller7.interfaz4;

import uniandes.dpoo.taller7.modelo.Top10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
public class VentanaPrincipal extends JFrame {
    private PanelSuperior panelSuperior;
    private PanelInferior panelInferior;
    private PanelDerecho panelDerecho;
    private PanelTablero panelTablero;
    private Top10 top10;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        top10 = new Top10();
        cargarTop10();

        panelSuperior = new PanelSuperior();
        panelInferior = new PanelInferior();
        panelDerecho = new PanelDerecho();
        panelTablero = new PanelTablero(top10);

        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelDerecho, BorderLayout.EAST);
        add(panelTablero, BorderLayout.CENTER);

        panelDerecho.addNuevoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tamano = panelSuperior.getTamanoTablero();
                String dificultad = panelSuperior.getDificultad(); // Obtener la dificultad seleccionada
                panelTablero.iniciarNuevoJuego(tamano, dificultad); // Pasar la dificultad al método iniciarNuevoJuego
                panelInferior.setJugadas(0);
            }
        });

        panelDerecho.addReiniciarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTablero.reiniciarTablero();
                panelInferior.setJugadas(0);
            }
        });

        panelDerecho.addTop10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTop10();
            }
        });

        panelDerecho.addCambiarJugadorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarJugador();
            }
        });

        panelTablero.addJugadaListener(new PanelTablero.JugadaListener() {
            @Override
            public void jugadaRealizada() {
                panelInferior.setJugadas(panelTablero.getJugadas());
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                guardarTop10();
            }
        });
    }

    private void mostrarTop10() {
        JDialog dialogoTop10 = new JDialog(this, "Top 10", true);
        dialogoTop10.setSize(300, 400);
        JTextArea areaTop10 = new JTextArea();
        areaTop10.setEditable(false);
        for (uniandes.dpoo.taller7.modelo.RegistroTop10 registro : top10.darRegistros()) {
            areaTop10.append(registro.toString() + "\n");
        }
        dialogoTop10.add(new JScrollPane(areaTop10));
        dialogoTop10.setVisible(true);
    }

    private void cambiarJugador() {
        String nuevoJugador = JOptionPane.showInputDialog(this, "Ingrese su nombre:");
        if (nuevoJugador != null && !nuevoJugador.trim().isEmpty()) {
            panelInferior.setJugador(nuevoJugador);
            panelTablero.setJugador(nuevoJugador);
        }
    }

    private void guardarTop10() {
        try {
            top10.salvarRecords(new File("top10.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarTop10() {
        try {
            top10.cargarRecords(new File("top10.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void actualizarTop10(String nombre, int puntaje) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
            }
        });
    }

        ;
}
