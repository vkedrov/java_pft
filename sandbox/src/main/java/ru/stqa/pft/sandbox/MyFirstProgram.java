package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {

    double len;

    Point t1 = new Point(2,2);
    Point t2 = new Point(4,4);

    len = Math.sqrt(Math.pow(t2.x-t1.x,2)+Math.pow(t2.y-t1.y,2));

    System.out.println("Hello, world! " + len + " " + distance(t1, t2) + " " + t1.dist(t2));

  }

  public static double distance (Point t1, Point t2) {

    return Math.sqrt(Math.pow(t2.x-t1.x,2)+Math.pow(t2.y-t1.y,2));
  }

}