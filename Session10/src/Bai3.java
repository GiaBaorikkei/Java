import java.time.Year;

class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        setYear(year); // Kiểm tra tính hợp lệ
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year > 1885 && year <= currentYear) {
            this.year = year;
        } else {
            System.out.println("Năm sản xuất không hợp lệ! Đặt về giá trị mặc định là " + currentYear);
            this.year = currentYear; // Mặc định về năm hiện tại nếu sai
        }
    }

    public void displayInfo() {
        System.out.println("Car: " + make + " " + model + " (" + year + ")");
    }
}

public class Bai3 {
    public static void main(String[] args) {

        Car myCar = new Car("Toyota", "Corolla", 2022);
        myCar.displayInfo();

        myCar.setYear(2025);
        myCar.displayInfo();

        myCar.setYear(2018);
        myCar.displayInfo();
    }
}
