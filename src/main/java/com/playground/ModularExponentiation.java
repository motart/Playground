package com.playground;

public class ModularExponentiation {
    private static int getModularExp (int x, int y, int p) {
        int res = 1;
        if (y == 0) {
            return 1;
        }
        if (y == 1) {
            return x;
        }
        res = getModularExp(x,y/2,p);
        if (y%2 == 0) {
            return (res*res)%p;
        }
        if (y%2==1) {
            return (x*res*res)%p;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(getModularExp(2,5,13));
    }
}
