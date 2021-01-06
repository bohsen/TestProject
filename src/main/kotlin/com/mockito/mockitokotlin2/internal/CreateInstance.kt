/*
 * The MIT License
 *
 * Copyright (c) 2018 Niek Haarman
 * Copyright (c) 2007 Mockito contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mockito.mockitokotlin2.internal

import kotlin.reflect.KClass

inline fun <reified T : Any> createInstance(): T {
    return when (T::class) {
        Boolean::class -> false as T
        Byte::class -> 0.toByte() as T
        Char::class -> 0.toChar() as T
        Short::class -> 0.toShort() as T
        Int::class -> 0 as T
        Long::class -> 0L as T
        Float::class -> 0f as T
        Double::class -> 0.0 as T
        else -> createInstance(T::class)
    }
}

fun <T : Any> createInstance(kClass: KClass<T>): T {
    return castNull()
}

/**
 * Uses a quirk in the bytecode generated by Kotlin
 * to cast [null] to a non-null type.
 *
 * See https://youtrack.jetbrains.com/issue/KT-8135.
 */
@Suppress("UNCHECKED_CAST")
private fun <T> castNull(): T = null as T
