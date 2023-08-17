import java.util.*;
import java.lang.Math;
class test2{
    static HashSet<Integer> player1=new HashSet<Integer>();
    static HashSet<Integer> player2=new HashSet<Integer>();
    static ArrayList<Integer> empty=new ArrayList<Integer>();
    
    public static void main(String args[]){
        char [][] gameboard={
            {' ','|',' ','|',' '},
            {'-','|','-','|','-'},
            {' ','|',' ','|',' '},
            {'-','|','-','|','-'},
            {' ','|',' ','|',' '}
        };
        empty.add(1);empty.add(2);empty.add(3);
        empty.add(4);empty.add(5);empty.add(6);
        empty.add(7);empty.add(8);empty.add(9);
        Scanner input=new Scanner(System.in);
        System.out.println("<----Welcome to TICTACTOE developed by ARIVENI MANIKANT---->");
        System.out.println("Enter Your Name:");
        String p1=input.nextLine();
        System.out.println("Select your play mode:");
        System.out.println("1. To play with computer");
        System.out.println("2. To play with friend(Offline)");
        System.out.println("3. To play with AI machine");
        int choice=input.nextInt();
        display_board(gameboard);
        if(choice==1){
                while(true)
                    {
                        System.out.println("Enter number from 1-9");
                        int position=input.nextInt();
                        while(player1.contains(position) || player2.contains(position))
                        {
                            System.out.println(position+" already used plz Retry,");
                            System.out.println("Enter number from 1-9");
                            position=input.nextInt();
                        }
                        place(gameboard,position,"player1");
                        String status=check_win();
                        if(status.length()>0){
                            System.out.println("You "+status);
                            break;
                        }
                        position=computer_generate();
                        while(player1.contains(position) || player2.contains(position))
                        {
                            position=computer_generate();
                        }
                        place(gameboard,position,"player2");
                        status=check_win();
                        if(status.length()>0){
                            System.out.println("Computer "+status);
                            break;
                        }

                    }
        }
        else if(choice==2)
        {
            System.out.println("Enter player2 Name:");
            String p2=input.next();
            while(true)
                    {
                        System.out.println("now it's "+p1+" turn and his symbol->X");
                        System.out.println("Enter number from 1-9");
                        int position=input.nextInt();
                        while(player1.contains(position) || player2.contains(position))
                        {
                            System.out.println(position+" already used plz Retry,");
                            System.out.println("Enter number from 1-9");
                            position=input.nextInt();
                        }
                        place(gameboard,position,"player1");
                        String status=check_win();
                        if(status.length()>0){
                            System.out.println(p1+" "+status);
                            break;
                        }
                        System.out.println("now it's "+p2+" turn and his symbol->O");
                        System.out.println("Enter number from 1-9");
                        position=input.nextInt();
                        while(player1.contains(position) || player2.contains(position))
                        {
                            System.out.println(position+" already used plz Retry,");
                            System.out.println("Enter number from 1-9");
                            position=input.nextInt();
                        }
                        place(gameboard,position,"player2");
                        status=check_win();
                        if(status.length()>0){
                            System.out.println(p2+" "+status);
                            break;
                        }

                    }
        }
        else if(choice==3)
        {
            while(true)
                    {
                        System.out.println("Enter number from 1-9");
                        int position=input.nextInt();
                        while(player1.contains(position) || player2.contains(position))
                        {
                            System.out.println(position+" already used plz Retry,");
                            System.out.println("Enter number from 1-9");
                            position=input.nextInt();
                        }
                        place(gameboard,position,"player1");
                        String status=check_win();
                        if(status.length()>0){
                            System.out.println("You "+status+" Game");
                            break;
                        }
                        position=AI_generate();
                        while(player1.contains(position) || player2.contains(position))
                        {
                            position=AI_generate();
                        }
                        place(gameboard,position,"player2");
                        status=check_win();
                        if(status.length()>0){
                            System.out.println("Computer "+status);
                            break;
                        }

                    }
        }
        else{
            System.out.println("select a valid option");
        }
    }
    static int AI_generate(){
        int i;
        for(i=0;i<empty.size();i++)
        {
            player2.add(empty.get(i));
            String ans=check_win();
            if(ans.equals("Player 2 Won"))
            {

                player2.remove(empty.get(i));
                return empty.get(i);
            }
            
            player2.remove(empty.get(i));
        }
        for(i=0;i<empty.size();i++)
        {
            player2.add(empty.get(i));
            String ans=check_win();
            if(ans.equals("Draw"))
            {
                player2.remove(empty.get(i));
                return empty.get(i); 
            }
            player2.remove(empty.get(i));
        }
        for(i=0;i<empty.size();i++)
        {    
            player1.add(empty.get(i));
            String ans=check_win();
            if(ans.equals("Player1 won"))
            {
                player1.remove(empty.get(i));
                return empty.get(i);
            }
            player1.remove(empty.get(i));
        }
        for(i=0;i<empty.size();i++)
        {    
            player1.add(empty.get(i));
            String ans=check_win();
            if(ans.equals("Draw"))
            {
                player1.remove(empty.get(i));
                return empty.get(i);   
            }
            player1.remove(empty.get(i));
        }
        if(empty.contains(5))
        {
            return 5;
        }
        else{
            if(player2.contains(5))
            {
               int[] corner=new int[]{2,4,6,8};
                for(int j:corner){
                    if(empty.contains(j))
                    {
                    return j;
                    }   
                }
                    
            } 
            else{
                int[] corner=new int[]{1,3,7,9};
                for(int j:corner){
                    if(empty.contains(j))
                    {
                        return j;
                    }
                    
                }
            }
            
            return empty.get(i);
        }
        
    } 
 
    static String check_win(){
        HashSet<Integer> r1=new HashSet<Integer>();
        r1.add(1);r1.add(2);r1.add(3);
        HashSet<Integer> r2=new HashSet<Integer>();
        r2.add(4);r2.add(5);r2.add(6);
        HashSet<Integer> r3=new HashSet<Integer>();
        r3.add(7);r3.add(8);r3.add(9);

        HashSet<Integer> c1=new HashSet<Integer>();
        c1.add(1);c1.add(4);c1.add(7);
        HashSet<Integer> c2=new HashSet<Integer>();
        c2.add(2);c2.add(5);c2.add(8);
        HashSet<Integer> c3=new HashSet<Integer>();
        c3.add(3);c3.add(6);c3.add(9);

        HashSet<Integer> d1=new HashSet<Integer>();
        d1.add(1);d1.add(5);d1.add(9);
        HashSet<Integer> d2=new HashSet<Integer>();
        d2.add(3);d2.add(5);d2.add(7);        

        HashSet<HashSet> set =new HashSet<HashSet> ();
        set.add(r1);set.add(r2);set.add(r3);
        set.add(c1);set.add(c2);set.add(c3);
        set.add(d1);set.add(d2);

        for(HashSet c:set){
            if(player1.containsAll(c)){
                return "Player1 won";
            }
            else if(player2.containsAll(c))
            {
                return "Player 2 Won";
            }
        }
        if(player1.size()+player2.size()==9)
        {
            return "Draw";
        }
        else{
            return "";
        }
    }
    static int computer_generate(){
        int range=9;
        int x=(int)(Math.random()*range)+1;
        return x;

    }
    static void display_board(char [][] gameboard){
        for(int i=0;i<gameboard.length;i++)
        {
            for(int j=0;j<gameboard[0].length;j++)
            {
                System.out.print(gameboard[i][j]);
            }
            System.out.println();
        }
        System.out.println("<------------------------------->");
    }
    static void place(char [][] gameboard,int position,String user){
        char syb='x';
        if(user.equals("player2")){
            syb='O';
            player2.add(position);
            empty.remove(Integer.valueOf(position));
        }
        else{
            player1.add(position);
            empty.remove(Integer.valueOf(position));
        }
        switch(position){
            case 1: gameboard[0][0]=syb;
                    break;
            case 2: gameboard[0][2]=syb;
                    break;
            case 3: gameboard[0][4]=syb;
                    break;    
            case 4: gameboard[2][0]=syb;
                    break;
            case 5: gameboard[2][2]=syb;
                    break;
            case 6: gameboard[2][4]=syb;
                    break;
            case 7: gameboard[4][0]=syb;
                    break;
            case 8: gameboard[4][2]=syb;
                    break;
            case 9: gameboard[4][4]=syb;
                    break;
            default : System.out.println("In valid option");                                    
        }
        display_board(gameboard);

    }
}