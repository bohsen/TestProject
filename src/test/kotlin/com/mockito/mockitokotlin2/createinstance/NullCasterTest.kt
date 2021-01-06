package com.mockito.mockitokotlin2.createinstance

import com.mockito.mockitokotlin2.TestBase
import com.mockito.mockitokotlin2.internal.createInstance
import com.nhaarman.expect.expect
import org.junit.Test


class NullCasterTest : TestBase() {

    @Test
    fun createInstance() {
        /* When */
        val result = createInstance(String::class)

        /* Then */
        expect(result).toBeNull()
    }

    @Test
    fun kotlinAcceptsNullValue() {
        /* Given */
        val s: String = createInstance(String::class)

        /* When */
        acceptNonNullableString(s)
    }

    private fun acceptNonNullableString(@Suppress("UNUSED_PARAMETER") s: String) {
    }
}
