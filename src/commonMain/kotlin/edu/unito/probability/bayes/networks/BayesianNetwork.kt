package edu.unito.probability.bayes.networks

import edu.unito.probability.bayes.RandomVariable

interface BayesianNetwork {
    /**
     * @return a list of the Random Variables, in topological order, contained
     * within the network.
     */
    fun variablesInTopologicalOrder(): List<RandomVariable>

    /**
     *
     * @param rv
     * the RandomVariable whose corresponding Node is to be
     * retrieved.
     * @return the Node associated with the random variable in this Bayesian
     * Network.
     */
    fun getNode(rv: RandomVariable): Node
}
