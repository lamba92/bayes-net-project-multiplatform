package edu.unito.probability

import edu.unito.probability.bayes.AssignmentProposition

interface ConditionalProbabilityDistribution {
    /**
     * @return the Random Variable this conditional probability distribution is
     * on.
     */
    fun getOn(): RandomVariable

    /**
     * @return a consistent ordered Set (e.g. LinkedHashSet) of the parent
     * Random Variables for this conditional distribution.
     */
    fun getParents(): Set<RandomVariable>

    /**
     * A convenience method for merging the elements of getParents() and getOn()
     * into a consistent ordered set (i.e. getOn() should always be the last
     * Random Variable returned when iterating over the set).
     *
     * @return a consistent ordered Set (e.g. LinkedHashSet) of the random
     * variables this conditional probability distribution is for.
     */
    fun getFor()
            = LinkedHashSet(getParents()).apply { add(getOn()) }

    /**
     *
     * @param rv
     * the Random Variable to be checked.
     * @return true if the conditional distribution is for the passed in Random
     * Variable, false otherwise.
     */
    operator fun contains(rv: RandomVariable): Boolean

    /**
     * Get the value for the provided set of AssignmentPropositions for the
     * random variables comprising the Conditional Distribution (size of each
     * must equal and their random variables must match).
     *
     * @param eventValues
     * the assignment propositions for the random variables
     * comprising the Conditional Distribution
     * @return the value for the possible worlds associated with the assignments
     * for the random variables comprising the Conditional Distribution.
     */
    fun getValue(vararg eventValues: AssignmentProposition): Double

    /**
     * A conditioning case is just a possible combination of values for the
     * parent nodes - a miniature possible world, if you like. The returned
     * distribution must sum to 1, because the entries represent an exhaustive
     * set of cases for the random variable.
     *
     * @param parentValues
     * for the conditioning case. The size of parentValues must equal
     * getParents() and their Random Variables must match.
     * @return the Probability Distribution for the Random Variable the
     * Conditional Probability Distribution is On.
     * @see ConditionalProbabilityDistribution.getOn
     * @see ConditionalProbabilityDistribution.getParents
     */
    fun getConditioningCase(vararg parentValues: AssignmentProposition): ProbabilityDistribution

    /**
     * Retrieve a specific example for the Random Variable this conditional
     * distribution is on.
     *
     * @param probabilityChoice
     * a double value, from the range [0.0d, 1.0d), i.e. 0.0d
     * (inclusive) to 1.0d (exclusive).
     * @param parentValues
     * for the conditioning case. The size of parentValues must equal
     * getParents() and their Random Variables must match.
     * @return a sample value from the domain of the Random Variable this
     * distribution is on, based on the probability argument passed in.
     * @see ConditionalProbabilityDistribution.getOn
     */
    abstract fun getSample(probabilityChoice: Double, vararg parentValues: AssignmentProposition): Any
}
