<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>

 

	<!-- Access the bootstrap Css like this,

		Spring boot will handle the resource mapping automcatically -->

	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

 

	<!--

	<spring:url value="/css/main.css" var="springCss" />

	<link href="${springCss}" rel="stylesheet" />

 

	<c:url value="/css/main.css" var="jstlCss" />

	<link href="${jstlCss}" rel="stylesheet" />

	 -->

	

</head>

<body>

 

	<nav class="navbar navbar-inverse">

		<div class="container">

			<div class="navbar-header">

				<a class="navbar-brand" href="#">Spring Boot</a>

			</div>

			<div id="navbar" class="collapse navbar-collapse">

				<ul class="nav navbar-nav">

					<li class="active"><a href="#">Home</a></li>

					<li><a href="#about">About</a></li>

				</ul>

			</div>

		</div>

	</nav>

 

	<div class="container">

 

		<div class="starter-template">

			<h1>Spring Boot Web JSP Example</h1>

			<h2>Message: ${message}</h2>

		</div>

 

	</div>

	

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 

</body>
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

 

</html>