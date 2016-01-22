<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 15.01.16
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html" %>
<%@ page import="com.jsoup.bean.Vacancy" %>
<%@ page import="com.jsoup.tools.VacanciesFromDB" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>JavaForFun</title>
    <link href='css/bootstrap-theme.min.css' rel='stylesheet'>
</head>
<div class="panel-heading">
    <h1>Vacancies</h1>
</div>
<div class="table table-hover">
    <table class="table">
        <thread>
            <tr>
                <th>
                    <div class="col-xs-3">
                        <a href="index.jsp?sort-by=title">Title</a>
                    </div>
                </th>
                <th>
                    <div class="col-xs-6">
                    </div>
                    Description
                </th>
                <th>
                    <div class="col-xs-3">
                        <a href="index.jsp?sort-by=company">Company</a>
                    </div>
                </th>
                <th>
                    <div class="col-xs-3">
                        <a href="index.jsp?sort-by=data">Date</a>
                    </div>
                </th>
                <th>
                    <div class="col-xs-3">
                        <a href="index.jsp?sort-by=city">City</a>
                    </div>
                </th>
            </tr>
        </thread>


        <% Class.forName("com.mysql.jdbc.Driver").newInstance();
            VacanciesFromDB vacanciesFromDB = new VacanciesFromDB();
            List<Vacancy> vacancies = vacanciesFromDB.getVacancyList();
            String typeOfSort = request.getParameter("sort-by");
            if (typeOfSort != null) {
                vacanciesFromDB.sortByData(typeOfSort);
            }
            for (Vacancy c : vacancies) {
                out.print("<tr>");
                out.print("<td class=\"col-xs-3\">" +"<a href=" + c.getLink() + ">" + c.getTitle() + "</a>"+ "</td>");
                out.print("<td class='description col-xs-6'>" + c.getDescription() + "</td>");
                out.print("<td class=\"col-xs-1\">" + c.getCompanyName() + "</td>");
                out.print("<td class=\"col-xs-1\">" + c.getDateOfPublication() + "</td>");
                out.print("<td class=\"col-xs-1\">" + c.getCity() + "</td>");
                out.print("</tr>");
            }
        %>
    </table>
    <script>
        function ellipsify(str) {
            if (str.length > 200) {
                return (str.substring(0, 200) + "...");
            }
            else {
                return str;
            }
        }
        var descriptions = document.getElementsByClassName("description");
        for (var i = 0; i < descriptions.length; i++) {
            //do something to each div like
            var str = descriptions[i].innerHTML;
            descriptions[i].innerHTML = ellipsify(str);
        }

    </script>
</div>
</body>
</html>
