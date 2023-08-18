var accountBalance = 0
var money = 0
var accountType = ""
var isSystemOpen: Boolean = true
var option = 0

fun main() {
    println()
    println(" -------------------------------")
    println(" Welcome to our Banking System. ")
    println(" -------------------------------")
    println()
    println(" What type of account would you like to create. ")
    println()
    println(" 1. Debit Account ")
    println(" 2. Credit Account ")
    println(" 3. Checking Account ")

    while (accountType == "") {
        println()
        print(" Choose an option: ")
        var userChoice = readln().toInt()
        println(" The selected option is ${userChoice}. ")
        println()
        when (userChoice) {
            1 -> accountType = "debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
            else -> continue
        }
    }
    
    println(" -----------------------------------------")
    println(" You have created a ${accountType} account")
    println(" -----------------------------------------")
    println()
    
    // println("The current balance is " + accountBalance + " dollars. ")
    
    while (isSystemOpen == true) {
        println(" What would you like to do?")
        println()
        println(" 1. Check bank account balance ")
        println(" 2. Withdraw money")
        println(" 3. Deposit Money ")
        println(" 4. Close the system")
        println()
        print(" Choose the option: ")

        var option = readln().toInt()
        println()
        println(" ---------------------------------")
        println(" The selected option is ${option}.")
        println(" ---------------------------------")
        println()
        
        when (option) {
            1 -> {
                println(" --------------------------------------------------")
                println(" The current balance is ${accountBalance} dollars. ")
                println(" --------------------------------------------------")
            }
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen = false
                println(" ---------------------")
                println(" The system is closed ")
                println(" ---------------------")
            }
        }
        println()
    }
}

fun withdraw(amount: Int): Int {
    accountBalance -= amount
    println(" -----------------------------------------------------------------------------------------")
    println(
        " You successfully withdrew ${amount} dollars. The current balance is ${accountBalance} dollars"
        )
    println(" -----------------------------------------------------------------------------------------")
    return amount
}

fun debitWithdraw(amount: Int): Int {
    if (accountBalance == 0) {
        println(" ------------------------------------------")
        println(" Can't withdraw, no money on this account! ")
        println(" ------------------------------------------")
        return accountBalance
    } else if (amount > accountBalance) {
        println(" --------------------------------------------------------------------------------")
        println(
            " Not enough money on this account! The current balance is ${accountBalance} dollars. "
            )
        println(" --------------------------------------------------------------------------------")
        return 0
    } else {
        return withdraw(amount)
    }
}

fun deposit(amount: Int): Int {
    accountBalance += amount
    println(" --------------------------------------------------------------------------------------------")
    println(
        " You successfully deposited ${amount} dollars. The current balance is ${accountBalance} dollars. "
        )
    println(" --------------------------------------------------------------------------------------------")
    return amount
}

fun creditDeposit(amount: Int): Int {
    if (accountBalance == 0) {
        println(" ------------------------------------------------------------")
        println(" This account is comppletely piad off! Do not deposit money! ")
        println(" ------------------------------------------------------------")
        return accountBalance
    } else if (accountBalance + amount > 0) {
        println(" --------------------------------------------------------------------------------")
        println(" Deposit failed, you tried to pay off an amount greater than the credit balance. ")
        println(" The current balance is ${accountBalance} dollars")
        println("--------------------------------------------------------------------------------")
        return 0
    } else if (amount == -accountBalance) {
        accountBalance = 0
        println(" -------------------------------")
        println(" you have paid off this account ")
        println(" ------------------------------ ")
        return amount
    } else {
        return deposit(amount)
    }
}


fun transfer(mode: String) {

    when (mode) {
        "withdraw" -> {
            if (accountType == "debit") {
                print(" Enter the amount you want to withdraw: ")
                money = readln().toInt()
                debitWithdraw(money)
            } else {
                print(" Enter the amount you want to withdraw: ")
                money = readln().toInt()
                withdraw(money)
            }
        }
        "deposit" -> {
            if (accountType == "credit") {
                print(" Enter the amount you want to deposit: ")
                money = readln().toInt()
                creditDeposit(money)
            } else {
                print(" Enter the amount you want to deposit: ")
                money = readln().toInt()
                deposit(money)
            }
        }
        else -> return
    }
}
