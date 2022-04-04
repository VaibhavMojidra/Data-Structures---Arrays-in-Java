
public class MyArray {
	private int array[];
	private int size;
	private int initialCapacity;
	
	MyArray(int initialCapacity){
		array=new int[initialCapacity];
		this.initialCapacity=initialCapacity;
		size=0;
	}
	
	private int get(int index) { // Read
		return array[index]; // O(1)
	}
	private void set(int index,int value) { //Update
		array[index]=value; // O(1)
	}
	
	private int getSize() {
		return size;
	}
	
	private void insert(int index,int value) { //Insert
		if(getSize()==initialCapacity) {
			resize();
		}
		for(int i=getSize();i>index;i--) { //O(n)
			array[i]=array[i-1];
			log("Shift");
		}
		set(index,value);
		size++;
	}

	
	
	private void resize() {
		int temp[]=new int[initialCapacity*2];
		for(int i=0;i<initialCapacity;i++) {
			temp[i]=array[i];
		}
		initialCapacity*=2;
		array=temp;
	}
	
	private void delete(int index) {
		for(int i=index;i<size-1;i++) {
			array[i]=array[i+1];
			log("Shift");
		}
		array[size-1]=0;
		size--;
	}
	
	private void add(int value) {
		if(getSize()==initialCapacity) {
			resize();
		}
		array[size]=value;
		size++;
	}
	
	private void log(String msg) {
		System.out.println("Log: "+msg);
	}
	
	private void getStatus() {
		System.out.println("\nStatus");
		System.out.println("Size: "+getSize());
		System.out.println("Array capacity: "+initialCapacity);
		System.out.print("Array data:");
		for(int i=0;i<size;i++) {
			System.out.print(" "+get(i));
		}
		System.out.println("\n\n");
	}
	
	private void deleteLast() {
		if(getSize()!=0) {
			array[size]=0;
			size--;
		}
	}
	
	public static void main(String[] args) {
		MyArray ma=new MyArray(10);
		ma.getStatus();
		
		//Adding Value == O(1)
		ma.add(12);
		ma.getStatus();
		
		//Adding Value == O(1)
		ma.add(8);
		ma.getStatus();
				
		//Adding Value == O(1)
		ma.add(10);
		ma.getStatus();
		
		//Updating Value == O(1)
		ma.set(1,6);
		ma.getStatus();
		
		//Insert Value == O(n)
		ma.insert(1,4);
		ma.getStatus();
		
		//Delete Value == O(n)
		ma.delete(2);
		ma.getStatus();
		
		for(int i=1;i<30;i++) { // Adding more than capacity will dynamically increase
			ma.add(i);
		}
		ma.getStatus();
		
		
		//Get element with index == O(1)
		System.out.println(ma.get(3));
		
		ma.deleteLast();
		ma.getStatus();
	}
}
