import java.util.*;
public class spos7 {
    boolean find(int[] frame, int ref){
        for (int i = 0; i < frame.length; i++) {
            if (frame[i] == ref) {
                return true;
            } 
        }
        return false;
    }
    int findIndex(int[] frame, int ref){
        for (int i = 0; i < frame.length; i++) {
            if (frame[i] == ref) {
                return i;
            } 
        }
        return 0;
    }
    void lru(){
        Scanner sc = new Scanner(System.in);
        int index = -1;
        System.out.println("Enter number of frames : ");
        int frames = sc.nextInt();
        System.out.println("Enter number of elements in the reference String : ");
        int n = sc.nextInt();
        int[] ref = new int[n];
        int[] frame = new int[frames];
        Arrays.fill(frame, -1);
        System.out.println("Enter the elements of the reference String : ");
        for (int i = 0; i < n; i++) {
            ref[i] = sc.nextInt();
        }
        int faults = 0;
        for (int i = 0; i < frames; i++) {
            frame[i] = ref[i];
            faults++;
            for (int k = 0; k < frame.length; k++) {
                if (frame[k] != -1) {
                    System.out.print(frame[k] + " ");
                }
            }
            System.out.println();
        }
        for (int i = frames; i < n; i++) {
            if (!find(frame, ref[i])) {
                faults++;
                index = (i - frames) % frames;
                frame[index] = ref[i];
            }
            else{
                index = (i - frames) % frames;
            }
            for (int k = 0; k < frame.length; k++) {
                System.out.print(frame[k] + " ");   
            }
            System.out.println();
        }
        System.out.println("Total Faults : " + faults);
        sc.close();
    }
    void optimal(){
        Scanner sc = new Scanner(System.in);
        int index = -1;
        System.out.println("Enter number of frames : ");
        int frames = sc.nextInt();
        System.out.println("Enter number of elements in the reference String : ");
        int n = sc.nextInt();
        int[] ref = new int[n];
        int[] frame = new int[frames];
        Arrays.fill(frame, -1);
        System.out.println("Enter the elements of the reference String : ");
        for (int i = 0; i < n; i++) {
            ref[i] = sc.nextInt();
        }
        int faults = 0;
        for (int i = 0; i < frames; i++) {
            frame[i] = ref[i];
            faults++;
            for (int k = 0; k < frame.length; k++) {
                if (frame[k] != -1) {
                    System.out.print(frame[k] + " ");
                }
            }
            System.out.println();
        }
        for (int i = frames; i < n; i++) {
            if (!find(frame, ref[i])) {
                faults++;
                int far = 0;
                for (int j = 0; j < frames; j++) {
                    int page = frame[j];
                    int k;
                    for (k = i + 1; k < n; k++) {
                        if (page == ref[k]) {
                            break;
                        }
                    }
                    if (k == n) {
                        index = j;
                        break;
                    }
                    if (k > far) {
                        far = k;
                        index = j;
                    }
                }
                frame[index] = ref[i];
            }
            for (int k = 0; k < frame.length; k++) {
                System.out.print(frame[k] + " ");   
            }
            System.out.println();
        }
        System.out.println("Total Faults : " + faults);
        sc.close();
    }
    public static void main(String[] args) {
        spos7 obj = new spos7();
        //obj.lru();
        obj.optimal();
    }
}




/*
1   1   1   4
-1  2   2   2
        3   3
 */