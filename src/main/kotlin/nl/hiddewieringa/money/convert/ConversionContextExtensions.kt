package nl.hiddewieringa.money.convert

import javax.money.convert.ConversionContext
import javax.money.convert.ConversionContextBuilder
import javax.money.convert.ProviderContext
import javax.money.convert.RateType

/**
 * @see ConversionContextBuilder.of
 */
fun conversionContext(init: ConversionContextBuilder.() -> Unit = {}): ConversionContext =
    ConversionContextBuilder
        .of()
        .apply(init)
        .build()

/**
 * @see ConversionContextBuilder.of
 */
fun conversionContext(conversionContext: ConversionContext, init: ConversionContextBuilder.() -> Unit = {}): ConversionContext =
    ConversionContextBuilder
        .of(conversionContext)
        .apply(init)
        .build()

/**
 * @see ConversionContextBuilder.of
 */
fun conversionContext(context: ProviderContext, rateType: RateType, init: ConversionContextBuilder.() -> Unit = {}): ConversionContext =
    ConversionContextBuilder
        .create(context, rateType)
        .apply(init)
        .build()
