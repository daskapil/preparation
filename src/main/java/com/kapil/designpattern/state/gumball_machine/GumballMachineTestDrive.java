package com.kapil.designpattern.state.gumball_machine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        log.info("{}", gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();

        for (int i = 0; i < 5; i++) {
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        log.info("{}", gumballMachine);
    }
}
