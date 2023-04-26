package com.kapil.designpattern.state.operate_phone;

public class OffState extends State {
    public OffState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setPhone(new LockedState(phone));
        return phone.turnOn();
    }

    @Override
    public String onOffOn() {
        phone.setPhone(new LockedState(phone));
        return phone.turnOn();
    }

}
