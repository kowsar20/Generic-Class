 public class Coin implements Measurable
    {
        //declare the class members
        private double value;
        private String name;
        //define a Coin
        public Coin(double aValue, String aName)
        {
//set the value of class members
            value = aValue;
            name = aName;
        }
        //getter for value
        public double getValue()
        {
//return value
            return value;
        }
        //define method getMeasure()
        public double getMeasure()
        {
//return value
            return value;
        }
        //define the method getName()
        public String getName()
        {
//return the name
            return name;
        }
        //define the method toString()
        public String toString()
        {
//return the value and name as strings
            return "Coin[value=" + value + ",name=" + name + "]";
        }
    }
    Filename: “Measurable.java”
    //define an interface Measurable
    public interface Measurable
    {
        //declare the method getMeasure()
        double getMeasure();
    }
    Filename: “Pair.java”
    //define class Pair
    public class Pair<T, S>
    {
        //define the class members
        private T first;
        private S second;
        //constructor
        public Pair(T firstElement, S secondElement)
        {
//set class elements
            first = firstElement;
            second = secondElement;
        }
        //getter for first
        public T getFirst()
        {
//return the value
            return first;
        }
        //getter for second
        public S getSecond()
        {
//return the second
            return second;
        }
    }
    Filename: “PairUtil.java”
    //define a class PairUtil
    public class PairUtil
    {
        //define a method minmax
        public static <E extends Measurable> Pair<E, E> minmax(E[] a)


        {
//if length of a is 0
            if (a.length == 0)
//return null
                return null;
//declare a variable min and set first element of a to it
            E min = a[0];
//declare a variable max and set first element of a to it
            E max = a[0];
//iterate a for loop
            for (E element : a)
            {
//if element is less than min
                if (element.getMeasure() < min.getMeasure())
//set min equal to element
                    min = element;
//if element is greater than max
                if (element.getMeasure() > max.getMeasure())
//set max equal to element
                    max = element;
            }
//create new pair and return it
            return new Pair<E, E>(min, max);
        }
    }
    Filename: “MinMaxTester.java”
    //deine a class MinMaxTester
    public class MinMaxTester
    {
        //define the main method
        public static void main(String[] args)
        {
//create a array coins of type Coin
            Coin[] coins =
                    {
//adding elements to array
                            new Coin(0.1, "Dime"),
                            new Coin(0.05, "Nickel"),
                            new Coin(0.01, "Penny"),
                            new Coin(0.25, "Quarter")
                    };
//define a Pair mm
            Pair<Coin, Coin> mm = PairUtil.minmax(coins);
//print first coin
            System.out.println(mm.getFirst());
//print the expected result
            System.out.println("Expected: Coin[value=0.01,name=Penny]");
//print second coin
            System.out.println(mm.getSecond());
//print the expected result
            System.out.println("Expected: Coin[value=0.25,name=Quarter]");
        }
    }

