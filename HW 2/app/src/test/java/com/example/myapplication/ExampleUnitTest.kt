package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun testCase1() {
        // Test Case 1
        val result = add(2, 3)
        println("Test Case 1: Adding 2 and 3")
        println("Result: $result")
        assert(result == 5)
    }

    @Test
    fun testCase2() {
        // Test Case 2
        val result = subtract(5, 3)
        println("Test Case 2: Subtracting 3 from 5")
        println("Result: $result")
        assert(result == 2)
    }

    @Test
    fun testCase3() {
        // Test Case 3
        val text = concatenate("Hello, ", "world!")
        println("Test Case 3: Concatenating strings")
        println("Result: $text")
        assert(text == "Hello, world!")
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }

    private fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    private fun concatenate(a: String, b: String): String {
        return a + b
    }
}
