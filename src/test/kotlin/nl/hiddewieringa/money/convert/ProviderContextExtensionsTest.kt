package nl.hiddewieringa.money.convert

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import javax.money.convert.RateType

internal class ProviderContextExtensionsTest {

    @Test
    fun testProviderContext() {
        assertNotNull(providerContext("IEF", RateType.ANY))
        assertNotNull(providerContext("IEF", RateType.ANY) {
            setProviderName("IEF")
        })
        assertNotNull(providerContext(providerContext("IEF", RateType.ANY)))
        assertNotNull(providerContext(providerContext("IEF", RateType.ANY)) {
            setProviderName("IEF")
        })
        assertNotNull(providerContext("IEF", setOf(RateType.DEFERRED)))
        assertNotNull(providerContext("IEF", setOf(RateType.DEFERRED)) {
            setProviderName("IEF")
        })
    }
}