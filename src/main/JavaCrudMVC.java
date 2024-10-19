package main;

import Modelo.Conexion;
import Vista.Vista;

public class JavaCrudMVC {

    public static void main(String[] args) {
        Conexion db = new Conexion();

        db.getConnection();    
        Vista vista = new Vista();
        vista.setVisible(true);
    }
}