package com.max.zero;

public class MathematicsImpl implements MathematicsDao{

    @Override
    public void add(int a, int b) {
        System.out.println(a +" + " + b +" = "+ (a+b));
    }
}
