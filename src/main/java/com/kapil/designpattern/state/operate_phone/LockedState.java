package com.kapil.designpattern.state.operate_phone;

public class LockedState extends State {
    public LockedState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        return null;
    }

    @Override
    public String onOffOn() {
        return null;
    }

}
