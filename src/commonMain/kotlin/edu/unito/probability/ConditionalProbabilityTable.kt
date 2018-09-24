package edu.unito.probability

import edu.unito.probability.bayes.AssignmentProposition

interface ConditionalProbabilityTable: ConditionalProbabilityDistribution {

    /**
     * Construct a Factor consisting of the Random Variables from the
     * Conditional Probability Table that are not part of the evidence (see
     * AIMA3e pg. 524).
     *
     * @param evidence
     * @return a Factor for the Random Variables from the Conditional
     * Probability Table that are not part of the evidence.
     */
    fun getFactorFor(vararg evidence: AssignmentProposition): Factor
}
