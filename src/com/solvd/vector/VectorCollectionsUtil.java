package com.solvd.vector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author asemenkov
 * @since Jun 29, 2021
 */
public class VectorCollectionsUtil implements Comparator<Vector> {

    public static List<TriCoordVector> generateVectors(int size) {
        Random r = new Random(0);
        List<TriCoordVector> vectors = new ArrayList<>();
        for (int i = 0, bound = 100; i < size; i++)
            vectors.add(new TriCoordVector(r.nextInt(bound), r.nextInt(bound), r.nextInt(bound)));
        return vectors;
    }

    @Override
    public int compare(Vector o1, Vector o2) {
        double thisLength = o1.getLength();
        double thatLength = o2.getLength();
        return Double.compare(thisLength, thatLength);
    }

    public static double getMedianLength(List<TriCoordVector> vectors) {
        int size = vectors.size();
        vectors.sort(new VectorCollectionsUtil());
        if (size % 2 == 1) return vectors.get(size / 2).getLength();
        else return (vectors.get(size / 2 - 1).getLength() + vectors.get(size / 2).getLength()) / 2;
    }

    public static List<TriCoordVector> removeShorterVectors(List<TriCoordVector> vectors, double length) {
        List<TriCoordVector> removedVectors = new ArrayList<>();
        for (TriCoordVector vector : vectors)
            if (vector.getLength() < length) removedVectors.add(vector);
        for (TriCoordVector vector : removedVectors)
            vectors.remove(vector);
        return removedVectors;
    }

    public static int countIntersection(List<TriCoordVector> vectors, List<TriCoordVector> otherVectors) {
        int intersections = 0;
        for (TriCoordVector vector : vectors)
            if (otherVectors.contains(vector)) intersections++;
        return intersections;
    }
}
