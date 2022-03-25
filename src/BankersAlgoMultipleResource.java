package bankerAlgoMultipleResource;
import java.util.ArrayList;
import java.util.Scanner;

public class BankersAlgoMultipleResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ask user for the number of processes and number of resources
		
		//create existing,possessed and available arrays & allocation and need matricess. 
		// such that available = existing-possessed 
		
		//scan need table to know which process can be given resources. when found, note it down and add the allocated res to available
		//add logs
		
		
		//iterate above step. while availablearray != existing array 
		//===========================================//
		
		int noOfResourceTypes=0, noOfProcesses=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the total number of types of resources:");
		noOfResourceTypes=sc.nextInt();
		
	    System.out.println("Enter the total number of processes:");
	    noOfProcesses=sc.nextInt();
	    
	    if(noOfResourceTypes>0 && noOfProcesses>0)
	    {
	    	int maxNeedMatrix[][]= {{0,0,1,2},{1,7,5,0},{2,3,5,6},{0,6,5,2},{0,6,5,6}};//new int[noOfProcesses][noOfResourceTypes];
	    	int needMatrix[][] = {{0,0,0,0},{0,7,5,0},{1,0,0,2},{0,0,2,0},{0,6,4,2}};//new int[noOfProcesses][noOfResourceTypes];
	    	int allocated[][] = {{0,0,1,2},{1,0,0,0},{1,3,5,4},{0,6,3,2},{0,0,1,4}};//  new int[noOfProcesses][noOfResourceTypes];
	    	int available[] = {0,1,0,0};// new int[noOfResourceTypes];
	    	int possessed[] = {2,9,10,12}; //new int[noOfResourceTypes];
	    	int existing[] = {2,10,12,12}; //new int[noOfResourceTypes];
	    	ArrayList<Integer> safeSequence = new ArrayList<Integer>();
	    	boolean isSafe=true;
	    	int failCount=0;
	    	int remainingCount=noOfProcesses;
	    	int i , j, sum;
	    	
	    	
//	    	System.out.println("Enter available resources vector.\n");
//	    	for(i=1;i<=noOfResourceTypes;i++)
//	    	{
//	    		System.out.println("Available no.of resources of type: "+i+":");
//	    		existing[i-1]=sc.nextInt();
//	    	}
//	    	
//	    	System.out.println("Enter maximum need matrix.\n");
//	    	for( i=1;i<=noOfProcesses;i++)
//	    	{
//	    		for(j=1;j<=noOfResourceTypes;j++)
//	    		{
//	    			System.out.println("Max no. of resources of type: "+j+" required by process "+i+":");
//	    			maxNeedMatrix[i-1][j-1]=sc.nextInt();
//	    		}	    		
//	    	}
//	    	
//			System.out.println("Enter allocated resources matrix and possessed vector.\n");
//	    	for(i=1;i<=noOfProcesses;i++)
//	    	{
//	    		for(j=1;j<=noOfResourceTypes;j++)
//	    		{
//	    			System.out.println("Resources of type: "+j+" allocated to process "+i+":");
//	    			allocated[i-1][j-1]=sc.nextInt();
//	    		    possessed[j-1]=possessed[j-1]+allocated[i-1][j-1];
//	    		}
//	    		
//	    	}
//	    	
//	    	System.out.println("Generating existing resources vector.\n");
//	    	for(i=1;i<=noOfResourceTypes;i++)
//	    	{
//	    		existing[i-1]=available[i-1]+possessed[i-1];
//	    	}
//	    	
//	    	System.out.println("Generating need matrix.\n");
//	    	for(i=1;i<=noOfProcesses;i++)
//	    	{
//	    		for(j=1;j<=noOfResourceTypes;j++)
//	    		{
//	    			sum=maxNeedMatrix[i-1][j-1]-allocated[i-1][j-1];
//	    			if(sum>0)
//	    			{needMatrix[i-1][j-1]=sum;}
//	    			else
//	    			{
//	    				System.out.println("Resource allocation cannot be done as allocation exceeds maximum need for process"+ i);
//	    				isSafe=false;
//	    				break;
//	    			}
//	    		}
//	    		if(!isSafe)
//	    		{
//	    			break;
//	    		}	
//	    		else
//	    		{isSafe=true;}
//	    	}
//	    		
//	    	
	    	System.out.println("Scanning need matrix to know which process can be given resources.\n");
	    	i=1;
	    		while(i<=noOfProcesses)
	    		{
	    			if(!safeSequence.contains(i))
	    			{System.out.println("Process "+i+" requesting:");
	    			for(j=1;j<=noOfResourceTypes;j++)
	    			{
	    				if(needMatrix[i-1][j-1]>available[j-1])
	    				{
	    					isSafe=false;
	    					//failCount++;
	    					break;
	    				}
	    				
	    			}	    		
	    			if(isSafe)
	    			{
	    				
	    				safeSequence.add(i);
	    				for(j=1;j<=noOfResourceTypes;j++)
		    			{
		    				available[j-1]+=allocated[i-1][j-1];
		    			}	
	    				System.out.println("Request granted to process "+i);
	    			}
	    			else
	    			{ 
	    				System.out.println("Cannot grant resources to process "+i);
	    			}
	    			
	    			}
	    			
	    			if(i==noOfProcesses && safeSequence.size()<noOfProcesses)
	    			{
	    				if(failCount==remainingCount)
	    				{
	    					break;
	    				}
	    				i=1;
	    			}
	    				else
	    				{i++;}
	    		
	    		}
	    		
	    		
	    	
	    	
	    }
	    else
	    {
	    	 System.out.print("Enter valid number of processes and resources");
	    }
		

	}

}