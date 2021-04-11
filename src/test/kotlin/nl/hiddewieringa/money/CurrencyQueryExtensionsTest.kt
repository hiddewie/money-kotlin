package nl.hiddewieringa.money

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class CurrencyQueryExtensionsTest {

    @Test
    fun testCurrencyQuery() {
        assertNotNull(currencyQuery())
        assertNotNull(currencyQuery {
            setCountries("NL".asCountryLocale())
        })
        assertNotNull(currencyQuery(currencyQuery()))
        assertNotNull(currencyQuery(currencyQuery()) {
            setCountries("NL".asCountryLocale())
        })
    }
}