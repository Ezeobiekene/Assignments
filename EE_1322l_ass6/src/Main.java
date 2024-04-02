import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            int menuOption;

            do {
                ArrayList<String> lines = getData();
                float price = getDollarPrice(lines);
                System.out.println("One BitCoin is currently worth $"+price);
                System.out.println("""
                        1. Buy Bitcoin
                        2. See everyones current value in USD
                        3. See one persons gain/loss
                        4. Quit""");
                menuOption = scanner.nextInt();

                switch (menuOption) {
                    case 1:
                        lines = getData();
                        price = getDollarPrice(lines);
                        buyBitCoin(price);
                        break;
                    case 2:
                        lines = getData();
                         price = getDollarPrice(lines);
                        getCurrentValue(price);
                        break;
                    case 3:
                        lines = getData();
                        price = getDollarPrice(lines);
                        System.out.println("Enter a name");
                        scanner.nextLine();
                        String name = scanner.nextLine();

                        float original = getPersonFromFile(name, "/Users/ekeneezeobi/Downloads/Assignment6/initialInvestmentUSD.txt");
                        float numOfBitCoins = getPersonFromFile(name, "/Users/ekeneezeobi/Downloads/clientBC.txt");
                        float current = numOfBitCoins * price;
                        float change = current - original;

                        System.out.println("Original Investment: $"+original);
                        System.out.println("Number of bitcoins: "+numOfBitCoins);
                        System.out.println("Current value: $"+current);
                        System.out.println("Change in value: $"+change);

                        break;
                    case 4:
                        break;
                }
            } while (menuOption != 4);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<String> getData() throws IOException{
        ArrayList<String> stringArrayList = new ArrayList<>();

            String HostName = "api.coindesk.com";
            Socket mySocket = new Socket(HostName,80);
            OutputStream myoutputstream = mySocket.getOutputStream();
            PrintWriter pw = new PrintWriter(myoutputstream);

            pw.println("GET http://api.coindesk.com/v1/bpi/currentprice.json HTTP/1.0\n\n");
            pw.flush();
            Scanner myScan = new Scanner(mySocket.getInputStream());
            while(myScan.hasNextLine()){
                stringArrayList.add(myScan.nextLine());

            }
            mySocket.close();
            pw.close();
            myoutputstream.close();

            return stringArrayList;
    }
    public static float getDollarPrice(ArrayList<String> lines) {
        boolean header=true;
        String json="";
        for(String line : lines) {
            if(line.equals("")) {
                header=false;
                continue;
            }
            if(!header) {
                json=line;
                break;
            }
        }
        //System.out.println("Json: "+json);
        String[] jsonParts=json.split(":");
        String priceLine=jsonParts[19];
        String justPrice=priceLine.replace("},\"GBP\"","");

        return Float.parseFloat(justPrice);
    }

    public static void buyBitCoin(float bitCoinPrice) throws IOException {
            File myFile = new File("/Users/ekeneezeobi/Downloads/Assignment6/initialInvestmentUSD.txt");
            Scanner myScan = new Scanner(myFile);

            FileWriter fw = new FileWriter("/Users/ekeneezeobi/Downloads/clientBC.txt");
            PrintWriter pw = new PrintWriter(fw);
                while(myScan.hasNextLine()){
                    String line = myScan.nextLine();
                    String[] bits = line.split(":");
                    String name = bits[0].trim();
                    float dollarAmount = Float.parseFloat(bits[1].trim());
                    float numOfBitCoins = dollarAmount/bitCoinPrice;

                    pw.println(name +" : "+ numOfBitCoins);
                    pw.flush();
                }
                myScan.close();
    }

    public static void getCurrentValue(float thisFloat) throws IOException{

            File myFile = new File("/Users/ekeneezeobi/Downloads/clientBC.txt");
            Scanner myScan = new Scanner(myFile);

            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                String[] bits = line.split(":");
                String name = bits[0].trim();
                String numOfBitCoins = bits[1].trim();

                float numBits = Float.parseFloat(numOfBitCoins);
                float value = thisFloat * numBits;
                System.out.println(name + ":$" + value);

            }
            myScan.close();
    }

    public static float getPersonFromFile(String name, String fileName) throws IOException, PersonNotFound{
            File newFile = new File(fileName);
            Scanner myScan = new Scanner(newFile);

            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                String[] breakLine = line.split(":");
                String theName = breakLine[0].trim();
                float bitsPrice = Float.parseFloat(breakLine[1].trim());

                if (name.equalsIgnoreCase(theName)) {
                    return bitsPrice;
                }
            }

        myScan.close();
        throw new PersonNotFound("Person not found");
    }

}