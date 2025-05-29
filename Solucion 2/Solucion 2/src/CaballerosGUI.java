import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CaballerosGUI {
    private JPanel pGeneral;
    private JButton ingresarCaballeroButton;
    private JTextArea textArea1;
    private JButton modificarCaballeroButton;
    private JButton mostrarCaballeroButton;
    private JButton mostrarInformeButton;

    private ArrayList<Object[]> caballeros = new ArrayList<>();
    public CaballerosGUI(){


        ingresarCaballeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarCaballero();
            }
        });


        modificarCaballeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Ingrese el ID del caballero a modificar:");

                if (id != null && !id.isEmpty()) {
                    modificarCaballero(id);
                } else {
                    JOptionPane.showMessageDialog(null, "ID no válido.");
                }
            }
        });


        mostrarCaballeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCaballeros();
            }
        });


        mostrarInformeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformeCaballeros();
            }
        });
    }

    public void ingresarCaballero() {
        JDialog dialogo = new JDialog();
        dialogo.setTitle("Registrar Caballero");
        dialogo.setSize(400, 400);
        dialogo.setModal(true);
        dialogo.setLayout(new GridLayout(9, 2, 5, 5));

        JTextField txtID = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtRango = new JTextField();
        JTextField txtConstelacion = new JTextField();
        JTextField txtPoder = new JTextField();
        JTextField txtMision = new JTextField();
        JTextField txtDificultad = new JTextField();
        JTextField txtRecompensa = new JTextField();

        dialogo.add(new JLabel("ID:"));
        dialogo.add(txtID);
        dialogo.add(new JLabel("Nombre:"));
        dialogo.add(txtNombre);
        dialogo.add(new JLabel("Rango (Bronce-Plata-Oro):"));
        dialogo.add(txtRango);
        dialogo.add(new JLabel("Constelación:"));
        dialogo.add(txtConstelacion);
        dialogo.add(new JLabel("Nivel de Poder:"));
        dialogo.add(txtPoder);
        dialogo.add(new JLabel("Misión:"));
        dialogo.add(txtMision);
        dialogo.add(new JLabel("Dificultad (1-5):"));
        dialogo.add(txtDificultad);
        dialogo.add(new JLabel("Recompensa:"));
        dialogo.add(txtRecompensa);

        JButton btnGuardar = new JButton("Guardar");
        dialogo.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                Object[] caballero = new Object[8];
                caballero[0] = txtID.getText();
                caballero[1] = txtNombre.getText();
                caballero[2] = txtRango.getText();
                caballero[3] = txtConstelacion.getText();
                caballero[4] = Integer.parseInt(txtPoder.getText());
                caballero[5] = txtMision.getText();
                caballero[6] = Integer.parseInt(txtDificultad.getText());
                caballero[7] = Double.parseDouble(txtRecompensa.getText());

                caballeros.add(caballero);

                JOptionPane.showMessageDialog(dialogo, "Caballero registrado correctamente.");
                dialogo.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialogo, "Error en los datos ingresados.");
            }
        });

        dialogo.setVisible(true);
    }

    public void mostrarInformeCaballeros() {
        textArea1.setText("");

        if (caballeros.isEmpty()) {
            textArea1.setText("No hay caballeros registrados.");
        } else {
            for (Object[] c : caballeros) {
                double recompensa = (double) c[7];
                double aporte = recompensa * 0.10;
                double impuesto = calcularImpuesto(recompensa);
                double neto = recompensa - aporte - impuesto;
                textArea1.append("---INFORME GENERAL---");
                textArea1.append("\nID: " + c[0] + "\n");
                textArea1.append("Nombre: " + c[1] + "\n");
                textArea1.append("Rango: " + c[2] + "\n");
                textArea1.append("Constelación: " + c[3] + "\n");
                textArea1.append("Nivel de Poder: " + c[4] + "\n");
                textArea1.append("Misión Asignada: " + c[5] + "\n");
                textArea1.append("Recompensa: " + recompensa + "\n");
                textArea1.append("Aporte al Santuario: " + aporte + "\n");
                textArea1.append("Impuesto del Reino: " + impuesto + "\n");
                textArea1.append("Recompensa Neta: " + neto + "\n");
                textArea1.append("--------------------------------------------------\n");
            }
        }
    }

    public void modificarCaballero(String idBuscar) {
        boolean encontrado = false;

        for (int i = 0; i < caballeros.size(); i++) {
            if (caballeros.get(i)[0].equals(idBuscar)) {
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", caballeros.get(i)[1]);
                String nuevoRango = JOptionPane.showInputDialog("Nuevo rango (Oro-Plata-Bronce) :", caballeros.get(i)[2]);
                String nuevaConstelacion = JOptionPane.showInputDialog("Nueva constelación:", caballeros.get(i)[3]);
                int nuevoPoder = Integer.parseInt(JOptionPane.showInputDialog("Nuevo nivel de poder:", caballeros.get(i)[4]));
                String nuevaMision = JOptionPane.showInputDialog("Nueva misión:", caballeros.get(i)[5]);
                int nuevaDificultad = Integer.parseInt(JOptionPane.showInputDialog("Nueva dificultad (1-5):", caballeros.get(i)[6]));
                double nuevaRecompensa = Double.parseDouble(JOptionPane.showInputDialog("Nueva recompensa:", caballeros.get(i)[7]));

                caballeros.get(i)[1] = nuevoNombre;
                caballeros.get(i)[2] = nuevoRango;
                caballeros.get(i)[3] = nuevaConstelacion;
                caballeros.get(i)[4] = nuevoPoder;
                caballeros.get(i)[5] = nuevaMision;
                caballeros.get(i)[6] = nuevaDificultad;
                caballeros.get(i)[7] = nuevaRecompensa;

                JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Caballero no encontrado.");
        }
    }

    public void mostrarCaballeros() {
        textArea1.setText(""); // Limpiar el área

        if (caballeros.isEmpty()) {
            textArea1.setText("No hay caballeros registrados.");
        } else {
            for (Object[] c : caballeros) {
                double recompensa = (double) c[7];
                double aporte = recompensa * 0.10;
                double impuesto = calcularImpuesto(recompensa);
                double neto = recompensa - aporte - impuesto;
                textArea1.append("ID: " + c[0] + "\n");
                textArea1.append("Nombre: " + c[1] + "\n");
                textArea1.append("Rango: " + c[2] + "\n");
                textArea1.append("Constelación: " + c[3] + "\n");
                textArea1.append("Nivel de Poder: " + c[4] + "\n");
                textArea1.append("Misión Asignada: " + c[5] + "\n");
                textArea1.append("Recompensa: " + recompensa + "\n");
                textArea1.append("--------------------------------------------------\n");
            }
        }
    }


    public double calcularImpuesto(double recompensa) {
        if (recompensa <= 100000) {
            return 0;
        } else if (recompensa <= 200000) {
            return (recompensa - 100000) * 0.12;
        } else if (recompensa <= 400000) {
            return (100000 * 0.12) + (recompensa - 200000) * 0.25;
        } else {
            return (100000 * 0.12) + (200000 * 0.25) + (recompensa - 400000) * 0.35;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CaballerosGUI");
        frame.setContentPane(new CaballerosGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
