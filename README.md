Projet : Déplacement du Héros sur une Carte
📌 Description
Ce projet est une application Java permettant de simuler le déplacement d’un héros sur une carte à partir d’un fichier de configuration.
Le héros doit éviter les obstacles et respecter les limites de la carte.

🛠️ Technologies utilisées
Java 17+
Swing (pour la sélection de fichiers)
JUnit 4 (pour les tests unitaires)
🚀 Installation & Exécution
1️⃣ Cloner le projet
sh
Copier
Modifier
git clone https://github.com/ton-repo/nom-du-projet.git
cd nom-du-projet
2️⃣ Compiler le projet
Dans un terminal, exécute la commande suivante :

sh
Copier
Modifier
javac -d bin -sourcepath src src/App/App.java
3️⃣ Exécuter le programme
sh
Copier
Modifier
java -cp bin App.App
Une boîte de dialogue te permettra de sélectionner les fichiers de configuration et de carte.

📂 Structure du projet
bash
Copier
Modifier
/nom-du-projet
│── src/
│   ├── App/          # Classe principale
│   ├── controleur/   # Gestion des déplacements
│   ├── modele/       # Classes de la carte et du héros
│   ├── vue/          # Affichage de la carte
│── test/             # Tests unitaires avec JUnit
│── README.md         # Documentation du projet
│── .gitignore        # Fichiers à ignorer dans Git
📜 Fichiers requis
Fichier de configuration : Doit contenir :
Copier
Modifier
x,y
Mouvements
Exemple :
Copier
Modifier
1,1
SSEE
Fichier de carte : Contient une représentation ASCII de la carte :
shell
Copier
Modifier
#####
#   #
# # #
#   #
#####
🧪 Tests
Les tests unitaires utilisent JUnit 4.
Pour les exécuter :

sh
Copier
Modifier
javac -cp "libs/junit-4.13.2.jar;bin" -d bin test/*.java
java -cp "libs/junit-4.13.2.jar;bin" org.junit.runner.JUnitCore test.CarteTest
🤝 Contributions
Les contributions sont les bienvenues !

Forke le projet
Crée une branche (git checkout -b feature/ma-feature)
Fais un commit (git commit -m "Ajout de ma feature")
Pousse la branche (git push origin feature/ma-feature)
Fais une Pull Request 🚀
🏷️ Licence
Ce projet est sous licence MIT.

