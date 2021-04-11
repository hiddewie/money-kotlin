package nl.hiddewieringa.money

import javax.money.MonetaryAmount

/**
 * @see MonetaryAmount.add
 */
operator fun MonetaryAmount.plus(other: MonetaryAmount): MonetaryAmount =
    this.add(other)

/**
 * @see MonetaryAmount.plus
 */
operator fun MonetaryAmount.unaryPlus(): MonetaryAmount =
    this.plus()

/**
 * @see MonetaryAmount.subtract
 */
operator fun MonetaryAmount.minus(other: MonetaryAmount): MonetaryAmount =
    this.subtract(other)

/**
 * @see MonetaryAmount.negate
 */
operator fun MonetaryAmount.unaryMinus(): MonetaryAmount =
    this.negate()

/**
 * @see MonetaryAmount.multiply
 */
operator fun MonetaryAmount.times(multiplier: Number): MonetaryAmount =
    this.multiply(multiplier)

/**
 * @see MonetaryAmount.multiply
 */
operator fun MonetaryAmount.times(multiplier: Long): MonetaryAmount =
    this.multiply(multiplier)

/**
 * @see MonetaryAmount.multiply
 */
operator fun MonetaryAmount.times(multiplier: Double): MonetaryAmount =
    this.multiply(multiplier)

/**
 * @see MonetaryAmount.multiply
 */
operator fun Number.times(other: MonetaryAmount): MonetaryAmount =
    other * this

/**
 * @see MonetaryAmount.multiply
 */
operator fun Long.times(other: MonetaryAmount): MonetaryAmount =
    other * this

/**
 * @see MonetaryAmount.multiply
 */
operator fun Double.times(other: MonetaryAmount): MonetaryAmount =
    other * this

/**
 * @see MonetaryAmount.divide
 */
operator fun MonetaryAmount.div(divisor: Number): MonetaryAmount =
    this.divide(divisor)

/**
 * @see MonetaryAmount.divide
 */
operator fun MonetaryAmount.div(divisor: Long): MonetaryAmount =
    this.divide(divisor)

/**
 * @see MonetaryAmount.divide
 */
operator fun MonetaryAmount.div(divisor: Double): MonetaryAmount =
    this.divide(divisor)

/**
 * @see MonetaryAmount.remainder
 */
operator fun MonetaryAmount.rem(divisor: Number): MonetaryAmount =
    this.remainder(divisor)

/**
 * @see MonetaryAmount.remainder
 */
operator fun MonetaryAmount.rem(divisor: Long): MonetaryAmount =
    this.remainder(divisor)

/**
 * @see MonetaryAmount.remainder
 */
operator fun MonetaryAmount.rem(divisor: Double): MonetaryAmount =
    this.remainder(divisor)
