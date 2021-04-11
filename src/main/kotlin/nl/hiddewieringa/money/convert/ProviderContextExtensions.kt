package nl.hiddewieringa.money.convert

import javax.money.convert.ProviderContext
import javax.money.convert.ProviderContextBuilder
import javax.money.convert.RateType

/**
 * @see ProviderContextBuilder.of
 */
fun providerContext(context: ProviderContext, init: ProviderContextBuilder.() -> Unit = {}): ProviderContext =
    ProviderContextBuilder
        .create(context)
        .apply(init)
        .build()

/**
 * @see ProviderContextBuilder.of
 */
fun providerContext(provider: String, rateType: RateType, init: ProviderContextBuilder.() -> Unit = {}): ProviderContext =
    ProviderContextBuilder
        .of(provider, rateType)
        .apply(init)
        .build()

/**
 * @see ProviderContextBuilder.of
 */
fun providerContext(provider: String, rateTypes: Collection<RateType>, init: ProviderContextBuilder.() -> Unit = {}): ProviderContext =
    ProviderContextBuilder
        .of(provider, rateTypes)
        .apply(init)
        .build()
