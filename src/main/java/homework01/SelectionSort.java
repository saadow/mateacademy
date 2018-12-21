package homework01;

public class SelectionSort {

	static void sort(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,4,2,4,7,11,3};
		SelectionSort.sort(arr);
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
