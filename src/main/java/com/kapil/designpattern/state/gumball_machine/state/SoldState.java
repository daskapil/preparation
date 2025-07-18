package com.kapil.designpattern.state.gumball_machine.state;

import com.kapil.designpattern.state.gumball_machine.GumballMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        log.info("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        log.info("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();

        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            log.info("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
