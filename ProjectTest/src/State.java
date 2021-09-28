
public class State {
	
	public String name;
	public long deaths;
	public long population;
	
	public State(String name, long population, long deaths) {
		
		this.name = name;
		this.deaths = deaths;
		this.population = population;
		
		
	}
	
	public String getName() {
		  
		return name;
	}

	/**
	 * Sets the name of the state to the String variable name
	 * 
	 * @param name holds the name of the state passed to the contructor 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the double contained in the double variable population 
	 * 
	 * @return population of the state in a double variable
	 */
	public long getPopulation() {
			  
		return population;
	}
	
	/**
	 * Sets the population of the state to the double variable population
	 * 
	 * @param population holds the population of the state passed to the contructor 
	 */
	public void setPopulation(long population) {
		this.population = population;
	}
	
	/**
	 * Gets the double contained in the double variable covidDeaths 
	 * 
	 * @return covidDeaths of the state in a double variable
	 */
	public long getDeaths() {
			  
		return deaths;
	}
	
	/**
	 * Sets the covid deaths of the state to the double variable covidDeaths
	 * 
	 * @param covidDeaths holds the number of covid deaths of the state passed to the contructor 
	 */
	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}
	
	

}
