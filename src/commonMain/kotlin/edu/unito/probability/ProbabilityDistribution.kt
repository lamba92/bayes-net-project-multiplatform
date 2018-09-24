package edu.unito.probability

import edu.unito.probability.bayes.AssignmentProposition

interface ProbabilityDistribution {
    /**
     * @return a consistent ordered Set (e.g. LinkedHashSet) of the random
     * variables this probability distribution is for.
     */
    fun getFor(): Set<RandomVariable>
    operator fun contains(rv: RandomVariable): Boolean
    fun getValue(vararg eventValues: AssignmentProposition): Double
}

interface ProbabilityMass : ProbabilityDistribution

interface CategoricalDistribution: ProbabilityMass {

    fun iterateOver(it: (possibleAssignment: Map<RandomVariable, Any>, probability: Double) -> Unit)
    fun getValues(): Array<Double>
    fun setValue(possibleAssignment: Map<RandomVariable, Any>, probability: Double)
    fun getSum(): Double
    fun normalize(): CategoricalDistribution
    fun marginal(vararg vars: RandomVariable): CategoricalDistribution
    fun pointwiseProduct(multiplier: CategoricalDistribution): CategoricalDistribution
    operator fun times(o: CategoricalDistribution) = pointwiseProduct(o)
}