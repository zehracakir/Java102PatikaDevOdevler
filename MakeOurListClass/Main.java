package MakeOurListClass;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(80);
        myList.add(50);
        myList.add(60);
        myList.add(70);
        myList.add(80);
        myList.add(90);

        // System.out.println("Number of elements in the array: "+myList.size());
        // System.out.println("Array Capacity: "+myList.getCapacity());
        // System.out.println("value at the entered index: "+myList.get(1));
        // System.out.println("After deletion :"+myList.remove(4));
        // System.out.println("After replacing the element in the index :"+myList.set(2,
        // 500));
        // System.out.println("My list: "+myList.toString());
        // System.out.println("index of entered data in array "+myList.indexOf(90));
        // System.out.println("last index of: "+myList.lastIndexOf(80));
        // System.out.println(myList.isEmpty());
        /*
         * Object[] array=myList.toArray();
         * System.out.println(array[0]);
         */
        // System.out.println(myList.subList(1, 1));
        // System.out.println(myList.contains(8));

    }
}
