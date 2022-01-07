
public class MergeSort {
	// merge function
	public static void merge(int[] A, int l, int m, int r) {

		int nL = m - l + 1;
		int nR = r - m;
		int n = A.length;

		int[] L = new int[nL];
		int[] R = new int[nR];

		for (int i = 0; i < nL; i++)
			L[i] = A[l + i];
		for (int i = 0; i < nR; i++)
			R[i] = A[m + 1 + i];

		int i, j, k;
		i = j = 0;
		k = l;

		while (i < nL && j < nR) {

			if (L[i] < R[j]) {
				A[k] = L[i];
				i++;

			} else {
				A[k] = R[j];
				j++;

			}
			k++;

		}

		while (i < nL) {
			A[k] = L[i];
			i++;
			k++;
		}

		while (j < nR) {
			A[k] = R[j];
			j++;
			k++;
		}

	}

	public static void mergeSort(int[] A, int l, int r) {

		if (l < r) {

			int m = l + (r - l) / 2;

			mergeSort(A, l, m);
			mergeSort(A, m + 1, r);
			merge(A, l, m, r);
		}

	}

	public static void main(String args[]) {

		int[] arr = { 8, 6, 7, 2, 3, 41, 12 };

		mergeSort(arr, 0, arr.length - 1);

		System.out.print(arr.length + "\n");
		for (int x : arr)
			System.out.print(" " + x);

	}

}
