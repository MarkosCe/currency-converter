/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.oraclesprint01conversordivisas.conversorTemperatura;

/**
 *
 * @author cesar
 */
public class Temperatura {
    
    public double celsiusToFahrenheit(double grados){
        return (grados * 9/5) + 32;
    }
    
    public double celsiusToKelvin(double grados){
        return grados + 273.15;
    }
    
    public double fahrenheitToCelsius(double grados){
        return (grados - 32) * 5/9;
    }
    
    public double farenheitToKelvin(double grados){
        return (grados - 32) * 5/9 + 273.15;
    }
    
    public double kelvinToCelsius(double grados){
        return grados - 273.15;
    }
    
    public double kelvinToFahrenheit(double grados){
        return (grados - 273.15) * 9/5 + 32;
    }
    
}
