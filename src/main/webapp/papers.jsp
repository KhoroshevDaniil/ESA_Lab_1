<%@ page import="com.example.model.Paper" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Papers</title>
</head>
<body>
<h1>Papers Page</h1>

<form action="papers" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required>
    <br>

    <label for="year">Year:</label>
    <input type="number" id="year" name="year" required>
    <br>

    <label for="author">Author:</label>
    <input type="text" id="author" name="author" required>
    <br>
    <input type="submit" value="Add Paper">
</form>

<hr>

<%
    List<Paper> papers = (List<Paper>) request.getAttribute("papers");
    if(papers.isEmpty()) {
        out.println("<p>No papers to display.</p>");
    }
    else {
        for (Paper paper : papers) {
            out.println(
                    "Title: " + paper.getTitle() + '\t' +
                    "| Year: " + Integer.toString(paper.getYear()) + '\t' +
                    "| Author: " + paper.getAuthor().getName() + "<br>"
            );
        }
    }
%>
</body>
</html>
