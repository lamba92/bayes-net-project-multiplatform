package edu.unito.probability

interface Domain {
    val isFinite: Boolean
    val isNotFinite: Boolean
    val size: Int
    val isOrdered: Boolean
}
