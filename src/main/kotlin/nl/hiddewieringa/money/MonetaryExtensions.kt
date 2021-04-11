package nl.hiddewieringa.money

import java.util.*
import javax.money.*
import javax.money.convert.CurrencyConversion
import javax.money.convert.ExchangeRateProvider
import javax.money.convert.MonetaryConversions
import javax.money.format.AmountFormatQuery
import javax.money.format.MonetaryAmountFormat
import javax.money.format.MonetaryFormats

/**
 * @see Monetary.getCurrency
 */
fun String.asCurrency(vararg providers: String): CurrencyUnit =
    Monetary.getCurrency(this, *providers)

/**
 * @see Locale
 */
fun String.asCountryLocale(): Locale =
    Locale("", this)

/**
 * @see Monetary.getCurrency
 */
fun Locale.getCurrency(vararg providers: String): CurrencyUnit =
    Monetary.getCurrency(this, *providers)

/**
 * @see Monetary.getCurrencies
 */
fun Locale.getCurrencies(vararg providers: String): Set<CurrencyUnit> =
    Monetary.getCurrencies(this, *providers)

fun String.asConversion(vararg providers: String): CurrencyConversion =
    MonetaryConversions.getConversion(this, *providers)

/**
 * @see Monetary.getAmountFactory
 */
fun <T : MonetaryAmount> monetaryAmount(type: Class<T>, init: MonetaryAmountFactory<T>.() -> Unit = {}): T =
    Monetary.getAmountFactory(type)
        .apply(init)
        .create()

/**
 * @see Monetary.getAmountFactories
 */
inline fun <reified T : MonetaryAmount> monetaryAmount(noinline init: MonetaryAmountFactory<T>.() -> Unit = {}): T =
    monetaryAmount(T::class.java, init)

/**
 * @see monetaryAmount
 */
fun <T : MonetaryAmount> Number.ofCurrency(type: Class<T>, currency: CurrencyUnit, monetaryContext: MonetaryContext? = null): T =
    monetaryAmount(type) {
        setNumber(this@ofCurrency)
        setCurrency(currency)
        if (monetaryContext != null) {
            setContext(monetaryContext)
        }
    }

/**
 * @see monetaryAmount
 */
fun <T : MonetaryAmount> Number.ofCurrency(type: Class<T>, currency: String, monetaryContext: MonetaryContext? = null): T =
    ofCurrency(type, currency.asCurrency(), monetaryContext)

/**
 * @see monetaryAmount
 */
inline fun <reified T : MonetaryAmount> Number.ofCurrency(currency: String, monetaryContext: MonetaryContext? = null): T =
    ofCurrency(T::class.java, currency, monetaryContext)

/**
 * @see monetaryAmount
 */
inline fun <reified T : MonetaryAmount> Number.ofCurrency(currency: CurrencyUnit, monetaryContext: MonetaryContext? = null): T =
    ofCurrency(T::class.java, currency, monetaryContext)

/**
 * Uses a default exchange rate provider
 * @see ExchangeRateProvider.getExchangeRate
 */
fun MonetaryAmount.convertTo(currency: String): MonetaryAmount =
    convertTo(currency, MonetaryConversions.getExchangeRateProvider())

/**
 * @see ExchangeRateProvider.getExchangeRate
 */
fun MonetaryAmount.convertTo(currency: String, rateProvider: ExchangeRateProvider): MonetaryAmount =
    with(rateProvider.getCurrencyConversion(currency))

/**
 * @see MonetaryFormats.getAmountFormat
 */
fun Locale.monetaryAmountFormat(vararg providers: String): MonetaryAmountFormat =
    MonetaryFormats.getAmountFormat(this, *providers)

/**
 * MonetaryFormats.getAmountFormat
 */
fun AmountFormatQuery.monetaryAmountFormat(): MonetaryAmountFormat =
    MonetaryFormats.getAmountFormat(this)
