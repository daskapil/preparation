package com.kapil.designpattern.state.operate_phone;

public class ReadyState extends State {
    public ReadyState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        return phone.home();
    }

    @Override
    public String onOffOn() {
        phone.setPhone(new OffState(phone));
        return phone.unlock();
    }

}
