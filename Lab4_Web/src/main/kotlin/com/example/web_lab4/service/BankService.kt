package com.example.web_lab4.service

import com.example.web_lab4.datasource.DataSourceBank
import com.example.web_lab4.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: DataSourceBank) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)
    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)
    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)
    fun deleteBank(accountNumber: String): Bank = dataSource.deleteBank(accountNumber)
}