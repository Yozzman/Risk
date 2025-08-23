# RISK – Jeu de stratégie (Java, Console)

Implémentation console du jeu RISK avec gestion des tours, des phases (renforts, attaques, déplacements), attribution des pays et affichage en console.

## Fonctionnalités

- Partie de 2 à 5 joueurs avec saisie des noms.
- Phases par tour:
    - Renforts: calcul automatique et distribution.
    - Attaque: contrôle des règles (propriété, voisinage, troupes min.), résolution via aléatoire.
    - Déplacement: mouvements entre pays adjacents en conservant au moins 1 troupe.
- Attribution initiale des pays, affichage de la carte après les actions.
- Console interactive (prompts clairs) et effets visuels (clear écran, barre de chargement).


## Architecture (résumé et simple)

- pf.yozzman.risk.phase
    - Partie: orchestration (initialisation, boucle de jeu, victoire).
    - PhaseRenforts, PhaseAttaque, PhaseDeplacement: logique de chaque phase.
- pf.yozzman.risk.model
    - Joueur, ListeJoueur, Pays, Troupe (+ Carte/Armee attendues par le code).
- pf.yozzman.risk.util
    - ConsoleReader/ConsoleWriter: entrées/sorties console.
    - BarreChargement: barre de progression simple.

Note: Les classes Carte et Armee sont requises par les phases et doivent fournir au minimum: initialiserPays, assignerPays, calculRenforts, distribuerRenfortsAuto, getPaysByName, attaquer, deplacer, afficherCarte, estVictoire.

## Prérequis et installation (simple)

- Java 17+
- Maven (si build Maven)
- Terminal compatible ANSI (pour le nettoyage d’écran)

Cloner le projet:

- git clone git@github.com:Yozzman/Risk.git
- cd Risk


## Build avec Maven

- mvn clean -U install test-compile

Le JAR est généré dans target/.

## Exécution (fichier .bat)

Sous Windows:

- Double-cliquer sur execute.bat
- ou depuis un terminal: execute.bat

Assurez-vous que:

- le script .bat pointe vers la classe main (ex. pf.yozzman.risk.Jeu) ou vers le JAR généré;
- la méthode main lance la partie


## Design patterns utilisés (objectif)

- Strategy (phases): chaque phase encapsule sa règle et son flux, facilitant l’évolution indépendante (renforts/attaque/déplacement).
- Facade (Partie): un point d’entrée unique qui simplifie l’utilisation (initialisation, enchaînement des phases, conditions de fin).
- MVC simplifié: Model (Joueur, Pays, Carte), “Contrôleurs” (phases), Vue (console via util) pour séparer responsabilités.
- Repository/Lookup léger (Carte.getPaysByName): accès centralisé aux pays pour réduire le couplage.


## Roadmap

Accompli

- Boucle de jeu multi-joueurs, gestion des tours.
- Phases Renforts, Attaque, Déplacement avec validations principales.
- Interface console robuste (prompts, validation d’entrées).
- Affichage carte et barre de chargement.

À faire

- Compléter Carte et Armee (voisinages, combats, bonus).
- Règles RISK avancées (bonus continents, renfort minimum, dés multiples).
- Normalisation des entrées (casse/accents) et aide à la saisie.
- IA simple pour parties solo.
- Sauvegarde/chargement de partie.
- Tests unitaires (JUnit) et CI.
- Internationalisation (FR/EN).
- Interface graphique (JavaFX) ou client web.


## Licence

Licence: Apache License 2.0

- Réutilisation, modification et distribution permises, y compris usage commercial.
- Obligation de conserver l’avis de licence et de citer les auteurs originaux.
- Exemple d’attribution:
    - “Ce projet dérive de ‘RISK – Jeu de stratégie (Java, Console)’ développé par FIRIAPU Hugues et SIOULT Julien (licence Apache-2.0).”

Le texte complet de la licence Apache-2.0 doit accompagner toute redistribution.

## Auteurs

- `FIRIAPU Hugues` — Étudiant en Licence Informatique au CNAM Polynésie Française, Apprenti analyste développeur chez ONATI
- `SIOULT Julien` — Chef de projet Télécom chez Alliance, Étudiant en Licence Informatique au CNAM Polynésie Française

