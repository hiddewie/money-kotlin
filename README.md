# Kotlin extensions for `javax.money` (Moneta) JSR 354

Extensions which makes working with [`javax.money` JSR 354](https://jcp.org/en/jsr/detail?id=354) with easier when using Kotlin.

This code builds upon the Money API  of the JSR proposal, not the [Moneta classes](https://github.com/JavaMoney/jsr354-ri#readme) in the reference implementation.

## Features

- Kotlin extension functions for all the `*Builder` in the `javax.money` package.
- Kotlin operator functions for the operators defined in `javax.money.MonetaryAmount`.

## Examples

All the extension/operator functions have an associated test in [`src/test/kotlin`](src/test/kotlin).

### Monetary amount

```kotlin
// Create a monetary amount of a specific type and currency
val money = (10.0).ofCurrency<FastMoney>("EUR")

// add
money + money
+money
// subtract & negate
money - money
-money
// multiply
money * 2
2 * money
// divide & remainder
money / 2.0
money % 2.0

monetaryAmountFactoryQuery {
    setFixedScale(true)
}
monetaryContext {
    setPrecision(1)
}
typedMonetaryContext<FastMoney> {
    setPrecision(1)
}
```

### Currency

```kotlin
"EUR".asCurrency()

currencyContext("PROVIDER") {
    setProviderName("PROVIDER")
}
currencyQuery {
    setCountries("NL".asCountryLocale())
}
```

### Locale

``kotlin
"NL".asCountryLocale()
"NL".asCountryLocale().getCurrency()
"NL".asCountryLocale().getCurrencies()
``

### Rounding

```kotlin
roundingContext("EUR", "PROVIDER") {
    setProviderName("PROVIDER")
}
roundingQuery {
    setScale(1)
}
```

### Format

```kotlin
Locale.GERMANY.monetaryAmountFormat()

amountFormatContext {
    setFormatName("name")
}
amountFormatContext(Locale.GERMANY) {
    setFormatName("name")
}
amountFormatQuery("name") {
    setLocale(Locale.GERMANY)
}
```

### Conversion

```kotlin
money.convertTo("EUR")
money.convertTo("EUR", provider)

providerContext("PROVIDER", RateType.ANY) {
    setProviderName("PROVIDER")
}
conversionContext {
    setRateType(RateType.ANY)
}
conversionQuery {
    setBaseCurrency("EUR")
}
```