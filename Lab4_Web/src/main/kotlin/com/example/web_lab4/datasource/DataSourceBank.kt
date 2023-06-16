package com.example.web_lab4.datasource

import com.example.web_lab4.model.Bank

interface DataSourceBank {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
    fun createBank(bank: Bank): Bank
    fun updateBank(bank: Bank): Bank
    fun deleteBank(accountNumber: String): Bank
}