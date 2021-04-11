package nl.hiddewieringa.money.convert

import javax.money.convert.ConversionQuery
import javax.money.convert.ConversionQueryBuilder

/**
 * @see ConversionQueryBuilder.of
 */
fun conversionQuery(init: ConversionQueryBuilder.() -> Unit = {}): ConversionQuery =
    ConversionQueryBuilder
        .of()
        .apply(init)
        .build()

/**
 * @see ConversionQueryBuilder.of
 */
fun conversionQuery(conversionQuery: ConversionQuery, init: ConversionQueryBuilder.() -> Unit = {}): ConversionQuery =
    ConversionQueryBuilder
        .of(conversionQuery)
        .apply(init)
        .build()