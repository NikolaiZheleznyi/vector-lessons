package com.solvd.vector;

/**
 * @author asemenkov
 * @since Jun 29, 2021
 */
public interface VectorMultipliable<T extends Vector> {

    T multiply(T vector);

}
