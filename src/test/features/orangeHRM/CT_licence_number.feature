
@tag
Feature: licence number
je veux m'authentifier et verifier le numero de licence number

  @tag1
  Scenario: licence number valide
    Given ouvrir chrome
    And saisir URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When saisir le username "Admin"
    And saisir mot de passe "admin123"
    And cliquer sur le bouton login
    Then verifier nom profil "Test User"
    When cliquer sur le bouton My info
    Then verifier le numero de licence "56788"

  