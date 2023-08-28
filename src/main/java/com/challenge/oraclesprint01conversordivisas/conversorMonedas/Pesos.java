/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.oraclesprint01conversordivisas.conversorMonedas;

/**
 *
 * @author cesar
 */
public class Pesos{
    
    private double amount;
    
    public Pesos(double amount) throws CurrencyConverterException{
        if(amount <= 0)
            throw new CurrencyConverterException("Cantidad debe ser mayor a 0");
        this.amount = amount;
    }
    
//    public double pesosADolar(double cantidad) throws CurrencyConverterException{
//        if(cantidad <= 0)
//            throw new CurrencyConverterException("Cantidad debe ser mayor a 0");
//        return cantidad * 0.060;
//    }
    
    public double pesosADolar() {
        return amount * 0.060;
    }
    
    public double pesosAEuro(){
        return amount * 0.055;
    }
    
    public double pesosALibras(){
        return amount * 0.047;
    }
    
    public double pesosAYen(){
        return amount * 8.76;
    }
    
    public double pesosAWonCoreano(){
        return amount * 78.97;
    }
    
}
