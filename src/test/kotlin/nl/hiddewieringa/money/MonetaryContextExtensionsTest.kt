package nl.hiddewieringa.money

import org.javamoney.moneta.FastMoney
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class MonetaryContextExtensionsTest {

    @Test
    fun testMonetaryContext() {
        assertNotNull(monetaryContext())
        assertNotNull(monetaryContext {
            setPrecision(1)
        })
        assertNotNull(monetaryContext(monetaryContext()))
        assertNotNull(monetaryContext(monetaryContext()) {
            setPrecision(1)
        })
        assertNotNull(typedMonetaryContext(FastMoney::class.java))
        assertNotNull(typedMonetaryContext(FastMoney::class.java) {
            setPrecision(1)
        })
        assertNotNull(typedMonetaryContext<FastMoney> {
            setPrecision(1)
        })
    }
}