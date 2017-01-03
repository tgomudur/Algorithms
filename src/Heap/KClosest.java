package Heap;

import java.util.*;
/**
 * Created by tharun on 1/2/17.
 */

class PointComparator implements Comparator<Point>{
    Point origin;
    PointComparator (Point origin) {
        this.origin = origin;
    }

    @Override
    public int compare(Point p1, Point p2){
        double dist1 = Math.pow((p1.x - origin.x), 2) + Math.pow((p1.y - origin.y), 2);
        double dist2 = Math.pow((p2.x - origin.x), 2) + Math.pow((p2.y - origin.y), 2);
        return (int) (dist1 - dist2);
    }
}

class KClosestSolution {
    public void findKClosest(Point[] points, int k) {
        Point origin = new Point(0, 0);
        PointComparator pointComparator = new PointComparator(origin);
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, pointComparator);

        for (Point element : points) {
            if (maxHeap.size() < k) maxHeap.add(element);
            else{
                if (pointComparator.compare(maxHeap.peek(), element) > 0) {
                    maxHeap.remove();
                    maxHeap.add(element);
                }
            }
        }

        for (Point element : maxHeap) {
            System.out.println(element.x);
            System.out.println(element.y);
            System.out.println();
        }
//        System.out.println(maxHeap);

    }
}
public class KClosest {
    public static void main (String[] args) {
        KClosestSolution s = new KClosestSolution();
        Point[] points = new Point[10];
        for (int i = 0; i < 10; i++){
            points[i] = new Point(i, i);
        }
        s.findKClosest(points , 5);
    }
}

