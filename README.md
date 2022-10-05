# ESGI - Design Pattern en JAVA
---------
## Rendu

La solution contenant les patrons implémentés se trouve à cet emplacement:  
`/src/main/java`

J'ai réalisé un fichier Main qui execute les differents design pattern dans `org.example`

Chaque projet contient un exemple de design pattern et est représenté sous la forme d'une application console.  
Tous les détails spécifiques au design pattern exécuté sont affichés la console.  

Resultat d'une execution : 
```console
------------------------------------------------------------------------------------------
Abstract Factory
------------------------------------------------------------------------------------------

Initialisation d'une chaise de type Gaming : 
-------------------------------------------------------
Class Name : GamingChair
Seat material : Plastic
Seat cover material : Synthetic
has wheels ? : true
-------------------------------------------------------
Initialisation d'une chaise de type Office : 
-------------------------------------------------------
Class Name : OfficeChair
Seat material : steel
Seat cover material : leather
has wheels ? : true
-------------------------------------------------------
Initialisation d'une chaise de type Rockingchair : 
-------------------------------------------------------
Class Name : RockingChair
Seat material : wood
Seat cover material : wood
has wheels ? : false
-------------------------------------------------------
------------------------------------------------------------------------------------------
Adapter
------------------------------------------------------------------------------------------

resultat de la méthode getData avant utilisation de l' adapter : 51208cc007009b98996d78b851b864405d17060aedee56f527d013dfde6df500f817c51571a1812c66152ff16c305100c4d1780dda8f404635e40d2dec4f3ccc93d438342aabe25948aab64d1c8303e3
resultat de la méthode getData après utilisation de l' adapter : 
[81, 32, -116, -64, 7, 0, -101, -104, -103, 109, 120, -72, 81, -72, 100, 64, 93, 23, 6, 10, -19, -18, 86, -11, 39, -48, 19, -33, -34, 109, -11, 0, -8, 23, -59, 21, 113, -95, -127, 44, 102, 21, 47, -15, 108, 48, 81, 0, -60, -47, 120, 13, -38, -113, 64, 70, 53, -28, 13, 45, -20, 79, 60, -52, -109, -44, 56, 52, 42, -85, -30, 89, 72, -86, -74, 77, 28, -125, 3, -29]
------------------------------------------------------------------------------------------
Chain of responsibility
------------------------------------------------------------------------------------------

reception de la requete 0
 --> Password OK
Votre email est invalide
reception de la requete 1
Votre mot de passe n'est pas assez long
reception de la requete 2
 --> Password OK
 --> Email OK
Nom d'utilisateur invalide
reception de la requete 3
 --> Password OK
 --> Email OK
 --> Username OK
```
---------

## Table des matières
- [Pattern de conception](#pattern-de-conception)
    - [Abstract factory](#abstract-factory)
- [Pattern de structuration](#pattern-de-structure-ou-de-structuration)
    - [Adapter](#adapter)
- [Pattern de comportement](#pattern-de-comportement)
    - [Chain of Responsability](#chain-of-responsability)

---------

## Pattern de conception
Permet de faciliter et optimiser la conception d'objet dans une application.

### Abstract Factory

> `Abstract Factory` est un patron de conception qui permet de créer des familles d’objets apparentés sans préciser leur classe concrète.  
> Source: [Refactoring.guru](https://refactoring.guru/fr/design-patterns/abstract-factory)

Ce pattern aide à la création d'objet, le but est de regrouper les objets en famille sans avoir à connaitre la base de ces objets.

`Abstract Factory` va permettre de déresponsabiliser la classe mère.  
Pour cela, nous utilisons une interface qui va contenir des signatures de méthodes.

Le design pattern `Abstract Factory` est composé de plusieurs structures dans notre exemple :

- **Les produits Abstraits** : ils déclarents une interfaces pour un ensembles d'objets qui peuvents être rassemblés
  dans une même famille. Dans notre exemple il s'agit de `Chair.java`.
- **Les produits concret** : Ce sont des implémentations des produits abstraits qui représente les différents 
  variantes possibles dans la factory. Dans notre exemple il sagit de `GamingChair.java`, `OfficeChair.java`, `RockingChair.java`.
- **La fabrique abstraite** : Interface qui déclare les méthodes pour créer les produits abstraits. Dans notre exemple `ChairFactory.java`
  déclare la méthode de création d'une chaise `createChair()`.
- **Les fabriques concrètes** : Classe qui implémentent les méthodes de créations d'objets de la fabrique abstraites. Dans notre exemple
  `GamingChairFactory.java`, `OfficeChairFactory.java`, `RockingChairFactory.java`.
 
Dans mon exemple j'ai crée une classe `Client.java` qui va intéragir avec les interfaces abstraites pour créer 
n'importe qu'elle variantes du produit `Chaise` :  `gaming`, `office` ou `rockingchair` sans préciser leurs classes concrètes.

----------
### Adapter

Le pattern `Adapter` est un connecteur entre 2 interface incompatible qui ne pourrait normalement pas pouvoir communiquer 
ensemble. Nous allons donc wrapper les classes existantes avec une nouvelle interface qui elle sera compatible avec l'interface
clientes.

Dans notre exemple nous avons un objet `HexadecimalData` qui renvoie des données dans un format hexadecimal sous forme de String,
cependant notre application utilise des tableaux d'octet pour fonctionner.

Nous allons donc créer une interface `DataAdapter` qui déclare le protocole que les autres classes doivent implémenter
pour interagir avec notre application, ici une méthode `getData()` qui renvoie un tableau d'octets.

Ensuite nous avons crée L'adapteur `DataAdapterImpl`, qui est une classe qui implémente l'interface `DataAdapter` et qui intéragit avec le service
tier et notre client. Cette classe va donc recevoir les données en hexadimal et les convertir en tableaux d'octets. 

### Chain of Responsibility

Chaîne de responsabilite est un design pattern comportemental qui permet de fair circuler des actions dans une chaînes de handlers.
Chacun de ces handlers peut décider de traiter la demande ou de l'envoyer au handler suivant.

Dans notre exemple nous allons imaginer un processus d'inscription, Lorsque notre client va recevoir une requête d'inscription 
nous allons réaliser une série de traitements, vérifier le nom d'utilisateur, le mail puis le mot de passe.

Nous allons donc créer un Handler `RegisterProcessor.java`, c'est lui qui va dispatcher les requêtes aux différents Handlers.
Ensuite nous allons coder les HandlerConcret qui sont les handlers qui réalise les traitements : `PasswordProcessor`, `UsernameProcessor` et `emailProcessor`.

Ensuite dans le client nous allons créer la chaîne d'action : 
```java
    RegisterProcessor chain = new PasswordProcessor(new EmailProcessor(new UsernameProcessor(null)));
```
L' ordre des vérifications de la chaîne va donc être : Mot de passe, Email puis Username.


