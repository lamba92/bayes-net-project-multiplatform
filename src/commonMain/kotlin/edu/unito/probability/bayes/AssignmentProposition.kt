package edu.unito.probability.bayes

import edu.unito.probability.RandomVariable

class AssignmentProposition(forVariable: RandomVariable, val value: Any):
    AbstractTermProposition(forVariable) {

    override fun holds(possibleWorld: Map<RandomVariable, Any>) = value == possibleWorld[termVariable]

}

abstract class AbstractTermProposition(val termVariable: RandomVariable):
    AbstractProposition(), TermProposition{
    override fun getTermVariable() = termVariable
}

abstract class AbstractProposition: Proposition {

    private val scope = LinkedHashSet<RandomVariable>()
    private val unboundScope = LinkedHashSet<RandomVariable>()

    override fun getScope() = scope
    override fun getUnboundScope() = unboundScope

    protected fun addScope(rv: RandomVariable) = scope.add(rv)
    protected fun addScope(vars: Collection<RandomVariable>) = scope.addAll(vars)
    protected fun addUnboundScope(rv: RandomVariable) = unboundScope.add(rv)
    protected fun addUnboundScope(vars: Collection<RandomVariable>) = unboundScope.addAll(vars)
}

interface Proposition {

    /**
     *
     * @return the Set of RandomVariables in the World (sample space) that this
     * Proposition is applicable to.
     */
    fun getScope(): Set<RandomVariable>
    /**
     *
     * @return the Set of RandomVariables from this propositions scope that are
     * not constrained to any particular set of values (e.g. bound =
     * P(Total = 11), while unbound = P(Total)). If a variable is
     * unbound it implies the distributions associated with the variable
     * is being sought.
     */
    fun getUnboundScope(): Set<RandomVariable>

    /**
     * Determine whether or not the proposition holds in a particular possible
     * world.
     *
     * @param possibleWorld
     * A possible world is defined to be an assignment of values to
     * all of the random variables under consideration.
     * @return true if the proposition holds in the given possible world, false
     * otherwise.
     */
    fun holds(possibleWorld: Map<RandomVariable, Any>): Boolean

}

interface TermProposition {
    fun getTermVariable(): RandomVariable
}
