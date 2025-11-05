package com.pbo.interfaces;

public interface Laptop {
    int MAX_VOL = 100;
    int MIN_VOL = 0;

    void nyalakan();
    void matikan();
    void perbesarVolume();
    void kecilkanVolume();
}