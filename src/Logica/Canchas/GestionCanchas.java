package Logica.Canchas;

import Logica.Usuarios.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GestionCanchas {
    private ArrayList<Cancha> canchasUP = new ArrayList<>();
    private ArrayList<Cancha> canchasG = new ArrayList<>();
    private ArrayList<Cancha> canchasA = new ArrayList<>();
    private HashMap<String, ArrayList<Cancha>> canchasMap = new HashMap<>();

    public GestionCanchas() {

        establecerCanchas();
        canchasMap.put("UdlaPark", canchasUP);
        canchasMap.put("UdlaGranados", canchasG);
        canchasMap.put("UdlaArena", canchasA);
    }

    public void establecerCanchas(){
        canchasUP.add(new Cancha("UdlaPark", 1, "Futbol", true, false, new Usuario()));
        canchasG.add(new Cancha("UdlaGranados",2, "Futbol", true, false, new Usuario()));
        canchasG.add(new Cancha("UdlaGranados", 3, "Basquetball", true, false, new Usuario()));
        canchasA.add(new Cancha("UdlaArena", 4, "Futbol", true, false, new Usuario()));
        canchasA.add(new Cancha("UdlaArena",5, "Futbol", true, false, new Usuario()));
        canchasA.add(new Cancha("UdlaArena",6, "Volleyball", true, false, new Usuario()));
        canchasA.add(new Cancha("UdlaArena",7, "Basquetball", true, false, new Usuario()));
    }

    public void mostrarCanchas(String campus, JTable table){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Campus", "Código", "Tipo de cancha", "Estado", "Reserva", "Estudiante"}, 0);
        model.addRow(new Object[]{"Campus", "Código", "Tipo de cancha", "Estado", "Reserva", "Estudiante"});
        if(canchasMap.containsKey(campus)){
            for(Cancha aux : canchasMap.get(campus)){
                model.addRow(new Object[]{aux.getCampus(), aux.getCodigo(), aux.getTipoCancha(), aux.isEstadoCancha(), aux.isBooked(), aux.getUsuario().getCorreoInstitucional()});
            }
        }else{
            for(ArrayList<Cancha> aux : canchasMap.values()){
                for (Cancha cancha : aux) {
                    model.addRow(new Object[]{cancha.getCampus(), cancha.getCodigo(), cancha.getTipoCancha(), cancha.isEstadoCancha(), cancha.isBooked(), cancha.getUsuario().getCorreoInstitucional()});
                }
            }
        }
        table.setModel(model);
    }
}
