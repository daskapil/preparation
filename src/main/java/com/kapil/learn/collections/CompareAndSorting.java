package com.kapil.learn.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Demonstrate the use of java.lang.Comparable and java.util.Comparator interfaces
 *      - Both are used for sorting the objects
 *      - Comparable is Called Natural ordering i.e. element itself tells the default ordering
 *      - Comparator is Total ordering - precise control over ordering
 *      - if both used, Comparator takes precedence
 * */
public class CompareAndSorting {

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        Player player4 = new Player(1, "Messi", 19);
        Player player5 = new Player(2, "Ronaldo", 21);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);
        footballTeam.add(player4);
        footballTeam.add(player5);

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam, new PlayAgeComparator());//Compile-time error if Player class does not implement Comparable interface
        System.out.println("After Sorting : " + footballTeam);
    }
}

class Player implements Comparable<Player> {
    private int ranking;
    private String name;
    private int age;

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Player otherPayer) {
        return Integer.compare(getRanking(), otherPayer.getRanking());
    }
    /* @Override
    public int compareTo(Object o) {
        return Integer.valueOf(getRanking()).compareTo((((Player) o).getRanking()));
    }*/
}

class PlayAgeComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class PlayNameComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return String.valueOf(o1.getName()).compareTo(o2.getName());
    }
}


