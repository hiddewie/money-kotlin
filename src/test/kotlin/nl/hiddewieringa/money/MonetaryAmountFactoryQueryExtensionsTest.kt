package nl.hiddewieringa.money

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class MonetaryAmountFactoryQueryExtensionsTest {

    @Test
    fun testMonetaryAmountFactoryQuery() {
        assertNotNull(monetaryAmountFactoryQuery())
        assertNotNull(monetaryAmountFactoryQuery {
            setFixedScale(true)
        })
        assertNotNull(monetaryAmountFactoryQuery(monetaryAmountFactoryQuery()))
        assertNotNull(monetaryAmountFactoryQuery(monetaryAmountFactoryQuery()) {
            setFixedScale(true)
        })
    }
}