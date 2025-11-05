package com.pbo.interfaces;

public class MacBook implements Laptop {
    private int volume;
    private boolean is_on;

    public MacBook() {
        this.volume = 25;
        this.is_on = false;
    }

    @Override
    public void nyalakan() {
        if (this.is_on) {
            System.out.println("MacBook is already on.");
        } else {
            this.is_on = true;
            System.out.println("Booting MacBook... Welcome!");
        }
    }

    @Override
    public void matikan() {
        if (!this.is_on) {
            System.out.println("MacBook is already off.");
        } else {
            this.is_on = false;
            System.out.println("Shutting down MacBook... Goodbye!");
        }
    }

    @Override
    public void perbesarVolume() {
        if (this.is_on) {
            if (this.volume == MAX_VOL) {
                System.out.println("Volume is at 100%");
            } else {
                this.volume += 2;
                if(this.volume > MAX_VOL) this.volume = MAX_VOL;
                System.out.println("Volume: " + this.getVolume());
            }
        } else {
            System.out.println("MacBook is sleeping.");
        }
    }

    @Override
    public void kecilkanVolume() {
        if (this.is_on) {
            if (this.volume == MIN_VOL) {
                System.out.println("Volume is muted");
            } else {
                this.volume -= 2;
                if(this.volume < MIN_VOL) this.volume = MIN_VOL;
                System.out.println("Volume: " + this.getVolume());
            }
        } else {
            System.out.println("MacBook is sleeping.");
        }
    }

    public int getVolume() {
        return this.volume;
    }
}