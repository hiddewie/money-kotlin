package nl.hiddewieringa.money

import javax.money.CurrencyContext
import javax.money.CurrencyContextBuilder

/**
 * @see CurrencyContextBuilder.of
 */
fun currencyContext(provider: String, init: CurrencyContextBuilder.() -> Unit = {}): CurrencyContext =
    CurrencyContextBuilder
        .of(provider)
        .apply(init)
        .build()

/**
 * @see CurrencyContextBuilder.of
 */
fun currencyContext(currencyContext: CurrencyContext, init: CurrencyContextBuilder.() -> Unit = {}): CurrencyContext =
    CurrencyContextBuilder
        .of(currencyContext)
        .apply(init)
        .build()