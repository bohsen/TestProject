package com.mockito.mockitokotlin2

import org.junit.After

abstract class TestBase {

    @After
    open fun tearDown() {
        mockMakerInlineEnabled = null
    }
}