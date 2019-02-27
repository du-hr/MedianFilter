import java.util.Arrays;

public class MedianFilter {

	public static void main(String[] args) {
		
		int[] testArray = new int[] {100,5,6,9,7,3,2,1,4,96,88,78};
		int[] resultArray = new int[testArray.length];
		int[] edgeProtectedArray = protectArrayEdge(testArray);
		
		
		int windowSize = 3;
		
		
		
		for (int i = 0; i + windowSize - 1 < edgeProtectedArray.length; i++) {
			int[] windowArray = new int[windowSize];
			windowArray = getWindowArrary(edgeProtectedArray,i,windowSize);
			resultArray[i] = getMedian(windowArray);
		}
		
		
		int result = getMedian(resultArray);
		int old = getMedian(testArray);
        System.out.printf("filtered arr[] : %s\n", Arrays.toString(resultArray)); 
        System.out.println(result);
        System.out.println(old);
        


	}

	private static int[] getWindowArrary(int[] edgeProtectedArray, int i, int windowSize) {
		int[] windowArray = new int[windowSize];
		for (int j = 0; j < windowSize; j++) {
			windowArray[j] = edgeProtectedArray[i];
			i++;	
		}
		return windowArray;
	}

	private static int getMedian(int[] windowArray) {
		int median;
		Arrays.sort(windowArray);
		if (windowArray.length%2 == 1) {
			median = windowArray [(windowArray.length-1)/2];
		}
		else {
			median = (windowArray [(windowArray.length)/2 - 1] + windowArray [(windowArray.length)/2 ])/2;
		}
		
		return median;
	}

	private static int[] protectArrayEdge(int[] testArray) {
		int[] edgeProtectedArray = new int[testArray.length+2];
		edgeProtectedArray[0] = testArray[0];
		edgeProtectedArray[testArray.length+1] = testArray[testArray.length-1];
		
		for (int i = 0; i < testArray.length; i++) {
			edgeProtectedArray[i+1] = testArray[i];
		}
		return edgeProtectedArray;
	}

}

