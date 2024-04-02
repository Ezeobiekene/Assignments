import java.util.Scanner;

class Lab8a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuOption;
        do{
            System.out.println(" ");
            System.out.println("Choose from the following:");
            System.out.println("0. Quit");
            System.out.println("1. Multiply 2 numbers");
            System.out.println("2. Div 2 numbers");
            System.out.println("3. Mod 2 numbers");
            menuOption = scanner.nextInt();

            switch(menuOption){
                case 1:
                    System.out.println("Enter the first number");
                    int x = scanner.nextInt();
                    System.out.println("Enter the second number");
                    int y = scanner.nextInt();

                    System.out.println("Answer: "+recursive_multiply(x,y));
                    break;
                case 2:
                    System.out.println("Enter the first number");
                    int a = scanner.nextInt();
                    System.out.println("Enter the second number");
                    int b = scanner.nextInt();

                    System.out.println("Answer: "+recursive_div(a,b));
                    break;
                case 3:
                    System.out.println("Enter the first number");
                    int m = scanner.nextInt();
                    System.out.println("Enter the second number");
                    int n = scanner.nextInt();

                    System.out.println("Answer: "+recursive_mod(m,n));
                    break;
                case 0:
                    break;
            }
        }while(menuOption != 0);
    }


    public static int recursive_multiply(int firstNum, int secNum){
        if(secNum == 0){
            return 0;
        }
        if(secNum == 1){
            return firstNum;
        }else{
            return firstNum + recursive_multiply(firstNum, secNum-1);
        }
    }

    public static int recursive_div(int firstNum, int secNum){
        if(secNum==0){
            return -1;
        }else if(firstNum == secNum){
            return 1;
        }else if(firstNum < secNum){
            return 0;
        }else{
            return 1 + recursive_div((firstNum-secNum), secNum);
        }
    }

    public static int recursive_mod(int firstNum, int secNum){
        if(secNum == 0){
            return -1;
        }else if(firstNum < secNum){
            return firstNum;
        }else{
            return recursive_mod((firstNum-secNum), secNum);
        }
    }
}