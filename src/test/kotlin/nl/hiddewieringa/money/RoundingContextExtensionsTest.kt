package nl.hiddewieringa.money

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RoundingContextExtensionsTest {

    @Test
    fun testRoundingContext() {
        assertNotNull(roundingContext("EUR", "ID"))
        assertNotNull(roundingContext("EUR", "ID") {
            setProviderName("PROV")
        })
        assertNotNull(roundingContext(roundingContext("EUR", "ID")))
        assertNotNull(roundingContext(roundingContext("EUR", "ID")) {
            setProviderName("PROV")
        })
    }
}