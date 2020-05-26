/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author marco
 */
public class FileRelatorio {
    
    private final File FILE;
    private List<String> conteudo;
    private final static String DATA;
    private final static String HORA;
    
    static {
        Calendar c = Calendar.getInstance();
        DATA = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
        HORA = new SimpleDateFormat("HH:mm:ss").format(c.getTime());
    }

    public FileRelatorio(String dirName) {
        FILE = new File(dirName);
        conteudo = new ArrayList<>();    
    }

    private void fread() throws IOException {
        try(BufferedReader bf = new BufferedReader(new FileReader(FILE))) {
            String linha;
            while((linha = bf.readLine()) != null) conteudo.add(linha);
        }
    }
    
    private void fwrite(String gravar, boolean append) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, append))) {
            bw.write(gravar);
            bw.newLine();
            bw.flush();
        }
    }
    
    private void completarDataHora() throws IOException {
        fread();
        conteudo.set(0, conteudo.get(0)+";data;hora");
        for(int i=1 ; i<conteudo.size() ; i++)
            conteudo.set(i, conteudo.get(i)+";"+DATA+";"+HORA);
    }
    
    public void completarRelatorioUsuario() throws IOException {
        completarDataHora();
        for(int i=0 ; i<conteudo.size() ; i++) 
            if(i==0) fwrite(conteudo.get(i), false);            
            else fwrite(conteudo.get(i), true);            
    }
    
}
