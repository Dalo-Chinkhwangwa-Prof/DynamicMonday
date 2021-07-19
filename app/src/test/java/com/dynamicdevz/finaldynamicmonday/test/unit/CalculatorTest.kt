package com.dynamicdevz.finaldynamicmonday.test.unit

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class CalculatorTest {

    private var calculator: Calculator? = null

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun testAddition(){
        assertEquals(7, calculator?.add(2, 5))
        assertEquals(42, calculator?.add(37, 5))
        assertEquals(420, calculator?.add(400, 20))
//        assertEquals(69, calculator?.add(52, 17))
//        assertEquals(96, calculator?.add(90, 6))
    }

    @Test
    fun `test subtraction  with negative numbers`(){
        assertEquals(-42, calculator?.subtract(-37, 5))
        assertEquals(-420, calculator?.subtract(-400, 20))
    }



    @After
    fun tearDown() {
        calculator = null
    }
}