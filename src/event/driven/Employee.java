package event.driven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Employee {
    private int id, age;
    private String name, address;
    private Date bDate;
    
    public int getID(){
        return this.id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    public Date getbDate(){
        return this.bDate;
    }
    public void setBdate(Date bDate){
        this.bDate = bDate;
    }
    
    public void calculateSalary(){
        
    }
    
    public void calculateAge() throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse(this.getbDate().toString());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        
        //Get LocalDate of birthday
        LocalDate localBday = LocalDate.of(year, month, day);
        LocalDate localNow = LocalDate.now();
        
        //Compare two dates to get Age
        Period dateDiff = Period.between(localBday, localNow);
        
        System.out.println(dateDiff.getYears() + "years old.");
        
    }
    
    public void displayInfo(){
        System.out.println("Employee ID: " + this.id +"\nName: " + this.name + "\nAddress: " + 
                this.address + "\nAge:" + this.age + "\nBirth Date: " + this.bDate);
    }
    
    class Teacher extends Employee{
        
        private double monthlySalary, totalDeduction, netSalary;

        public double getMonthlySalary() {
            return monthlySalary;
        }

        public void setMonthlySalary(double monthlySalary) {
            this.monthlySalary = monthlySalary;
        }

        public double getTotalDeduction() {
            return totalDeduction;
        }

        public void setTotalDeduction(double totalDeduction) {
            this.totalDeduction = totalDeduction;
        }

        public double getNetSalary() {
            return netSalary;
        }

        public void setNetSalary(double NetSalary) {
            this.netSalary = NetSalary;
        }
        
        @Override
        public void calculateSalary(){
            this.setNetSalary(this.getMonthlySalary() - this.totalDeduction);
        }
        //helper
        private void calculateTotalDeduction(double sss, double pagibig, double philHealth){
            this.setTotalDeduction(sss+pagibig+philHealth);
        }
        
        public void DisplayTeacherInfo(){
            System.out.println("Employee ID: " + this.getID() +"\nName: " + this.getName() + "\nAddress: " + 
                this.getAddress() + "\nAge:" + this.getAge() + "\nBirth Date: " + this.getbDate() + 
                    "\n\nMonthly Salary: " + this.monthlySalary + "\nTotal Deduction: " + this.totalDeduction +
                    "\nNet Pay: " + this.netSalary);
        }
        
        
    }
    
    class Utility extends Employee{
        private double dailyRate, monthlySalary, netSalary, totalDeduction = 400.0;
        private int noOfDaysWork;
        private String position;

        public void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

        public void setNoOfDaysWork(int noOfDaysWork) {
            this.noOfDaysWork = noOfDaysWork;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getDailyRate() {
            return dailyRate;
        }

        public double getMonthlySalary() {
            return monthlySalary;
        }

        public double getNetSalary() {
            return netSalary;
        }

        public double getTotalDeduction() {
            return totalDeduction;
        }

        public int getNoOfDaysWork() {
            return noOfDaysWork;
        }

        public String getPosition() {
            return position;
        }
        
        @Override
        public void calculateSalary(){
            this.monthlySalary = this.getDailyRate() * this.noOfDaysWork;
            this.netSalary = this.monthlySalary - this.totalDeduction; 
        }
        
        public void displayUtilityInfo(){
            System.out.println("Employee ID: " + this.getID() +"\nName: " + this.getName() + "\nAddress: " + 
                    this.getAddress() + "\nAge:" + this.getAge() + "\nBirth Date: " + this.getbDate() + "\nPosition:" + this.getPosition() + 
                    "\nDaily Rate: " + this.getDailyRate() + "\nNo. of Days Work: " + this.getNoOfDaysWork() +
                    "\n\nMonthly Salary: " + this.getMonthlySalary() + "\nTotal Deduction: " + this.getTotalDeduction() +
                    "\nNet Pay: " + this.getNetSalary());
        }
    }
}
