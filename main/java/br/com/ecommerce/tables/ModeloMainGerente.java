/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.tables;

import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class ModeloMainGerente extends AbstractTableModel {

    String[] colunas = {"Nome", "Descrição", "Preço", "Situação"};
    List<Produto> dados = new ArrayList<>();

    public void setDados(List<Produto> dados) {
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
        switch(columnIndex){
            case 0: return dados.get(rowIndex).getNome();
            case 1: return dados.get(rowIndex).getDescricao();
            case 2: return dados.get(rowIndex).getPreco();
            case 3: return dados.get(rowIndex).getSituacao().getDescricao();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: dados.get(rowIndex).setNome((String) aValue); break;
            case 1: dados.get(rowIndex).setDescricao((String) aValue); break;
            case 2: dados.get(rowIndex).setPreco((Double) aValue); break;
            case 3: 
                int type = (int) aValue;
                switch(type){
                    case 1: dados.get(rowIndex).setSituacao(EstadoProduto.ESTOQUE); break;
                    case 2: dados.get(rowIndex).setSituacao(EstadoProduto.INDISPONIVEL); break;
                    case 3: dados.get(rowIndex).setSituacao(EstadoProduto.VENDIDO); break;
                    case 4: dados.get(rowIndex).setSituacao(EstadoProduto.FORA_ESTOQUE); break;
                }
                break;
        }
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public void addProduto(Produto p){
        dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void removerProduto(Produto p){
        dados.remove(p);
        this.fireTableDataChanged();
    }
    
    public void clear() {
        dados.clear();
    }
    
    public Produto getProdutoIndex(int index){
        return dados.get(index);
    }
    
    public void setProduto(int index, Produto p){
        dados.set(index, p);
        fireTableDataChanged();
    }

    public int quantidadeProduto(int index){
        int soma = 0;
        Produto p = dados.get(index);
        for(Produto aux : dados)
            if(p.equals(aux)) soma++;
        return soma;
    }
}
