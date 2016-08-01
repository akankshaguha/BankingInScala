package com.bitwise.banking

import org.junit.{Assert, Test}

/**
  * Created by akankshag on 8/1/2016.
  */
class BankAccountTest {
  @Test
  def amountEnteredShouldNotBeNegative(): Unit ={
    //given
    val t = new BankAccount(-1)
    //when
    //then
  }
  @Test
  def itShouldAbleToWithdrawMoney(): Unit ={
    //given
    val t = new BankAccount(500)
    //when
    t.withdraw(10)
    //then
    Assert.assertEquals(BankAccount(490),t.withdraw(10))
  }
  @Test
  def itShouldAbleToDepositMoney(): Unit ={
    //given
    val t = new BankAccount(500)
    //when
    t.deposit(10)
    //then
    Assert.assertEquals(BankAccount(510),t.deposit(10))
  }





}
