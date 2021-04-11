package nl.hiddewieringa.money

import org.javamoney.moneta.FastMoney
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.money.MonetaryAmount

internal class MonetaryAmountExtensionsTest {

    private val testValue = (10.0).ofCurrency<FastMoney>("EUR")

    @Test
    fun testPlus() {
        assertEqualNumber(testValue + 1.ofCurrency<FastMoney>("EUR"), 11.0)
    }

    @Test
    fun testMinus() {
        assertEqualNumber(testValue - 1.ofCurrency<FastMoney>("EUR"), 9.0)
    }

    @Test
    fun testUnaryPlus() {
        assertEqualNumber(+testValue, 10.0)
    }

    @Test
    fun testUnaryMinus() {
        assertEqualNumber(-testValue, -10.0)
    }

    @Test
    fun testTimes() {
        assertEqualNumber(testValue * 2, 20.0)
    }

    @Test
    fun testTimesPrefix() {
        assertEqualNumber(2 * testValue, 20.0)
    }

    @Test
    fun testDivide() {
        assertEqualNumber(testValue / 2, 5.0)
    }

    @Test
    fun testRemainder() {
        assertEqualNumber(testValue % 3, 1.0)
    }

    private fun assertEqualNumber(amount: MonetaryAmount, value: Double) =
        assertEquals(amount.number.doubleValueExact(), value)
}