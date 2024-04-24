package exception;

class ComLineSum {
    public static void main(String args[]) {
        int InvalidCount = 0;
        int number, sum = 0;

        for (int i = 0; i < args.length; i++) {
            try {
                number = Integer.parseInt(args[i]); //converts arg to integer
            } catch (NumberFormatException e) {
                InvalidCount++;
                System.out.println("Invalid Number: " + args[i]);
                continue; // Skip the remaining part of the loop
            }
            sum += number;
        }
        System.out.println();
        System.out.println("Number of Invalid Arguments = " + InvalidCount);
        System.out.println("Number of Valid Arguments = " + (args.length - InvalidCount));
        System.out.println("Sum of Valid Arguments = " + sum);
    }
}

