package com.jsoup.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsoup.bean.Vacancy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by vladimir on 15.01.16.
 */
public class CreateJSP {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("vacancy.json");
        File htmlFile = new File("vacansy.jsp");

        if (!htmlFile.exists()) {
            htmlFile.createNewFile();
        }

        Vacancy[] vacancies = objectMapper.readValue(file, Vacancy[].class);

        BufferedWriter bf = new BufferedWriter(new FileWriter(htmlFile));
        bf.write("<html>" +
                "<head>" +
                "<meta charset=UTF-8>" +
                "<link href='style.css' rel='stylesheet' type='text/css'/>" +
                "</head>" +
                "<body>" +
                "<table>" + "<tr>" + "<th>Title</th>" + "<th>Description</th>" + "<th>Company Name</th>" + "<th>Date Of Publication</th>" + "<th>City</th>" + "<th>Employment Type</th>" + "<th>Experience</th>" + "</tr>");

        for (Vacancy v : vacancies) {

            bf.write("<tr>" + "<td>" + "<a href=" + v.getLink() + ">" + v.getTitle() + "</a>" + "</td>" +
                    "<td>" + v.getDescription() + "</td>" +
                    "<td>" + v.getCompanyName() + "</td>" +
                    "<td>" + v.getDateOfPublication() + "</td>" +
                    "<td>" + v.getCity() + "</td>" +
                    "<td>" + v.getTypeOfEmployment() + "</td>" +
                    "<td>" + v.getExperienceOfWork() + "</td>" +
                    "</tr>"
            );

        }
        bf.write("</table>" +
                "</body>" +
                "</html>");

        bf.close();
    }
}
