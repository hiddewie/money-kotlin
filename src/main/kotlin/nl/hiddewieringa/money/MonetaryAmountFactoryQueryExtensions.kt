package nl.hiddewieringa.money

import javax.money.MonetaryAmountFactoryQuery
import javax.money.MonetaryAmountFactoryQueryBuilder

/**
 * @see MonetaryAmountFactoryQueryBuilder.of
 */
fun monetaryAmountFactoryQuery(init: MonetaryAmountFactoryQueryBuilder.() -> Unit = {}): MonetaryAmountFactoryQuery =
    MonetaryAmountFactoryQueryBuilder
        .of()
        .apply(init)
        .build()

/**
 * @see MonetaryAmountFactoryQueryBuilder.of
 */
fun monetaryAmountFactoryQuery(monetaryAmountFactoryQuery: MonetaryAmountFactoryQuery, init: MonetaryAmountFactoryQueryBuilder.() -> Unit = {}): MonetaryAmountFactoryQuery =
    MonetaryAmountFactoryQueryBuilder
        .of(monetaryAmountFactoryQuery)
        .apply(init)
        .build()
