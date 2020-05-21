/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.tables;

import br.com.ecommerce.classes.Produto;

/**
 *
 * @author marco
 */
public class ModeloVisualizarCarrinho extends ModeloBase {
    
    String[] colunas = {"Nome", "Descrição", "Preço", "Quantidade"};

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto aux = getProdutoIndex(rowIndex);
        switch(columnIndex){
            case 3: map.put(aux, (Integer) aValue); break;
        }
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public void removeProduto(Produto p){
        map.remove(p);
        this.fireTableDataChanged();
    } 
    
    public void setQuantidade(Produto key, Integer qnt) {
        Integer qntOld = super.quantidadeProduto(key);
        map.replace(key, qntOld, qnt);
        this.fireTableDataChanged();
    }
    
}
