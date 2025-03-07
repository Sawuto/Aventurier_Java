# **Projet : Déplacement du Héros sur une Carte**

## 📌 Description
Ce projet est une application **Java** permettant de simuler le déplacement d'un héros sur une carte à partir d'un fichier de configuration.
Le héros doit éviter les obstacles et respecter les limites de la carte.

---

## 🛠️ Technologies utilisées
- **Java 17+**
- **Swing** (pour la sélection de fichiers)
- **JUnit 4** (pour les tests unitaires)

---

## 🚀 Installation & Exécution
### 1. **Cloner le projet**
```sh
git clone https://github.com/ton-repo/nom-du-projet.git
cd nom-du-projet
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

## 📂 Structure du projet
```
/nom-du-projet
│── src/
│   ├── App/          # Classe principale
│   ├── controleur/   # Gestion des déplacements
│   ├── modele/       # Classes de la carte et du héros
│   ├── vue/          # Affichage de la carte
│── test/             # Tests unitaires avec JUnit
│── README.md         # Documentation du projet
│── .gitignore        # Fichiers à ignorer dans Git
```

---

## 📜 Fichiers requis
### 1. **Fichier de configuration**
Doit contenir :
```
x,y
Mouvements
```
**Exemple :**
```
1,1
SSEE
```

### 2. **Fichier de carte**
Représentation ASCII de la carte :
```
#####
#   #
# # #
#   #
#####
```

---

## 🧪 Tests
Les tests unitaires utilisent **JUnit 4**.
Pour les exécuter :
```sh
javac -cp "libs/junit-4.13.2.jar;bin" -d bin test/*.java
java -cp "libs/junit-4.13.2.jar;bin" org.junit.runner.JUnitCore test.CarteTest
```

---

## 💪 Contributions
Les contributions sont les bienvenues !

1. Forke le projet
2. Crée une branche (`git checkout -b feature/ma-feature`)
3. Fais un commit (`git commit -m "Ajout de ma feature"`)
4. Pousse la branche (`git push origin feature/ma-feature`)
5. Fais une **Pull Request** 🚀

---

## 🏆 Licence
Ce projet est sous licence **MIT**.

---

📚 **Auteur** : [Ton Nom](https://github.com/ton-profil) | 🌐 [Repo GitHub](https://github.com/ton-repo/nom-du-projet)

