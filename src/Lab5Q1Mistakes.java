public class Lab5Q1Mistakes {
    public static void main(String[] args) {
        A[] ps = new A[4];
        // ps[0] = new A(); // abstract class. cant instantiate
        ps[0] = new B();
        ps[1] = new C();
        // ps[3] = new D(); // abstract class. cant instantiate
        ps[2] = new E();
        ps[3] = new F();
        for (int i = 0; i < ps.length; i++) {
            ps[i].f1();
            ps[i].f2();
            ps[i].f3();
        }
    }
}

/*
 * Output:
    A.f1 called
    B.f1 called
    A.f2 called
    B.f3 called
    A.f1 called
    C.f1 called
    A.f2 called
    C.f3 called
    A.f1 called
    C.f1 called
    A.f2 called
    D.f3 called
    A.f1 called
    C.f1 called
    A.f2 called
    D.f3 called
    F.f3 called
 */

abstract class A { // must be abstract class. Add abstract
    public void f1() {
        System.out.println("A.f1 called");
    }

    public final void f2() {
        System.out.println("A.f2 called");
    }

    public abstract void f3();
}

class B extends A {
	// should use @override
    public void f1() {
        super.f1();
        System.out.println("B.f1 called");
    }

	// can't override final method
    // public void f2() {
    //     super.f2();
    //     System.out.println("B.f2 called");
    // }

    public void f3() {
        System.out.println("B.f3 called");
    }
}

class C extends A {
    public void f1() {
        super.f1();
        System.out.println("C.f1 called");
    }

	// didn't override the abstract method f3. Must override it
    @Override
    public void f3() {
        System.out.println("C.f3 called");
    }
}

abstract class D extends C {
    public void f3() {
        System.out.println("D.f3 called");
    }
}

final class E extends D {
}

class F extends D { // can't inherit from final class E. Switch class E to D
    public void f3() {
        super.f3();
        System.out.println("F.f3 called");
    }
}