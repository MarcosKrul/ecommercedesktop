/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.tables;

import br.com.ecommerce.classes.Endereco;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class ModeloEndereco extends AbstractTableModel {

    String[] colunas = {"Rua", "Cidade", "CEP", "Número", "Complemento"};
    List<Endereco> dados = new ArrayList<>();

    public void setDados(List<Endereco> dados) {
        this.dados.clear();
        this.dados = dados;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return dados.get(rowIndex).getRua();
            case 1: return dados.get(rowIndex).getCidade();
            case 2: return dados.get(rowIndex).getCep();
            case 3: return dados.get(rowIndex).getNumero();
            case 4: return dados.get(rowIndex).getComplemento();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: dados.get(rowIndex).setRua((String) aValue); break;
            case 1: dados.get(rowIndex).setCidade((String) aValue); break;
            case 2: dados.get(rowIndex).setCep((String) aValue); break;
            case 3: dados.get(rowIndex).setNumero((String) aValue); break;
            case 4: dados.get(rowIndex).setComplemento((String) aValue); break;
        }
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public void addEnderecoTabela(Endereco e) {
        dados.add(e);
        this.fireTableDataChanged();
    }
    
    public Endereco getEnderecoIndex(int index) {
        return dados.get(index);
    }
    
}
