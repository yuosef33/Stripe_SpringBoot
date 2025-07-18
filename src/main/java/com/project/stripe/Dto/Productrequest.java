package com.project.stripe.Dto;

public class Productrequest {
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;

    public Productrequest() {
    }

    public Productrequest(Long amount, Long quantity, String name, String currency) {
        this.amount = amount;
        this.quantity = quantity;
        this.name = name;
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
