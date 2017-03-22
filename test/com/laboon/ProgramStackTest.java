package com.laboon;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Test methods in ProgramStack class
 */



public class ProgramStackTest {

    // Test that pushing a positive integer (20) will result in the next
    // pop being that value.
    @Test
    public void testPositivePush() {
	ProgramStack stack = new ProgramStack();
	final int testVal = 20;
	stack.push(testVal);
	int topVal = stack.pop();
	assertEquals(testVal, topVal);
    }
    // Test that pushing a negative integer (-1) will result in the next
    // pop being that value.
    @Test
    public void testNegativePush() {
	ProgramStack stack = new ProgramStack();
	final int testVal = -1;
	stack.push(testVal);
	int topVal = stack.pop();
	assertEquals(testVal, topVal);
    }

    // Test that pushing a zero (0) will result in the next
    // pop being that value.
    @Test
    public void testZeroPush() {
	ProgramStack stack = new ProgramStack();
	final int testVal = 0;
	stack.push(testVal);
	int topVal = stack.pop();
	assertEquals(testVal, topVal);
    }

    // Popping a newly-created stack (with 0 elements) should return
    // 0 (and not an EmptyStackException like a normal Java stack would)
    @Test
    public void testPop0Elements() {
	ProgramStack stack = new ProgramStack();
	try {
	    int val = stack.pop();
	    assertEquals(val, 0);
	} catch (EmptyStackException esex) {
	    fail();
	}
    }

    // Peeking a newly-created stack (with 0 elements) should return
    // 0 (and not an EmptyStackException like a normal Java stack would)
    @Test
    public void testPeek0Elements() {
	ProgramStack stack = new ProgramStack();
	try {
	    int val = stack.peek();
	    assertEquals(val, 0);
	} catch (EmptyStackException esex) {
	    fail();
	}

    }

    // Popping an element with multiple elements should return the
    // top element only.
    @Test
    public void testPopWithManyElements() {
	ProgramStack stack = new ProgramStack();
	for (int j = 0; j < 10; j++) {
	    stack.push(j);
	}
	assertEquals(stack.pop(), 9);
	assertEquals(stack.pop(), 8);
	assertEquals(stack.pop(), 7);
    }
    
    // Peeking an element with multiple elements should return the
    // top element only.  The stack should remain the same, so
    // multiple peeks should return the same value.
    @Test
    public void testPeekWithManyElements() {
	ProgramStack stack = new ProgramStack();
	for (int j = 0; j < 10; j++) {
	    stack.push(j);
	}
	assertEquals(stack.peek(), 9);
    }

    // Pushing and popping multiple elements should not cause any problems.
    @Test
    public void testPushPopMultiple() {
	ProgramStack stack = new ProgramStack();
	int retVal = 0;
	for (int j = 0; j < 10; j++) {
	    stack.push(j);
	    assertEquals(stack.peek(), j);
	}
	for (int j = 0; j < 10; j++) {
	    assertEquals(stack.pop(), (9 - j));
	}
	assertEquals(stack.peek(), 0);
	
    }

    // An empty ProgramStack should be represented by the String "[]".
    @Test
    public void testToStringEmpty() {
	ProgramStack stack = new ProgramStack();
	assertTrue(stack.toString().equals("[]"));
    }
    
    // A ProgramStack with one element should be represented by that one
    // element surrounded by brackets, e.g. "[8]".
    @Test
    public void testToStringOne() {
	ProgramStack stack = new ProgramStack();
	stack.push(8);
	assertTrue(stack.toString().equals("[8]"));

    }
    
    // A ProgramStack with multiple elements should consist of the elements
    // in that Stack in order, separated by commas and spaces.
    @Test
    public void testToStringMultiple() {
	ProgramStack stack = new ProgramStack();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	assertTrue(stack.toString().equals("[1, 2, 3]"));
    }
    // Test that 101 strings (0-100) will successfully print from stack
    // - we know 3 works, test 100.
    @Test
    public void testToString101() {
        ProgramStack stack = new ProgramStack();
	for(int i = 0; i <= 100; i++) {
            stack.push(i);
	}
	// May the Gods of computation forgive me for this clustered statement - it's right though - Julian
        assertTrue(stack.toString().equals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100]"));
    }

    @Test
    public void testToStringNegativeNumbers() {
        ProgramStack stack = new ProgramStack();
	stack.push(-8);
	stack.push(-1);
	stack.push(-6);
	assertTrue(stack.toString().equals("[-8, -1, -6]"));
    }
	
    @Test
    public void testToStringMultipleDigitNumbers() {
        ProgramStack stack = new ProgramStack();
	// Utilizing random values to make sure that the stack returns large multiple-digit numbers
	stack.push(8675309); // Because Jenny
	stack.push(-2147483648); // Because signed int min
	stack.push(9001); // Because over 9000
	stack.push(1632); // Because 1632 is great
	stack.push(2147483647); // Because signed int max
	stack.push(1234567890); // Because easy-to-swipeon my keyboard
	asertTrue(stack.toString().equals("[8675309, -2147483648, 9001, 1632, 2147483647, 1234567890)"));
}
