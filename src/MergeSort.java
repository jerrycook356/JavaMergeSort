
public class MergeSort {

	public static void main(String[] args) {
		
		int[] intArray = { 20,35,-15,7,55,1,-22};
		
		mergeSort(intArray,0,intArray.length);
		print(intArray);

	}
	
	
	
	public static void mergeSort(int[] intArray,int start, int end) {
		
		if(end - start < 2)
			return;
		
		int mid = (start + end)/2;
		
		
		
		mergeSort(intArray, start,mid);
		mergeSort(intArray,mid,end);
		
		merge(intArray,start,mid,end);
	}
	
	
	public static void merge(int[] intArray, int start, int mid, int end) {
		
		//since the elements in the left array are sorted if the end of left array is less than the 
		//beginning of the right array then everything in left array is sorted. 
		if(intArray[mid-1] <= intArray[mid])
			return;
		
		int i = start;
		int j = mid;
		int tempIndex = 0; //keep track of were we are in temp array
		
		int[] temp = new int[end-start];
		
		//compare array indexes write smaller into temp
		
		while(i < mid && j < end)
		{
			// the index in temp = intArray[i] if i is less than j else equals intArray[j]
			//then increment all indexes
			temp[tempIndex++] = intArray[i] <= intArray[j] ? intArray[i++] :intArray[j++];
			
		}
		
		// if any elements are left in the left array they need to copied into temp array. 
		//if any elements are left in the right array nothing needs to be done because 
		//the are all ready in the right spot in the tempArray;
		//arrayCopy(array to copy from, startingElement, where to copy to, destination Array, 
		//destination position,number of elements to copy
		 System.arraycopy(intArray, i, intArray, start+tempIndex, mid-i);
		 //copy of temp array into intArray
		 System.arraycopy(temp, 0, intArray, start, tempIndex);
		 
		 
	}
	
	public static void print(int[] intArray) {
		for(int i = 0; i < intArray.length;i++)
		{
			System.out.println(intArray[i]);
		}
	}

}
