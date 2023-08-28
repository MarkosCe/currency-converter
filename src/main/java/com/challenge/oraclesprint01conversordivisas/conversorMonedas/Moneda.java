/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.oraclesprint01conversordivisas.conversorMonedas;

/**
 *
 * @author cesar
 */
public class Moneda {
    
    public double dolarAPesos(double cantidad) throws CurrencyConverterException{
        if (cantidad <= 0) {
            throw new CurrencyConverterException("La cantidad debe ser mayor a cero");
        }
        return cantidad * 16.73;
    }
    
    public double euroAPesos(double cantidad) throws CurrencyConverterException{
        if (cantidad <= 0) {
            throw new CurrencyConverterException("La cantidad debe ser mayor a cero");
        }
        return cantidad * 18.07;
    }
    
    public double librasAPesos(double cantidad) throws CurrencyConverterException{
        if (cantidad <= 0) {
            throw new CurrencyConverterException("La cantidad debe ser mayor a cero");
        }
        return cantidad * 21.07;
    }
    
    public double yenAPesos(double cantidad) throws CurrencyConverterException{
        if (cantidad <= 0) {
            throw new CurrencyConverterException("La cantidad debe ser mayor a cero");
        }
        return cantidad * 0.11;
    }
    
    public double wonCoreanoAPesos(double cantidad) throws CurrencyConverterException{
        if (cantidad <= 0) {
            throw new CurrencyConverterException("La cantidad debe ser mayor a cero");
        }
        return cantidad * 0.013;
    }
}
