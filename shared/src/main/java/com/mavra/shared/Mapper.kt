package com.mavra.shared

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */
interface Mapper<I, O> {
    fun mapTo(out: I): O
}