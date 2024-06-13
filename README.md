# MeteoCompose

MeteoCompose est une application de météo développée en Kotlin utilisant Jetpack Compose pour l'interface utilisateur et l'architecture MVVM pour la gestion des données. Cette application permet aux utilisateurs de rechercher des informations météorologiques pour une ville donnée.

## Fonctionnalités

- **Recherche Météo** : Permet aux utilisateurs de saisir le nom d'une ville et de récupérer les informations météorologiques actuelles pour cette ville.
- **Affichage des Données Météorologiques** : Affiche la température, l'humidité, la pression atmosphérique et une description de la météo actuelle.
- **Interface Utilisateur Propre et Simple** : Utilise Jetpack Compose pour une interface utilisateur moderne et réactive.

## Architecture

L'application suit l'architecture MVVM (Model-View-ViewModel) pour une séparation claire des responsabilités :

- **Model** : Définit les structures de données et gère la récupération des données depuis l'API météo.
- **View** : Composants Jetpack Compose qui affichent les données à l'utilisateur.
- **ViewModel** : Gère la logique métier et les données de l'interface utilisateur.


## Installation

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/votre-utilisateur/weatherapp.git


