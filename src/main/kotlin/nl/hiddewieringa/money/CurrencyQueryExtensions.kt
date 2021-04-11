package nl.hiddewieringa.money

import javax.money.CurrencyQuery
import javax.money.CurrencyQueryBuilder

/**
 * @see CurrencyQueryBuilder.of
 */
fun currencyQuery(init: CurrencyQueryBuilder.() -> Unit = {}): CurrencyQuery =
    CurrencyQueryBuilder
        .of()
        .apply(init)
        .build()

/**
 * @see CurrencyQueryBuilder.of
 */
fun currencyQuery(currencyQuery: CurrencyQuery, init: CurrencyQueryBuilder.() -> Unit = {}): CurrencyQuery =
    CurrencyQueryBuilder
        .of(currencyQuery)
        .apply(init)
        .build()