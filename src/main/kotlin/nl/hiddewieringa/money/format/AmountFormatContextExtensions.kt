package nl.hiddewieringa.money.format

import java.util.*
import javax.money.format.AmountFormatContext
import javax.money.format.AmountFormatContextBuilder
import javax.money.format.AmountFormatQuery

/**
 * @see AmountFormatContextBuilder.of
 */
fun amountFormatContext(formatQuery: AmountFormatQuery, init: AmountFormatContextBuilder.() -> Unit = {}): AmountFormatContext =
    AmountFormatContextBuilder
        .create(formatQuery)
        .apply(init)
        .build()

/**
 * @see AmountFormatContextBuilder.of
 */
fun amountFormatContext(formatName: String, init: AmountFormatContextBuilder.() -> Unit = {}): AmountFormatContext =
    AmountFormatContextBuilder
        .of(formatName)
        .apply(init)
        .build()

/**
 * @see AmountFormatContextBuilder.of
 */
fun amountFormatContext(amountFormatContext: AmountFormatContext, init: AmountFormatContextBuilder.() -> Unit = {}): AmountFormatContext =
    AmountFormatContextBuilder
        .of(amountFormatContext)
        .apply(init)
        .build()

/**
 * @see AmountFormatContextBuilder.of
 */
fun amountFormatContext(locale: Locale, init: AmountFormatContextBuilder.() -> Unit = {}): AmountFormatContext =
    AmountFormatContextBuilder
        .of(locale)
        .apply(init)
        .build()
