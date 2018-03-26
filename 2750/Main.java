import java.util.Scanner;

class Sort{
	
	private static int[] a;
	private static int i,n;

	Sort(int n){
		this.n = n;
		a = new int[n];
		i = 0;
	}
	
	public static void print(){
		for(int i = 0 ; i < n ; ++i){
			System.out.println(a[i]);
		}
	}
	public static void put(int n){
		a[i] = n;
		i++;
	}

	public static void bubbleSort(){
		for(int i = 0 ; i < n-1; ++i){
			for(int j = 0 ; j < n-(i+1); ++j){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	public static void insertSort(){
		for(int i = 1; i < n ; ++i){
			for(int j = 0 ; j < i ; ++j){
				if(a[i] < a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	public static void margeSort(int left,int right){
		int mid;

		if(left < right){
			mid = (left + right) / 2;

			margeSort(left,mid);
			margeSort(mid+1,right);

			margeTwoArea(left,mid,right);
		}

	}
	public static void margeTwoArea(int left,int mid,int right){
		int fIdx = left;
		int rIdx = mid + 1;

		int[] sortArr = new int[right+1];
		int sIdx = left;

		// 비교해서 정렬하기
		while(fIdx <= mid && rIdx <= right){
			if(a[fIdx] <= a[rIdx]){
				sortArr[sIdx] = a[fIdx++];
			}
			else{
				sortArr[sIdx] = a[rIdx++];
			}

			sIdx++;
		}

		// 남은 찌꺼기들 집어넣기
		if(fIdx > mid){
			for(int i = rIdx; i <= right; i++){
				sortArr[sIdx] = a[i];
				sIdx++;
			}
		}
		else{
			for(int i = fIdx; i <= mid; ++i){
				sortArr[sIdx] = a[i];
				sIdx++;
			}
		}

		// 원 배열에 옮겨담기
		for(int i = left; i <= right; ++i){
			a[i] = sortArr[i];
		}

	}
	public static void quickSort(int left,int right){
			if(left <= right){
				//int pivot = partition_acend(left,right);
				int pivot = partition_decend(left,right);
				quickSort(left,pivot-1);
				quickSort(pivot+1,right);
			}
	}

	public static int partition_acend(int left,int right){
		int pivot = a[left];
		int low = left + 1;
		int high = right;

		while(low <= high){
			while(low <= right && pivot >= a[low]){
				low++;
			}
			while(high >= (left + 1) && pivot <= a[high]){
				high--;
			}

			if(low <= high){
				int temp = a[low];
				a[low] = a[high];
				a[high] = temp;
			}
		}

		a[left] = a[high];
		a[high] = pivot;

		return high;
	}
	public static int partition_decend(int left,int right){
		int pivot = a[left];
		int low = left + 1;
		int high = right;

		while(low <= high){
			while(low <= right && pivot <= a[low]){
				low++;
			}
			while(high >= (left + 1) && pivot >= a[high]){
				high--;
			}

			if(low <= high){
				int temp = a[low];
				a[low] = a[high];
				a[high] = temp;
			}
		}

		a[left] = a[high];
		a[high] =pivot;

		return high;
	}
}

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Sort sort = new Sort(n);
		for(int i = 0 ; i < n ; ++i){
			sort.put(sc.nextInt());
		}

		//sort.bubbleSort();
		//sort.insertSort();
		//sort.margeSort(0,n-1);
		sort.quickSort(0,n-1);
		
		sort.print();
	}

}
