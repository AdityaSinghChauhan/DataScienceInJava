package Statistics;

import java.util.Arrays;
import java.util.HashMap;

/*
mean: regular meaning of "average"
median: middle value
mode: most often
variance: mean of squared differences of number and actual mean.
standard deviation: squareroot of variance.
skewness and kurtosis as defined by http://www.itl.nist.gov/div898/handbook/eda/section3/eda35b.htm
*/

public class Measure {

	public static void main(String[] args) {
		int[] nums = { 1,2,3,4,5,4,3,2,1 };
		System.out.println("Mean = " + Measure.mean(nums));
		System.out.println("Median = " + Measure.median(nums));
		if (Measure.mode(nums) != 0) {
			System.out.println("Mode = " + Measure.mode(nums));
		} else {
			System.out.println("Mode = none");
		}
		System.out.println("Standard Deviation = " + Measure.standardDeviation(nums));
		System.out.println("Variance = " + Measure.variance(nums));
		System.out.println("Skewness = " + Measure.skewness(nums));
		System.out.println("Kurtosis = " + Measure.kurtosis(nums));

	}

	public static double mean(int[] nums) {
		double sum = 0.0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum / nums.length;

	}

	public static double median(int[] nums) {
		Arrays.sort(nums);
		double median = 0.0;
		if (nums.length % 2 == 0) {
			int mid1 = nums[nums.length / 2];
			int mid2 = nums[nums.length / 2 - 1];
			median = (mid1 + mid2) / 2;
		} else {
			median = nums[(nums.length + 1) / 2];
		}
		return median;
	}

	public static int mode(int[] nums) {
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (count.containsKey(nums[i])) {
				count.put(nums[i], count.get(nums[i]) + 1);
			} else {
				count.put(nums[i], 1);
			}
		}
		Object[] keyArr = count.keySet().toArray();
		int max = 1;
		int mode = 0;
		for (int i = 0; i < keyArr.length; i++) {

			if (max < count.get(keyArr[i])) {
				max = count.get(keyArr[i]);
				mode = (int) keyArr[i];
			}

		}
		return mode;
	}

	public static double standardDeviation(int[] nums) {
		double mean = Measure.mean(nums);
		int[] muArr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			muArr[i] = (int) Math.pow((nums[i] - mean), 2);
		}
		double variance = Measure.mean(muArr);
		return Math.pow(variance, 0.5);
	}

	public static double variance(int[] nums) {
		return Math.pow(Measure.standardDeviation(nums), 2);

	}
	
	public static double skewness(int[] nums) {
		double eleMean = 0.0;
		double mean = Measure.mean(nums);
		for(int i=0;i<nums.length;i++){
			eleMean = eleMean + Math.pow((nums[i] - mean), 3);
		}
		return (((eleMean/nums.length)/(Math.pow(Measure.standardDeviation(nums), 3))));

	}
	
	public static double kurtosis(int[] nums) {
		double eleMean = 0.0;
		double mean = Measure.mean(nums);
		for(int i=0;i<nums.length;i++){
			eleMean = eleMean + Math.pow((nums[i] - mean), 4);
		}
		return (((eleMean/nums.length)/(Math.pow(Measure.standardDeviation(nums), 4))) - 3);
		
	}

}
