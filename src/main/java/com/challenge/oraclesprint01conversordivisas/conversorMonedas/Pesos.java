/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.oraclesprint01conversordivisas.conversorMonedas;

/**
 *
 * @author cesar
 */
public class Pesos {
    
    public double pesosADolar(double cantidad){
        return cantidad * 0.060;
    }
    
    public double pesosAEuro(double cantidad){
        return cantidad * 0.055;
    }
    
    public double pesosALibras(double cantidad){
        return cantidad * 0.047;
    }
    
    public double pesosAYen(double cantidad){
        return cantidad * 8.76;
    }
    
    public double pesosAWonCoreano(double cantidad){
        return cantidad * 78.97;
    }
    
}
