

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 

<!DOCTYPE html>

 

<html>

 

<head>

 

    <meta charset="UTF-8">

 
<div class="container">
    <title>Edit Record</title>
</div>
 

</head>

 

<body>

 

    <h1>Edit Record</h1>

    

 

    <form action="/replace-api" method="post">

    <input type="hidden" id="eventId" name="eventId"   value="${eventId}">

 

        <label for="date">New date:</label>

 

        <input type="text" id="date" name="date" required><br><br>

 

        

 

        <label for="time">New time:</label>

 

        <input type="text" id="time" name="time" required><br><br>

 

        

 

        <input type="submit" value="Create Changes">

 

    </form>

 <style>

        /* Set the background color to orange */

        body {

           /* background-color: orange;*/

            color: #0434c0;

            justify-content: center; /* Center content horizontally */

            align-items: center;

        }

        .container {

    text-align: center; /* Center text inside the container */

}

        /* Style the header with a yellow background and white text */

        header {

            background-color: yellow;

             color:  #0434c0;

            padding: 10px;

        }


        button {

            /*background-color: orange;*/

             color:black;

           

            border: none;

            padding: 10px 20px;

            cursor: pointer;

        }

 

        /* Style links with orange text color */

        a {

            color: brown;

            text-decoration: none;

        }

        /* Style the footer with a yellow background and white text */

        footer {

            background-color: yellow;

            color: black;

            padding: 10px;

        }

        /* Style the admin panel with a yellow background */

       .paymentt {

            background-color: yellow;

            padding: 20px;

            margin: 10px;

        }

        /* Style tables with alternating row colors */

        table {

            width: 100%;

            border-collapse: collapse;

        }

        table, th, td {

            border: 1px solid orange;

        }

        th, td {

            padding: 10px;

        }

        /* Define a CSS class for success messages with green text */

        .success-message {

            color: green;

        }
 

        /* Define a CSS class for error messages with red text */

        .error-message {

            color: red;

        }

    </style>

</body>

 

</html>