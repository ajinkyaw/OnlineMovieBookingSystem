<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
<div class="container">
<title>Event Schedule</title>
<div>
</head>

<body>

	<h2>List of Events</h2>

	<table border="1">

		<thead>

			<tr>

				
				<th>Movie ID</th>

				<th>Date</th>

				<th>Time</th>

			<th>Event Id</th>

			</tr>

		</thead>

		<tbody>

			<c:forEach var="MovieScheduler" items="${schdlist}">

				

				<tr>

					

					<td>${MovieScheduler.movieId}</td>

					<td>${MovieScheduler.date}</td>

					<td>${MovieScheduler.time}</td>
					
					<td><input   id="eventId" name="eventId"

						value="${MovieScheduler.eventId}"></td>

					<td>
					<form action="replace" method="post">
					<input type="hidden" name="eventId" value="${MovieScheduler.eventId}">
					<input type="submit" value="Edit">
					</form>
					</td>
					
					<td>
					<form action="/removingEvent" method="post">
					<input type="hidden" name="eventId" value="${MovieScheduler.eventId}">
					<input type="submit" value="Remove">
					</form>
					</td>

				</tr>

				</form>

			</c:forEach>

		</tbody>

	</table>
					<td>
					<form action="/addSchd" method="post">
					<input type="hidden" name="eventId" value="eventId">
					<input type="submit" value="Add Event">
					</form>
					</td>
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

 

