package com.solvd.vector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class VectorFunctionalUtils {
        public static List<Vector> generate(int n, IntSupplier intSupplier){
            List<Vector> vectors = new ArrayList<>();
            for (int i = 0; i < n; i++){
                vectors.add(new TriCoordVector(intSupplier.getAsInt(), intSupplier.getAsInt(), intSupplier.getAsInt()));
            }
            return vectors;
        }

       public static List<Vector> sort (List<Vector> vectorList, Comparator<Vector> vectorComparator){
           List<Vector> vectors = new ArrayList<>(vectorList);
           return vectors.stream().sorted(vectorComparator).collect(Collectors.toList());
        }

       public static List<Long> map(List<Vector> vectorList, Function<Vector, Long> vectorLongFunction){
            List<Vector> vectors = new ArrayList<>(vectorList);
            return vectors.stream().map(vectorLongFunction).collect(Collectors.toList());
       }

}



