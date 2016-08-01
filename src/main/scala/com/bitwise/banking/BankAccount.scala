package com.bitwise.banking

/**
  * Created by akankshag on 8/1/2016.
  */


trait AccountDetails {
  val currentBalance: Int

  def withdraw(amount: Int): BankAccount
  def deposit(amount:Int):BankAccount
  def getCurrentBalance:Int



}


 class BankAccount(val currentBalance:Int) extends AccountDetails{

  override  def withdraw(amount:Int):BankAccount= {
    if (amount <= 0 && amount >= currentBalance) {

     throw new Error("Invalid amount entered")
    }else {

      BankAccount(currentBalance - amount)
    }
  }



   override def toString = s"BankAccount($currentBalance)"

   def canEqual(other: Any): Boolean = other.isInstanceOf[BankAccount]

   override def equals(other: Any): Boolean = other match {
     case that: BankAccount =>
       (that canEqual this) &&
         currentBalance == that.currentBalance
     case _ => false
   }

   override def hashCode(): Int = {
     val state = Seq(currentBalance)
     state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
   }

   override def getCurrentBalance: Int = ???



   override def deposit(amount:Int):BankAccount=amount match {
     case amount => if (amount <=0 && amount >=currentBalance) throw new Error("insuuficient fund")
     else BankAccount(currentBalance +amount)
   }
 }

object BankAccount{

  def apply(currentBalance: Int): BankAccount = currentBalance match{
    case 0 => throw new Error("Empty BankAccount")
    case _ => if(currentBalance < 0)
      throw new Error("Insufficient fund")
    else new BankAccount(currentBalance)

  }


}


