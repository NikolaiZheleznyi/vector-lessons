package com.solvd.vector;

/**
 * @author asemenkov
 * @since Jun 29, 2021
 */
public abstract class Vector {

    public abstract double getLength();

    public abstract double getScalarProduct(Vector vector);

    public abstract double getCosAngle(Vector vector);

}
