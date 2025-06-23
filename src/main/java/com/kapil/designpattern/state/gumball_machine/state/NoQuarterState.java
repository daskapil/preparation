package com.kapil.designpattern.state.gumball_machine.state;

import com.kapil.designpattern.state.gumball_machine.GumballMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        log.info("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        log.info("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        log.info("You need to pay first");
    }
}
