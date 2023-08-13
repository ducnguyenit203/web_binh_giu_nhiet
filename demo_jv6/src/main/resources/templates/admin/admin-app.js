var app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
        .when("/product", {
            templateUrl: "/admin/product/index.html",
            controller: "product-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/admin/authority/index.html",
            controller: "authority-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/admin/authority/unauthorized.html",
        })
        .when("/account", {
            templateUrl: "/admin/account/index.html",
            controller: "account-ctrl"
        })
        .when("/orders", {
            templateUrl: "/admin/order/index.html",
            controller: "order-ctrl"
        })
        .when("/categories", {
            templateUrl: "/admin/category/index.html",
            controller: "category-ctrl"
        }).when("/homeadmin", {
        templateUrl: "/admin/index.html",
    })
        .otherwise({
            //template: "<h1 class='text-center'>FPT Polytechnic Administrator</h1>",
            templateUrl: "/admin/current.html"
        })
})