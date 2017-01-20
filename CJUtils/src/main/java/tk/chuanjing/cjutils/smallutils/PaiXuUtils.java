package tk.chuanjing.cjutils.smallutils;

public class PaiXuUtils {

	/**
	 * 冒泡排序算法  int
	 * @param arr
	 */
	public static int[] maoPao(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
	
	/**
	 * 冒泡排序算法  float
	 * @param arr
	 */
	public static float[] maoPao(float[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					float temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * 选择排序算法
	 * @param arr
	 */
	public static int[] xuanZhe(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	/**
	 * 二分查找算法
	 * @param arr
	 * @param key
	 */
	public static int erFen(int[] arr, int key) {
		int mid;
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] > key) {
				right = mid - 1;
			}
			if (arr[mid] < key) {
				left = mid + 1;
			}
			if (arr[mid] == key) {
				return mid;			//找到了，下标为mid
			}
		}
		if (left > right) {
			return -1;				//不存在，没找到！
		}
		
		return -1;
	}
}
