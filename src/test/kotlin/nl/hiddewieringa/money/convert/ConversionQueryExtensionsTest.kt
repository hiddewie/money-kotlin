package nl.hiddewieringa.money.convert

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class ConversionQueryExtensionsTest {

    @Test
    fun testConversionQuery() {
        assertNotNull(conversionQuery())
        assertNotNull(conversionQuery {
            setBaseCurrency("EUR")
        })
        assertNotNull(conversionQuery(conversionQuery()))
        assertNotNull(conversionQuery(conversionQuery()) {
            setBaseCurrency("EUR")
        })
    }
}