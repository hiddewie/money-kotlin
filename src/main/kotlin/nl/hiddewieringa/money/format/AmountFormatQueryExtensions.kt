package nl.hiddewieringa.money.format

import java.util.*
import javax.money.format.AmountFormatQuery
import javax.money.format.AmountFormatQueryBuilder

/**
 * @see AmountFormatQueryBuilder.of
 */
fun amountFormatQuery(formatName: String, init: AmountFormatQueryBuilder.() -> Unit = {}): AmountFormatQuery =
    AmountFormatQueryBuilder
        .of(formatName)
        .apply(init)
        .build()

/**
 * @see AmountFormatQueryBuilder.of
 */
fun amountFormatQuery(amountFormatQuery: AmountFormatQuery, init: AmountFormatQueryBuilder.() -> Unit = {}): AmountFormatQuery =
    AmountFormatQueryBuilder
        .of(amountFormatQuery)
        .apply(init)
        .build()

/**
 * @see AmountFormatQueryBuilder.of
 */
fun amountFormatQuery(locale: Locale, init: AmountFormatQueryBuilder.() -> Unit = {}): AmountFormatQuery =
    AmountFormatQueryBuilder
        .of(locale)
        .apply(init)
        .build()
