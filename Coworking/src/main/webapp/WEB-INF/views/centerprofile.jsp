<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
	<title>Home - Coworking 2.0</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
	body {
		padding-top: 70px;
	}
</style>

<!--  <link rel="stylesheet" href="resources/css/bootstrap.min.css"> -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	type="text/css" rel="stylesheet">

<style>
      #map_canvas {
        height:350px;
        width:350px;
        vertical-align: middle;
        }
        #perfil {
        margin-left:60px;
        float:left;
        witdh:500px
        }
        
</style>
    <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script>
      var geocoder;
      var map;
      var mapOptions = {
          zoom: 17,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        }
      var marker;
 
      function initialize() {
        geocoder = new google.maps.Geocoder();
        map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
        codeAddress();
      }
 
      function codeAddress() {
        var address = "${model.maps}";
        geocoder.geocode( { 'address': address}, function(results, status) {
          if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
            if(marker)
              marker.setMap(null);
            marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location,
                draggable: true
            });
            google.maps.event.addListener(marker, "dragend", function() {
              document.getElementById('lat').value = marker.getPosition().lat();
              document.getElementById('lng').value = marker.getPosition().lng();
            });
            document.getElementById('lat').value = marker.getPosition().lat();
            document.getElementById('lng').value = marker.getPosition().lng();
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
    </script>
</head>

<body>
<body onload="initialize()">
<style type="text/css">
#ProfilePage
{
    /* Move it off the top of the page, then centre it horizontally */
    margin: 50px auto;
    width: 635px;

/* For visibility. Delete me */
border: 1px solid red;
}

#LeftCol
{
    /* Move it to the left */
    float: left;

    width: 200px;
    text-align: center;

    /* Move it away from the content */
    margin-right: 20px;

/* For visibility. Delete me */
border: 1px solid brown;
}

#Photo
{
    /* Width and height of photo container */
    width: 200px;
    height: 200px;

/* For visibility. Delete me */
border: 1px solid green;
}


#Info
{
    width: 400px;
    text-align: center;

    /* Move it to the right */
    float: right;

/* For visibility. Delete me */
border: 1px solid blue;
}

#Info strong
{
    /* Give it a width */
    display: inline-block;
    width: 100px;

/* For visibility. Delete me */
border: 1px solid orange;
}

#Info span
{
    /* Give it a width */
    display: inline-block;
    width: 250px;

/* For visibility. Delete me */
border: 1px solid purple;
}
</style>

<div id="ProfilePage">
    <div id="LeftCol">
        <div id="Photo">
        <img src="${model.link}"  width="200px" height="200px"></div>
        
       
    </div>

    <div id="Info">
        <p>
            <strong>Nom del centre:</strong>
            <span>${model.nom}</span>
        </p>
        <p>
            <strong>Descripció:</strong>
            <span>${model.descripcio}</span>
        </p>
        <p>
            <strong>Serveis del centre:</strong>
            <span>${model.serveis}</span>
        </p>
        <p>
            <strong>Email de contacte: </strong>
            <span>${model.email}</span>
        </p>
        <p>
            <strong>Telefon:</strong>
            <span>${model.telefon}</span>
        </p>
		<p>
            <strong>Poblacio:</strong>
            <span>${model.poblacio}</span>
        </p>
		<p>
            <strong>Carrer:</strong>
            <span>${model.carrer}</span>
        </p>
		<p>
            <strong>Nº Edifici:</strong>
            <span>${model.num_edifici}</span>
        </p>
		<p>
            <strong>Nº de localitats:</strong>
            <span>${model.capacitat}</span>
        </p>
		<p>
            <strong>Web:</strong>
            <span>${model.web}</span>
        </p>
		<p>
            <strong>Valoracio mitjana:</strong>
            <span>${model.valoracio}</span>
        </p>
    </div>

    <!-- Needed because other elements inside ProfilePage have floats -->
    <div style="clear:both"></div>
</div>
<center>

<div style="color:#FFFFF">
  <h3>Localització del centre: </h3>
	<div id="map_canvas"></div>
</div>
</center>

</body>
</html>