package Statistics;

import java.util.Arrays;
import java.util.HashMap;

public class MeanMedianMode {

	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 7};
		System.out.println("Mean = "+MeanMedianMode.mean(nums));
		System.out.println("Median = "+MeanMedianMode.median(nums));
		if(MeanMedianMode.mode(nums)!=0){
			System.out.println("Mode = "+MeanMedianMode.mode(nums));
		}else{
			System.out.println("Mode = none");
		}
		

	}
	
	public  static double mean(int[] nums){
		double sum = 0.0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
		}
		return sum/nums.length;
		
	}
	
	public static double median(int[] nums){
		Arrays.sort(nums);
		double median = 0.0;
		if(nums.length%2==0){
			int mid1 = nums[nums.length/2];
			int mid2 = nums[nums.length/2 -1];
			median = (mid1 + mid2)/2;
		}else{
			median  = nums[(nums.length +1)/2];
		}
		return median;
	}
	
	public static int mode(int[] nums){
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for(int i = 0; i<nums.length ; i++){
			if(count.containsKey(nums[i])){
				count.put(nums[i], count.get(nums[i])+1);
			}else{
				count.put(nums[i], 1);
			}
		}
		Object[] keyArr = count.keySet().toArray();
		int max = 1 ;
		int mode = 0;
		for(int i = 0;i<keyArr.length;i++){
			
			if(max < count.get(keyArr[i])){
				max = count.get(keyArr[i]);
				mode = (int) keyArr[i];
			}
			
		}
		return mode;
	}

}
