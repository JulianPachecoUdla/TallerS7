import javax.swing.*;
import java.util.LinkedList;

public class Santuario {
    //gestorDeCaballeros
    private LinkedList<Caballero> listaCaballeros;

    public Santuario(LinkedList<Caballero> listaCaballeros) {
        this.listaCaballeros = listaCaballeros;
    }

    public void registrarCaballero(Caballero caballero){
        listaCaballeros.add(caballero);

    }

    public void listarCaballeros(JTextArea txtCont) {
        StringBuilder sb = new StringBuilder();

        for (Caballero c : listaCaballeros) {
            sb.append("ID: ").append(c.getID()).append("\n");
            sb.append("Nombre: ").append(c.getNombre()).append("\n");
            sb.append("Rango: ").append(c.getRango()).append("\n");
            sb.append("Constelación: ").append(c.getConstelacion()).append("\n");
            sb.append("Nivel de Poder: ").append(c.getNivPoder()).append("\n");
            sb.append("----------------------------\n");
        }

        txtCont.setText(sb.toString());
    }

    public void modificarCaballero(int id, Caballero nuevosDatos, JTextArea txtCont) {
        for (Caballero c : listaCaballeros) {
            if (c.getID() == id) {
                c.setNombre(nuevosDatos.getNombre());
                c.setRango(nuevosDatos.getRango());
                c.setConstelacion(nuevosDatos.getConstelacion());
                c.setNivPoder(nuevosDatos.getNivPoder());
                c.setMision(nuevosDatos.getMision());
                JOptionPane.showMessageDialog(null,"Caballero modificado con éxito.");
                return;
            }
            listarCaballeros(txtCont);
        }
        JOptionPane.showMessageDialog(null, "Caballero no encontrado.");
    }

    public void mostrarInforme(JTextArea txtCont) {
        StringBuilder sb = new StringBuilder();
        sb.append("INFORME DE CABALLEROS \n");
        for (Caballero c : listaCaballeros) {
            float recompensa = c.getMision().getRecompensa();
            float aporte = c.calcularAporte();
            float impuesto = c.calcularImpuesto();

            float neto = recompensa - aporte - impuesto;

            // Mostrar informe
            sb.append("----------------------------\n");
            sb.append("Nombre: ").append(c.getNombre()).append("\n");
            sb.append("Rango: ").append(c.getRango()).append("\n");
            sb.append("Constelación: ").append(c.getConstelacion()).append("\n");
            sb.append("Nivel de Poder: ").append(c.getNivPoder()).append("\n");
            sb.append("Misión: ").append(c.getMision().getDescripcion()).append("\n");
            sb.append("Recompensa: ").append(recompensa).append("\n");
            sb.append("Aporte al Santuario: ").append(aporte).append("\n");
            sb.append("Impuesto al Reino: ").append(impuesto).append("\n");
            sb.append("Recompensa neta: ").append(neto).append("\n");
        }
        txtCont.setText(sb.toString());
    }

}
