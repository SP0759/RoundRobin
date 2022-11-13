// package roundrobin;		
import java.util.*;
public class Roundrobin {
    public static void main(String[] args) {
        int n,sum=0;
        float total_tt=0,total_waiting=0;
          Scanner s=new Scanner(System.in);
          System.out.println("Enter Number Of Process U want 2 Execute---"); 
          n=s.nextInt();						/// Taking input 
          int arrival[]=new int[n];
          int cpu[]=new int[n];
          int ncpu[]=new int[n];
          int pri[]=new int[n];
          int finish[]=new int[100];
          int turntt[]=new int[n];
          int wait[]=new int[n];
          int process[]=new int[n];
          int t_quantum,difference,temp_sum=0,k=0;
          int seq[]=new int[100];
          
         // int pro[][]=new int[3][3];
          for(int i=0;i<n;i++)
          {
                System.out.println("Enter arrival time of "+(i+1)+" Process : ");
                arrival[i]=s.nextInt();
                System.out.println("Enter CPU time of "+(i+1)+" Process : ");
                ncpu[i]=cpu[i]=s.nextInt();
                
                
                
                process[i]=i+1;
          }
          
         System.out.println("Enter time quantum : ");
         t_quantum = s.nextInt();
          
          int temp=0;
          for(int i=0;i<n;i++){temp_sum=temp_sum+cpu[i];}
          //System.out.println(temp_sum);
          
          
          System.out.println("Process execution sequence : ");
          while(sum!=temp_sum){
		  for(int i=0;i<n;i++)
		  {
		  	if(ncpu[i]<t_quantum)
		  		{
		  			difference=ncpu[i];
		  			temp=ncpu[i];
		  			ncpu[i]=0;
		  		}
		  	else
		  		{
		  			difference = ncpu[i]-t_quantum;
		  			temp=t_quantum;
		  			ncpu[i]=difference;
		  		}
		  	if(temp > 0)
		  	{	
		        sum=sum+temp;
		        finish[k]=sum;
		        seq[k]=i;
		        System.out.print(seq[k]+1+" ");
		        
		        k++;
		        
		        }
		  }
          }
          System.out.println();
          
          for(int i=0;i<n;i++)
          {	
          	int carr=0,tt=0;
          	carr=arrival[i];
          	
          	for(int j=0;j<k;j++)
          	{
                	if(seq[j]==i)
                	{
                		tt=tt+(finish[j]-carr);
                		carr=finish[j];
                	}
                }
                
                turntt[i]=tt;
                System.out.println("Turn around time for "+(i+1)+" process : "+turntt[i]);
                total_tt=total_tt+turntt[i];
                
                wait[i]=turntt[i]-cpu[i];
                
                System.out.println("Waiting time for "+(i+1)+" process : "+wait[i]);
                
                total_waiting+=wait[i];
          }
          System.out.println("-------------------------------------------------");
          System.out.println("Process\t\tAT\tCPU_T");
          for(int i=0;i<n;i++)
          {
                System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+cpu[i]);
          }
          
          System.out.println("-------------------------------------------------");
          System.out.println("Total turn around time is : "+(total_tt/n));
          System.out.println("\nTotal waiting time is : "+(total_waiting/n));
          
                                    
    }
}
/*
 * Output:- 
 * 
Enter Number Of Process U want 2 Execute---
4
Enter arrival time of 1 Process :
0
Enter CPU time of 1 Process :
5
Enter arrival time of 2 Process :
2
Enter CPU time of 2 Process :
4
Enter arrival time of 3 Process :
4
Enter CPU time of 3 Process :
7
Enter arrival time of 4 Process :
6
Enter CPU time of 4 Process :
6
Enter time quantum :
2
Process execution sequence :
1 2 3 4 1 2 3 4 1 3 4 3
Turn around time for 1 process : 17
Waiting time for 1 process : 12
Turn around time for 2 process : 10
Waiting time for 2 process : 6
Turn around time for 3 process : 18
Waiting time for 3 process : 11
Turn around time for 4 process : 15
Waiting time for 4 process : 9
-------------------------------------------------
Process         AT      CPU_T
1               0       5
2               2       4
3               4       7
4               6       6
-------------------------------------------------
Total turn around time is : 15.0

Total waiting time is : 9.5
 */