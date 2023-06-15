package tester;

class A {
	public void show() {
		System.out.println("in super's show : non static");
	}

	public static void test() {
		System.out.println("in super's test :  static");
	}
}

class B extends A {
	@Override
	public void show() {
		System.out.println("in sub's show : non static");
	}

//@Override : javac err : since you can't override a static method 
	public static void test() {
		System.out.println("in sub's test :  static");
	}
}
















public class Tester {
	public static void main(String[] args) {
		A ref = new A();
		A ref2 = new B();
		// Method hiding : equivalent to compile time poly : resolved by type of ref
		// Above is not really a useful practice --only for understanding purpose, no
		// practical usage.
		ref.test();
		ref2.test();
		// method overriding : run time poly --resolved by type of the instance
		ref.show();
		ref2.show();
	}

}
