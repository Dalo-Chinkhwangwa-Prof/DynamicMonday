package com.dynamicdevz.finaldynamicmonday.test

import androidx.arch.core.executor.TaskExecutor
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FinalViewModelTest {


    val SIZE = 50
    @get: Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: FinalViewModel

    @Before
    fun setUp() {
        viewModel = FinalViewModel()
        viewModel.init(MockJikanService())
    }

    private val searchString = "naruto"

    @Test
    fun testResponseSize(){
        viewModel.getData(searchString)
        println("searching ${viewModel.liveData.value?.size}")
        assertEquals(SIZE, viewModel.liveData.value?.size)
    }

    @After
    fun tearDown() {
    }
}