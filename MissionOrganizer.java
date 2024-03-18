package space;

import java.util.*;


/*
 * During iteration, missions that cost < $1 trillion (1e12) are presented in insertion order.
 * Then expensive missions (that cost >= $1 trillion) are presented in the natural sorting order
 * of the Mission class.
 */


public class MissionOrganizer implements Iterable<Mission>
{
	private final static float			ONE_TRILLION = 1.0e12f;
	
	// Insert declarations for 2 collections: 1 for cheap missions, 1 for expensive missions.
	TreeSet<Mission> 				cheapMission;
	ArrayList<Mission>				expensiveMission;
	
	MissionOrganizer()
	{
		// Create the 2 mission collections.
		cheapMission = new TreeSet<Mission>();
		expensiveMission = new ArrayList<Mission>();
	}
	
	
	// Returns true if either cheapMissions or expensiveMissions contains m.
	public boolean contains(Mission m)
	{
		//Compare cheapMissions first
		for(Mission e : cheapMission)
		{
			if(e.equals(m)) 
			{
				return true;
			}
		}
		
		//Compare expensiveMission 
		if(expensiveMission.contains(m))
		{
			return true;
		}
		
		return false;
	}
	
	
	// Only adds if mission is not yet contained in this collection. Adds to
	// cheapMissions or expensiveMissions, depending on whether the mission's
	// cost is < $1 trillion or >= $1 trillion.
	public void add(Mission mission)
	{
		//Checks for contains
		if(this.contains(mission))
		{
			System.out.println("Already contains.");
		}
		
		//Checks and adds for cheap missions
		if(mission.getCost() < ONE_TRILLION)
		{
			cheapMission.add(mission);
		}
		//Checks and adds for expensive missions
		else if(mission.getCost() >= ONE_TRILLION)
		{
			expensiveMission.add(mission);
		}

	}
	
	
	// Create an ArrayList<Mission>. Add all the cheap missions to the ArrayList; then
	// add all the expensive missions. (Hint: look in the API page for ArrayList for a
	// method that adds all members of a collection.) The ArrayList will then contain
	// all the missions, in the desired order. Return the ArrayList's iterator. This
	// technique was shown in lecture, in the presentation of the Roster class.
	public Iterator<Mission> iterator()
	{
		ArrayList<Mission> newArray = new ArrayList<Mission>(cheapMission);
		newArray.addAll(expensiveMission);
		
		return newArray.iterator();
	}
	
	
	
	
	// All costs are uneducated guesses.
	private final static Mission[]		TEST_MISSIONS =
	{
        new Mission("Alderaan", 1E16f),
        new Mission("High Earth Orbit", 3E8f),
        new Mission("Moon", 2.5E10f),
        new Mission("Alpha Centauri", 1E14f),
        new Mission("Asteroids", 7E11f),
        new Mission("Uranus", 9E11f),
        new Mission("Jupiter", 2E11f),
        new Mission("Low Earth Orbit", 1E8f),
        new Mission("Cetaganda", 13E16f),
        new Mission("Mars", 8E10f),
        new Mission("Neptune", 1.0E12f),
        new Mission("Barrayar", 1E16f),
        new Mission("Saturn", 8E11f),
        //TEST_MISSION2
        new Mission("Mustafar", 0.99E10F),
        new Mission("Kashyyyk", 0.15E8F),
        new Mission("Coruscant", 1.5999E14F),
        new Mission("Hoth", 2.4582948E13F)
	};
	
	
	public static void main(String[] args)
	{

		MissionOrganizer organizer = new MissionOrganizer();
		for (Mission m: TEST_MISSIONS)
			organizer.add(m);
		
		for (Mission m: organizer)
			System.out.println(m);
	}
}
