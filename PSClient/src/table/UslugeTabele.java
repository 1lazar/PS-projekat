/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Usluga;
import domain.VrsteUsluga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laza Laki Lakosta
 */
public class UslugeTabele  extends AbstractTableModel{
    private final List<Usluga> usluge;

    public UslugeTabele(List<Usluga> usluge) {
        this.usluge = usluge;
    }
    
    @Override
    public int getRowCount() {
        if(usluge==null){
            return 0;
        }
        return usluge.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usluga usluga = usluge.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usluga.getUslugaId();
            case 1:
                return usluga.getNaocare().getMarka();
            case 2:
                return usluga.getStakla().getNaziv();
            case 3:
                return usluga.getVrsteUsluge().getVrsta();
            default:
                return "n/a";
            
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns = {"Id","Naocare","Stakla","Vrsta Usluge"};
        return columns[column];
    }
    public Usluga getUsluga(int row){
        return usluge.get(row);
    }
    
    public List<Usluga> getUsluga(){
        return usluge;
    }
    
    public void dodajUslugu(Usluga usluga) {
        System.out.println(usluga);
        usluge.add(usluga);
        fireTableDataChanged();
    }
    
    public void obrisiUslugu(int row){
        usluge.remove(row);
        fireTableDataChanged();
    }
    public void refresh() {
        fireTableDataChanged();
    }

}
