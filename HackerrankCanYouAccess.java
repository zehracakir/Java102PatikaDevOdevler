/* 
You are given a class Solution and an inner class Inner.Private. The main method of class Solution takes an integer  as input. The powerof2 in class Inner.Private checks whether a number is a power of . You have to call the method powerof2 of the class Inner.Private from the main method of the class Solution.

Constraints

Sample Input

8
Sample Output

8 is power of 2
An instance of class: Solution.Inner.Private has been created
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Permission;

public class Solution {
	public static void main(String[] args) throws Exception {
		Do_Not_Terminate.forbidExit();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of
						// the class Solution.Inner.Private

			Inner inner = new Inner();
			Inner.Private p = inner.new Private();
			System.out.println(num + " is " + p.powerof2(num));
			o = p;

			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

		} // end of try

		catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}// end of main

	static class Inner {
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}// end of Inner

}// end of Solution

class Do_Not_Terminate {

	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}
