package com.kapil.algorithms.part1.union_find;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UFTest {

    AbstractUF abstractUf;
    int numberOfComponent;

    @BeforeEach
    void setUp() {
        numberOfComponent = 5;
        abstractUf = new QuickFindUF(numberOfComponent);
    }

    @Test
    void union() {
    }

    @Test
    void connected() {
    }

    @Test
    void find() {
    }

    @Test
    void count() {
        assertEquals(numberOfComponent, abstractUf.count(), () -> "Number of component count did not match");
    }
}