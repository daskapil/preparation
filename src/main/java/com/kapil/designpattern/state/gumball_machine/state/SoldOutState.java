package com.kapil.designpattern.state.gumball_machine.state;

import com.kapil.designpattern.state.gumball_machine.GumballMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        log.info("You can't eject, you haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        log.info("You turned, but there are no gumballs");
        // No state change here, as the machine is sold out.
    }

    @Override
    public void dispense() {
        log.info("No gumball dispensed, the machine is sold out");
    }
}
