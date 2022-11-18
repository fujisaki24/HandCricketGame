// Online Java Compiler
// Use this editor to write, compile and run your Java code online

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.util.Random;   
class HelloWorld {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Random random = new Random(); 
       int p1_score = 0;
       int cpu_score = 0;
       int toss=0;
       int wickets=1;
       int innings=0;
       boolean isBat,isBowl;
       boolean isPlaying = false;
       
       do
       {
         if(toss==0)
         {
         System.out.println("Hand Cricket Game\n1.Bat\n2.Bowl\n");
         System.out.printf("\nEnter choice:");
         toss = sc.nextInt();
         if(toss>3 || toss==0)
         {
             System.out.println("Invalid input!!!!\nRe-try");
             toss=0;
             isPlaying=true;
             continue;
         }
         }
         
         if(toss==1 && innings==0)
         {
             System.out.println("First innings.Score as much possible\n");
             p1_score=BattingFunction(wickets,true,Integer.MAX_VALUE);
             innings++;
             toss=2;
             ++p1_score;
             System.out.println("Player score:"+p1_score);
             isPlaying=true;
         }
         else if(toss==2 && innings==1)
         {
             System.out.println("\nSecond innings.Opponents have to chase "+p1_score+" runs.");
             cpu_score=BattingFunction(wickets,false,p1_score);
             System.out.println("CPU score:"+cpu_score);
             isPlaying=false;
         }
         else if(toss==2 && innings==0)
         {
             System.out.println("\nFirst innings.Defend as much possible\n");
             cpu_score=BattingFunction(wickets,false,Integer.MAX_VALUE);
             innings++;
             toss=1;
             ++cpu_score;
             System.out.println("CPU score:"+cpu_score);
             isPlaying=true;
         }
         else if(toss==1 & innings==1)
         {
             System.out.println("\nSecond innings.Opponents have to chase "+cpu_score+" runs.");
             p1_score=BattingFunction(wickets,true,cpu_score);
             System.out.println("Player score:"+p1_score);
             isPlaying=false;
         }
         
         //Win Screen
         if(isPlaying==false)
         {
         if(cpu_score>p1_score) System.out.println("\nYou Suck my friend!!");
         else if(p1_score>cpu_score) System.out.println("\nYou Won!!Hurray!!");
         else if(p1_score==cpu_score) System.out.println("\nDraw Match!!");
         
         System.out.println("Do you want to play again??(Y/N)");
         char c = sc.next().charAt(0);
         if(c=='y'||c=='Y')
         {
             isPlaying=true;
             toss=0;
             p1_score=0;
             cpu_score=0;
             innings=0;
         }
         else if(c=='N'||c=='n')isPlaying=false;
         else System.out.println("System Error!!!");
         
         }
         
           
       }while(isPlaying);
       
       
       
    }
    
    //Scoring
    public static int BattingFunction(int wickets,boolean isPlayerBatting,int chase_score)
    {
       Scanner sc = new Scanner(System.in);
       Random random = new Random(); 
        int score=0;
        int p_input;
        int cpu_input=-1;
        boolean isOver = false;
        //int[] players = new int[wicket];
        do
        {
            if(isPlayerBatting==true)
            {
            System.out.printf("\nPlay\nEnter input:");
            p_input=sc.nextInt();
            if(p_input>7)
            {
                System.out.println("Reball!! Invalid input\n");
                continue;
            }
            cpu_input = random.nextInt(7);
            if(p_input==cpu_input)
            {
                System.out.println("Wicket!!!\nPlayer input="+p_input+"\nCPU input="+cpu_input+"\n");
                isOver=true;
                
            }
            else
            {
                score+=p_input;
                System.out.println("Score="+score+"\n");
                cpu_input=-1;
            }
             if(score>chase_score)
            {
                isOver=true;
            }
            }
            else
            {
                System.out.printf("\nPlay\nEnter input:");
            p_input=sc.nextInt();
            if(p_input>7)
            {
                System.out.println("Reball!! Invalid input\n");
                continue;
            }
            cpu_input = random.nextInt(7);
            if(p_input==cpu_input)
            {
                System.out.println("Wicket!!!\nPlayer input="+p_input+"\nCPU input="+cpu_input+"\n");
                isOver=true;
            }
            else
            {
                score+=cpu_input;
                System.out.println("Score="+score+"\n");
                cpu_input=-1;
            }
            if(score>chase_score)
            {
                isOver=true;
            }
            }
        }while(isOver==false);
        return score;
    }
    
    
    
}