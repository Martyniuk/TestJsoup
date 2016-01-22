package com.jsoup.dao;

import com.jsoup.tools.JDBCConnection;
import com.jsoup.bean.Vacancy;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 20.01.16.
 */
public class VacancyDao {

    private static final VacancyDao instance = null;

    private VacancyDao() {
    }

    public static VacancyDao getInstance() {

        return instance == null ? new VacancyDao() : instance;
    }

    public void createTable() {
        try (Connection con = JDBCConnection.getConnection()) {

            String sql = "CREATE TABLE `vacancies` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `link` VARCHAR(200) DEFAULT NULL,\n" +
                    "  `title` VARCHAR(100) DEFAULT NULL,\n" +
                    "  `city` VARCHAR(500) DEFAULT NULL,\n" +
                    "  `description` TEXT,\n" +
                    "  `dateOfPublication` VARCHAR(50) DEFAULT NULL,\n" +
                    "  `typeOfEmployment` VARCHAR(50) DEFAULT NULL,\n" +
                    "  `companyName` VARCHAR(20) DEFAULT NULL,\n" +
                    "  `experienceOfWork` VARCHAR(300) DEFAULT NULL,\n" +
                    "  `show` TINYINT(4) DEFAULT NULL,\n" +
                    "  `keyWord` VARCHAR(200) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE KEY `link_UNIQUE` (`link`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addVacancy(String link,
                           String title,
                           String city,
                           String description,
                           String dateOfPublication,
                           String typeOfEmployment,
                           String companyName,
                           String experienceOfWork,
                           boolean show,
                           String keyWord) {
        Vacancy vacancy = new Vacancy(link, title, city, description, dateOfPublication, typeOfEmployment, companyName, experienceOfWork, show, keyWord);
        try (Connection con = JDBCConnection.getConnection()) {

            String sql = "INSERT INTO `vacancies`.`vacancies` (`link`,`title`,`city`,`description`,`dateOfPublication`,`typeOfEmployment`,`companyName`,`experienceOfWork`,`show`,`keyWord`) VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vacancy.getLink());
            ps.setString(2, vacancy.getTitle());
            ps.setString(3, vacancy.getCity());
            ps.setString(4, vacancy.getDescription());
            ps.setString(5, vacancy.getDateOfPublication());
            ps.setString(6, vacancy.getTypeOfEmployment());
            ps.setString(7, vacancy.getCompanyName());
            ps.setString(8, vacancy.getExperienceOfWork());
            ps.setBoolean(9, vacancy.isShow());
            ps.setString(10, vacancy.getKeyWord());
            ps.execute();
            System.out.printf("added new vacancy to db, %s \n", title);

        }  catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
                System.out.printf("Already have this vacancy: %s \n", title);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vacancy> getVacancyFromDB() {
        ArrayList<Vacancy> vacancies = new ArrayList<>();

        Statement stmt = null;
        try (Connection con = JDBCConnection.getConnection()) {
            stmt = con.createStatement();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // select
            String sql = "SELECT * FROM vacancies.vacancies";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while(rs.next()){
                String link  = rs.getString("link");
                String title  = rs.getString("title");
                String city  = rs.getString("city");
                String description  = rs.getString("description");
                String experienceOfWork  = rs.getString("experienceOfWork");
                String dateOfPublication  = rs.getString("dateOfPublication");
                String typeOfEmployment  = rs.getString("typeOfEmployment");
                String companyName  = rs.getString("companyName");
                String keyWord  = rs.getString("keyWord");
                boolean show  = rs.getBoolean("show");
                Vacancy vacancy = new Vacancy(link, title, city, description, dateOfPublication, typeOfEmployment, companyName, experienceOfWork, show, keyWord);
                vacancies.add(vacancy);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vacancies;
    }
}
