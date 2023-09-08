package account

class Account(val accountNumber: String, var balance: Double = 0.0) {
    fun deposit(amount: Double) {
        this.balance += amount
    }
    fun withdraw(amount: Double) {
        if(this.balance < amount) {
            println("잔액이 부족합니다.")
        } else {
            this.balance -= amount;
        }
    }
}