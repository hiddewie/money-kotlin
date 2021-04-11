package nl.hiddewieringa.money

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class CurrencyContextExtensionsTest {

    @Test
    fun testCurrencyContext() {
        assertNotNull(currencyContext("IER"))
        assertNotNull(currencyContext("IER") {
            setProviderName("IER")
        })
        assertNotNull(currencyContext(currencyContext("IER")))
        assertNotNull(currencyContext(currencyContext("IER")) {
            setProviderName("IER")
        })
    }
}