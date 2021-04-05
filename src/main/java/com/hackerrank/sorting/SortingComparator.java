package com.hackerrank.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return score == player.score &&
            Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}

/**
 *  1. decreasing score
 *  2. alphabetically ascending
 *  return:
 *      -1 first < second (first goes before second)
 *      0 first = second
 *      1 first > second (second goes before first)
 */
class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        int firstRule = Integer.compare(a.score, b.score);
        if(firstRule == 0) {
          return a.name.compareTo(b.name);
        }
        return -1 * firstRule;
    }
}


public class SortingComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
