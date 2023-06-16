package com.example.web_lab4.datasource.mock

import com.example.web_lab4.datasource.DataSourceBank
import com.example.web_lab4.model.Bank
import org.springframework.stereotype.Repository

@Repository
class DataSourceBank: DataSourceBank {
    val banks = mutableListOf(
            Bank("1234", 3.14, 17),
            Bank("1010", 17.0, 0),
            Bank("5678", 0.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull {
        it.accountNumber == accountNumber
    } ?: throw NoSuchMethodError("Не удалось найти банк с номером счета: $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
                throw IllegalArgumentException("Банк с номером счета: ${bank.accountNumber} уже существует")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull {
            it.accountNumber == bank.accountNumber
        } ?: throw NoSuchElementException("Не удалось найти номер счета: ${bank.accountNumber}")
        banks.remove(currentBank)
        banks.add(bank)
        return bank
    }

    override fun deleteBank(accountNumber: String): Bank {
        val currentBank = banks.firstOrNull {
            it.accountNumber == accountNumber
        } ?: throw NoSuchElementException("Не удалось найти номер счета $accountNumber")
        banks.remove(currentBank)
        return currentBank
    }
}