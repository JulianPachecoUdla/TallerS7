import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class frmCaballeros {
    private JPanel pGeneral;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtConstelacion;
    private JTextField txtPoder;
    private JTextField txtMision;
    private JTextField txtRecompensa;
    private JComboBox cmbRango;
    private JComboBox cmbDificultad;
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnInforme;
    private JTextArea txtCont;
    private JButton mostrarCaballerosButton;

    private Santuario gestionCaballeros;

    public frmCaballeros() {
        // Crear lista vacía de caballeros
        LinkedList<Caballero> lista = new LinkedList<>();

        // Pasar lista al constructor de Santuario
        gestionCaballeros = new Santuario(lista);


        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //obtener datos
                    int id = Integer.parseInt(txtID.getText());
                    String nombre = txtNombre.getText();
                    String constelacion = txtConstelacion.getText();
                    int poder = Integer.parseInt(txtPoder.getText());
                    String rango = cmbRango.getSelectedItem().toString();

                    String descripcionMision = txtMision.getText();
                    int dificultad = Integer.parseInt(cmbDificultad.getSelectedItem().toString());
                    float recompensa = Float.parseFloat(txtRecompensa.getText());

                    //crear mision
                    Mision mision = new Mision(descripcionMision, dificultad, recompensa);

                    //CrearCaballero
                    Caballero caballero = new Caballero(id, nombre, rango, constelacion, poder, mision);

                    //Registrar caballero en el Santuario
                    gestionCaballeros.registrarCaballero(caballero);
                    gestionCaballeros.listarCaballeros(txtCont);

                    txtID.setText("");
                    txtNombre.setText("");
                    txtConstelacion.setText("");
                    txtPoder.setText("");
                    txtMision.setText("");
                    txtRecompensa.setText("");

                    gestionCaballeros.listarCaballeros(txtCont);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnModificar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(txtID.getText().trim());
                            String nombre = txtNombre.getText().trim();
                            String rango = cmbRango.getSelectedItem().toString();
                            String constelacion = txtConstelacion.getText().trim();
                            int nivPoder = Integer.parseInt(txtPoder.getText().trim());
                            String descripcion = txtMision.getText().trim();
                            int dificultad = Integer.parseInt(cmbDificultad.getSelectedItem().toString());
                            float recompensa = Float.parseFloat(txtRecompensa.getText().trim());

                            Mision mision = new Mision(descripcion, dificultad, recompensa);
                            Caballero nuevosDatos = new Caballero(id, nombre, rango, constelacion, nivPoder, mision);

                            gestionCaballeros.modificarCaballero(id, nuevosDatos, txtCont);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al modificar caballero: " + ex.getMessage());
                        }
                    }
                });


            }
        });


        btnInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionCaballeros.mostrarInforme(txtCont);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        mostrarCaballerosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionCaballeros.listarCaballeros(txtCont);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("frmCaballeros");
        frame.setContentPane(new frmCaballeros().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
