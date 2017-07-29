package Statistics;
/*
 * Correlation Coefficient Formula Courtesy : http://www.statisticshowto.com/what-is-the-correlation-coefficient-formula/
 * Linear Regression formula Courtesy : http://www.statisticshowto.com/how-to-find-a-linear-regression-equation/
 * 
 */
public class Regression {

	public static void main(String[] args) {
		int[] x = {1,2,3,4,5,6};
		int[] y = {1,2,3,4,5,6};
		System.out.println("Correlation Coefficient = "+correlationCoefficient(x, y));
		double slopeIntercept[] = biVariateLinearRegression(x, y);
		System.out.println("Linear Regression Coefficient Equation : y = "+slopeIntercept[0]+"x + "+slopeIntercept[1]);
	}
	public static double correlationCoefficient(int[] x,int[] y){
		double r = (x.length*(sum_xy(x,y)) - sum_array(x)*sum_array(y))/
						(Math.sqrt((x.length*sum_arr_2(x) - Math.pow(sum_array(x), 2))*(y.length*sum_arr_2(y) - Math.pow(sum_array(y), 2))));
		return r;
	} 
	
	public static double[] biVariateLinearRegression(int[] x, int[] y){
		double slope = 0.0; double intercept = 0.0;
		slope = (x.length*sum_xy(x, y) - sum_array(x)*sum_array(y))/(x.length*sum_arr_2(x) - Math.pow(sum_array(x), 2));
		intercept = (sum_array(y)*sum_arr_2(x) - sum_array(x)*sum_xy(x, y))/(x.length*sum_arr_2(x) - Math.pow(sum_array(x), 2));
		double[] slopeIntercept = {slope,intercept};
		return slopeIntercept;
	}
	
	public static double sum_array(int[] arr){
		double sum_arr = 0.0;
		for(int i=0;i<arr.length;i++){
			sum_arr+=arr[i];
		}
		return sum_arr;
	}
	
	public static double sum_xy(int[] x, int[] y){
		double sum_x_y = 0.0;
		for(int i=0;i<x.length;i++){
			sum_x_y+=(x[i]*y[i]);
		}
		return sum_x_y;
	}
	
	public static double sum_arr_2(int[] x){
		double sum_x_2 = 0.0;
		for(int i=0;i<x.length;i++){
			sum_x_2+=(x[i]*x[i]);
		}
		return sum_x_2;
	}
	
	
}
