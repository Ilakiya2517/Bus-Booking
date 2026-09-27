
import java.util.ArrayList;
import java.util.Scanner;

public class Busproject 
{
    static class Bus
     {
        private int busno;
        private String ac;
        private int capacity;
        public Bus(int bno, String bac, int bcapacity)
         {
            busno = bno;
            ac = bac;
            capacity = bcapacity;
          }

        public int getBusNo() 
        {
            return busno;
        }
        public int getCapacity()
         {
            return capacity;
        }
    }
    static class Booking
     {
        String passengerName;
        int busNo;
        String date;
        public Booking(Scanner scan) 
        {
            System.out.println("Enter Passenger Name:");
            passengerName = scan.next();
            System.out.println("Enter Bus No:");
            busNo = scan.nextInt();
            System.out.println("Enter the date (dd/mm/yyyy):");
            date = scan.next();
        }
    }
    public static boolean isAvailable(ArrayList<Bus> buses, ArrayList<Booking> bookings, int busNo, String date)
     {
        int capacity = 0;
        for (Bus bus : buses)
         {
            if (bus.getBusNo() == busNo)
             {
                capacity = bus.getCapacity();
                break;
            }
        }
        int booked = 0;
        for (Booking booking : bookings)
         {
            if (booking.busNo == busNo && booking.date.equals(date)) 
            {
                booked++;
            }
         }

        return booked < capacity;
    }
    public static void main(String[] args) 
    {
        ArrayList<Bus> buses = new ArrayList<>();
        buses.add(new Bus(1, "AC", 10));
        buses.add(new Bus(2, "AC", 12));
        buses.add(new Bus(3, "Non-AC", 15));

        ArrayList<Booking> bookings = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int userOpt = 1;
        while (userOpt == 1) 
        {
            System.out.println("Enter 1 to book and 2 to exit");
            userOpt = scan.nextInt();

            if (userOpt == 1)
             {
                Booking booking = new Booking(scan);
                if (isAvailable(buses, bookings, booking.busNo, booking.date)) 
                {
                    bookings.add(booking);
                    System.out.println("Your booking is confirmed...");
                } else 
                {
                    System.out.println("Sorry, the bus is full! Try another date or bus.");
                }
            }
        }
    }
}
