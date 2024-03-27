Feature: Sending emails with attachments

  We need to send emails with files attachments
  There is maximum size per email
  We need to send multiple files, but as less as possible

  Scenario: 1

    Given The maximum size for an email is 8 Mb
    And We have this set of attachments :
      | File name | Size |
      | a         | 5    |
      | b         | 10   |
      | c         | 3    |
    And We prepare emails
    Then An errors occurs because file "b" size exceeded the limit

    Given The maximum size for an email is 12 Mb
    Then We expect to have 2 mails :
      | File names | Total size |
      | b          | 10         |
      | a, c       | 8          |

  Scenario: 2
    Given The maximum size for an email is 20 Mb
    And We have this set of attachments :
      | File name | Size |
      | a         | 2    |
      | b         | 14   |
      | c         | 6    |
      | d         | 18   |
    And We prepare emails
    Then We expect to have 2 mails :
      | File names | Total size |
      | a, d       | 20         |
      | b, c       | 20         |

    Given The maximum size for an email is 18 Mb
    And We prepare emails
    Then We expect to have 3 mails :
      | File names | Total size |
      | d          | 18         |
      | a, b       | 16         |
      | c          | 6          |

  Scenario: 3
    Given The maximum size for an email is 20 Mb
    And We have this set of attachments :
      | File name | Size |
      | a         | 2    |
      | b         | 17   |
      | c         | 18   |
      | d         | 2.5  |
    And We prepare emails
    Then We expect to have 2 mails :
      | File names | Total size |
      | a, c       | 20         |
      | b, d       | 19.5       |

  Scenario: 4
    Given The maximum size for an email is 20 Mb
    And We have this set of attachments :
      | File name | Size |
      | a         | 9    |
      | b         | 4    |
      | c         | 18   |
      | d         | 8    |
    And We prepare emails
    Then We expect to have 3 mails :
      | File names | Total size |
      | c          | 18         |
      | a, d       | 17         |
      | b          | 4          |