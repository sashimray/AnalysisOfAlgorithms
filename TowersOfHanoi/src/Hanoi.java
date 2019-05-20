/*
    Towers of Hanoi

1. Simple Hanoi
    # Move only 1 ring at a time
    # Cant put a long ring on a smaller ring

      |               |              |
      |               |              |
   ___|___         ___|___        ___|___
    From(1)         To(2)         Spare(3)


2. Linear Hanoi
  #Usual rules + Rings cannot go directly from one end to the other end


      |               |              |
      |               |              |
   ___|___         ___|___        ___|___
    From(A)        Spare(B)         To(C)

3. "Second-Half" Linear Hanoi : Mid to End
  #Usual rules + Rings cannot go directly from one end to the other end


      |               |              |
      |               |              |
   ___|___         ___|___        ___|___
    Spare(A)        From(B)         To(C)

3. "First-Half" Linear Hanoi : End to Mid
  #Usual rules + Rings cannot go directly from one end to the other end


      |               |              |
      |               |              |
   ___|___         ___|___        ___|___
    From(A)         To(B)         Spare(C)

 */



public class Hanoi {


//    static void simpleHanoi(int n, char from, char to, char spare){
//        if(n>0){
//            simpleHanoi(n-1, from, spare, to);
//            System.out.println("---Move ring " + n + " from peg  " + from + " to peg  "  + to);
//            simpleHanoi( n-1, spare, to, from);
//        }
//
//    }

    static void simpleHanoi(int n, int from, int to, int spare){
        if(n>0){
            simpleHanoi(n-1, from, spare, to);
            System.out.println("Move ring " + n + " from peg  " + from + " to peg  "  + to);
            simpleHanoi( n-1, spare, to, from);
        }

    }

    static void linHanoi(int n, int from, int to, int spare){
        if(n>0){
            linHanoi(n-1, from, to, spare);
            System.out.println("move ring " + n + " from peg  " + from + " to peg  "  + spare);
            linHanoi( n-1, to, from, spare );
            System.out.println("move ring " + n + " from peg  " + spare + " to peg  " + to);
            linHanoi(n-1 , from, to, spare);
        }

    }

    static void mid_to_end(int n, int from, int to, int spare){
        if(n>0){
                mid_to_end(n-1, from, spare, to);
                System.out.println("  Move ring " + n + " from peg  " + from + " to peg  "  + to);
                linHanoi(n-1, spare, to, from);
            }
    }

    static void end_to_mid(int n, int from, int to, int spare){
        if(n>0) {
            linHanoi(n-1, from, spare, to);
            System.out.println(" Move ring " + n + " from peg  " + from + " to peg  "  + to);
            end_to_mid(n-1, spare, to, from);
        }
    }

    static int num =3;
//    static int[] destination= {0,3,2,1};// not using index = 0
    static int[] destination= {0,3,3,3,3};
    static void reverse_hanoi(int n, int from){
        if(n>0){
            if (destination[n] == from){
                reverse_hanoi(n-1, from);
            }else{
                simpleHanoi(n-1, from, (6-from-destination[n]) ,  destination[n] );
                System.out.println(" 1Move ring " + n + " from peg  " + from + " to peg  " + destination[n] );
                reverse_hanoi(n-1, (6-from-destination[n]) );
            }
        }
    }


    // not using index = 0
    static int[] dest= {0,1,1,1,1,2};
    static void reverse_linhanoi(int n, int from){
        if(n>0){
            if (dest[n] == from){
                reverse_linhanoi(n-1, from);
            }else {
               if (dest[n] >= (6-from-dest[n]) ) {
                    linHanoi(n-1, from, dest[n], (6-from-dest[n]));
                    System.out.println(" 1Move ring " + n + " from peg  " + from + " to peg  " + (6-from-dest[n]) );
                   reverse_linhanoi(n-1,(dest[n]) );
                   System.out.println("  2Move ring " + n + " from peg  " + (6-from-dest[n]) + " to peg  " + (dest[n]));
                }else{
                    linHanoi(n-1, from, (6-from-dest[n]), dest[n]);
                    System.out.println(" 3Move ring " + n + " from peg  " + from + " to peg  " +  (dest[n]) );
                    reverse_linhanoi(n-1, (6-from-dest[n]) );
                    System.out.println("  4Move ring " + n + " from peg  " +  (dest[n])  + " to peg  " +(6-from-dest[n]));
             }
                }
//            }
                }


    }

    public static void main(String[] args) {
        Hanoi exm = new Hanoi();
//        exm.simpleHanoi(3,1,3,2 );
//        exm.linHanoi(3, 1,3,2);
//        exm.mid_to_end(3, 'B','C','A');
//        exm.end_to_mid(3, '1','2','3');
        exm.reverse_hanoi(destination.length-1, 1);
//        exm.reverse_linhanoi(dest.length-1, 1);
    }
}
