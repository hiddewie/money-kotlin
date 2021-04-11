package nl.hiddewieringa.money

import javax.money.RoundingQuery
import javax.money.RoundingQueryBuilder

/**
 * @see RoundingQueryBuilder.of
 */
fun roundingQuery(init: RoundingQueryBuilder.() -> Unit = {}): RoundingQuery =
    RoundingQueryBuilder
        .of()
        .apply(init)
        .build()

/**
 * @see RoundingQueryBuilder.of
 */
fun roundingQuery(roundingQuery: RoundingQuery, init: RoundingQueryBuilder.() -> Unit = {}): RoundingQuery =
    RoundingQueryBuilder
        .of(roundingQuery)
        .apply(init)
        .build()