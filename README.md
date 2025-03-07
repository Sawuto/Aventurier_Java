# **Projet : Déplacement du Héros sur une Carte**

## Description
Ce projet est une application **Java** permettant de simuler le déplacement d'un héros sur une carte à partir d'un fichier de configuration.
Le héros doit éviter les obstacles et respecter les limites de la carte.

---

## Technologies utilisées
- **Java 21**
- **Swing** (pour la sélection de fichiers)
- **JUnit 4** (pour les tests unitaires)

---

## Installation & Exécution
### 1. **Cloner le projet**
```sh
git clone (https://github.com/Sawuto/Aventurier_Java.git)
cd Aventurier_java
```

### 2. **Compiler le projet**
Dans un terminal, exécute la commande suivante :
```sh
javac -d bin -sourcepath src src/App/App.java
```

### 3. **Exécuter le programme**
```sh
java -cp bin App.App
```
Une boîte de dialogue permettra de sélectionner les fichiers de configuration et de carte.

---

## Structure du projet
```
/aventurier_java
|── /Readme                  # Contient la documentation principale du projet
|── /aventurier               # Dossier principal contenant le code source du jeu
    ├── /src/                # Dossier source contenant tout le code Java
    │   ├── /App/            # Classe principale, point d'entrée du jeu
    │   ├── /controleur/     # Gestion des déplacements et des actions du héros
    │   ├── /modele/         # Modèles représentant la carte, le héros, etc.
    │   ├── /vue/            # Affichage de la carte et des éléments graphiques
    ├── /test/           # Contient les tests unitaires utilisant JUnit
    ├── /doc/                # Documentation du projet (par exemple, architecture, fonctionnements)
    ├── /lib/                # Bibliothèques externes nécessaires au projet
    │   ├── junit-4.13.2.jar         # Bibliothèque JUnit pour les tests
    │   ├── hamcrest-core-1.3.jar    # Bibliothèque Hamcrest pour les tests
    ├── /bin/                # Dossier contenant les fichiers compilés (.class)
    ├── /fichier_test/       # Fichiers utilisés pour les tests du jeu (cartes, scénarios)
    ├── .gitignore           # Fichiers ou dossiers à ignorer par Git (par exemple, compilations)

```

---

## Sélection des fichiers
Lors de l'exécution du programme, une boîte de dialogue s'ouvrira pour choisir les fichiers nécessaires :

1. **Sélection du fichier de configuration**  
   - Ce fichier doit contenir la position initiale du héros et la liste des déplacements.
   - Exemple :
     ```
     1,1
     SSEE
     ```

2. **Sélection du fichier de carte**  
   - Ce fichier représente la carte en ASCII avec des `#` pour les murs et des espaces pour les zones accessibles.
   - Exemple :
```
###    ######    ###
###      ##      ###
##     ##  ##     ##
#      ##  ##      #
##                ##
#####          #####
###### ##  ##  #####
 #     ######     # 
     ########       
    ############    
    ############    
     ########      #
 #     ######     ##
###### ##  ## ######
#####          #####
##                ##
#   ## #    # ##   #
##   ##      ##   ##
###    #    #    ###
###    ######    ###
```
Une fois les fichiers sélectionnés, le programme chargera la carte et effectuera les déplacements du héros en évitant les obstacles et en respectant les limites.
---

## Tests
Les tests unitaires utilisent **JUnit 4**.

Configuration des bibliothèques
Assurez-vous d'ajouter **JUnit** et **Hamcrest** dans le dossier `lib` et de les inclure dans le **Build Path** de votre projet.

Exécution des tests
Pour exécuter les tests :
```sh
javac -cp "libs/junit-4.13.2.jar;bin" -d bin test/*.java
java -cp "libs/junit-4.13.2.jar;bin" org.junit.runner.JUnitCore test.CarteTest
```

---


**Auteur** : Enzo Saccone (https://github.com/Sawuto) | 🌐 [Repo GitHub](https://github.com/Sawuto/Aventurier_Java.git)
