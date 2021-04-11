package nl.hiddewieringa.money.convert

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import javax.money.convert.RateType

internal class ConversionContextExtensionsTest {

    @Test
    fun testConversionContext() {
        assertNotNull(conversionContext())
        assertNotNull(conversionContext {
            setRateType(RateType.ANY)
        })
        assertNotNull(conversionContext(conversionContext()))
        assertNotNull(conversionContext(conversionContext()) {
            setRateType(RateType.ANY)
        })
        assertNotNull(conversionContext(providerContext("IER", RateType.ANY), RateType.DEFERRED))
        assertNotNull(conversionContext(providerContext("IER", RateType.ANY), RateType.DEFERRED) {
            setRateType(RateType.DEFERRED)
        })
    }
}