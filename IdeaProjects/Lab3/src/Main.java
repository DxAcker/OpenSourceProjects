import java.util.Scanner;

public class Main {

    public static String IPtoBin(String ip) {
        String output = "";
        String[] words = ip.split("\\.");
        String[] bin_str = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            bin_str[i] = Integer.toBinaryString(Integer.parseInt(words[i]));
            while (bin_str[i].length() != 8) {
                bin_str[i] = '0' + bin_str[i];
            }
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

    public static boolean validIPDec (String ip) {
        try {
            if ( ip == null || ip.isEmpty() ) {
                return false;
            }
            String[] parts = ip.split( "\\." );
            if ( parts.length != 4 ) {
                return false;
            }
            for ( String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    return false;
                }
            }
            return !ip.endsWith(".");
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean validIPBin (String ip) {
        try {
            if ( ip == null || ip.isEmpty() ) {
                return false;
            }
            String[] parts = ip.split( "\\." );
            if ( parts.length != 4 ) {
                return false;
            }
            for ( String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 11111111) ) {
                    return false;
                }
            }
            return !ip.endsWith(".");
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean IsBin (String ip) {
        String[] words = ip.split("\\.");
        for (String word : words) {
            if (!word.matches("[0-1]+")) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input an IP: ");
        String IPin = in.nextLine();
        if (!IsBin(IPin)) {
            if (!validIPDec(IPin)) {
                System.err.println("Your ip is incorrect! Try again!");
            } else {
                String out = IPtoBin(IPin);
                String[] parts = IPtoBin(IPin).split("\\.");
                System.out.println("Your binary IP: " + out);
                if (out.charAt(0) == '0' && Integer.parseInt(parts[0]) != 0) {
                    System.out.println("The class of IP is A.");
                }
                else if (out.charAt(0) == '1' && out.charAt(1) == '0' && Integer.parseInt(parts[1]) != 0 && Integer.parseInt(parts[0]) != 0) {
                    System.out.println("The class of IP is B.");
                }
                else if (out.charAt(1) == '1' && out.charAt(2) == '0' && Integer.parseInt(parts[2] ) != 0 && Integer.parseInt(parts[1]) != 0) {
                    System.out.println("The class of IP is C.");
                }
                else if (out.charAt(2) == '1' && out.charAt(3) == '0' && Integer.parseInt(parts[3]) != 0 && Integer.parseInt(parts[2]) != 0 && Integer.parseInt(parts[1]) != 0) {
                    System.out.println("The class of IP is D.");
                }
                else if (out.charAt(3) == '1' && out.charAt(4) == '0' && Integer.parseInt(parts[4]) != 0 && Integer.parseInt(parts[3]) != 0 && Integer.parseInt(parts[2]) != 0 && Integer.parseInt(parts[1]) != 0) {
                    System.out.println("The class of IP is E.");
                }
                else System.err.println("IP is incorrect!");
            }
            } else {
            if (!validIPBin(IPin)) {
                System.err.println("Your ip is incorrect! Try again!");
            } else {
                String[] parts = IPin.split("\\.");
                String out = IPtoDec(IPin);
                System.out.println("Your decade IP: " + out);
                if (out.charAt(0) == '0' && Integer.parseInt(parts[0]) != 0) {
                    System.out.println("The class of IP is A.");
                }
                else if (out.charAt(0) == '1' && out.charAt(1) == '0' && Integer.parseInt(parts[1]) != 0 && Integer.parseInt(parts[0]) != 0) {
                    System.out.println("The class of IP is B.");
                }
                else if (out.charAt(1) == '1' && out.charAt(2) == '0' && Integer.parseInt(parts[2] ) != 0 && Integer.parseInt(parts[1]) != 0) {
                    System.out.println("The class of IP is C.");
                }
                else if (out.charAt(2) == '1' && out.charAt(3) == '0' && Integer.parseInt(parts[3]) != 0 && Integer.parseInt(parts[2]) != 0 && Integer.parseInt(parts[1]) != 0) {
                    System.out.println("The class of IP is D.");
                }
                else if (out.charAt(3) == '1' && out.charAt(4) == '0' && Integer.parseInt(parts[4]) != 0 && Integer.parseInt(parts[3]) != 0 && Integer.parseInt(parts[2]) != 0 && Integer.parseInt(parts[1]) != 0) {
                    System.out.println("The class of IP is E.");
                }
                else System.err.println("IP is incorrect!");
            }
            }
        }
    }