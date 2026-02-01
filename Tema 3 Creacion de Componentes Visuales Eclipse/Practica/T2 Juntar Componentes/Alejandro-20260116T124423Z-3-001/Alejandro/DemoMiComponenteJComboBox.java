package Combinar;

import javax.swing.*;

import componentePersonalizado.MiComponenteJComboBox;

import java.awt.*;

public class DemoMiComponenteJComboBox {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Prueba MiComponenteJComboBox");
        ventana.setSize(450, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);

        // Opciones del combo
        String[] paises = {
                "España", "Francia", "Alemania",
                "Italia", "Portugal", "Brasil"
        };

        // Crear el componente personalizado
        MiComponenteJComboBox combo = new MiComponenteJComboBox(paises);
        combo.setBounds(50, 40, 320, 30);

        // Probar propiedades
        combo.setTextoPorDefecto("Elije uno");
        combo.setSeleccionObligatoria(true);
        combo.setColorError(new Color(255, 180, 180));

        // Label para mostrar resultado
        JLabel lblResultado = new JLabel("Esperando selección...");
        lblResultado.setBounds(50, 90, 320, 25);

        // Botón para comprobar estado
        JButton btnComprobar = new JButton("Comprobar selección");
        btnComprobar.setBounds(50, 130, 320, 30);

        btnComprobar.addActionListener(e -> {
            if (combo.esSeleccionValida()) {
                lblResultado.setText("Selección válida: " + combo.getSelectedItem());
            } else {
                lblResultado.setText("❌ Selección NO válida");
            }
        });

        // Añadir componentes
        ventana.getContentPane().add(combo);
        ventana.getContentPane().add(lblResultado);
        ventana.getContentPane().add(btnComprobar);

        ventana.setVisible(true);
    }
}

