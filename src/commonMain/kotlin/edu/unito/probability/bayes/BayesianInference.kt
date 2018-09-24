package edu.unito.probability.bayes

import edu.unito.probability.CategoricalDistribution
import edu.unito.probability.RandomVariable
import edu.unito.probability.bayes.networks.BayesianNetwork

interface BayesInference {
    /**
     * @param X
     * the query variables.
     * @param observedEvidence
     * observed values for variables E.
     * @param bn
     * a Bayes networks with variables {X}  E  Y / Y = hidden
     * variables
     * @return a distribution over the query variables.
    */
    fun ask(queries: Array<RandomVariable>,
            observedEvidence: Array<AssignmentProposition>,
            bn: BayesianNetwork): CategoricalDistribution

}