/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Naocare;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.w3c.dom.views.AbstractView;

/**
 *
 * @author Laza Laki Lakosta
 */
public class NaocareTabele extends AbstractTableModel{
    private final List<Naocare> naocare;

    public NaocareTabele(List<Naocare> naocare) {
        this.naocare = naocare;
    }

    @Override
    public int getRowCount() {
        if(naocare==null){
            return 0;
        }
        return naocare.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Naocare naocara = naocare.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return naocara.getId();
            case 1:
                return naocara.getMarka();
            case 2:
                return naocara.getModel();
            case 3:
                return naocara.getKolicina();
            case 4:
                return naocara.getCena();
            default:
                return "n/a";
            
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns = {"Id", "Marka", "Model", "Kolicina","Cena"};
        return columns[column];
    }

    public Naocare getNaocare(int row) {
        return naocare.get(row);
    }
    
    
}
