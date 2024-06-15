package nl.hiddewieringa.money

import nl.hiddewieringa.money.format.amountFormatQuery
import org.javamoney.moneta.FastMoney
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*
import javax.money.Monetary
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
    fun `monetary amount`() {
        assertNotNull(monetaryAmount<FastMoney> {
            setNumber(10)
            setCurrency("EUR")
        })
        assertNotNull(monetaryAmount(FastMoney::class.java) {
            setNumber(10)
            setCurrency("EUR")
        })
        assertNotNull(10.ofCurrency<FastMoney>("EUR"))
        assertNotNull(10.ofCurrency<FastMoney>("EUR".asCurrency()))
    }

    @Test
    fun testMonetaryAmountFormat() {
        assertNotNull(Locale.GERMANY.monetaryAmountFormat())
        assertNotNull(Locale.GERMANY.monetaryAmountFormat())
        assertNotNull(amountFormatQuery(Locale.GERMAN).monetaryAmountFormat())
    }
}
