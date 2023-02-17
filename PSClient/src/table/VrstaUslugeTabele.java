/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Stakla;
import domain.VrsteUsluga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laza Laki Lakosta
 */
public class VrstaUslugeTabele  extends AbstractTableModel{
    private final List<VrsteUsluga> vrste;

    public VrstaUslugeTabele(List<VrsteUsluga> vrste) {
        this.vrste = vrste;
    }
    
    @Override
    public int getRowCount() {
        if(vrste==null){
            return 0;
        }
        return vrste.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VrsteUsluga vrsta = vrste.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vrsta.getId();
            case 1:
                return vrsta.getVrsta();
            case 2:
                return vrsta.getCena();
            default:
                return "n/a";
            
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns = {"Id","Vrsta","Cena"};
        return columns[column];
    }
    public VrsteUsluga getVrsteUsluga(int row){
        return vrste.get(row);
    }
}
