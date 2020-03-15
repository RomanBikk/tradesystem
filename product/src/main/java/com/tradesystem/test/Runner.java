package com.tradesystem.test;

import java.util.Optional;

public class Runner {


    public static void main(String[] args) {
        A a = new A();
        handle(a);
    }

    public static String handle(A a) {
        Optional<A> aOptional = Optional.ofNullable(a);

        A a1 = aOptional.orElse(new A());

        //return a.getB().getC().getD().getName();

        return Optional.ofNullable(a)
                .map(A::getB)
                .map(B::getC)
                .map(C::getD)
                .map(D::getName)
                .orElse(null);
    }
}
