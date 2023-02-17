/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Pacijent;
import domain.Stakla;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laza Laki Lakosta
 */
public class StaklaTabele  extends AbstractTableModel{
    private final List<Stakla> stakla;

    public StaklaTabele(List<Stakla> stakla) {
        this.stakla = stakla;
    }

    

    @Override
    public int getRowCount() {
        if(stakla==null){
            return 0;
        }
        return stakla.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stakla staklo = stakla.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return staklo.getId();
            case 1:
                return staklo.getNaziv();
            case 2:
                return staklo.getVrsta();
            case 3:
                return staklo.getDioptrija();
            case 4:
                return staklo.getKolicina();
            case 5:
                return staklo.getCena();
            default:
                return "n/a";
            
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns = {"Id", "Naziv", "Vrsta","Dioptrija","Kolicina","Cena"};
        return columns[column];
    }
    public Stakla getStakla(int row){
        return stakla.get(row);
    }
}
