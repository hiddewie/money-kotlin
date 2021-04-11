package nl.hiddewieringa.money.format

import nl.hiddewieringa.money.asCountryLocale
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class AmountFormatQueryExtensionsTest {

    @Test
    fun testAmountFormatQuery() {
        val locale = "NL".asCountryLocale()

        assertNotNull(amountFormatQuery("name"))
        assertNotNull(amountFormatQuery("name") {
            setLocale(locale)
        })
        assertNotNull(amountFormatQuery(amountFormatQuery("name")))
        assertNotNull(amountFormatQuery(amountFormatQuery("name")) {
            setLocale(locale)
        })
        assertNotNull(amountFormatQuery(locale))
        assertNotNull(amountFormatQuery(locale) {
            setLocale(locale)
        })
    }
}