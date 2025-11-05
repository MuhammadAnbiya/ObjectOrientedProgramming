package com.pbo.abstracts;

public class Lingkaran extends BangunDatar {
    private double r; 

    public Lingkaran(double r) {
        this.r = r;
    }

    @Override
    public double getLuas() {
        return Math.PI * r * r;
    }
}