package com.kapil.designpattern.state.gumball_machine.state;

import com.kapil.designpattern.state.gumball_machine.GumballMachine;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class HasQuarterState implements State {
    GumballMachine gumballMachine;
    Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        log.info("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        log.info("You turned the crank");

        int winner = randomWinner.nextInt(10);
        if (winner == 0 && gumballMachine.getCount() > 1) {
            log.info("Congratulations! You are a winner! You get an extra gumball!");
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            log.info("No extra gumball, you get a regular one.");
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        log.info("No gumball dispensed");
        // This state does not dispense a gumball directly.
        // The dispense action is handled in the SoldState after the crank is turned.
    }
}
