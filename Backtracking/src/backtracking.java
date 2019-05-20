import java.util.Scanner;

public class backtracking {

    static int count =0;

    public static void get_solutions(int n , int index, int[] arr, int sum){
        if (n<0){
            return ; //do nothing
        }
        if(n==0){ // solution
            count++;
            System.out.print("Solution " + count + ": " );
            for (int i = 0; i< arr.length; i++)
                if (arr[i]!=0)
                    System.out.print(arr[i] + " ");
            System.out.println();
        }
        if(n>0) {
            for (int k =1; k <= sum; k++) {
                arr[index] = k;
                get_solutions(n - k, index + 1, arr, sum);
                arr[index] = 0;
            }
        }
    }

    public static int schmibonacci(int num){
        int i, sum;

        if(num==0){
            count++;
            return 1;
        }
        else{
            sum=0;
            for(i=0;i<=num-1;i++){
                sum = sum +schmibonacci(i);

            }
        }
        return schmibonacci(num-1) * sum;
    }

    public static int new_schmibonacci(int num){
        int i, sum,temp;

        if(num==0){
           count++;
            return 1;
        }
        else{
            sum=0;
            for(i=0;i<=num-2;i++){
                sum = sum +new_schmibonacci(i);
            }
            temp = new_schmibonacci(num-1);

        }
        return temp *(sum+temp);
    }

    public static int lin_schmib(int n){
        int curr_element = 0, prev_element=0, sum =0;
        for(int i = 0; i<=n; i++){
            if (i ==0){
                curr_element = 1;
            }else{
                curr_element = prev_element*sum;
            }
            sum+= curr_element;
            prev_element = curr_element;
        }

        return curr_element;
    }

    public static void main(String[] args){
//        Scanner in_num = new Scanner(System.in);  // Input
//        System.out.println("Enter a number: ");
//        int num = in_num.nextInt();
//        int[] arer = new int[num];
//        get_solutions(num ,0, arer, num);
//        in_num.close();
        int n = 10;
        for (int i = 0 ; i<=n ;i++){
//            int answer = 0;
//            answer = schmibonacci(i);
//            System.out.print("T("+i+") " + answer);
//            System.out.print("  A("+i+") " + count );
//            System.out.println(" ");
            count=0;
//            System.out.println(" ----- New Schmib -----");
            int new_ans = 0;
            new_ans= new_schmibonacci(i);
            System.out.print("T("+i+")" + new_ans);
            System.out.print(" A("+i+")" + count);
            System.out.println(" ");
//            System.out.println(" -------------- ");
        }

        int lin_schmib = lin_schmib(n);
        System.out.println("Linear Schmib Print " + lin_schmib);

    }
}
