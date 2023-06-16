package com.example.web_lab4.service

import com.example.web_lab4.datasource.DataSourceBank
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class BankServiceT {
    private val dataSource: DataSourceBank = mockk(relaxed = true)
    private val bankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks`() {
        bankService.getBanks()
        verify(exactly = 1) {
            dataSource.retrieveBanks()
        }
    }
}