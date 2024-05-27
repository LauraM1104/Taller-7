package uniandes.dpoo.taller7.interfaz4;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PanelTablero extends JPanel {
    private Tablero tablero;
    private List<JugadaListener> listeners;
    private Top10 top10;
    private String jugador;
    private String dificultad;

    public PanelTablero(Top10 top10) {
        this.top10 = top10;
        this.tablero = new Tablero(5); // Por defecto, un tablero de tamaño 5x5
        this.listeners = new ArrayList<>();
        this.jugador = ""; // Jugador por defecto
        this.dificultad = "Fácil"; // Dificultad por defecto
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int anchoCelda = getWidth() / tablero.darTablero().length;
                int altoCelda = getHeight() / tablero.darTablero().length;
                int x = e.getX() / anchoCelda;
                int y = e.getY() / altoCelda;
                tablero.jugar(x, y);
                notifyJugadaListeners();
                repaint();

                // Verificar si todas las luces están apagadas
                boolean[][] luces = tablero.darTablero();
                boolean todasApagadas = true;
                for (int i = 0; i < luces.length; i++) {
                    for (int j = 0; j < luces.length; j++) {
                        if (luces[i][j]) {
                            todasApagadas = false;
                            break;
                        }
                    }
                    if (!todasApagadas) {
                        break;
                    }
                }

                if (todasApagadas) {
                    mostrarMensajeVictoria();
                    registrarPuntaje();
                }
            }
        });
    }

    public void iniciarNuevoJuego(int tamano, String dificultad) {
        this.tablero = new Tablero(tamano);
        this.dificultad = dificultad;
        mezclarTablero(tamano, dificultad);
        notifyJugadaListeners(); // Notificar que las jugadas se han reiniciado
        repaint();
    }

    private void mezclarTablero(int tamano, String dificultad) {
        int numMovimientosIniciales = 0;
        switch (dificultad) {
            case "Fácil":
                numMovimientosIniciales = 0; // Menos movimientos iniciales
                break;
            case "Medio":
                numMovimientosIniciales = tamano * 2;
                break;
            case "Difícil":
                numMovimientosIniciales = tamano * 3; // Más movimientos iniciales
                break;
        }

        Random rand = new Random();
        for (int i = 0; i < numMovimientosIniciales; i++) {
            int x = rand.nextInt(tamano);
            int y = rand.nextInt(tamano);
            tablero.jugar(x, y); // Realiza un movimiento inicial aleatorio
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        boolean[][] luces = tablero.darTablero();
        int anchoCelda = getWidth() / luces.length;
        int altoCelda = getHeight() / luces.length;

        for (int i = 0; i < luces.length; i++) {
            for (int j = 0; j < luces.length; j++) {
                g2d.setColor(Color.BLACK);
                g2d.drawRect(i * anchoCelda, j * altoCelda, anchoCelda, altoCelda);
                g2d.setColor(luces[i][j] ? Color.YELLOW : Color.GRAY);
                g2d.fillRect(i * anchoCelda + 1, j * altoCelda + 1, anchoCelda - 2, altoCelda - 2);
            }
        }
    }

    public void reiniciarTablero() {
        tablero.reiniciar();
        mezclarTablero(tablero.darTablero().length, dificultad);
        notifyJugadaListeners(); // Notificar que las jugadas se han reiniciado
        repaint();
    }

    public int getJugadas() {
        return tablero.darJugadas();
    }

    public void addJugadaListener(JugadaListener listener) {
        listeners.add(listener);
    }

    private void notifyJugadaListeners() {
        for (JugadaListener listener : listeners) {
            listener.jugadaRealizada();
        }
    }

    private void mostrarMensajeVictoria() {
        JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado el juego.", "Victoria", JOptionPane.INFORMATION_MESSAGE);
    }

    private void registrarPuntaje() {
        if (jugador != null && !jugador.trim().isEmpty()) {
            int puntaje = tablero.calcularPuntaje();
            if (top10.esTop10(puntaje)) {
                top10.agregarRegistro(jugador, puntaje);
                JOptionPane.showMessageDialog(this, "¡Felicidades! Has entrado al Top 10 con " + puntaje + " puntos.");
            } else {
                JOptionPane.showMessageDialog(this, "Juego completado con " + puntaje + " puntos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa tu nombre antes de jugar.");
        }
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public interface JugadaListener {
        void jugadaRealizada();
    }
}
