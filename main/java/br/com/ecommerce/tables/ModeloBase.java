/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.tables;

import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public abstract class ModeloBase extends AbstractTableModel {
    
    Map<Produto, Integer> map = new LinkedHashMap<>();
    
    @Override
    public int getRowCount() {
        return map.size();
    }
    
    public void setMap(Map<Produto, Integer> map) {
        this.map = map;
        this.fireTableDataChanged();
    }
    
    public void clearMap(){
        this.map.clear();
        this.fireTableDataChanged();
    }
    
    public Integer quantidadeProduto(Produto p) {
        return map.get(p);
    }
    
    public Integer quantidadeProduto(int index) {
        return map.get(getProdutoIndex(index));
    }
    
    public Produto getProdutoIndex(int rowIndex){
        int count = 0;
        Produto aux = null;
        for(Map.Entry<Produto, Integer> entry : map.entrySet())
            if(count == rowIndex) {
                aux = entry.getKey();
                break;
            } else count++;
        return aux;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto aux = getProdutoIndex(rowIndex);
        switch(columnIndex){
            case 0: return aux.getNome();
            case 1: return aux.getDescricao();
            case 2: return aux.getPreco();
            case 3: return map.get(aux);
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto aux = getProdutoIndex(rowIndex);
        switch(columnIndex){
            case 0: aux.setNome((String) aValue); break;
            case 1: aux.setDescricao((String) aValue); break;
            case 2: aux.setPreco((Double) aValue); break;
            case 3: map.put(aux, (Integer) aValue); break;
        }
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public void addProduto(Produto p) {
        for(Produto aux: map.keySet())
            if(aux.equals(p)){
                Integer qntOld = map.get(aux);
                map.replace(aux, qntOld, qntOld+1);
                this.fireTableDataChanged();
                return;
            }
        if(p.getSituacao() == EstadoProduto.FORA_ESTOQUE){
            map.put(p, 0);
            return;
        }
        map.put(p, 1);
        this.fireTableDataChanged();
    }

}
