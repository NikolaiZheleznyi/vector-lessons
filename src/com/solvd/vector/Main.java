package com.solvd.vector;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author asemenkov
 * @since Jun 29, 2021
 */
public class Main {

    public static void main_(String[] args) {
        List<TriCoordVector> vectors = VectorCollectionsUtil.generateVectors(10);
        double median = VectorCollectionsUtil.getMedianLength(vectors);
        List<TriCoordVector> removalList = VectorCollectionsUtil.removeShorterVectors(vectors, median);
        int intersections = VectorCollectionsUtil.countIntersection(vectors, removalList);
    }

    public static void main(String[] args) {

        TriCoordVector v1 = new TriCoordVector(1, 2, 3);
        Vector v2 = new TriCoordVector(4, 5, 6);
        VectorMultipliable<TriCoordVector> v3 = new TriCoordVector(7, 8, 9);

        double cos = v1.getCosAngle(v2);
        double scalar = v2.getScalarProduct(v1);

        Random r = new Random(0);
        List<Vector> vectors = VectorFunctionalUtils.generate(10,r::nextInt);
        Comparator<Vector> vectorComparator = (a, b) -> {
            if (a.getLength() < b.getLength()) return -1;
            else if (a.getLength() > b.getLength()) return 1;
            else return 0;
        };
        vectors = VectorFunctionalUtils.sort(vectors,vectorComparator);
        List<Vector> sortedVectors = vectors.stream().sorted(vectorComparator.reversed()).
                collect(Collectors.toList());
        Function<Vector, Long> vectorLongFunction = vector -> Double.
                valueOf(vector.getLength()).longValue();
        List<Long> longList = VectorFunctionalUtils.map(sortedVectors,vectorLongFunction);
        Stream<Long> stream = longList.stream();

        Long sum = (stream.filter(x -> x % 2 == 0).peek(System.out::println).reduce(0L, Long::sum));
        System.out.println(sum);
    }

}



