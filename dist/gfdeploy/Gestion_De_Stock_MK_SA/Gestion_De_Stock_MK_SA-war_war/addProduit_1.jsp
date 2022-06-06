<%-- 
    Document   : addProduit
    Created on : 6 juin 2022, 11:51:54
    Author     : MK
--%>

<%@page import="java.util.List"%>
<%@page import="entites.Marque"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Calendrier</title>

    <!-- Fontfaces CSS-->
    <link href="./front/assetsDashboard/css/font-face.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="./front/assetsDashboard/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="./front/assetsDashboard/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="./front/assetsDashboard/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- FullCalendar -->
    <link href='./front/assetsDashboard/vendor/fullcalendar-3.10.0/fullcalendar.css' rel='stylesheet' media="all" />

    <!-- Main CSS-->
    <link href="./front/assetsDashboard/css/theme.css" rel="stylesheet" media="all">
    <link rel="stylesheet" href="./front/css/bootstrap.min.css">
       <script src="https://kit.fontawesome.com/3f8b3dee73.js" crossorigin="anonymous"></script>

       <link rel="stylesheet" href="./css/bootstrap.min.css">
       <script src="https://kit.fontawesome.com/3f8b3dee73.js" crossorigin="anonymous"></script>
    <style type="text/css">
    /* force class color to override the bootstrap base rule
       NOTE: adding 'url: #' to calendar makes this unneeded
     */
    .fc-event, .fc-event:hover {
          color: #fff !important;
          text-decoration: none;
    }
   
       </style>

    </head>
    <body>
           <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="./front/assetsDashboard/images/icon/logo2.png" alt="" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                        <li class="active has-sub">
                            <a class="js-arrow" href="./htmlaccueilPatient.html">
                                <i class="fas fa-desktop"></i>Dashboard</a>
                        </li>
                        
                        <li>
                            
                            <a href="./calendrierPatient.html?annee=$annee&mois=$mois&jour=$jour">
                                <i class="fas fa-calendar-alt"></i>Ajouter un produit</a>
                        </li>
                        
                        
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="#">
                    <img src="./front/assetsDashboard/images/icon/logo2.png" alt="" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li class="active has-sub">
                            <a class="js-arrow" href="./htmlaccueilPatient.html">
                                <i class="fas fa-desktop"></i>Dashboard</a>
                        </li>
                        
                        
                        
                        <li>
                        <a href="./htmlcalendrierPatient.html">
                                <i class="fas fa-calendar-alt"></i>Reserver un rendez-vous</a>
                        </li>
                        
                        
                        
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <form class="form-header" action="" method="POST">
                                <input class="au-input au-input--xl" type="text" name="search" placeholder="Chercher .. " />
                                <button class="au-btn--submit" type="submit">
                                    <i class="zmdi zmdi-search"></i>
                                </button>
                            </form>
                            <div class="header-button">
                                
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="./front/assetsDashboard/images/icon/patient1.jpg" alt="" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">nom prenom </a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="./front/assetsDashboard/images/icon/patient1.jpg" alt="" />
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#">nom prenom</a>
                                                    </h5>
                                                    <span class="email"> email </span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                <a href="./htmlprofile.html">
                                                        <i class="zmdi zmdi-account"></i>Profile</a>
                                                </div>
                                                
                                                
                                            </div>
                                            <div class="account-dropdown__footer">
                                                <a href="./htmlaccueil.html">
                                                    <i class="zmdi zmdi-power"></i>Déconnexion</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- END HEADER DESKTOP-->


            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col">
                              <div class="au-card">
                              <form action="http://localhost:8080/Gestion_De_Stock_MK_SA-war/CreationProduit"
                                    method="post" class="container corps mt-3 mx-auto position-relative">
              <div class="text-success">
                Entrez les informations de produit : 
              </div>
              <div class="formul" style="margin-left: 150px;width:400px">
                <div class="row">
                  <label for="nomref" class="pt-3 form-label col-3">Nom de produit</label>
                  <input value=nomref type="text" name="nomref" class="form-control-sm col-8 mt-auto bg-warning" id="nomref" style="height: 15px;" >
                </div>
                  
                  <div class="row marque">
                                            <label for="marque" class="form-label">Marque</label></br>
                                            <select class="form-select form-select-lg mb-3"
                                                    name="marque" id="marque" required>
                                                <option selected >choisir la marque</option>
                                                 <% 
                                                 List<Marque> ListMarque = (List<Marque>) request.getAttribute("ListMarque");
                                                    for (int i = 0; i < ListMarque.size(); i++){
                                                %>
                                                <option value="<%= ListMarque.get(i).getNomMarque() %>">
                                                    <%= ListMarque.get(i).getNomMarque() %></option>
                                                <% } %>
                                            </select>
                                        </div>
                
                <div class="row">
                  <label for="denomination" class="pt-3 form-label col-3">Dénomination</label>
                  <input value="denomination" type="text" name="denomination" 
                         class="form-control-sm col-8 mt-auto bg-warning" id="denomination" style="height: 15px;" >
                </div>
                <div class="row">
                  <label for="prix" class="pt-3 form-label col-3">Prix</label>
                  <input value="prix" type="text" name="prix" 
                         class="form-control-sm col-8 mt-auto bg-warning" id="prix" style="height: 15px;" >
                </div>
                <div class="row">
                  <label for="poids" class="pt-3 form-label col-3">Poids</label>
                  <input value="poids" type="text" name="poids" 
                         class="form-control-sm col-8 mt-auto bg-warning" id="poids" style="height: 15px;" >
                </div>
                <div class="row">
                  <label for="volume" class="pt-3 form-label col-3">Volume</label>
                  <input value="volume" type="text" name="volume" 
                         class="form-control-sm col-8 mt-auto bg-warning" id="volume" style="height: 15px;" >
                </div>
                                          
      
                
              </div>
             
              <input type="submit" name="confirmer" value="confirmer" class="btn btn-primary position-absolute" style="right: 5px;">
                <i class="far fa-window-close position-absolute" style="right: 12px;top:437px;"></i>

             
            </form>
              
            
            
                              </div>
                            </div><!-- .col -->
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2022 MKSA. All rights reserved.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="./front/assetsDashboard/vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="./front/assetsDashboard/vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="./front/assetsDashboard/vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="./front/assetsDashboard/vendor/slick/slick.min.js">
    </script>
    <script src="./front/assetsDashboard/vendor/wow/wow.min.js"></script>
    <script src="./front/assetsDashboard/vendor/animsition/animsition.min.js"></script>
    <script src="./front/assetsDashboard/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="./front/assetsDashboard/vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="./front/assetsDashboard/vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="./front/assetsDashboard/vendor/circle-progress/circle-progress.min.js"></script>
    <script src="./front/assetsDashboard/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="./front/assetsDashboard/vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="./front/assetsDashboard/vendor/select2/select2.min.js"></script>

    <!-- full calendar requires moment along jquery which is included above -->
    <script src="./front/assetsDashboard/vendor/fullcalendar-3.10.0/lib/moment.min.js"></script>
    <script src="./front/assetsDashboard/vendor/fullcalendar-3.10.0/fullcalendar.js"></script>

    <!-- Main JS-->
    <script src="./front/assetsDashboard/js/main.js"></script>

    <script type="text/javascript">
$(function() {
  // for now, there is something adding a click handler to 'a'
  var tues = moment().day(2).hour(19);

  // build trival night events for example data
  var events = [
    {
      title: "Special Conference",
      start: moment().format('YYYY-MM-DD'),
      url: '#'
    },
    {
      title: "Doctor Appt",
      start: moment().hour(9).add(2, 'days').toISOString(),
      url: '#'
    }

  ];

  var trivia_nights = []

  for(var i = 1; i <= 4; i++) {
    var n = tues.clone().add(i, 'weeks');
    console.log("isoString: " + n.toISOString());
    trivia_nights.push({
      title: 'Trival Night @ Pub XYZ',
      start: n.toISOString(),
      allDay: false,
      url: '#'
    });
  }

  // setup a few events
  $('#calendar').fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,agendaWeek,agendaDay,listWeek'
    },
    events: events.concat(trivia_nights)
  });
});
    </script>

    </body>
</html>
