
@tag
Feature: authentification page Home
  en tant qu'utilisateur,je veux me connecter

  @authentification
  Scenario: authentification valide
    Given ouvrir le navigateur chrome
    And saisir url
    When saisir l'adresse email
    And saisir le mot de passe
    And cliquer sur le bouton se connecter
    Then verifier le nom de profil
    

  