Feature: Test multi

  Testing multiple examples

  Scenario Outline: Multiple example separated

    When A file is sent
    And The file is a <Nature>
    And The contract is : <Id>, <Company>, <User>, <Date>
    Then The status is <Status>

    Examples: XXX
      | Nature | Id    | Company | User    | Date       | Status |
      | XXXd   | 25485 |         | 859584  | 2022-01-01 | warn   |
      | XXX    |       |         | 1234568 | 2022-01-01 | ok     |
      | XXX    |       | 1234567 | 435489  | 2022-01-01 | warn   |
      | XXX    |       |         |         | 2022-01-01 | ko     |
      | XXX    |       |         | 1234568 |            | ko     |

    Examples: AAA
      | Nature | Id | Company | User | Date | Status |
      | AAA    |    | 2354689 |      |      | ok     |
      | AAA    |    | 2354689 |      |      | ok     |
    
    Examples: BBB
      | Nature | Id   | Company | User   | Date | Status |
      | BBB    |      | 123589  |        |      | ok     |
      | BBB    | 9999 | 123589  |        |      | warn   |
      | BBB    |      | 123589  | 874856 |      | warn   |

    Examples: CCC
      | Nature | Id   | Company | User   | Date       | Status |
      | CCC    |      | 987546  |        | 2022-01-01 | ok     |
      | CCC    | 8756 | 987546  |        | 2022-01-01 | warn   |
      | CCC    |      |         |        | 2022-01-01 | ko     |
      | CCC    |      | 987546  | 874856 | 2022-01-01 | warn   |
      | CCC    |      | 987546  |        |            | ko     |

    Examples: DDD
      | Nature | Id   | Company  | User   | Date       | Status |
      | DDD    |      | 85639528 |        | 1986-10-05 | ok     |
      | DDD    | 8754 | 85639528 |        | 1986-10-05 | warn   |
      | DDD    |      |          |        | 1986-10-05 | ko     |
      | DDD    |      | 85639528 | 874856 | 1986-10-05 | warn   |
      | DDD    |      | 85639528 |        |            | ko     |
      | DDD    |      | 85639528 |        | 1986-10-05 | warn   |

    Examples: EEE
      | Nature | Id   | Company  | User | Date       | Status |
      | EEE    |      |          |      | 1986-10-05 | ko     |
      | EEE    |      | 85639528 |      | 1986-10-05 | ok     |
      | EEE    |      | 85639528 |      | 1986-10-05 | ok     |
      | EEE    | 8558 | 85639528 |      |            | warn   |
      | EEE    |      | 85639528 |      |            | warn   |
