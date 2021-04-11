package nl.hiddewieringa.money

import javax.money.RoundingContext
import javax.money.RoundingContextBuilder

/**
 * @see RoundingContextBuilder.of
 */
fun roundingContext(provider: String, roundingId: String, init: RoundingContextBuilder.() -> Unit = {}): RoundingContext =
    RoundingContextBuilder
        .of(provider, roundingId)
        .apply(init)
        .build()

/**
 * @see RoundingContextBuilder.of
 */
fun roundingContext(roundingContext: RoundingContext, init: RoundingContextBuilder.() -> Unit = {}): RoundingContext =
    RoundingContextBuilder
        .of(roundingContext)
        .apply(init)
        .build()
