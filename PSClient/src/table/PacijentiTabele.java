/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Pacijent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laza Laki Lakosta
 */
public class PacijentiTabele extends AbstractTableModel{
    private List<Pacijent> pacijenti;

    public PacijentiTabele(List<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    @Override
    public int getRowCount() {
        if(pacijenti==null){
            return 0;
        }
        return pacijenti.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacijent pacijent = pacijenti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pacijent.getPacijentId();
            case 1:
                return pacijent.getIme();
            case 2:
                return pacijent.getPrezime();
            case 3:
                return pacijent.getKontaktTelefon();
            case 4:
                return pacijent.getDioptrijaLevogOka();
            case 5:
                return pacijent.getDioptrijaDesnogOka();
            case 6:
                return pacijent.getPD();
            default:
                return "n/a";
            
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns = {"Id", "Ime", "Prezime", "Telefon","Dioptrija Levog Oka","Dioptrija Desnog Oka","PD"};
        return columns[column];
    }
    public Pacijent getPacijent(int row){
        return pacijenti.get(row);
    }
    public void setPacijente(List<Pacijent> pacijenti){
        this.pacijenti = pacijenti;
        fireTableDataChanged();
    }
}
