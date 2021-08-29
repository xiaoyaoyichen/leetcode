import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] sArray = s.split(" ");
        int l = sArray.length;
        System.out.println(sArray[l - 1].length());*/

       /* Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();
        String c = scanner.next().toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c.charAt(0)) {
                count++;
            }
        }
        System.out.println(count);*/


       /* Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        for (int i = 2; i <= t; i++) {
            if (t % i == 0) {
                t = t / i;
                System.out.print(i + " ");
                i = 1;
                if (t == 1) {
                    break;
                }

            }
        }*/

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] sArr = s.split("\\s+");
        for (int i = 0; i < sArr.length; i++) {
            System.out.print(sArr[sArr.length - i -1] + " ");
        }
    }



}