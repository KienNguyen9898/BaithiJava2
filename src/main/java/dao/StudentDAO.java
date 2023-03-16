package dao;

import connection.MyConnection;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    //in
    public List<Student> getAll(){
        final String sql = "SELECT * FROM `students`";
        List<Student> studentList = new ArrayList<>();
        try{
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Student s = new Student();
                s.setId(resultSet.getString("id"));
                s.setFullname(resultSet.getString("full_name"));
                s.setGender(resultSet.getInt("gender"));
                s.setDate(resultSet.getString("student_date"));
                s.setAddress(resultSet.getString("address"));
                s.setPhone(resultSet.getString("phone"));
                s.setEmail(resultSet.getString("email"));
                s.setGpa(resultSet.getDouble("gpa"));
                studentList.add(s);

            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return  studentList;
    }

    //tim theo id
    public Student getById(String id) {
        final String sql = "SELECT * FROM `students` WHERE  `id` = " + id;
        Student s = null;

        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                s = new Student();
                s.setId(resultSet.getString("id"));
                s.setFullname(resultSet.getString("full_name"));
                s.setGender(resultSet.getInt("gender"));
                s.setDate(resultSet.getString("student_date"));
                s.setAddress(resultSet.getString("address"));
                s.setPhone(resultSet.getString("phone"));
                s.setEmail(resultSet.getString("email"));
                s.setGpa(resultSet.getDouble("gpa"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }


    //them
    public void insert(Student s) {
        final String sql = String.format("INSERT  INTO `students` VALUES ( '%s','%s','%d','%s','%s','%s','%s', '%f')",
                s.getId(), s.getFullname(), s.getGender(), s.getDate(), s.getAddress(), s.getPhone(), s.getEmail(), s.getGpa()
        );
        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            long rs = statement.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //xoa
    public void delete(String id) {
        Student student = getById(id);
        if (student == null) {
            throw new RuntimeException("Khong co sinh vien hop le!");
        }

        final String sql = String.format("DELETE FROM `students` WHERE `id` = "+id);
        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            long rs = statement.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        //sua
        public void update(Student student, String id) {
            Student s1 = getById(id);
            if (s1 == null) {
                throw new RuntimeException("Khong co sinh vien hop le!");
            }

            final String sql = String.format("UPDATE `students` SET `id='%s',`full_name`='%s',`gender`='%d',`student_date`='%s',`address`='%s',`phone`='%s', `email`='%s', `gpa`='%f' WHERE `id` = '%s'",
                    student.getId(), student.getFullname(), student.getGender(), student.getDate(), student.getAddress(), student.getPhone(), student.getEmail(), student.getGpa(), id
            );
            try {
                Connection connection = MyConnection.getConnection();
                Statement statement = connection.createStatement();
                long rs = statement.executeUpdate(sql);

                if (rs == 0) {
                    System.out.println("Cập nhật thất bại");
                }
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



}
