# Kotlin extensions for `javax.money` (Moneta) JSR 354

Extensions which makes working with [`javax.money` JSR 354](https://jcp.org/en/jsr/detail?id=354) with easier when using Kotlin.

This code builds upon the Money API of the JSR proposal, not the [Moneta classes](https://github.com/JavaMoney/jsr354-ri#readme) in the reference implementation.

## Features

- Kotlin extension functions for all the `*Builder` in the `javax.money` package.
- Kotlin operator functions for the operators defined in `javax.money.MonetaryAmount`.

## Requirements

At least Java 21.

At least Kotlin 2.

## Installation

Find the latest version on [Maven Central](https://search.maven.org/artifact/nl.hiddewieringa/money-kotlin/).

Add the `money-kotlin` dependency to your project.

Gradle:
```kotlin
implementation("nl.hiddewieringa:money-kotlin:$moneyKotlinVersion")
```

Maven:
```xml
<dependency>
  <groupId>nl.hiddewieringa</groupId>
  <artifactId>money-kotlin</artifactId>
  <version>${moneyKotlin.version}</version>
</dependency>
```

This library depends only on the Money API of the JSR proposal. Ensure you add a dependency on a specific implementation such as `org.javamoney:moneta:<version>`.

## Examples

All the extension/operator functions have an associated test in [`src/test/kotlin`](src/test/kotlin).

### Monetary amount

```kotlin
// Create a monetary amount of a specific type and currency
val money = (10.0).ofCurrency<FastMoney>("EUR")

// Create a monetary amount of a default type for the provider and currency.
// If using Moneta, its default type is Money and can be changed by specifying 
// org.javamoney.moneta.Money.defaults.amountType in the javamoney.properties.
val money = (10.0).ofCurrency("EUR")
//or
val money = (10.0).ofCurrency<MonetaryAmount>("EUR")

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

```kotlin
"NL".asCountryLocale()
"NL".asCountryLocale().getCurrency()
"NL".asCountryLocale().getCurrencies()
```

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

## Releasing and publishing

### Preparation

Ensure that the properties `signing.keyId`, `signing.password` and `signing.secretKeyRingFile=` are set in `~/.gradle/gradle.properties`.
These properties are neccesary for signing releases.

Ensure that the properties `sonatypeUsername` and `sonatypePassword` are set in `~/.gradle/gradle.properties`.
These properties are credentials for publishing to Maven Central.

### Building

Build the project
```bash
./gradlew clean build
```

### Releasing

Release a version by tagging a Git commit
```bash
git tag -a 1.0.0 -m "Version 1.0.0"
```

### Publishing

Publish the release to Sonatype
```bash
./gradlew publishToSonatype closeAndReleaseSonatypeStagingRepository
```
This will publish the artifacts to Maven Central.
