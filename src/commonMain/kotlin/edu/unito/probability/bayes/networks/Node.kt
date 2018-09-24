package edu.unito.probability.bayes.networks

import edu.unito.probability.ConditionalProbabilityDistribution
import edu.unito.probability.ConditionalProbabilityTable
import edu.unito.probability.RandomVariable

interface Node {
    /**
     *
     * @return the Random Variable this Node is for/on.
     */
    fun getRandomVariable(): RandomVariable

    /**
     *
     * @return true if this Node has no parents.
     *
     * @see Node.getParents
     */
    fun isRoot(): Boolean

    /**
     *
     * @return the parent Nodes for this Node.
     */
    fun getParents(): Set<Node>

    /**
     *
     * @return the children Nodes for this Node.
     */
    fun getChildren(): Set<Node>

    /**
     * Get this Node's Markov Blanket:<br></br>
     * 'A node is conditionally independent of all other nodes in the network,
     * given its parents, children, and children's parents - that is, given its
     * **MARKOV BLANKET** (AIMA3e pg, 517).
     *
     * @return this Node's Markov Blanket.
     */
    fun getMarkovBlanket(): Set<Node>

    /**
     *
     * @return the Conditional Probability Distribution associated with this
     * Node.
     */
    fun getCPD(): ConditionalProbabilityDistribution
}

interface DiscreteNode : Node

interface FiniteNode : DiscreteNode {

    /**
     *
     * @return the Conditional Probability Table detailing the finite set of
     * probabilities for this Node.
     */
    val cpt: ConditionalProbabilityTable
}
