package ru.stqa.pft.sandbox;

public class Point {

  double x;
  double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;

  }

  public double dist(Point t2) {
    return Math.sqrt(Math.pow(t2.x-this.x,2)+Math.pow(t2.y-this.y,2));

  }

}
