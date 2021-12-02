Feature: Manipulation d'un portefeuille

  Gestion d'un portefeuille
  - On peut à tout moment connaître le contenu de son portefeuille.
  - On peut ajouter et supprimer de l'argent dans son portefeuille.
  - Le nouveau solde est automatiquement calculé

  Scenario: Ajout d'argent dans un portefeuille

    When Je créé un portefeuille avec 100.0 €
    And J'ajoute 20.0 €
    Then Le nouveau solde est 120.0 €

  Scenario: Retirer de l'argent dans un portefeuille

    When Je créé un portefeuille avec 100.0 €
    And Je retire 20.0 €
    Then Le nouveau solde est 80.0 €