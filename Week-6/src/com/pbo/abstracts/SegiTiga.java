package com.pbo.abstracts;

public class SegiTiga extends BangunDatar {
    private double alas;
    private double tinggi;

    public SegiTiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double getLuas() {
        return (alas * tinggi) / 2;
    }
}