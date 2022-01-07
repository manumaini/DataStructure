import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

	public static void main(String args[]) {

		int[] arr = { 5, 8, 6, 7, 2, 3, 41, 12, 16 };
		int n = arr.length;

		//List<Integer> list = new ArrayList<>(Arrays.asList(5, 8, 6, 2, 4, 8, 6));

		// passing
		for (int i = 0; i < n - 1; i++) {

			boolean flag = false;
			// for unsorted part of the array
			for (int j = 0; j < n - i - 1; j++) {

				if (arr[j] > arr[j + 1]) {

					// swap
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					flag = true;
				}

			}

			if (!flag)
				break;
		}

		for (int x : arr)
			System.out.print(" " + x);

	}

}
