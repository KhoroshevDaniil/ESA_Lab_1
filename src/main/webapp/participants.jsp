<%@ page import="com.example.model.Participant" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Participants</title>
</head>
<body>
    <h1>Participants Page</h1>

    <form action="participants" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required>
        <br>

        <label for="academic_degree">Academic Degree:</label>
        <select name="academic_degree" id="academic_degree">
            <option>Bachelor of science</option>
            <option>Master of science</option>
            <option>PhD</option>
        </select>
        <br>

        <input type="submit" value="Add Participant">
    </form>

    <hr>

    <%
        List<Participant> participants = (List<Participant>) request.getAttribute("participants");
        if(participants.isEmpty()) {
            out.println("<p>No participants to display.</p>");
        }
        else {
            for (Participant participant : participants) {
                out.println(
                        "Name: " + participant.getName() + '\t' +
                        "| Age: " + Integer.toString(participant.getAge()) + '\t' +
                        "| Academic Degree: " + participant.getAcademicDegree() + '\t' + "<br>"
                );
            }
        }
    %>
</body>
</html>
