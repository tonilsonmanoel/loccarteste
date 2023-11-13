/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Tonilson
 */
public class Decimal {
    public String getDecimalFormat(Double numeroDec){
        
        
        try {
         DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt","Brazil"));
         dfs.setDecimalSeparator(',');
         dfs.setGroupingSeparator('.');                 
         DecimalFormat df = new DecimalFormat("###,##0.00",dfs);
         String numeroDecimalFormat = df.format(numeroDec);
         return numeroDecimalFormat;
        } catch (Exception e) {
           return null;
        }
    
    }
}
