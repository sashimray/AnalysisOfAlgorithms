import java.util.Random;


public class MusicChairs {
    static int num = 5;
    static int[] players = new int[num];
    static int[] chairs = new int[num-1];
    static double simulations = 250000;

    public static int[] get_solutions(int player_num){
        int[] last_winner = new int[player_num];
        while(player_num>2){                   //while there more than 1 players
            for (int i = 1; i < player_num; i++) {
                if (players[i]!=0){
                    int index = i;
                    if (i > 1 && i < player_num - 1) {                  // between two ends
                        index += toss() - 1;                            // going left or right
                    }
                    if (i == player_num - 1) {                          // The last player
                        if (is_occupied(player_num - 2,chairs)){
                            int lor = toss();
                            if (lor == 0) {
                                chairs[player_num - 2] = players[i];
                            } else {
                                chairs[player_num - 2] = players[i - 1];
                            }
                        }
                        else{
                            chairs[player_num-2]=players[i];
                        }
                    } else {
                        if (!is_occupied(index,chairs)) {
                            chairs[index] = players[i];
                        } else {
                            int win_lose = toss();
                            if (win_lose== 1) {  //0 current_player loses , 1 wins
                                chairs[index] = players[i];
                            }
                        }
                    }
                }
            }

            print_players(chairs);
            last_winner = chairs ;
            player_num = update_plys_chairs(player_num-1, chairs );

        }
        return last_winner;
    }

    public static void print_players(int[] players_in_game){
        for (int i = 1 ; i< players_in_game.length; i++){
            System.out.print(players_in_game[i]+" ");
        }
        System.out.println("");
    }

    public static boolean is_occupied( int chair_id, int[] current_chair){
        if (current_chair[chair_id]==0){
            return false;
        }
        return true;
    }

    public static int update_plys_chairs(int current_player,  int[] chs ){
//        int[] empty = new int[chs.length];
//        int check = 1;
//        for (int i =1; i < chs.length ; i++) {
//            if(chs[i]!=0){
//                empty[check++]=chs[i];
//            }
//        }
//        players = new int[check];
//        System.arraycopy( empty, 0, players, 0, check );
        players = chs;
        chairs = new int[current_player-1];
        return current_player-1;
    }

    public  static int toss(){
        Random rand = new Random();
        return rand.nextInt(2); // integer range 0 and 1
    }

    public static void reset_ply_chs (int play_num){    //reset players and chairs
        players = new int[play_num];
        for (int i = 0; i< play_num ; i++){  //initialise player_id
            players[i] = i;
        }
        chairs= new int[play_num-1];   //initialise empty chairs
    }

    public static int[] player_scoreboard(int player_id , int[] update_scoreboard){
        update_scoreboard[player_id] +=1 ;
        return update_scoreboard;
    }

    public static void print_probability(int[] final_scoreboard , double sims){
        System.out.print("n = "+ String.valueOf(final_scoreboard.length -1 ) + " : ");
        for (int i = 1; i<final_scoreboard.length; i++){
//            System.out.print(" Player " + i + " prob " + String.format("%.6f", (final_scoreboard[i]/sims ))  );
            System.out.print( "  " + String.format("%.6f", (final_scoreboard[i]/sims ))  );
        }
        System.out.println("");
    }

    public static void main(String[] args){
        int minm = 3;   // minimum players +1
        int max = 21;    // max players +1
        int[] scoreboard = new int [max];
        for (int plays = minm ; plays <= max ; plays++ ) {
            scoreboard = new int [plays];
            reset_ply_chs(plays);
            for ( int i = 0 ; i<simulations ; i++ ){
                int[] winner = get_solutions(plays);
                scoreboard = player_scoreboard(winner[1], scoreboard);
                reset_ply_chs(plays);
            }
            print_probability(scoreboard, simulations);
        }

    }
}
