package com.pbo.interfaces;

public class Lenovo implements Laptop {
    private int volume;
    private boolean is_on;

    public Lenovo() {
        this.volume = 50;
        this.is_on = false;
    }

    @Override
    public void nyalakan() {
        if (this.is_on) {
            System.out.println("Laptop sudah menyala (Lenovo)");
        } else {
            this.is_on = true;
            System.out.println("Laptop berhasil dinyalakan (Lenovo)");
        }
    }

    @Override
    public void matikan() {
        if (!this.is_on) {
            System.out.println("Laptop sudah mati (Lenovo)");
        } else {
            this.is_on = false;
            System.out.println("Laptop berhasil dimatikan (Lenovo)");
        }
    }

    @Override
    public void perbesarVolume() {
        if (this.is_on) {
            if (this.volume == MAX_VOL) {
                System.out.println("Volume SUDAH MAKSIMAL!");
            } else {
                this.volume += 10;
                if(this.volume > MAX_VOL) this.volume = MAX_VOL;
                System.out.println("Volume: " + this.getVolume());
            }
        } else {
            System.out.println("Laptop MATI. Tidak bisa menambah volume.");
        }
    }

    @Override
    public void kecilkanVolume() {
        if (this.is_on) {
            if (this.volume == MIN_VOL) {
                System.out.println("Volume SUDAH MINIMAL!");
            } else {
                this.volume -= 10;
                if(this.volume < MIN_VOL) this.volume = MIN_VOL;
                System.out.println("Volume: " + this.getVolume());
            }
        } else {
            System.out.println("Laptop MATI. Tidak bisa mengurangi volume.");
        }
    }

    public int getVolume() {
        return this.volume;
    }
}