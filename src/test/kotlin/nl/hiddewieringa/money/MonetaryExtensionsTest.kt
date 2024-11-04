package nl.hiddewieringa.money

import nl.hiddewieringa.money.format.amountFormatQuery
import org.javamoney.moneta.FastMoney
import org.javamoney.moneta.Money
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*
import javax.money.Monetary
import javax.money.MonetaryAmount
import javax.money.UnknownCurrencyException

class MonetaryExtensionsTest {
    @Test
    fun `known string to currency`() {
        assertEquals("CHF".asCurrency(), Monetary.getCurrency("CHF"))
        assertEquals("USD".asCurrency(), Monetary.getCurrency("USD"))
    }

    @Test
    fun `unknown currency throws`() {
        assertThrows<UnknownCurrencyException> {
            "AAA".asCurrency()
        }
    }

    @Test
    fun `as country locale`() {
        assertEquals(
            "NL".asCountryLocale(),
            Locale.of("", "NL")
        )
    }

    @Test
    fun `locale currency`() {
        assertEquals(
            Locale.of("", "NL").getCurrency(),
            "EUR".asCurrency()
        )
    }

    @Test
    fun currencies() {
        assertEquals(
            Locale.of("", "NL").getCurrencies(),
            setOf("EUR".asCurrency())
        )
    }

    @Test
    @Disabled
    fun conversion() {
        // Not tested because of external provider connectivity
    }

    @Test
    fun `default monetary amount`() {
        with(monetaryAmount<MonetaryAmount> { setNumber(10); setCurrency("EUR") }) {
            assertNotNull(this)
            assertEquals(this::class, Money::class)
        }

        with(monetaryAmount(MonetaryAmount::class.java) { setNumber(10); setCurrency("EUR") }) {
            assertNotNull(this)
            assertEquals(this::class, Money::class)
        }

        with(10.ofCurrency<MonetaryAmount>("EUR")) {
            assertNotNull(this)
            assertEquals(this::class, Money::class)
        }

        with(10.ofCurrency<MonetaryAmount>("EUR".asCurrency())) {
            assertNotNull(this)
            assertEquals(this::class, Money::class)
        }

        assertNotNull(10.ofCurrency("EUR"))
        assertNotNull(10.ofCurrency("EUR".asCurrency()))
    }

    @Test
    fun `monetary amount`() {
        with(monetaryAmount<FastMoney> { setNumber(10); setCurrency("EUR") }) {
            assertNotNull(this)
            assertEquals(this::class, FastMoney::class)
        }

        with(monetaryAmount(FastMoney::class.java) { setNumber(10); setCurrency("EUR") }) {
            assertNotNull(this)
            assertEquals(this::class, FastMoney::class)
        }

        with(10.ofCurrency<FastMoney>("EUR")) {
            assertNotNull(this)
            assertEquals(this::class, FastMoney::class)
        }

        with(10.ofCurrency<FastMoney>("EUR".asCurrency())) {
            assertNotNull(this)
            assertEquals(this::class, FastMoney::class)
        }
    }

    @Test
    fun testMonetaryAmountFormat() {
        assertNotNull(Locale.GERMANY.monetaryAmountFormat())
        assertNotNull(Locale.GERMANY.monetaryAmountFormat())
        assertNotNull(amountFormatQuery(Locale.GERMAN).monetaryAmountFormat())
    }
}
