package com.pbo.interfaces;

public class Toshiba implements Laptop {
    private int volume;
    private boolean is_on;

    public Toshiba() {
        this.volume = 70;
        this.is_on = false;
    }

    @Override
    public void nyalakan() {
        if (this.is_on) {
            System.out.println("Laptop already on (Toshiba)");
        } else {
            this.is_on = true;
            System.out.println("Laptop is now ON (Toshiba)");
        }
    }

    @Override
    public void matikan() {
        if (!this.is_on) {
            System.out.println("Laptop already off (Toshiba)");
        } else {
            this.is_on = false;
            System.out.println("Laptop is now OFF (Toshiba)");
        }
    }

    @Override
    public void perbesarVolume() {
        if (this.is_on) {
            if (this.volume == MAX_VOL) {
                System.out.println("Volume is Full");
            } else {
                this.volume += 5;
                if(this.volume > MAX_VOL) this.volume = MAX_VOL;
                System.out.println("Volume: " + this.getVolume());
            }
        } else {
            System.out.println("Laptop is OFF.");
        }
    }

    @Override
    public void kecilkanVolume() {
        if (this.is_on) {
            if (this.volume == MIN_VOL) {
                System.out.println("Volume is Muted");
            } else {
                this.volume -= 5;
                if(this.volume < MIN_VOL) this.volume = MIN_VOL;
                System.out.println("Volume: " + this.getVolume());
            }
        } else {
            System.out.println("Laptop is OFF.");
        }
    }

    public int getVolume() {
        return this.volume;
    }
}