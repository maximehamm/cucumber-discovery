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

    @And("Je retire {double} €")
    public void withdraw(double amount) {
        wallet.withdraw(amount);
    }

    @When("Je rajoute {double} €")
    public void add(double amount) {
        wallet.add(amount);
    }

    @Then("Le nouveau solde est {double} €")
    public void checkSolde(double amount) {
        assertEquals(amount, wallet.getBalance());
    }

    @Then("that's it !")
    public void thatSIt() {
    }
}
