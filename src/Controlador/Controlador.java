package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    
    PersonaDAO dao = new PersonaDAO();
    Persona p = new Persona();
    Vista vista; 
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador(Vista v){
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        listar(vista.tabla);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.btnListar){
            limpiarTabla();
            listar(vista.tabla);
        }
        if(e.getSource() == vista.btnGuardar){
            agregar();
            limpiarTabla();
            listar(vista.tabla);
        }
        
        if(e.getSource() == vista.btnEditar){
            int fila = vista.tabla.getSelectedRow();
            if (fila == -1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            }
            else{
                int id = Integer.parseInt((String)vista.tabla.getValueAt(fila,0).toString());
                String nom = (String)vista.tabla.getValueAt(fila,1);
                String correo = (String)vista.tabla.getValueAt(fila,2);
                String tel = (String)vista.tabla.getValueAt(fila,3);
                vista.txtId.setText("" + id);
                vista.txtNombres.setText(nom);
                vista.txtCorreo.setText(correo);
                vista.txtTelefono.setText(tel);
        }
    }
    if (e.getSource() == vista.btnActualizar){
        actualizar();
        limpiarTabla();
        listar(vista.tabla);
    }
    if (e.getSource() == vista.btnEliminar){
        delete();
        limpiarTabla();
        listar(vista.tabla);
    }
    }
    
    public void delete(){
        int fila = vista.tabla.getSelectedRow();
            if (fila == -1){
                JOptionPane.showMessageDialog(vista,"Debe seleccionar un usuario");
        }else{
                int id = Integer.parseInt((String)vista.tabla.getValueAt(fila,0).toString());
                dao.delete(id);
                JOptionPane.showMessageDialog(vista,"Usuario eliminado");
            }
    }
    
    public void actualizar(){
        int id = Integer.parseInt(vista.txtId.getText());
        String nom = vista.txtNombres.getText();
        String correo = vista.txtCorreo.getText();
        String tel = vista.txtTelefono.getText();
        p.setId(id);
        p.setNom(nom);
        p.setCorreo(correo);
        p.setTel(tel);
        int r = dao.Actualizar(p);
        if (r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario actualizado con éxito");
        }else {
            JOptionPane.showMessageDialog(vista,"Error");
        }
    }
    
    public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        List<Persona>lista = dao.listar();
        Object[]object = new Object[4];
        for (int i = 0; i < lista.size(); i++){
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNom();
            object[2] = lista.get(i).getCorreo();
            object[3] = lista.get(i).getTel();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }
    
    public void agregar(){
        String nom = vista.txtNombres.getText();
        String correo = vista.txtCorreo.getText();
        String tel = vista.txtTelefono.getText();
        p.setNom(nom);
        p.setCorreo(correo);
        p.setTel(tel);
        int r = dao.agregar(p);
        if (r == 1){
            JOptionPane.showMessageDialog(vista,"Usuario agregado con exito");
        }else{
            JOptionPane.showMessageDialog(vista,"Error");
        }
    }
    
    void limpiarTabla(){
        for (int i = 0; i<vista.tabla.getRowCount();i++){
            modelo.removeRow(i);
            i = i - i;
        }
    }
}
