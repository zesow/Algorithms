import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.Scanner;

class Sort{

    private static long[] a = new long[5000001];
    private static int n,k,i;
	private static long result;
    Sort(int n,int k){
        this.n = n;
		this.k = k;
		i = 0;
    }
	public static long getResult(){
		return result;
	}
    public static void put(long num){
        a[i++] = num;
    }
	public static long get(int idx){
		return a[idx];
	}
    public static void quickSort(int left,int right){

                int pivot = partition(left,right);

				if(pivot == k-1){
					result =  a[pivot];
					return;
				}
				else if(pivot > k-1)
					quickSort(left,pivot-1);
				else
					quickSort(pivot+1,right);

    }

    public static int partition(int left,int right){
        long pivot = a[left];
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
                long temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
        }

        a[left] = a[high];
        a[high] = pivot;

        return high;
    }
}

class Main{
	
	private static int n,k;
	public static void main(String[] args){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);
		Sort sort = new Sort(n,k);

		line = sc.nextLine().split(" ");
		for(int i = 0 ;i < n ; ++i){
			sort.put(Integer.parseInt(line[i]));
		}
		sort.quickSort(0,n-1);
		System.out.println(sort.getResult());
	}
}
