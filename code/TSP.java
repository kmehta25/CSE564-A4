import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class TSP extends Handler{
	
	@Override
	public void handleRequest(int type) {
		if(type!=Handler.TSP) {
			this.nextHandler.handleRequest(type);
			return;
		}
		LinkedHashMap<String, City> cities = CitiesList.getInstance().citiesList;
		LinkedHashMap<String, City> citiesReordered = new LinkedHashMap<String, City>();
		HashSet<String> visited = new HashSet<String>();
		
		System.out.println("Calculating TSP for new path of "+cities.size()+" cities....");
		
		Iterator<Entry<String, City>> iter = cities.entrySet().iterator();
		City startCity, currentCity, nextCity = null;
		
		int size = cities.size();
		double pathDist = 0, minDist = Double.MAX_VALUE;
		
		if(size>=1) {
			currentCity = iter.next().getValue();
			visited.add(currentCity.label);
			citiesReordered.put(currentCity.label, currentCity);
			startCity = currentCity;
			
			while(visited.size()<size) {
				minDist = Double.MAX_VALUE;
				for(String adjCity: cities.keySet()) {
					if(!visited.contains(adjCity)) {
						double dx = (currentCity.bounds.x-cities.get(adjCity).bounds.x);
						double dy = (currentCity.bounds.y-cities.get(adjCity).bounds.y);
						double temp = Math.sqrt(dx*dx+dy*dy);
						if(temp<minDist) {
							minDist = temp;
							nextCity = cities.get(adjCity);
						}
					}
				}
				currentCity = nextCity;
				pathDist += minDist;
				visited.add(nextCity.label);
				citiesReordered.put(nextCity.label, nextCity);
			}
			
			// Last point to starting point
			double dx = (currentCity.bounds.x-startCity.bounds.x);
			double dy = (currentCity.bounds.y-startCity.bounds.y);
			pathDist+=Math.sqrt(dx*dx+dy*dy);
			
			}
		CitiesList.getInstance().citiesList = citiesReordered;
		CitiesList.getInstance().pathDist = pathDist;
		
		
		// add links to path repo
		CitiesList.getInstance().addTSPPath();
		
		// notifyObservers
		setChanged();
		notifyObservers();				
	}
	
}
