import java.util.Scanner;

public class Main {

    public static String IPtoBin(String ip) {
        String output = "";
        String[] words = ip.split("\\.");
        String[] bin_str = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            bin_str[i] = Integer.toBinaryString(Integer.parseInt(words[i]));
            output = output.concat(bin_str[i] + ".");
        }

        return output;
    }

    public static String IPtoDec(String ip) {
        String output = "";
        String[] words = ip.split("\\.");
        int[] dec = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            dec[i] = Integer.parseInt(words[i], 2);
            output = output.concat(dec[i] + ".");
        }

        return output;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input an IP: ");
        String IPin = in.nextLine();
        System.out.print("Your entered IP type is (1)Dec or (2)Bin?: ");
        short answer = in.nextShort();
        if (answer == 1) {
            String out = IPtoBin(IPin);
            System.out.println("Your binary IP: " + out);
            if      (out.charAt(0) == '0') System.out.println("The class of IP is A.");
            else if (out.charAt(0) == '1' && out.charAt(1) == '0') System.out.println("The class of IP is B.");
            else if (out.charAt(1) == '1' && out.charAt(2) == '0') System.out.println("The class of IP is C.");
            else if (out.charAt(2) == '1' && out.charAt(3) == '0') System.out.println("The class of IP is D.");
            else if (out.charAt(3) == '1' && out.charAt(4) == '0') System.out.println("The class of IP is E.");
            else System.out.println("Error at if-else algorithm!");
        }
        else {
            String out = IPtoDec(IPin);
            System.out.println("Your decade IP: " + out);
            if      (IPin.charAt(0) == '0') System.out.println("The class of IP is A.");
            else if (IPin.charAt(0) == '1' && IPin.charAt(1) == '0') System.out.println("The class of IP is B.");
            else if (IPin.charAt(1) == '1' && IPin.charAt(2) == '0') System.out.println("The class of IP is C.");
            else if (IPin.charAt(2) == '1' && IPin.charAt(3) == '0') System.out.println("The class of IP is D.");
            else if (IPin.charAt(3) == '1' && IPin.charAt(4) == '0') System.out.println("The class of IP is E.");
            else System.out.println("Error at if-else algorithm!");
        }
    }
}
