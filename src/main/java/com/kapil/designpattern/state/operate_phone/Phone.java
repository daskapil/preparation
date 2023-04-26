package com.kapil.designpattern.state.operate_phone;

public class Phone {
    private State state;

    public Phone() {
        state = new OffState(this);
    }

    public void setPhone(State state) {
        this.state = state;
    }

    public String lock() {
        return "Phone locked";
    }

    public String home() {
        return "Going to home-screen!";
    }

    public String unlock() {
        return "Phone unlocked";
    }

    public String turnOn() {
        return "Turning on the screen, device remain locked";
    }

}
