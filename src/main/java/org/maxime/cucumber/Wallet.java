package org.maxime.cucumber;

/**
 * Un portefeuille contient de l'argent. On peut en ajouter ou en retirer
 */
public class Wallet {

    private double balance;

    /**
     * Créer un nouveau portefeuille
     * @param montantInitial Le montant initial
     */
    public Wallet(double montantInitial) {
        this.balance = montantInitial;
    }
}
