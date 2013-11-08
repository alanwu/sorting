import java.util.Arrays;


public class MergeSort {

	public static void main(String[] args) {
		int[] source = {12,321,4,67,65,324,2423,12,445,534,5,5,3};
		
		System.out.println(Arrays.toString(source));
		mergeSort(source);
		System.out.println(Arrays.toString(source));
	}
	
	private static void mergeSort(int[] source) {
		if (source.length == 1) {
			return;
		}
		
		int[] left = getLeft(source);
		int[] right = getRight(source);
		mergeSort(left);
		mergeSort(right);
		
		merge(left, right, source);
	}
	
	private static void merge(int[] left, int[] right, int[] source) {
		int iL = 0;
		int iR = 0;
		for (int i = 0; i < source.length; i++) {
			if (iL < left.length && iR < right.length) {
				if (left[iL] < right[iR]) {
					source[i] = left[iL++];
				} else {
					source[i] = right[iR++];
				}
			} else if (iL < left.length) {
				source[i] = left[iL++];
			} else if (iR < right.length) {
				source[i] = right[iR++];
			}
		}
	}
	
	private static int[] getLeft(int[] source) {
		int length = source.length / 2;
		int[] result = new int[length];
		
		for (int i = 0; i < length; i++) {
			result[i] = source[i];
		}
		
		return result;
	}
	
	private static int[] getRight(int[] source) {
		int start = source.length / 2;
		int[] result = new int[source.length - start];

		for (int i = start; i < source.length; i++) {
			result[i - start] = source[i];
		}
		
		return result;
	}
}
