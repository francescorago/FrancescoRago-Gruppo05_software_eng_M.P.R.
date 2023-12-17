/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator_project;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 *
 * @author manci
 */
public class ComplexNumber {
    private double real;
    private double imag;

     public ComplexNumber() {
        this.real = 0.0;
        this.imag = 0.0;
    }
    public ComplexNumber(double real, double imag) { //costruttore
        this.real = real;
        this.imag = imag;
    }

    public double getReal() { 
        return real;
    }

    public double getImag() {//getter
        return imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {//setter
        this.imag = imag;
    }          
public ComplexNumber(String complexNumber) {
    // Divide la parte reale e la parte immaginaria
    String[] parts = complexNumber.split("(?=[+-])");

    // Assegna i valori
    this.real = Double.parseDouble(parts[0]);

    // Gestisci la parte immaginaria
    if (parts.length > 1) {
        this.imag = Double.parseDouble(parts[1].replace("j", ""));
        
    } else {
        this.imag = 0.0;
    }
}

@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ComplexNumber that = (ComplexNumber) obj;

        return Double.compare(that.real, real) == 0 &&
               Double.compare(that.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    
    // Metodo per ottenere la rappresentazione testuale del numero complesso
    @Override
    public String toString() {
        if (imag == 0) {
            return String.valueOf(real);
        } else if (real == 0) {
            return imag + "j";
        } else {
            return real + (imag >= 0 ? "+" : "") + imag + "j";
        }
    }

    
    
    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImag = this.imag + other.imag;
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = (this.real * other.real) - (this.imag * other.imag);
        double newImag = (this.real * other.imag) + (this.imag * other.real);
        return new ComplexNumber(newReal, newImag);
    }
     public ComplexNumber divide(ComplexNumber other) {
        // Controlla che il divisore non sia zero
        if (other.real == 0 && other.imag == 0) {
            throw new ArithmeticException("Divisione per zero non consentita.");
        }

        // Esegue la divisione dei numeri complessi
        double denominator = (other.real * other.real) + (other.imag * other.imag);
        double newReal = (this.real * other.real + this.imag * other.imag) / denominator;
        double newImag = (this.imag * other.real - this.real * other.imag) / denominator;

        return new ComplexNumber(newReal, newImag);
    }
public ComplexNumber inv(){
    double newReal = this.real * (-1);
    double newImag = this.imag * (-1);
    return new ComplexNumber(newReal, newImag);
}
    public ComplexNumber subtract(ComplexNumber other) {
        double newReal = this.real - other.real;
        double newImag = this.imag - other.imag;
        return new ComplexNumber(newReal, newImag);
    }
    public ComplexNumber squareRoot() {
        // Calcola la radice quadrata di un numero complesso

        // Calcola il modulo del numero complesso
        double modulus = sqrt(this.real * this.real + this.imag * this.imag);

        // Calcola l'angolo (fase) del numero complesso
        double angle = Math.atan2(this.imag, this.real);

        // Calcola la radice quadrata del modulo
        double sqrtModulus = sqrt(modulus);

        // Calcola la parte reale e immaginaria della radice quadrata
        double sqrtReal = sqrtModulus * cos(angle / 2);
        double sqrtImag = sqrtModulus * sin(angle / 2);

        return new ComplexNumber(sqrtReal, sqrtImag);
    }
    
}
 
 
