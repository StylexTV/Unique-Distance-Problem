# Unique-Distance-Problem

This is a simple program that exhaustively computes the number of possible solutions to arrange `n` pieces on an `n x n` grid such that each possible pairing has a unique distance compared to all the other different pairings.

Program output:

```
n = 1, solutions = 1

X

n = 2, solutions = 2

X .
. X

X X
. .

n = 3, solutions = 5

X X .   X X .
. . .   . . .
. . X   . X .

X X .   X . .
. . .   . X X
X . .   . . .

X X .
. . X
. . .

n = 4, solutions = 23

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

n = 5, solutions = 35

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

n = 6, solutions = 2

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

n = 7, solutions = 1

X . X . . . .
. . X . . . .
. . . . . . X
X . . . . . .
. . . . . . .
. . . . . X .
. . . . . . X

...

```
