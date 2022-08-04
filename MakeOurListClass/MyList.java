package MakeOurListClass;

import java.util.Arrays;

public class MyList<T> {
    private int capacity = 10;
    private T[] array;
    private T[] tempArray;

    // MyList() : If the empty constructor is used, the initial size of the array
    // should be 10.
    public MyList() {
        this.array = (T[]) new Object[capacity];
    }

    // MyList(int capacity) : The initial value of the array should be taken from
    // the capacity parameter.
    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    // getCapacity() : returns the capacity of the array.
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public T[] getTempArray() {
        return tempArray;
    }

    public void setTempArray(T[] tempArray) {
        this.tempArray = tempArray;
    }

    // size() : Returns the number of elements in the array.
    public int size() {
        int number = 0;
        for (int i = 0; i < getCapacity(); i++) {
            if (array[i] != null) {
                number++;
            }
        }

        return number;
    }

    // add(T data) : It should be used to add an element to the array of the class.
    // If there is not enough space in the array, the array size should be doubled.

    public void add(T data) {
        if (size() > getCapacity()) {
            this.tempArray = this.array;
            setCapacity(getCapacity() * 2);
            this.array = (T[]) new Object[getCapacity()];
            this.array = Arrays.copyOf(tempArray, getCapacity());
        }
        this.array[size()] = data;
    }

    // get(int index): returns the value at the given index. Returns null if invalid
    // index is entered.
    public T get(int index) {
        if (index > size() || index < 0) {
            return null;
        }

        return this.array[index];

    }

    // remove(int index): should delete the data in the given index and shift the
    // data after the deleted index to the left. Returns null if invalid index is
    // entered.
    public T remove(int index) {
        if (size() < index || index < 0) {
            return null;
        }
        T[] temp = this.array;
        this.array[index] = null;
        for (int i = index; i < size(); i++) {
            if (size() - i == 1)
                this.array[i] = null;
            else
                this.array[i] = temp[i + 1];
        }
        return this.array[index];
    }

    // set(int index, T data) : It should replace the data in the given index with a
    // new one. Returns null if invalid index is entered.
    public T set(int index, T data) {
        if (size() < index || index < 0) {
            return null;
        }
        this.array[index] = data;
        return this.array[index];
    }

    // String toString() : A method that lists the elements in the array of the
    // class.
    @Override
    public String toString() {
        return "My list : " + Arrays.toString(array);
    }

    // int indexOf(T data) : Returns the index of the object given in the parameter
    // in the list. Returns -1 if the object is not in the list.
    public int indexOf(T data) {
        for (int i = 0; i < size(); i++) {
            if (this.array[i] == data) {
                return i;
            }
        }
        return -12;
    }

    // int lastIndexOf(T data) : It tells the last index of the specified item in
    // the list. Returns -1 if the object is not in the list.
    public int lastIndexOf(T data) {
        for (int i = size(); i >= 0; i--) {
            if (this.array[i] == data) {
                return i;
            }
        }
        return -2;
    }

    // boolean isEmpty() : Indicates whether the list is empty.
    public boolean isEmpty() {
        return size() == 0;
    }

    // T[] toArray() : Converts the items in the list into an array in the same
    // order.
    public T[] toArray() {
        return this.array;
    }

    // clear() : Deletes all items in the list, making it an empty list.
    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.array[i] = null;
        }
    }

    // MyList<T> sublist(int start,int finish) : Returns a list of the index range
    // given in the parameter.
    public MyList<T> subList(int start, int finish) {
        MyList<T> list = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            list.add(this.array[i]);
        }
        return list;
    }

    // boolean contains(T data) : It tells whether the value given in the parameter
    // is in the array.
    public boolean contains(T data) {
        for (int i = 0; i < size(); i++) {
            if (this.array[i] == data)
                return true;
        }
        return false;
    }
}