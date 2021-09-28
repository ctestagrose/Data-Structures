/**
 * This is the HashTable class and when called it will create an array of lists. 
 * The array of lists will be of size 101 and a hashing function will be used to determine where each state will be placed
 * This hashTable class uses separate chaining
 * The hash function will use the state name, population, and deaths to calculate the key
 * 
 * @author Conrad Testagrose
 *
 */
class HashTable {
	
	private LinkedList[] hashArray = new LinkedList[101];
	
	/**
	 * This is the HashTable constructor it takes no arguments
	 * 
	 */
	public HashTable() {
		
		for(int i = 0; i < 101; i++) {
			
			hashArray[i] = new LinkedList();
			
		}
		
		
	}
	
	/**
	 * This is the insert function and will use a hashing function to determine where to insert the state
	 * This function will call the Node class to create a node that will hold the data on the state and then insert the Node into its appropriate location
	 * 
	 * @param state : This is a String that holds the state name
	 * @param population : This is a long value that will hold the states population
	 * @param deaths : This is the long value of the number of deaths from covid-19
	 */
	public void insert(String state, long population, long deaths) {
		
		Node newNode = new Node(state, population, deaths);
				
		long num = 0;
		
		for(int i = 0; i < state.length(); i++) {
			
			num = num + state.charAt(i);
			
		}
		
		num = num + population + deaths;
		
		int key = (int) (num % 101);
		
		hashArray[key].insert(newNode);
		
	}
	
	/**
	 * This is the find function 
	 * 
	 * 
	 * @param state
	 * @param population
	 * @param deaths
	 * @return
	 */
	public int find(String state, long population, long deaths) {
		
		String findName = state;
		
		long num = 0;
		
		for(int i = 0; i < state.length(); i++) {
			
			num = num + state.charAt(i);
			
		}
		
		num = num + population + deaths;
		
		int key = (int) (num % 101);
		
		
		if(hashArray[key] != null) {
			
			hashArray[key].find(findName, key);
			
		}
		
		
		return 0;
	}
	
	
	public void delete(String state, long population, long deaths) {
		
		String findName = state;
		
		long num = 0;
		
		for(int i = 0; i < state.length(); i++) {
			
			num = num + state.charAt(i);
			
		}
		
		num = num + population + deaths;
		
		int key = (int) (num % 101);
		
		
		if(hashArray[key] != null) {
			
			hashArray[key].delete(findName, key);
				
				
			
			
		}
		
	}
	
	public void display() {
		
		
		for(int i = 0; i < hashArray.length; i++) {
			
			System.out.printf("%3d.", i);
			
			hashArray[i].display();
			
			System.out.println("");
				
			
		}	
		
	
	}


	public void printEmptyAndCollisions() {

		int empty = 0;
		int collisions = 0;
		
		
		for(int i = 0; i < hashArray.length; i++) {
			
			int eOC = hashArray[i].emptyOrCollision();
			
			if(eOC == 0) {
				
				empty++;

			}
			else if(eOC == 1) {
					
				collisions++;
				
			}
			
			eOC = 0;
			
		}
		
		System.out.printf("There are %d empty cells and %d collisions in the hash table\n\n", empty, collisions);
		
		
	}
	
	private class Node{
		
		String name;
		long population;
		long deaths;
		Node nextNode;
		
		public Node(String name, long population, long deaths) {
			
			this.name = name;
			this.population = population;
			this.deaths = deaths;
			
		}
		
		public void printNode() {
			
			System.out.printf("%-30s %-20.2f\n", name, (double)deaths/population * 100000);
			
		}
		
	}
	

class LinkedList {
	
	private Node first;
	
	public LinkedList() {
		
		first = null;
		
	}
	
	public void insert(Node newNode) {
		
		if(first == null) {
			
			first = newNode;
			
		}
		else{
			
			Node current = first;
			
			while(current != null) {
				
				if(current.nextNode == null) {
					
					current.nextNode = newNode;
					
					return;
					
				}
				
				current = current.nextNode;
				
			}
			
		}
					
	}
	
	public void delete(String name, int index) {
		
		Node current = first;
		
		if(first.name.compareToIgnoreCase(name) == 0) {
			
			if(first.nextNode != null) {
				
				first = first.nextNode;
				return;
				
			}
			else {
				
				first = null;
				return;
				
			}
			
		}
		
		while(current.nextNode != null) {
			
			if(current.nextNode.name.compareToIgnoreCase(name) == 0) {
				
				current.nextNode = current.nextNode.nextNode;
				
				return;
			}
			else {
				
				current = current.nextNode;
				
			}
			
		}
		
		
		System.out.printf("%s was not found\n", name);
		return;
		
	}
	
	public void find(String name, int index) {
		
		Node current = first;
		
		while(current != null) {
			
			if(current.name.compareToIgnoreCase(name) == 0) {
				
				System.out.printf("%s is found at index %d with a DR of %.2f\n", current.name, index, (double)current.deaths/current.population * 100000);
				
				return;
				
			}
			
			current = current.nextNode;
			
			
		}
		
		
		System.out.printf("%s was not found\n", name);
		return;
		
	}
	
	public void display() {
		
		Node current = first;
		
		if(current == null) {
			
			System.out.println("   Empty");
			
		}
			
		while(current != null) {
			
			if(current == first) {
				
				System.out.print("   ");
				current.printNode();
				current = current.nextNode;
				
				
			}
			else {
			
				System.out.print("       ");
			
				current.printNode();
			
				current = current.nextNode;
			
			}
		}
		
	}
	
	public int emptyOrCollision() {
		
		Node current = first;
		
		if(current == null) {
			
			return 0;
			
		}
		else if(current.nextNode != null){
		
			
			
			return 1;
		}
		else {
			
			
			return 2;
		}
		
	}
	

}

}

