package nl.hiddewieringa.money.format

import nl.hiddewieringa.money.asCountryLocale
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class AmountFormatContextExtensionsTest {

    @Test
    fun testAmountFormatContext() {
        assertNotNull(amountFormatContext("name"))
        assertNotNull(amountFormatContext("name") {
            setFormatName("name")
        })
        assertNotNull(amountFormatContext(amountFormatQuery("name")))
        assertNotNull(amountFormatContext(amountFormatQuery("name")) {
            setFormatName("name")
        })
        assertNotNull(amountFormatContext("NL".asCountryLocale()))
        assertNotNull(amountFormatContext("NL".asCountryLocale()) {
            setFormatName("name")
        })
        assertNotNull(amountFormatContext(amountFormatContext("name")))
        assertNotNull(amountFormatContext(amountFormatContext("name")) {
            setFormatName("name")
        })
    }
}