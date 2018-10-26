package com.wxweven.jvm;

class Father  {

    public void fMe() {
        System.out.println("fMe");
        fMe1();//invovespecial调用
        System.out.println(this);
        this.fMe1();//invovespecial调用
    }

    public void fMe1() {
        System.out.println("fMe1");
    }
}


class Son extends Father {

    public void fMe1() {
        System.out.println("sMe1");
    }
}

public class ThisTest {
    public static void main(String[] args) {
        Father test = new Son();
        test.fMe();//编译时指向父类中国的fMe()，在运行时由于是invokevirtual调用，因此test将变成实际类型Son，如果Son中有Fme()，就调用Son自己的，若没有就调用父类的
    }
}