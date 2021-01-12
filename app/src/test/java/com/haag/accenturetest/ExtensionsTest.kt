package com.haag.accenturetest

import com.google.common.truth.Truth.assertThat
import com.haag.accenturetest.util.region
import org.junit.Test

class ExtensionsTest {

    @Test
    fun `The North displays correct image`() {
        val result = region("The North")
        assertThat(result).contains("https://bit.ly/2Gcq0r4")
    }

    @Test
    fun `The Vale displays correct image`() {
        val result = region("The Vale")
        assertThat(result).contains("https://bit.ly/34FAvws")
    }

    @Test
    fun `The Riverlands displays correct image`() {
        val result = region("The Riverlands")
        assertThat(result).contains("https://bit.ly/3kJrIiP")
    }

    @Test
    fun `Iron Islands displays correct image`() {
        val result = region("Iron Islands")
        assertThat(result).contains("https://bit.ly/3kJrIiP")
    }

    @Test
    fun `The Westerlands displays correct image`() {
        val result = region("The Westerlands")
        assertThat(result).contains("https://bit.ly/2TAzjnO")
    }

    @Test
    fun `The Reach displays correct image`() {
        val result = region("The Reach")
        assertThat(result).contains("https://bit.ly/2HSCW5N")
    }

    @Test
    fun `Dorne displays correct image`() {
        val result = region("Dorne")
        assertThat(result).contains("https://bit.ly/2HOcavT")
    }

    @Test
    fun `The Stormlands displays correct image`() {
        val result = region("The Stormlands")
        assertThat(result).contains("https://bit.ly/34F2sEC")
    }

    @Test
    fun `Everything else displays no image`() {
        val result = region("The Neck")
        assertThat(result).contains(" ")
    }

    @Test
    fun `Empty string displays no image`() {
        val result = region("")
        assertThat(result).contains(" ")
    }
}