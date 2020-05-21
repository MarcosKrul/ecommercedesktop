/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.tables;

import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.enumeracoes.EstadoProduto;

/**
 *
 * @author marco
 */
public class ModeloMainUsuario extends ModeloBase {

    String[] colunas = {"Nome", "Descrição", "Preço", "Quantidade disponível"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        Produto aux = getProdutoIndex(rowIndex);
//        if(map.get(aux) == 0) {
//            map.remove(aux);
//            this.fireTableDataChanged();
//            return null;
//        }
//        return super.getValueAt(rowIndex, columnIndex);
//    }
    
    public void addProduto(Produto p, boolean todos){
        if(!todos && p.getSituacao() == EstadoProduto.ESTOQUE){
            super.addProduto(p);
            return;
        }
        super.addProduto(p);
    }

}
