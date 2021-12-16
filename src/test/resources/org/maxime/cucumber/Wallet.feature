Feature: Manipulation d'un portefeuille

  Gestion d'un portefeuille
  - On peut à tout moment connaître le contenu de son portefeuille.
  - On peut ajouter et supprimer de l'argent dans son portefeuille.
  - Le nouveau solde est automatiquement calculé

  Background:
    * Je créé un portefeuille avec 100.0 €

  Scenario: Ajout d'argent dans un portefeuille
  Ce premier test vérifie un cas très simple :
    * J'ajoute 20.0 €
    Then Le nouveau solde est 120.0 €

  Scenario: Retirer de l'argent dans un portefeuille
    * Je retire 20.0 €
    Then Le nouveau solde est 80.0 €

  Scenario: A découvert !
    * J'ajoute 20.0 €
    * Je retire 130.0 €
    Then Le nouveau solde est -10.0 €

