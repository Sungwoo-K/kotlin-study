package account

import java.io.BufferedReader
import java.io.InputStreamReader


class AccountManagement() {
    private var accountList: ArrayList<Account> = ArrayList()
    private val reader = BufferedReader(InputStreamReader(System.`in`))

    fun addAccount(accountNumber: String) {
        val account = Account(accountNumber)
        this.accountList.add(account)
    }

    fun showAccountList() {
        if(accountList.size == 0) {
            println("더 이상 계좌가 조회되지 않습니다.")
            return
        }
        for(acc in this.accountList){
            println("계좌번호: [${acc.accountNumber}], 잔액: [${acc.balance}]")
        }
    }

    fun deposit(accountNumber: String, amount: Double) {
        val account = this.accountList.find { it.accountNumber == accountNumber }
        if(account != null) {
            account.deposit(amount)
        } else {
            println("계좌가 일치하지 않습니다.")
        }
    }

    fun withdraw(accountNumber: String, amount: Double) {
        val account = this.accountList.find { it.accountNumber == accountNumber }
        if(account != null) {
            account.withdraw(amount)
        } else {
            println("계좌가 일치하지 않습니다.")
        }
    }

    fun run() {
        while (true) {
            println("\n=== 계좌 관리 프로그램 ===");
            println("1. 계좌 추가");
            println("2. 계좌 목록 조회");
            println("3. 입금");
            println("4. 출금");
            println("0. 종료");
            print("원하는 기능을 선택하세요: ");

            val choice:String = reader.readLine()

            if(choice == "0") {
                println("프로그램을 종료합니다.")
                break
            }

            when (choice) {
                "1" -> {
                    print("계좌번호: ")
                    val accountNumber = readlnOrNull()
                    if(accountNumber != null) {
                        addAccount(accountNumber)
                    } else {
                        println("입력값이 없습니다.")
                    }
                }
                "2" -> {
                    showAccountList()
                }
                "3" -> {
                    print("계좌번호: ")
                    val accountNumber = readlnOrNull()
                    print("입금액: ")
                    val depositAmount = readlnOrNull()?.toDoubleOrNull()
                    if(accountNumber != null && depositAmount != null) {
                        deposit(accountNumber, depositAmount)
                    } else {
                        println("입력값이 잘못되었습니다.")
                    }
                }
                "4" -> {
                    print("계좌번호: ")
                    val accountNumber = readlnOrNull()
                    print("출금액: ")
                    val withdrawAmount = readlnOrNull()?.toDoubleOrNull()
                    if(accountNumber != null && withdrawAmount != null) {
                        withdraw(accountNumber, withdrawAmount)
                    } else {
                        println("입력값이 잘못되었습니다.")
                    }
                }
            }
        }



    }
}

