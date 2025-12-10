@US23
Feature: chercher un produit dans le catalogue
  je veux chercher un produit avec le nom et verifier son detail

  @CT_SEARCH_PRODUIT
  Scenario Outline: chercher produit
    Given ouvrir navigateur chrome
    And saisir url "https://automationexercise.com"
    Then verifier que la couleur de menu home est "rgba(255, 165, 0, 1)"
    When cliquer sur le bouton products
    Then verifier affichage de "ALL PRODUCTS"
    When saisir le nom de produit suivant "<produit>"
    And cliquer sur le bouton search
    Then verifier affichage de text "SEARCHED PRODUCTS"
    And verifier le prix produit affiche "<prix>"

    Examples: 
      | produit                         | prix |
      | Blue Top                        |  500 |
      | Fancy Green Top                 |  700 |
      | Printed Off Shoulder Top- White |  315 |
