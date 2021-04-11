package nl.hiddewieringa.money

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class RoundingQueryExtensionsTest {

    @Test
    fun testRoundingQuery() {
        assertNotNull(roundingQuery())
        assertNotNull(roundingQuery {
            setScale(1)
        })
        assertNotNull(roundingQuery(roundingQuery()))
        assertNotNull(roundingQuery(roundingQuery()) {
            setScale(1)
        })
    }
}