package nl.hiddewieringa.money

import javax.money.MonetaryAmount
import javax.money.MonetaryContext
import javax.money.MonetaryContextBuilder

/**
 * @see MonetaryContextBuilder.of
 */
fun monetaryContext(init: MonetaryContextBuilder.() -> Unit = {}): MonetaryContext =
    MonetaryContextBuilder
        .of()
        .apply(init)
        .build()

/**
 * @see MonetaryContextBuilder.of
 */
fun <A : MonetaryAmount> typedMonetaryContext(amountType: Class<A>, init: MonetaryContextBuilder.() -> Unit = {}): MonetaryContext =
    MonetaryContextBuilder
        .of(amountType)
        .apply(init)
        .build()

/**
 * @see MonetaryContextBuilder.of
 */
inline fun <reified A : MonetaryAmount> typedMonetaryContext(noinline init: MonetaryContextBuilder.() -> Unit = {}): MonetaryContext =
    typedMonetaryContext(A::class.java, init)


/**
 * @see MonetaryContextBuilder.of
 */
fun monetaryContext(monetaryContext: MonetaryContext, init: MonetaryContextBuilder.() -> Unit = {}): MonetaryContext =
    MonetaryContextBuilder
        .of(monetaryContext)
        .apply(init)
        .build()