package com.wxweven.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by wxweven on 17/9/14.
 */
public class Test {
    class GrandFather {
        void say() {
            System.out.println("grandfather");
        }
    }

    class Father extends GrandFather {
        void say() {
            System.out.println("father");
        }
    }

    class Son extends Father {
        void say() {
            GrandFather grandFather = new GrandFather();
            grandFather.say();
        }
    }

    class Son2 extends Father {
        void say() {
            try {
                MethodType methodType = MethodType.methodType(void.class);
                MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GrandFather.class, "say", methodType, getClass());
                methodHandle.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new Test().new Son2()).say();
    }

}
