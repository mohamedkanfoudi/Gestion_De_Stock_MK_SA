



<?php

require "utils.php";



session_start();
$idcompte = $_SESSION['idcompte'];  
$idcompte_patient = $_GET['idC'];


$conn = new mysqli('localhost', 'root', '' , 'cabinetdb') or die ('Echec de se connecter à la base de donnée');
mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
$users = $conn->query("SELECT * FROM compte WHERE IdCompte= $idcompte_patient;");
$row= $users->fetch_assoc();




//pour listes de rendez-vous  

$sql2 = "SELECT rdv.idRdv , rdv.DateRdv , rdv.prix ,
  compte.PrenomUser , compte.NomUser , compte.TelephoneUser , compte.Email
   FROM `rdv` join compte 
   WHERE compte.IdCompte = rdv.idCompte AND compte.IdCompte = '$idcompte' ; " ;

?>






<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard</title>

    <!-- Fontfaces CSS-->
    <link href="./assetsDashboard/css/font-face.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="./assetsDashboard/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="./assetsDashboard/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="./assetsDashboard/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link rel="stylesheet" href="./style-fiche.css">

    <link href="./assetsDashboard/css/theme.css" rel="stylesheet" media="all">
    </head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="./assetsDashboard/images/icon/logo2.png" alt="" />
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
                            <a class="js-arrow" href="./accueilSecretaire.php">
                                <i class="fas fa-desktop"></i>Dashboard</a>
                        </li>
                        <li>
                            <a href="./tablesSecretaire.php">
                                <i class="fas fa-table"></i>Tables</a>
                        </li>
                        <li>
                            <a href="./calendrierSecretaire.php">
                                <i class="fas fa-calendar-alt"></i>Calendrier</a>
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
                    <img src="./assetsDashboard/images/icon/logo2.png" alt="" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li class="active has-sub">
                            <a class="js-arrow" href="./accueilSecretaire.php">
                                <i class="fas fa-desktop"></i>Dashboard</a>
                        </li>
                        
                        <li class="">
                            <a href="./tablesSecretaire.php">
                                <i class="fas fa-table"></i>Tables</a>
                        </li>
                        
                        <li>
                            <a href="./calendrierSecretaire.php">
                                <i class="fas fa-calendar-alt"></i>Calendrier</a>
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
                                            <img src="./assetsDashboard/images/icon/secretaire.jpg" alt="" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#"><?php echo $_SESSION['nom']; ?> <?php echo $_SESSION['prenom']; ?> </a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="./assetsDashboard/images/icon/secretaire.jpg" alt="" />
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#"><?php echo $_SESSION['nom']; ?> <?php echo $_SESSION['prenom']; ?></a>
                                                    </h5>
                                                    <span class="email"><?php echo $_SESSION['email']; ?> </span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                <a href="./profile.php">
                                                        <i class="zmdi zmdi-account"></i>Profile</a>
                                                </div>
                                                
                                                
                                            </div>
                                            <div class="account-dropdown__footer">
                                                <a href="./accueil.php">
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
                        
                        <!-- ------------------------------------------------------------>
                        <h1>Patient: <?php echo $row["PrenomUser"].' '.$row["NomUser"]?> </h1>
    <a href="fiche-modification.php?idC=<?php echo $idcompte_patient ?>" ><h2>modifier</h2></a>
        <div class="flex-container">
            <div class="flex-child">
        <fieldset>
            <legend><h3>Informations Patients</h3></legend>
        <p><label for="lastname"> Nom:</label> <b><?php echo $row["NomUser"]?></b>  
            <tab1><label for="firstname"> Prénom:</label> <b><?php echo $row["PrenomUser"]?></b></tab1>
        </p>

        <p><label for="cin"> CIN:</label> <b><?php echo $row["CinUser"]?></b>
            <tab1></tab1><label for="gender"> Sexe:</label> <b>Homme</b>
        </p>
        <p>
            <label for="birthday"> Date de naissance:</label> <b><?php echo $row["NaissanceUser"]?></b>
            <tab1> <label for="birthlocation"> Lieu de naissance:</label> <b><?php echo ""?></b></tab1>
        </p>
        </fieldset>
            </div>
        <div class="flex-child">
        <fieldset>
            <legend><h3>Adresse et Contact</h3></legend>
            <label for="address"> Adresse:</label> <b><?php echo $row["addressUser"]?></b>
            <p><label for="city"> Ville:</label> <b><?php echo $row["Ville"]?></b>
            <label for="email"> email:</label> <b><?php echo $row["Email"]?></b><br><br>
            <label for="telephone_portable"> Téléphone Portable:</label> <b><?php echo $row["TelephoneUser"]?></b>

        </p>
        
    
        </fieldset>
    </div>
</div>
    <fieldset>
        <legend><h3>Liste de consultations</h3></legend>
    </fieldset>
    <fieldset>
        <legend><h3>Liste des paiements</h3></legend>
    </fieldset>
    <fieldset>
        <legend><h3>Liste des rendez-vous</h3></legend>
        
    </fieldset>
                        <!-- -------------------------------------------------------------- -->   
                        </div>
                        
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2022 C4GAMES. All rights reserved.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="./assetsDashboard/vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="./assetsDashboard/vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="./assetsDashboard/vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="./assetsDashboard/vendor/slick/slick.min.js">
    </script>
    <script src="./assetsDashboard/vendor/wow/wow.min.js"></script>
    <script src="./assetsDashboard/vendor/animsition/animsition.min.js"></script>
    <script src="./assetsDashboard/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="./assetsDashboard/vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="./assetsDashboard/vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="./assetsDashboard/vendor/circle-progress/circle-progress.min.js"></script>
    <script src="./assetsDashboard/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="./assetsDashboard/vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="./assetsDashboard/vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="./assetsDashboard/js/main.js"></script>

</body>

</html>
<!-- end document-->

