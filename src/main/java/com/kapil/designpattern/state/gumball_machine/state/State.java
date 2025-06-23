package com.kapil.designpattern.state.gumball_machine.state;

public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
