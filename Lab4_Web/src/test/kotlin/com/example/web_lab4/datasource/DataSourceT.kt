package com.example.web_lab4.datasource

import com.example.web_lab4.datasource.mock.DataSourceBank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DataSourceT {
    private val mockDataSource = DataSourceBank()

    @Test
    fun should() {
        val banks = mockDataSource.retrieveBanks()
        assertThat(banks).isNotEmpty()
    }
}