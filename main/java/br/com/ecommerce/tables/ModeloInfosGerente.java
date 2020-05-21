/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.tables;

import br.com.ecommerce.classes.InfoGerente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class ModeloInfosGerente extends AbstractTableModel {

    private String[] colunas = {"Nome do produto","Valor total"};
    private List<InfoGerente> dados = new ArrayList<>();

    public void setDados(List<InfoGerente> dados) {
        this.dados = dados;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dados.get(rowIndex).getNome();
            case 1: return dados.get(rowIndex).getTotal();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: dados.get(rowIndex).setNome((String) aValue); break;
            case 1: dados.get(rowIndex).setTotal((Double) aValue); break;
        }
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }
}
