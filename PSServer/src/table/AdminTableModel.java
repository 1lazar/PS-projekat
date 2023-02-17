/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Administrator;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author LENOVO
 */
public class AdminTableModel extends AbstractTableModel{

    String[] columnNames = new String[]{"username","firstname","lastname"};
    List<Administrator> users;

    public AdminTableModel(List<Administrator> users) {
        this.users = users;
    }

    @Override
    public String getColumnName(int column) {
    if(column>columnNames.length) return "n/a";
    return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
    
    @Override
    public int getRowCount() {
        if(users == null){
            return 0;
        }
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
   
        Administrator u = users.get(rowIndex);
        switch (columnIndex) {
            case 0: return u.getUsername();
            case 1: return u.getIme();
            case 2: return u.getPrezime();
            default:return "n/a";
        }
    }

    public void addUser(Administrator u){
        if(users.contains(u)) return;
        users.add(u);
        fireTableDataChanged();
    }
    
}
