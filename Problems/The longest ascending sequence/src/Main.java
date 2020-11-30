import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int previous = scanner.nextInt();
        int maxLength = 1;
        int currentLength = 1;
        while (size - 1 > 0) {
            int element = scanner.nextInt();
            currentLength += element > previous ? 1 : 1 - currentLength;
            maxLength = Math.max(currentLength, maxLength);
            previous = element;
            size--;
        }
        System.out.println(maxLength);
    }
}
