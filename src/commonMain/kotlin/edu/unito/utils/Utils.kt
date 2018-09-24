package edu.unito.utils

fun <K, V> Map<K, V>.forEach(lambda: (key: K, value: V) -> Unit)
        = forEach { lambda(it.key, it.value) }
