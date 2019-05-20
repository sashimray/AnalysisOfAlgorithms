package com.company;


public class CalcPi {
    public static double sims=100000;

    public static boolean check_if_valid(double gen_x,double gen_y){
        double area= Math.pow(gen_x,2) + Math.pow(gen_y,2);
        if (area<=1){
            return true;
        }
        return false ;
    }
    public static void main(String[] args){
        double winner = 0;
        for (int i = 0; i<=sims; i++){
            double gen_x = Math.random(); // get random number between 0 and 1
            double gen_y = Math.random();

            if (check_if_valid(gen_x,gen_y)){
                winner+=1;
            }
        }System.out.println("Result : ");
        System.out.println("Darts inside the circle  " + winner + " out of "+ sims +" times ");
        calculate_final(winner);
    }

    public static void calculate_final(double final_ans){
        double calc_final = 4 * (final_ans/sims);
        System.out.println("The approx = " + calc_final + "  ");
    }

}
