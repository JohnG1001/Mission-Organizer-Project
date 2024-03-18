package space;

import java.util.ArrayList;


public class Mission implements Comparable<Mission>
{
	private String			destination;
	private float			cost;
	
	
	public Mission(String destination, Float cost)
	{
		this.destination = destination;
		this.cost = cost;
	}
	
	
	public String getDestination()
	{
		return destination;
	}
	
	
	public float getCost()
	{
		return cost;
	}


	// Compare by cost, then by destination.
	public int compareTo(Mission that) 
	{ 		
		float costComp = (int) (this.cost - that.cost);
		if(costComp != 0)
		{
			return (int)costComp;
		}
		else
		{
			return (int)Math.signum(this.destination.compareTo(that.destination));
		}

	}
	
	
	// Let compareTo() do the work. This method should just be 1 line.
	public boolean equals(Object x)
	{
		Mission that = (Mission) x;
		return this.compareTo(that) == 0;
	}
	
	
	// Return the destination’s hash code.
	public int hashCode()
	{
		return destination.hashCode();
	}
	
	
	public String toString()
	{
		return "Mission to " + destination + " will cost " + cost;
	}
	
	public static void main(String[] args)
	{
		Mission newMission = new Mission("Mars", (float) 1.57);
		Mission oldMisstion = new Mission("Saturn", (float)1.57);
		
		System.out.println(newMission.getDestination() + " " + newMission.getCost());
		System.out.println(newMission.compareTo(oldMisstion));
		System.out.println(newMission.equals(oldMisstion));
		System.out.println(newMission.hashCode());
	}
}
