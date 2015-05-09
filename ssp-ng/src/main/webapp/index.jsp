<!doctype html>
<html lang="en" ng-app="shopping-list">
<head>
    <meta charset="utf-8">
    <title>Shopping List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href='http://fonts.googleapis.com/css?family=Nixie+One' rel='stylesheet' type='text/css'>
    <link href="lib/fontello/css/fontello.css" rel="stylesheet">
    <link href="lib/fontello/css/animation.css" rel="stylesheet">
    <link rel="stylesheet" href="css/app.css"/>
</head>
<body ng-controller="HomeController">

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a ng-href="#">Home</a></li>
            <li><a ng-href="#/about">About</a></li>
            <li><a ng-href="#">Contact</a></li>
        </ul>
        <h3 class="text-muted">ssp-ng</h3>
    </div>


    <div class="col-lg-2">
        <div class="btn-wrapper">
            <a ng-click="createList();" class="btn btn-block btn-warning">Nouvelle Liste</a>
        </div>
        <div class="unstyled" ui-sortable ng-model="lists">
            <hr>
            <p ng-repeat="list in lists"><a ng-click="loadList(list);"
                                              class="btn btn-block btn-primary">{{list.name}}</a></p>

        </div>

        `


    </div>
    <div class="col-lg-10">
        <div ng-show="lists.length>0" class="list">
            <h4 class="title" editable="updateList" contentEditable="true" ng-model="currentList.name"></h4>

            <div class="wrapper">
                <form ng-submit="addItem()">
                    <input type="text" ng-model="newItem" autofocus placeholder="Ajouter à la liste..."
                           class="form-control"/>
                </form>
                <hr>
                <p class="input-group" ng-repeat="item in currentList.items">

                        <input type="text" ng-model="item.name" class="form-control">
                        <span class="input-group-btn">
                            <button class="btn btn-danger" ng-click="removeItem(item)" aria-label="Remove">X</button>
                        </span>

                </p>



            </div>
            <section class="actions">
                <button class="btn btn-danger" ng-click="deleteList();" aria-label="Remove">Remove all</button>
            </section>
        </div>
    </div>


    <div class="footer">

    </div>
</div>


<!--
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
 -->
<script src="lib/jquery-1.9.0.min.js"></script>

<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.4/angular.min.js"></script>
-->
<script src="lib/angular/angular.min.js"></script>
<script src="lib/angular/angular-resource.min.js"></script>

<script src="js/app.js"></script>
<script src="js/services.js"></script>
<script src="js/controllers.js"></script>
<script src="js/filters.js"></script>
<script src="js/directives.js"></script>
</body>
</html>