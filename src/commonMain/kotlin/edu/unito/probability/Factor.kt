package edu.unito.probability

interface Factor {

    fun iterateOver(it: (possibleAssignment: Map<RandomVariable, Any>, probability: Double) -> Unit)
    fun getValues(): Array<Double>
    fun getArgumentVariables(): Set<RandomVariable>
    operator fun contains(rv: RandomVariable): Boolean
    fun sumOut(rvs: Set<RandomVariable>): Factor
    fun maxOut(rvs: Set<RandomVariable>): Factor
    fun getSize(): Int
    fun pointwiseProduct(multiplier: Factor): Factor
    operator fun times(o: Factor) = pointwiseProduct(o)
    fun printTable(): String
}