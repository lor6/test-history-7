package com.baeldung.strings

import org.junit.Test

import java.text.DecimalFormat

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNull

class ConvertStringToInt {

    @Test
    void givenString_thenConvertToIntegerUsingAsInteger() {
        def stringNum = "123"
        def invalidString = "123a"
        Integer expectedInteger = 123
        Integer integerNum = stringNum as Integer
        def intNum = invalidString?.isInteger() ? invalidString as Integer : null

        assertNull(null, intNum)
        assertEquals(integerNum, expectedInteger)
    }

    @Test
    void givenString_thenConvertToIntUsingAsInt() {
        def stringNum = "123"
        int expectedInt = 123
        int intNum = stringNum as int

        assertEquals(intNum, expectedInt)
    }

    @Test
    void givenString_thenConvertToIntegerUsingToInteger() {
        def stringNum = "123"
        int expectedInt = 123
        int intNum = stringNum.toInteger()

        assertEquals(intNum, expectedInt)
    }

    @Test
    void givenString_thenConvertToIntegerUsingParseInt() {
        def stringNum = "123"
        int expectedInt = 123
        int intNum = Integer.parseInt(stringNum)

        assertEquals(intNum, expectedInt)
    }

    @Test
    void givenString_thenConvertToIntegerUsingValueOf() {
        def stringNum = "123"
        int expectedInt = 123
        int intNum = Integer.valueOf(stringNum)

        assertEquals(intNum, expectedInt)
    }

    @Test
    void givenString_thenConvertToIntegerUsingIntValue() {
        def stringNum = "123"
        int expectedInt = 123
        int intNum = new Integer(stringNum).intValue()
        int secondIntNum = new Integer(stringNum)

        assertEquals(intNum, expectedInt)
        assertEquals(secondIntNum, expectedInt)
    }

    @Test
    void givenString_thenConvertToIntegerUsingDecimalFormat() {
        def stringNum = "123"
        int expectedInt = 123
        DecimalFormat decimalFormat = new DecimalFormat("#")
        int intNum = decimalFormat.parse(stringNum).intValue()

        assertEquals(intNum, expectedInt)
    }

    @Test(expected = NumberFormatException.class)
    void givenInvalidString_whenUsingAs_thenThrowNumberFormatException() {
        def invalidString = "123a"
        invalidString as Integer
    }

    @Test(expected = NullPointerException.class)
    void givenNullString_whenUsingToInteger_thenThrowNullPointerException() {
        def invalidString = null
        invalidString.toInteger()
    }
}
