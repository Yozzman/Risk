## NFP121 - Projet RISK

Suite à la présentation de notre projet, nous avons pris un moment pour améliorer notre projet.
Nous nous sommes posés et avions discuter sur le sujet.
L'objectif était d'avoir une vision commune afin de rendre un projet correcte et qui fonctionne.

Voici les évolutions que nous avions faite :

```
- Nous avons améliorer l'affichage de l'interface graphique pour rendre le jeu plus agréable et plus facile à utiliser.
- Nous avons amélioré les différentes phases de jeu pour qu'elle fonctionne le plus fidèlement possible au jeu réel.
- Nous avons également essayer d'implémenter des patterns dans notre code.
```


#### 1) Singleton (Un pattern de type création)

Nous avons implémenté le pattern Singleton dans la classe `Carte`. Cela nous permet de garantir qu'il y a qu'une seule instance de la carte du monde et que toutes les parties du code manipulent la même instance de la carte. Cela nous permet de gérer le jeu de manière plus simple et plus efficace.

#### 2) Builder (Un pattern de type création)

Nous avons implémenté le pattern Builder dans la classe 'Pays'. Cela nous permet d'initialiser un pays de manière flexible et simple. Nous pouvons créer un pays avec ses propriétés par étape, en utilisant une méthode `Builder` qui utilise un builder pour créer et ajouter un pays à la carte du monde. Certains des attributs de pays peuvent être initialiser de manière optionnels.


#### 3) Façade (Un pattern de type structure)

Nous avons sans le svoir implémenté le pattern façade dans la classe `Partie`. Cela nous permet d'encapsuler les différentes phases de jeu dans une classe. Le point d'entrée de notre application (`Jeu.main`) n'a pas besoin de connaître la complexité de l'enchaînement des tours, des phases, ou de la gestion des joueurs. Il lui suffit d'instancier `Partie` et d'appeler la méthode `demarrer()`. Cette méthode simple masque toute la logique complexe, offrant une interface de haut niveau très facile à utiliser.

### 3. Patterns de Comportement

Ces patterns se concentrent sur la manière dont les objets communiquent et collaborent.

#### Stratégie (Un pattern de comportement)

Nous avons implémenté le pattern Stratégie dans la classe `PhaseJeu`. Cela nous permet de choisir la stratégie de chaque phase de jeu en fonction de l'objet de jeu. Cela nous permet de rendre le code plus modulaire et plus flexible. Nous pouvons ajouter de nouvelles stratégies de jeu sans modifier le code existant.

### Conclusion

L'utilisation de ces patterns nous offre une architecture à la fois robuste, flexible et facile à faire évoluer. La séparation des responsabilités est claire, ce qui sera un atout majeur pour les développements futurs, comme l'intégration d'une IA ou de règles plus complexes.

