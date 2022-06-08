Pour générer le jar de l'application:
  mvn clean install

Pour tester:
il suffit de lancer cette commande avec en paramètre le fichier de test
java -jar "jar path dans le dossier target" "test file path"

exemple:

java -jar C:\workspace\tondeuse\target\tondeuse-1.0-SNAPSHOT.jar C:\Documents\tondeuse.txt
