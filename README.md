# Unique Distance Problem

This is a simple program that exhaustively computes the number of possible solutions to arrange `n` pieces on an `n x n` grid such that each possible pairing has a unique distance compared to all the other different pairings.

Program output:

```java
n = 1, solutions = 1, time = 0s

X

n = 2, solutions = 2, time = 0s

X .
. X

X X
. .

n = 3, solutions = 5, time = 0s

X X .   X X .
. . .   . . .
. . X   . X .

X X .   X . .
. . .   . X X
X . .   . . .

X X .
. . X
. . .

n = 4, solutions = 23, time = 0s

X X . .   X X . .   X X . .   X X . .
. . . .   . . . .   . . . .   . . . X
. . . .   . . X .   X . . .   . . . .
. X . X   . . . X   . . . X   . . . X

X . . .   X . . X   . X X .   X X . .
. . . X   . . . .   . . . .   . . . .
. . X .   . X . .   . X . .   . X . .
. . X .   . . X .   . . X .   . . X .

X . X .   X X . .   . X X .   X X . .
. . . X   . . X .   X . . .   . . . .
. . . .   . . . .   . . . .   . . . X
. . X .   . . X .   . . X .   . X . .

X X . .   X . . X   . X X .   X X . .
. . . .   . . . .   . . . .   . . . .
. . X .   . X . .   X . . .   X . . .
. X . .   . X . .   . X . .   . X . .

X . . X   X X . .   X . X .   X X . .
. X . .   . . . .   . . X .   . . X .
. . . .   . X . .   . . . .   . . . .
. X . .   X . . .   X . . .   X . . .

X X . .   X . . .   X . X .
. . . .   . X . X   . . . X
X . . X   . . . X   . . . X
. . . .   . . . .   . . . .

n = 5, solutions = 35, time = 0s

X X . . .   X X . . .   X X . . .   X X . . .   X . X . .
. . X . .   . . . . .   . . . . .   . . X . .   . . . . .
. . . . .   . . . . .   . . . . .   . . . . .   . . . . .
. . . . .   . . . X .   . . X . .   . . . . .   . . X X .
. . X . X   . X . . X   . X . . X   . X . . X   . . . . X

X X . . .   X X . . .   X X . . .   X X . . .   X X . . .
. . . . .   . . . . X   . . . . .   . . X . .   . . . . X
X . . . .   . . . . .   . X . . .   . . . . .   . . . X .
. . . X .   . . . X .   X . . . .   X . . . .   . . . . .
. . . . X   . . . . X   . . . . X   . . . . X   . . . . X

X X . . .   X . . X .   X . X . .   X . . X .   X . . X .
. . X . X   . . . . .   . . . . .   . X . . .   . . . . .
. . . . .   . . . . .   . . . . .   . . . . .   . . . . .
. . . . .   . X . . .   X . . . .   . . . . .   . X . . .
. . . . X   . . X X .   . . X X .   . . X X .   . X . X .

X X . . .   X X . . .   X . X . .   X X . . .   . X X . .
. . . X .   . . . . .   . . X . .   . . X . .   . . . . .
. . . . .   . . . . .   . . . . .   . . . . .   . X . . .
. . . . .   . . X . .   . . . . .   . . . . .   . . . . X
. X . X .   X . . X .   X . . X .   X . . X .   . . . X .

X . X . .   X . . . .   . X . . .   X X . . X   X X . . X
. . . . .   . X . . X   X . . . .   . . . . .   . . . . .
. . . . X   . . . . .   . . . X X   . . . X .   . X . . .
. . . X .   . . . X .   . . . . .   . . . . .   . . . . .
. . . X .   . . . X .   . . . X .   . . . X .   . . . X .

X . X . .   X . X X .   X X . . .   X . . . X   X . X . .
. . . . .   . . . . .   . . . . .   . X . . .   . . . X .
. . . . .   . . . . .   X . . . .   . X . . .   . . . . .
. . . X X   . . . . X   . . . X .   . . . . .   . . . . X
. . X . .   . . X . .   . . X . .   . X . . .   X . . . .

X . X . .   X . . . .   . X X . .   X X . . .   X . X . .
. . . X X   . X . . X   X . . . .   . . . . .   . . . . .
. . . . .   . . . . .   . . . . .   X . . X .   . . . . X
. . . . .   . . . X X   . . X . X   . . . . X   . . X X .
X . . . .   . . . . .   . . . . .   . . . . .   . . . . .

n = 6, solutions = 2, time = 0s

X X . . . .
. . . X . .
. . . . . .
. . . . . X
. . . . . .
. . X . . X

X . X . . X
. . . . . .
. . . . . .
. . . X . .
. . . . X .
. . . . X .

n = 7, solutions = 1, time = 0.3s

X . X . . . .
. . X . . . .
. . . . . . X
X . . . . . .
. . . . . . .
. . . . . X .
. . . . . . X

n = 8, solutions = 0, time = 0.9s

n = 9, solutions = 0, time = 8.8s

n = 10, solutions = 0, time = 28.6s

...

```
