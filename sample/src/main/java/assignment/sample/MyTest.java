package assignment.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MyTest 
{
	HashMap<String,Integer> stateCounts;
	HashMap<String,String> stateNames;
	List<InputData> inputList;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MyTest t=new MyTest();
        System.out.println(t.stateNames());
        System.out.println(t.inputList().get(1).getFullName());
        t.stateNames();
        t.inputList();
        t.stateCounters();
        t.resultByState();
        
    }
    
    public  HashMap<String,String> stateNames() {    	
    	stateNames =new HashMap<String, String>();
    	stateNames.put("NY", "New York" );
    	stateNames.put("KY", "Kentucky" );
    	stateNames.put("TX", "Texas" );
    	return stateNames;
    }
    
    public List<InputData> inputList()
    {
    	inputList= new ArrayList<InputData>();
    	inputList.add(new InputData("Mary Jane Smith", "TX"));
    	inputList.add(new InputData("John Jones", "NY"));
    	inputList.add(new InputData("Madonna", "NY"));
    	inputList.add(new InputData("Mark Anthony Lewis", "KY"));    	
    	inputList.add(new InputData("Sue Reed", "TX"));
    	inputList.add(new InputData("Tim Oscar Steele", "TX"));
    	
    	return inputList;
    }
    
    	public void stateCounters()
    	{
    		stateCounts =new HashMap<String, Integer>();
    		
    		for(String s :stateNames.keySet())
    		{
    			stateCounts.put(s,0);
    		}
    		
    		for(InputData objw :inputList)
    		{
    			String code=objw.getStateCd();
    			if(stateCounts.containsKey(code))
    			{
    				stateCounts.put(code, (stateCounts.get(code)+1));
    			}
    			else
    			{
    				stateCounts.put(code,1);
    			}
    		}
    		
    		/*for(String s :stateNames.keySet()){
    			int counter=0;
    			for(InputData objw :inputList)
        		{
        			String code=objw.getStateCd();
        			
        			if(s.equals(code))
        			{
        				counter++;
        			}
        			
        		}
    			
    			if(counter==0)
    				++counter;
    			stateCounts.put(s, counter);
    		}
    		*/
    		
    		
    		
    	}
    	
    	public void resultByState()
    	{
    		
    		stateNames.forEach((k,v)->    		
    				{
    					
    					System.out.println(v+" ("+stateCounts.get(k)+")");
    					for(InputData i : inputList)
						{
							if(k==i.getStateCd()){
								/*String[] arr=i.getFullName().split(" ");
								if(arr.length==3)
								{
									System.out.println(arr[0]+" "+arr[2]);
								}
								else 
								{
									System.out.println(i.getFullName());
								}*/
								System.out.println(i);
							}
						}
    					/*if(stateCounts.keySet().contains(k))
    					{
    						System.out.println(v+"--"+stateCounts.get(k));
    						for(InputData i : inputList)
    						{
    							if(k==i.getStateCd())
    								System.out.println(i.getFullName());
    						}
    					}*/
    				});
    		
    		
    	}
}

 final class InputData
{
	private final String fullName ;
	private final String stateCd;
	public InputData(String fullName, String stateCd) {
		this.fullName=fullName;
		this.stateCd=stateCd;
	}
	
	public String getFullName()
	{
		return fullName;
	}
	public String getStateCd()
	{
		return stateCd;
	}
	@Override
	public String toString() {
		StringBuilder s=new StringBuilder();
		String[] arr=this.getFullName().split(" ");
		if(arr.length==3)
		{
			s=s.append(arr[0]+" "+arr[2]);
		}
		else 
		{
			s=s.append(this.getFullName());
		}
		return s.toString();
	}
}
