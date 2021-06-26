package com.codewithvarun.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecursiveSort implements Sort {
    @Override
    public int[] sort(int[] input) {
        var vector = Arrays.stream(input).boxed().collect(Collectors.toList());
        recursiveSort(vector);
        return vector.stream().mapToInt(i->i).toArray();
    }

    private void recursiveSort(List<Integer> vector) {
        if (vector.size() == 1)
            return;

        // assume that the value in the last index is smaller
        // since the array is not sorted
        // so remove the last index from the array (reduce the array size)
        // and store that value in a temp variable (cannot lose the value obviously)
        // the value is stored in the method scope -- inside call callstack
        var smallerVal = vector.get(vector.size() - 1);
        vector.remove(vector.size() - 1);

        // recursively reduce the array until 1 element is remaining
        recursiveSort(vector);

        // start inserting the element in the sorted order
        // insert smaller number to its correct position
        insert(vector, smallerVal);
    }

    /**
     * The base condition is reached when the array is empty
     * or the last element in the array is smaller then the passed value
     * then simply append the value at the end
     *
     * Or else recursively call the insert function with a reduced array
     * @param vector
     * @param smallerVal
     */
    private void insert(List<Integer> vector, Integer smallerVal) {
        if (vector.isEmpty() || vector.get(vector.size() - 1) <= smallerVal) {
            vector.add(smallerVal);
            return;
        }

        // we've reached this step that means
        // the last value is still bigger then the passed element
        // so we pop last value and recursive;y call insert
        // and then add the value to its end again (cannot lost the information)
        var biggerVal = vector.get(vector.size() - 1);
        vector.remove(vector.size() - 1);
        insert(vector, smallerVal);
        
        // add the bigger value at the end
        vector.add(biggerVal);
    }


}
