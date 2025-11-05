package com.pbo.interfaces;

public class LaptopUser {
    private Laptop laptop;

    public LaptopUser(Laptop laptop) {
        this.laptop = laptop;
    }

    public void hidupkanLaptop() {
        this.laptop.nyalakan();
    }

    public void matikanLaptop() {
        this.laptop.matikan();
    }

    public void tambahVolume() {
        this.laptop.perbesarVolume();
    }

    public void kurangiVolume() {
        this.laptop.kecilkanVolume();
    }
}