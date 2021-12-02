package org.maxime.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static junit.framework.Assert.assertEquals;

public class WalletTest {

    private Wallet wallet;

    @When("Je créé un portefeuille avec {double} €")
    public void create(double amount) {
        wallet = new Wallet(amount);
    }

}
