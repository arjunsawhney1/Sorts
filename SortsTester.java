/*
 * NAME: Arjun Sawhney
 * PID:  A15499408
 */

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

/**
 * SortsTester class to test Sorts
 * @author Arjun Sawhney
 * @since  05/02/2020
 */
public class SortsTester {
    Integer[] randomInt = new Integer[] {21, 56, 28, 49, 35, 42};
    Integer[] sortedInt = new Integer[] {21, 28, 35, 42, 49, 56};
    Integer[] reversedInt = new Integer[] {56, 49, 42, 35, 28, 21};

    Character[] randomChar = new Character[] {'B', 'D', 'C', 'A', 'F', 'E'};
    Character[] sortedChar = new Character[] {'A', 'B', 'C', 'D', 'E', 'F'};
    Character[] reversedChar = new Character[] {'F', 'E', 'D', 'C', 'B', 'A'};

    String[] randomString = new String[] {"Rohan", "Chhaya", "Arjun", "Sawhney", "Rajesh",
            "Kartik"};
    String[] sortedString = new String[] {"Arjun", "Chhaya", "Kartik", "Rajesh", "Rohan",
            "Sawhney"};
    String[] reversedString = new String[] {"Sawhney", "Rohan", "Rajesh", "Kartik", "Chhaya",
            "Arjun"};

    Sorts<Integer> intSort;
    Sorts<Character> charSort;
    Sorts<String> stringSort;

    ArrayList<Integer> intList;
    ArrayList<Character> charList;
    ArrayList<String> stringList;

    @Before
    public void setup() {
        intSort = new Sorts<Integer>();
        charSort = new Sorts<Character>();
        stringSort = new Sorts<String>();

        intList = new ArrayList<>();
        charList = new ArrayList<>();
        stringList = new ArrayList<>();
    }

    public void randomInput() {
        if (intList.size() > 0 && charList.size() > 0 && stringList.size() > 0) {
            intList.clear();
            charList.clear();
            stringList.clear();
        }

        for (int i = 0; i < 6; i++) {
            intList.add(randomInt[i]);
            charList.add(randomChar[i]);
            stringList.add(randomString[i]);
        }
    }

    public void sortedInput() {
        if (intList.size() > 0 && charList.size() > 0 && stringList.size() > 0) {
            intList.clear();
            charList.clear();
            stringList.clear();
        }

        for (int i = 0; i < 6; i++) {
            intList.add(sortedInt[i]);
            charList.add(sortedChar[i]);
            stringList.add(sortedString[i]);
        }
    }

    public void reversedInput() {
        if (intList.size() > 0 && charList.size() > 0 && stringList.size() > 0) {
            intList.clear();
            charList.clear();
            stringList.clear();
        }

        for (int i = 0; i < 6; i++) {
            intList.add(reversedInt[i]);
            charList.add(reversedChar[i]);
            stringList.add(reversedString[i]);
        }
    }

    @Test
    public void testInsertionSort() {
        randomInput();
        assertArrayEquals(randomInt, intList.toArray());
        assertArrayEquals(randomChar, charList.toArray());
        assertArrayEquals(randomString, stringList.toArray());

        intSort.InsertionSort(intList, 0, intList.size() - 1);
        charSort.InsertionSort(charList, 0, intList.size() - 1);
        stringSort.InsertionSort(stringList, 0, intList.size() - 1);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        sortedInput();
        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        intSort.InsertionSort(intList, 0, intList.size() - 1);
        charSort.InsertionSort(charList, 0, intList.size() - 1);
        stringSort.InsertionSort(stringList, 0, intList.size() - 1);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        reversedInput();
        assertArrayEquals(reversedInt, intList.toArray());
        assertArrayEquals(reversedChar, charList.toArray());
        assertArrayEquals(reversedString, stringList.toArray());

        intSort.InsertionSort(intList, 0, intList.size() - 1);
        charSort.InsertionSort(charList, 0, intList.size() - 1);
        stringSort.InsertionSort(stringList, 0, intList.size() - 1);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());
    }

    @Test
    public void testQuickSort() {
        randomInput();
        assertArrayEquals(randomInt, intList.toArray());
        assertArrayEquals(randomChar, charList.toArray());
        assertArrayEquals(randomString, stringList.toArray());

        intSort.QuickSort(intList, 0, intList.size() - 1);
        charSort.QuickSort(charList, 0, intList.size() - 1);
        stringSort.QuickSort(stringList, 0, intList.size() - 1);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        sortedInput();
        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        intSort.QuickSort(intList, 0, intList.size() - 1);
        charSort.QuickSort(charList, 0, intList.size() - 1);
        stringSort.QuickSort(stringList, 0, intList.size() - 1);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        reversedInput();
        assertArrayEquals(reversedInt, intList.toArray());
        assertArrayEquals(reversedChar, charList.toArray());
        assertArrayEquals(reversedString, stringList.toArray());

        intSort.QuickSort(intList, 0, intList.size() - 1);
        charSort.QuickSort(charList, 0, intList.size() - 1);
        stringSort.QuickSort(stringList, 0, intList.size() - 1);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());
    }

    @Test
    public void testModifiedQuickSort() {
        randomInput();
        assertArrayEquals(randomInt, intList.toArray());
        assertArrayEquals(randomChar, charList.toArray());
        assertArrayEquals(randomString, stringList.toArray());

        intSort.Modified_QuickSort(intList, 0, intList.size() - 1, 4);
        charSort.Modified_QuickSort(charList, 0, intList.size() - 1, 4);
        stringSort.Modified_QuickSort(stringList, 0, intList.size() - 1, 4);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        sortedInput();
        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        intSort.Modified_QuickSort(intList, 0, intList.size() - 1, 3);
        charSort.Modified_QuickSort(charList, 0, intList.size() - 1, 3);
        stringSort.Modified_QuickSort(stringList, 0, intList.size() - 1, 3);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        reversedInput();
        assertArrayEquals(reversedInt, intList.toArray());
        assertArrayEquals(reversedChar, charList.toArray());
        assertArrayEquals(reversedString, stringList.toArray());

        intSort.Modified_QuickSort(intList, 0, intList.size() - 1, 2);
        charSort.Modified_QuickSort(charList, 0, intList.size() - 1, 2);
        stringSort.Modified_QuickSort(stringList, 0, intList.size() - 1, 2);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());
    }

    @Test
    public void testTimSort() {
        randomInput();
        assertArrayEquals(randomInt, intList.toArray());
        assertArrayEquals(randomChar, charList.toArray());
        assertArrayEquals(randomString, stringList.toArray());

        intSort.TimSort(intList, 0, intList.size() - 1, 4);
        charSort.TimSort(charList, 0, intList.size() - 1, 4);
        stringSort.TimSort(stringList, 0, intList.size() - 1, 4);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        sortedInput();
        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        intSort.TimSort(intList, 0, intList.size() - 1, 3);
        charSort.TimSort(charList, 0, intList.size() - 1, 3);
        stringSort.TimSort(stringList, 0, intList.size() - 1, 3);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());

        reversedInput();
        assertArrayEquals(reversedInt, intList.toArray());
        assertArrayEquals(reversedChar, charList.toArray());
        assertArrayEquals(reversedString, stringList.toArray());

        intSort.TimSort(intList, 0, intList.size() - 1, 2);
        charSort.TimSort(charList, 0, intList.size() - 1, 2);
        stringSort.TimSort(stringList, 0, intList.size() - 1, 2);

        assertArrayEquals(sortedInt, intList.toArray());
        assertArrayEquals(sortedChar, charList.toArray());
        assertArrayEquals(sortedString, stringList.toArray());
    }
}
