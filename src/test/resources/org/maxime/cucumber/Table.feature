Feature: Using data table

  This is the introduction ! Do not hesitate to write fex lines of explanations

  Background:
    * There are my favorite authors
      | FIRST NAME | LAST NAME |
      | Stephen    | King      |
      | Franck     | Herbert   |
      | Charles    | Dickinson |
    Then I have 3 favorites authors

    * I have a library containing some books
      | TITLE             | DATE | AUTHOR             |
      | Marche ou creve   | 1982 | King, Stephen      |
      | Shining           | 1977 | King, Stephen      |
      | La ligne verte    | 1996 | King, Stephen      |
      | Dune              | 1965 | Herbert, Franck    |
      | Le Messie de Dune | 1969 | Herbert, Franck    |
      | Crows             | 1985 | Dickinson, Charles |
    Then I have 6 books

  Scenario: Counting books per authors
    Then Here is my book count (with map)
      | King, Stephen      | 3 |
      | Herbert, Franck    | 2 |
      | Dickinson, Charles | 1 |

  Scenario: Vérifier qu'on retrouve bien le plus vieux livre par author
    Then Here is my oldest per author (with list)
      | AUTHOR             | TITLE   | DATE |
      | King, Stephen      | Shining | 1977 |
      | Herbert, Franck    | Dune    | 1965 |
      | Dickinson, Charles | Crows   | 1985 |

