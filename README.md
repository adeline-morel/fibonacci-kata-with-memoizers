# Suite de Fibonacci en Java avec Memoizers

Un memoizer en Java est une technique d'optimisation qui permet de stocker les résultats des appels de fonction précédents pour éviter de recalculer les mêmes résultats à l'avenir. Cela est particulièrement utile pour les fonctions récursives qui peuvent avoir des appels répétés avec les mêmes arguments.

## Comment fonctionne un Memoizer ?
Stockage des Résultats : Un memoizer utilise généralement une structure de données comme une HashMap pour stocker les résultats des appels de fonction. La clé est l'argument de la fonction, et la valeur est le résultat correspondant.

Vérification avant Calcul : Avant de calculer le résultat d'une fonction, le memoizer vérifie si le résultat est déjà présent dans la HashMap. Si c'est le cas, il retourne le résultat stocké. Sinon, il calcule le résultat, le stocke dans la HashMap, puis le retourne.

## Exemple d'utilisation d'un Memoizer en Java
Voici un exemple simple d'utilisation d'un memoizer pour une fonction qui calcule la somme des nombres de 1 à n :

```java
import java.util.HashMap;
import java.util.Map;

public class SimpleMemoizerExample {

    // Map pour stocker les résultats des appels précédents
    private Map<Integer, Integer> memo = new HashMap<>();

    // Fonction pour calculer la somme de 1 à n avec memoization
    public int sum(int n) {
        // Vérifie si le résultat est déjà calculé
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Calcul du résultat si non présent dans le memo
        int result;
        if (n == 1) {
            result = 1;
        } else {
            result = n + sum(n - 1);
        }

        // Stockage du résultat dans le memo
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        SimpleMemoizerExample example = new SimpleMemoizerExample();
        System.out.println(example.sum(5)); // Calculera et stockera les résultats
        System.out.println(example.sum(5)); // Utilisera le résultat stocké
    }
}
```

## Explications :
**HashMap** `memo` : Utilisée pour stocker les résultats des appels précédents. La clé est l'argument de la fonction `(n)`, et la valeur est la somme des nombres de 1 à `n`.

**Vérification dans** `memo` : Avant de calculer la somme, la fonction vérifie si le résultat est déjà présent dans `memo`. Si oui, elle retourne directement ce résultat.

**Calcul et Stockage** : Si le résultat n'est pas dans `memo`, la fonction calcule la somme, stocke le résultat dans `memo`, puis le retourne.

Cette approche peut grandement améliorer les performances des fonctions récursives en évitant les calculs redondants.

Sur son repository où il liste différents design patterns en proposant des exemples d'implémentations, Rémi Forax propose deux versions d'implémentation de Memoizer en Java :
- [memoizer1.java](https://github.com/forax/design-pattern-reloaded/blob/2fc54386187c199e82eba54bd8bb5353d3771267/src/main/java/memoizer/memoizer1.java)
- [memoizer2.java](https://github.com/forax/design-pattern-reloaded/blob/2fc54386187c199e82eba54bd8bb5353d3771267/src/main/java/memoizer/memoizer2.java)

Mon but : les utiliser dans le cadre de la suite de Fibonacci.

## Qu'est-ce que la suite de Fibonacci ?

La suite de Fibonacci est une série de nombres dans laquelle chaque nombre est la somme des deux précédents. Elle commence généralement par 0 et 1. Voici les premiers termes de la suite :

0, 1, 1, 2, 3, 5, 8, 13, 21, 34,…

Formule Récursive :

F(0) = 0
F(1) = 1
F(n) = F(n − 1) + F(n − 2) pour n ≥ 2

### Contexte Historique et Applications
#### Origine :
La suite de Fibonacci a été décrite pour la première fois par Leonardo Fibonacci, un mathématicien italien, dans son livre "Liber Abaci" publié en 1202. Elle est née de l'étude de la croissance idéalisée d'une population de lapins.

#### Applications :
La suite de Fibonacci apparaît dans divers domaines, notamment :

- Biologie : Modélisation de la croissance des plantes et des populations animales.
- Informatique : Algorithmes de recherche et d'optimisation, comme la recherche de Fibonacci.
- Art et Musique : Composition et design, souvent en lien avec le nombre d'or.
- Finance : Analyse technique des marchés boursiers.

#### Propriétés Mathématiques :
La suite de Fibonacci est étroitement liée au nombre d'or, souvent noté ϕ, qui est approximativement 1,61803. Le ratio de deux nombres consécutifs de la suite tend vers  ϕ à mesure que les nombres augmentent.

La suite de Fibonacci est un exemple fascinant de la manière dont une simple relation récursive peut générer une séquence de nombres ayant des propriétés riches et des applications variées.

## Description du Kata

### Objectif :
Écrire une fonction qui retourne le nombre à la position p dans la suite de Fibonacci.

### Consignes :

#### Initialisation :
Les deux premiers nombres de la suite sont 0 et 1.

#### Calcul :
Chaque nombre suivant est la somme des deux précédents.
- Entrée : Un entier p représentant la position dans la suite (en commençant par 0).
- Sortie : Le nombre à la position p dans la suite de Fibonacci.

#### Contraintes :
p est un entier positif ou zéro.
Gérer les cas où p est 0 ou 1.

#### Exemple :

Pour p = 5, la sortie doit être : 3
Pour p = 10, la sortie doit être : 34