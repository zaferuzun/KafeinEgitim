package com.kafein.lambda.giris;

@FunctionalInterface
interface Interface1 {
    public void f();
}

@FunctionalInterface
interface Interface2 {
    public void f(int i);
}

interface Interface3 {
    public int f();

}

interface Interface4 {
    public int f(int i);
}

interface Interface5 {
    public double f(double d1, double d2);
}