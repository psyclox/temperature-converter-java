import java.util.*;
public class Main {
    public static void main(String[] temp_converter) {
        Scanner angel=new Scanner(System.in);

        float value=0;
        boolean validIp=false;
        while (!validIp) {
            System.out.print("Enter the temperature value: ");
            try {
                value=Float.parseFloat(angel.nextLine());
                validIp=true;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input!.... \tPlease enter a valid temperature value");
            }
        }

        System.out.print("Enter the unit of the temperature (1 for Fahrenheit, 2 for Celsius, 3 for Kelvin):");
        int from=angel.nextInt();

        System.out.print("Enter the unit to convert to (1 for Fahrenheit, 2 for Celsius, 3 for Kelvin):");
        int to=angel.nextInt();

        String[] units={"Fahrenheit","Celsius","Kelvin"};

        float out= convertTemperature(value, units[from -1],units[to -1]);
        System.out.println("Converted temperature:"+out+" "+units[to -1]);

        angel.close();
    }

    public static float convertTemperature(float value,String from,String to) {
        float out = 0;

        if(from.equalsIgnoreCase("Fahrenheit")&&to.equalsIgnoreCase("Celsius")) {
            out=(value -32) *5/9;
        } else if (from.equalsIgnoreCase("Fahrenheit")&&to.equalsIgnoreCase("Kelvin")) {
            out=(value -32)*5/9+273.15f;
        } else if (from.equalsIgnoreCase("Celsius")&&to.equalsIgnoreCase("Fahrenheit")) {
            out=(value *9/5)+32;
        } else if (from.equalsIgnoreCase("Celsius")&&to.equalsIgnoreCase("Kelvin")) {
            out=value +273.15f;
        } else if (from.equalsIgnoreCase("Kelvin")&&to.equalsIgnoreCase("Celsius")) {
            out=value -273.15f;
        } else if (from.equalsIgnoreCase("Kelvin")&&to.equalsIgnoreCase("Fahrenheit")) {
            out=(value -273.15f)*9/5+32;
        } else if (from.equalsIgnoreCase(to)) {
            out=value;
        }
        else
        {
            System.out.println("Invalid units!!");
            System.exit(1);
        }

        return out;
    }
}


