package com.mavixk.jcp.regex;

public class Payment {
  private int ID;

  public static void main(String[] args){
    CreditCard creditCard = new CreditCard();
    creditCard.setCardnum(123);
    creditCard.setSecretcode(123);
    Payment payment = creditCard;
    if(payment instanceof CreditCard){
      CreditCard card = (CreditCard)payment;
      System.out.println(card.getCardnum());
    }
  }
}

class CreditCard extends Payment{
  private int cardnum;
  private int secretcode;

  public int getCardnum() {
    return cardnum;
  }

  public void setCardnum(int cardnum) {
    this.cardnum = cardnum;
  }

  public void setSecretcode(int secretcode) {
    this.secretcode = secretcode;
  }

  public int getSecretcode() {
    return secretcode;
  }

}
