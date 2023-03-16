package model;

public class Student implements Comparable<Student> {
    private String id;
    private String fullname;
    private  int gender;
    private String date ;
    private String address;
    private String phone;
    private String email;
    private double gpa;

    public Student() {
    }

    public Student(String id, String fullname, int gender, String date, String address, String phone, String email, double gpa) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student[" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gpa=" + gpa +
                ']';
    }
    @Override
    public int compareTo(Student o) {
        if (this.gpa > o.gpa) {
            return 1;
        } else if (this.gpa < o.gpa) {
            return -1;
        }
        return 0;
    }
}
