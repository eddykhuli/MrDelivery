/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('app', ['angular-storage']);
app.controller('HomeController', ['$scope', 'store', "$window", "$http", function ($scope, store, $window, $http) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
       
       $http.get('/restaurant/getAllRestaurants',config).then(function(response){
           console.log(response);
           $scope.restaurants = response.data;
       });
       
       
        $scope.locations = ["Alberton", "Ballito", "Bedfordview", "Benoni", "Bloemfontein", "Brakenfell", "Bryanston", "Centurion", "Benoni", "Constantia", "Cresta & Randburg", "Durban North", "East london", "East Rand Mall", "Edenvale", "Fordsburg", "Fourways", "Gardens", "Gateway", "Gordons Bay", "Hatfield", "Kempton Park", "Kenilworth", "Kimberly", "Klerksdorp", "Melville", "Menlyn", "Midrand", "Milnerton", "Morningside", "Mthatha", "Nelspruit", "Northgate", "Norwood", "Parow", "Polokwane", "Port Elizabeth", "Potchefstroom", "Rivonia & Sunninghill", "Rondebosch", "Rosebank", "Rustenburg", "Sandton", "Sea point", "Somerset west", "Southern surbubs(JHB)", "Stellenbosch", "Table view", "Tokai", "Tygervalley", "Weltervredepark", "Westrand", "Westville", "Witbank", "Other"];
         var orderDate = new Date();
        var dd = orderDate.getDate();
        var mm = orderDate.getMonth()+1; //January is 0!
        var yyyy = orderDate.getFullYear();
        var hh = orderDate.getHours();
        var mm = orderDate.getMinutes();
        if(dd<10) {
        dd = '0'+dd;
        } 

        if(mm<10) {
            mm = '0'+mm;
        } 
        
        orderDate = mm + '/' + dd + '/' + yyyy + ' at ' + hh+':'+mm;
        console.log(orderDate);
        $scope.isLoggedin = false;
        console.log("home controller");
        $scope.loggedInAccount = store.get("accountObj");
         
       if($scope.isLoggedIn === true)
       {
            $scope.currentUser;
        $http.get('/account/person/getPerson/'+ $scope.loggedInAccount.userId, config).then(function (response) {
                console.log(response.data);
                $scope.currentUser = response.data;
                 store.set("currentUser",$scope.currentUser);
            });
       
       }
       
       
        console.log(store.get("currentUser"));
        store.set("loggedInAccount", $scope.loggedInAccount);
        //store.remove("loggedInAccount");
          //store.remove("currentUser");
        $scope.info = $scope.loggedInAccount.email;
        console.log($scope.info);

        $scope.logout = function () {
            store.remove("loggedInAccount");
            store.remove("currentUser");
            alert("Logging out");
            $window.location.href = "http://localhost:8080/";

        };
        
        $scope.viewProfile = function () {
            $http.get('/account/person/getPerson/'+ $scope.loggedInAccount.userId, config).then(function (response) {
                console.log(response.data);
                $scope.currentUser = response.data;
               
                $window.location.href = "/customer/viewProfile";
                
            });
        };
        $scope.driver = function()
        {
          $window.location.href = "http://localhost:8080/registerDriver";  
        };
         $scope.partner = function()
        {
          $window.location.href = "http://localhost:8080/registerRestaurant";  
        };
        $scope.placeAnOrder = function () {
            $scope.p = $scope.getChow;
            if($scope.p !== null){
                $window.location.href = "http://localhost:8080/login/customer/restaurants";
            }
            else{
                alert("Please Enter location");
             $window.location.href = "http://localhost:8080/";
            };
             
        };
        $scope.viewMenu = function () {
            console.log("button working");
            $window.location.href = "http://localhost:8080/restaurants/menu";
        };
        
       $scope.viewOrders = function(){
            
            $http.get('/login/customer/viewOrders/'+$scope.loggedInAccount.userId,config).then(function(response){
                alert("working");
                console.log(response.data);
                $scope.orderInfo = response.data;
                $window.location.href = "/login/customer/orders";
            });
       };

    }]);
app.controller('Registration', ['$scope', '$http','$window', function ($scope, $http,$window) {
        console.log("registrationControl");
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };//this implies that this will receicve & send data as json

        $scope.onClick = function () {
           
                    $http.post('/registerPerson', $scope.person, config).then(function () {
                    alert("Customer successfully registered!!");
                    }, function () {
                    alert("Failed ");
                });
            };
       

    }]);
app.controller('LoginCtrl', ['$scope', '$http', '$window', 'store', function ($scope, $http, $window, store) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };//this implies that this will receicve & send data as json

        $scope.onClick = function (login) {


            $http({
                url: '/acc/login',
                method: 'GET',
                params: {email: $scope.login.email, password: $scope.login.password}
            }).then(successCallback);
            function successCallback(response) {
                var user = response.data;

                if ($scope.login.email === user.email) {
                    $scope.user = user;
                    console.log(user);
                    var account = {
                        'id': response.data.id,
                        'email': response.data.email,
                        'userId': response.data.userId
                    };

                    store.set("accountObj", account);
                    // store.set("userId",account.userId);
                   $scope.isLoggedin = false;
                    if (user.role === 'Customer')
                    {
                        alert("Logged in as customer");
                        $scope.isLoggedin = true;
                        $window.location.href = "http://localhost:8080/";

                    } else if (user.role === 'Partner')
                    {
                        alert("Logged in as Partner");
                        $window.location.href = "http://localhost:8080/login/restaurant";

                    } else if (user.role === 'Administrator') {
                        
                        alert("Logged in as administrator");
                        $window.location.href = "http://localhost:8080/login/admin";

                    }
                    else if (user.role === 'Driver') {
                        
                        alert("Logged in as Driver");
                        $window.location.href = "http://localhost:8080/login/driver";

                    }
                } else
                {
                   alert("Failed to login..check login Details and try again");
                   $window.location.href = "/login";
                }
            }
            
        };

    }]);

app.controller('RestaurantRequest', ['$scope', '$http','$window', function ($scope, $http,$window) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        $scope.createRequest = function () {
            $http.post('http://localhost:8080/placeRequestForRestaurant', $scope.r, config).then(function () {
                alert("Request succesfully sent");
                $window.location.href = '/login';
            }), function () {
                alert("failed to send request");
            };
        };


    }]);
app.controller('DriverRequestController', ['$scope', '$http', '$location','$window', function ($scope, $http, $location,$window) {

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }};

        $scope.locations = ["Alberton", "Ballito", "Bedfordview", "Benoni", "Bloemfontein", "Brakenfell", "Bryanston", "Centurion", "Benoni", "Constantia", "Cresta & Randburg", "Durban North", "East london", "East Rand Mall", "Edenvale", "Fordsburg", "Fourways", "Gardens", "Gateway", "Gordons Bay", "Hatfield", "Kempton Park", "Kenilworth", "Kimberly", "Klerksdorp", "Melville", "Menlyn", "Midrand", "Milnerton", "Morningside", "Mthatha", "Nelspruit", "Northgate", "Norwood", "Parow", "Polokwane", "Port Elizabeth", "Potchefstroom", "Rivonia & Sunninghill", "Rondebosch", "Rosebank", "Rustenburg", "Sandton", "Sea point", "Somerset west", "Southern surbubs(JHB)", "Stellenbosch", "Table view", "Tokai", "Tygervalley", "Weltervredepark", "Westrand", "Westville", "Witbank", "Other"];
        $scope.availTime = ["Anytime", "Nights And Weekends", "Weekends Only", "Weekdays Only"];
        $scope.appoint = ["Full Time", "Part Time", "Others"];
        $scope.transportOption = ["Car", "Bike", "Other Transport"];
        $scope.license = ['Yes', 'No'];
        $scope.driver = {favorite: 'Yes'};

        $scope.createDriverRequest = function (driver) {
            $http.post('http://localhost:8080/registerDriver', $scope.driver, config).then(function (response) {
                console.log(response);
                alert("Driver request successfully sent");
                $window.location.href = '/login';
            });
        };
        
         $scope.viewToDeliverOrders = function(){
            
            $scope.status = "Dispatched";
           
            $http.get('http://localhost:8080/driver/order/findByStatus/'+$scope.status,config).then(function(response){
                console.log(response.data);
                $scope.orders = response.data;
                $scope.orderDate = $scope.orders.orderDate;
            });
        };
        
        $scope.updateOrderStatus = function(order){
            
           $scope.orderId = order.orderId;
         
         
           $http.put('/restaurant/order/updateOrder/'+$scope.orderId,order,config).then(function(response){
               alert("Order status now updated to"+order.status);
               console.log(response.data);
               
           });

        };
        
       

    }]);


app.controller('AdminController', ['$scope', '$http', '$window','store', function ($scope, $http, $window,store) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        
        console.log(store.get("currentUser"));
        $scope.adminDetails = store.get("currentUser");
     
       $scope.deleteUser = function(){
           $http.delete('/person/deletePerson/'+ store.get("userId"),config).then(function(response){
               alert("deleted");
           });
       };
        $scope.getPerson = function(){
             $http.get("http://localhost:8080/account/person/getPerson/" + store.get("userId"), config).then(function (response) {
            //$scope.userInfo = response.data;
            console.log(response.data);
        });
        };
       $scope.viewAllRestaurantRequests = function(){
            $http.get('http://localhost:8080/getAllRestaurantsRequests', config).then(function (response) {
            console.log(response);
            $scope.restaurants = response.data;
            console.log($scope.restaurants);

        });
       };
          $scope.allAccounts = function(){
            
            $http.get('/login/allAccounts',config).then(function(response){
                console.log(response);
                $scope.accounts = response.data;
            });
        };
          $scope.viewAllDriverRequests = function(){
            $http.get('http://localhost:8080/getAllDriverRequests', config).then(function (response) {
            console.log(response);
            $scope.drivers = response.data;
        });
       };
       $scope.viewAllUsers = function(){
           $http.get('/person/getAllPeople',config).then(function(response){
               console.log(response);
               $scope.people = response.data;
               store.set("userId",response.data.id);
               console.log($scope.people);
           });
       };
        $scope.registerPartner = function (rests) {
          
                    $http.post('http://localhost:8080/registerPartner', rests, config).then(function (response) {
                    console.log(response);
                    alert("Partner succesfully registerd");
                    

                });
           
        };
        $scope.driver;
        $scope.registerDriver = function(driver){
            
            $http.post('/registerDriverAccount',driver,config).then(function(response){
                console.log(response);
                $scope.driver = response.data;
                store.set("driver",$scope.driver);
                console.log(store.get("driver"));
                alert("Driver succesfully registered and Account saved");
            });
        };
        $scope.viewAllProducts = function(){
            
            $http.get('/restaurant/getAllProducts/',config).then(function(response){
                $scope.allProducts = response.data;
            });
        };
        $scope.viewAllRestaurants = function(){
            $http.get('/restaurant/getAllRestaurants',config).then(function(response){
                console.log(response);
                $scope.allRestaurants = response.data;
            });
        };
        $scope.getAllOrders = function(){
            
            $http.get('/admin/order/allOrders',config).then(function(response){
                console.log(response);
                $scope.allOrders = response.data;
            });
        };
        
        
        
     
        
        $scope.logoutAdmin = function () {
            store.remove("loggedInAccount");
            store.remove("currentUser");
            alert("Logging out");
            $window.location.href = "/";};
       

        $scope.sendPassword = function(rests){
            
            $http.get('/login/account/findUesrAccount/'+rests.id,config).then(function(response){
                console.log(response);
                        var mailData = {
                    "email" :  response.data.email,
                     "password" : response.data.password
                  };
            console.log(mailData);
            $scope.obj = JSON.parse(mailData);
            console.log($scope.obj);
                    $http.post('http://localhost:8080/sendPasswordToPartner', $scope.obj,config).then(function(response){
                       console.log(response);
                   });
            });
            
//            console.log(rests);
////           
//            console.log(mailData);
//            //JSON.parse('{ "name":"John", "age":30, "city":"New York"}')
      
//             $http({
//                url: '/sendPasswordToPartner',
//                method: 'POST',
//                params: {email: "ghlungwani909@gmail.com", password:  "glen123"}
//            }).then(function(response){
//                console.log(response.data);
//            });
////            
////            /login/account/findUesrAccount/{userId}
////            
        };




    }]);





app.controller('RestaurantController', ['$scope', '$http', '$window', 'store', function ($scope, $http, $window, store) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        $scope.categories = [];
        var id = store.get("accountObj").userId;

        $http.get("http://localhost:8080/account/person/getPerson/" + id, config).then(function (response) {
            //$scope.userInfo = response.data;
            console.log(response.data);
        });

        var imageCopy = null;
        var image = null;
        var handleImageSelect = function (evt) {
            var files = evt.target.files;
            var file = files[0];

            if (files && file) {
                var reader = new FileReader();
                reader.onload = function (readerEvt) {
                    var binaryString = readerEvt.target.result;
                    imageCopy = btoa(binaryString);
                    image = 'data:image/octet-stream;base64,' + imageCopy;
                    //console.log(image);
                };
                reader.readAsBinaryString(file);
            }
        };

        if (window.File && window.FileReader && window.FileList && window.Blob) {
            document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
        } else {
            alert('The File APIs are not fully supported in this browser.');
        }
        console.log(store.get("accountObj"));
        $scope.addRestaurant = function ()
        {
            console.log(store.get("accountObj"));
            var restaurant = {
               'accountId': store.get("accountObj").id,
               'address': $scope.address,
               'image': image,
               'restaurantName': $scope.restaurantName
            };
            
            $http.post('http://localhost:8080/restaurant/addRestaurant',restaurant,config).then(function (response) {
                store.set("restId",response.data.id);
                alert("Restaurant added succesfully");
                console.log(response.data);
            });
        };
       
        $http.get('http://localhost:8080/restaurant/getByAccountId/'+store.get("accountObj").id,config).then(function(response){
            console.log(response.data);
            store.set("restObj",response.data);
            $scope.restaurantImage = store.get("restObj").image;
            console.log(store.get("restObj"));
           
            
            if(response.data.categories !== null)
            {
               
                for(var x = 0; x <= response.data.categories.length;x++)
                {
                       if(response.data.categories[x] !== null)
                       {
                           
                           
                            $scope.categories =response.data.categories;
                         //$scope.categories = response.data.categories;
                            console.log($scope.categories);
                       }
                }
            }
            
        });
        
        $scope.addCategory = function(){
            console.log(store.get("restObj").id);//to continue from here
            var categoryInfo = {
                'restId': store.get("restObj").id,
                'categoryName' : $scope.categoryName
            };
            
                console.log(categoryInfo);
             $http.post('/categories/addCategory/'+store.get("restObj").id,categoryInfo,config).then(function (response) {
                console.log(response.data);
                
                alert("New Category added successfully...");
            });
        };
         var currId = store.get("accountObj").id;
         console.log(store.get("accountObj").id);
       console.log(store.get("restObj").id);
        
         $scope.addProduct = function () {
            console.log($scope.category.categoryName);
            var catName = $scope.category.categoryName;
            console.log(catName);
            
              var price =  parseFloat($scope.price);
                    var productInfo = {
                        //'id' : $scope.id,
                        'description': $scope.description,
                        'price': price,
                        'category': catName,
                        'productName': $scope.productName
                    };
                   $http.post('http://localhost:8080/restaurant/addProduct/'+catName,productInfo, config).then(function (response) {
                        console.log(response);
                        alert("New Product added successfully...");
                    });
            
        };
        
        $scope.viewRestOrders = function(){
            
            $scope.restaurantName = store.get("restObj").restaurantName;
            console.log($scope.restaurantName);
            $http.get('http://localhost:8080/restaurant/getOrders/'+$scope.restaurantName,config).then(function(response){
                console.log(response.data);
                $scope.orders = response.data;
                $scope.orderDate = $scope.orders.orderDate;
            });
        };
         $scope.viewDelivered = function(){
            
            $scope.status = "Delivered";
           
            $http.get('http://localhost:8080/driver/order/findByStatus/'+$scope.status,config).then(function(response){
                console.log(response.data);
                $scope.ordersD = response.data;
                $scope.orderDate = $scope.orders.orderDate;
            });
        };
        
        $scope.updateOrderStatus = function(order){
            
           $scope.orderId = order.orderId;
         
         
           $http.put('/restaurant/order/updateOrder/'+$scope.orderId,order,config).then(function(response){
               alert("Order status now updated to"+order.status);
               console.log(response.data);
               
           });

        };
        
        $scope.logout = function () {
            store.remove("loggedInAccount");
            store.remove("currentUser");
            alert("Logging out");
            $window.location.href = "http://localhost:8080/";};



    }]);


app.controller('CustomerController', ['$scope', '$http','store','$window', function ($scope, $http,store,$window) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        $http.get('http://localhost:8080/restaurant/getAllRestaurants',config).then(function(response){
            console.log(response.data);
            $scope.allRestaurants = response.data;
            $scope.getLimits = function (allRestaurants) {
                return [
                    Math.floor(allRestaurants.length / 2) + 1,
                    -Math.floor(allRestaurants.length / 2)
                ];
               };
            for(var i = 0; i < $scope.allRestaurants.length;i++)
            {
                
                console.log(store.get("restaurant"));
            }
            console.log($scope.allRestaurants);
        });

        $scope.viewRestaurant = function(restaurant){
            //console.log(restaurant);
            alert("its working");
            store.set("restaurant",restaurant);
            console.log("its working");
            
             console.log(store.get("restaurant"));  
        };

    }]);
app.controller('MenuController', ['$scope', '$http','store','$window','$rootScope', function ($scope, $http,store,$window,$rootScope) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
                $scope.total=0;
              // $scope.quantity = 1;
               $scope.products = [];
               $scope.cart = [];
                $scope.deliveryType = ['Mr D Delivery', 'Self Collect'];
                $scope.collection = { favorite: 'Mr D Delivery' };
                $scope.restaurantInfo = store.get("restaurant");
                console.log($scope.restaurantInfo.categories);
          
       $http.get('/restaurant/getByAccountId/'+ store.get("restaurant").accountId,config).then(function(response){
           console.log(response.data);
           $scope.image = store.get("restaurant").image;
           $scope.restaurantName = response.data.restaurantName;
           $scope.categories = response.data.categories;
           
           
           $http.get('/categories/get/getCategoryByRestId/'+store.get("restaurant").accountId,config).then(function(response){
                console.log(response.data);
              
                $scope.products = response.data.map(product => product.products);
               // $scope.products.push(response.data);
                console.log($scope.products);
           });
           });
            $scope.selected = function()
            {
                 console.log($scope.collection.favorite);
                 
                 if($scope.collection.favorite === 'Mr D Delivery')
                 {
//                        $scope.estatimatedTime = "Estimated time of delivery 45 minutes"; 
//                        $scope.serviceFee = false;
//                        $scope.decision = "Mr D Delivery";
//                        $scope.total =  $scope.subtotal + $scope.deliveryFee;
                        console.log($scope.collection.favourite);
                 }else if($scope.collection.favorite === 'Self Collect')
                 {
                        $scope.serviceFee = true;
                        $scope.estatimatedTime = " Ready to collect in 20 minutes";
                        $scope.total =  $scope.subtotal;
                        $scope.decision = "Self Collect";
                        console.log($scope.collection.favourite);
                 }
                 
                 console.log($scope.estatimatedTime);
            };
         
        
        
         $scope.showCartInfo= function(toAddProduct){
               
                $scope.modelProduct = toAddProduct;
                console.log($scope.modelProduct);
                $scope.increaseCart = function()
                {
                  // $scope.quantity +=1;
                   //$scope.total +=parseFloat($scope.product.price);
                  toAddProduct.quantity +=1;
                    $scope.total  +=parseFloat(toAddProduct.price);  
                   console.log(toAddProduct);
                };
                
             $scope.decreaseCart = function()
             {
                     toAddProduct.quantity -=1;
                     $scope.total  -=parseFloat(toAddProduct.price);  
             };
            // $scope.subTotal += $scope.total;   
      };
          
              
        $scope.addToCart = function(modelProduct){
		  
		 	
            console.log(modelProduct);
            
           
           if($scope.cart.length === 0)
           {
             //modelProduct.quantity = 1;
             $scope.cart.push(modelProduct);
             
           }
           else{
           
               for(var x = 0; x< $scope.cart.length; x++)
               {
                   var repeat = false;
                   if($scope.cart[x].id === modelProduct.id)
                   {
                       alert("Product already in cart,quantity will be increased");
                       repeat = true;
                        $scope.cart[x].quantity += 1;
                   }
               }
               if (!repeat) {
                    //modelProduct.quantity = 1;
                    $scope.cart.push(modelProduct);	
		}

           }
            
           store.set("cartInfo",$scope.cart);
           store.set("total",$scope.total);
           console.log(store.get("total"));
           console.log($scope.cart);
           console.log(store.get("cartInfo"));
          
              
       };
       $scope.removeFromCart = function(product){
            var index = $scope.cart.indexOf(product);
            $scope.cart.splice(index, 1);
       };
        
       $scope.showOrder = function(){
           console.log(store.get("currentUser"));
             console.log(store.get("cartInfo"));
           $window.location.href = "/customer/menu/addToCart";
       };
       $scope.backToShopping = function(){
           store.get("cartInfo");
           $window.location.href = "/customer/menu";
       };
  
    }]);
app.controller('CartController', ['$scope','$http','store','$window', function ($scope, $http,store,$window) {
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        $scope.restName =store.get("restaurant").restaurantName;
        console.log($scope.restName);
        $scope.cartOwner = store.get("currentUser");
        $scope.subTotal = store.get("total");
        $scope.serviceFee = 26.00;
        $scope.totalDue = $scope.subTotal + $scope.serviceFee;
        $scope.account = store.get("accountObj");
        $scope.userCart = store.get("cartInfo");
        
        $scope.showInfomation = function(){
             console.log($scope.cartOwner);
             console.log(store.get("cartInfo"));
             console.log(store.get("accountObj"));
             console.log($scope.serviceFee +" "+$scope.account.userId +" "+$scope.subTotal);
             console.log(store.get("accountObj"));
        };
        var orderDate = new Date();
        var dd = orderDate.getDate();
        var mm = orderDate.getMonth()+1; //January is 0!
        var yyyy = orderDate.getFullYear();
        var hh = orderDate.getHours();
        var mm = orderDate.getMinutes();
        if(dd<10) {
        dd = '0'+dd;
        } 

        if(mm<10) {
            mm = '0'+mm;
        } 

        orderDate = mm + '/' + dd + '/' + yyyy + 'time' + hh+':'+mm;
        console.log(orderDate);
         $scope.deliveryType = ['Mr D Delivery', 'Self Collect'];
         $scope.collection = { favorite: 'Mr D Delivery' };
       
                 
        var orderInfo = {
            'orderId' : makeid(),
            'userId' : $scope.account.userId,
            'subTotal' :   $scope.subTotal,
            'total' :$scope.totalDue,
            'collectionType' : "Mr D Delivery",
            'status' : 'Received',
            'cartItems' : $scope.userCart,
            'restaurantName' :  $scope.restName,
            'orderDate' : orderDate
        };
        console.log(orderInfo);
        $scope.orderInfo = orderInfo;
        console.log(orderInfo);
        
       
        
           
                function makeid() {
                    var text = "MDM";
                    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

                    for (var i = 0; i < 10; i++)
                      text += possible.charAt(Math.floor(Math.random() * possible.length));

                    return text;
                    }

                console.log(makeid());
                
                
                $scope.toCashPayment = function(){
                     $window.location.href = "/order/payment/cashPayment";
                };
                $scope.toCardPayment = function(){
                    $window.location.href = "/order/payment/cardPayment";
                };
                
                 $scope.placeOrder = function(){
                     
                            console.log($scope.orderInfo);
                            
                           $http.post('/order/saveOrder',$scope.orderInfo).then(function(response){
                               alert("order succesfully placed...check email for status or check in your order history");
                               console.log(response.data);
                                store.set("orderObj",response.data);
//                               console.log(store.get("orderObj"));
                           });
                              $scope.done = function(){
                              var paymentInfo ={
                                  'orderId' : store.get("orderObj").orderId,
                                   'userId' : store.get("orderObj").userId,
                                    'status' : "Payed",
                                     'paymentType' :"Cash payment",
                                     'amountPayed' :store.get("orderObj").total
                            };
                            console.log(paymentInfo);
                            $http.post('/order/payment',paymentInfo,config).then(function(response){
                                alert("payment made");
                                console.log(response.data);
                                
                            });
                           // $window.location.href = '/';
                };
                            
                            
                           
                };
             
               $scope.proceedOrder = function(){
                   
                            $http({
                        url: '/payment/creditCardpayment',
                        method: 'GET',
                        params: {accountNumber: $scope.bank.accountNumber, pin: $scope.bank.pin}
                        }).then(function(response){
                        console.log(response.data);
                        var details = response.data;
                        if($scope.bank.accountNumber === details.accountNumber && $scope.bank.pin === details.pin)
                        {   console.log($scope.orderInfo);
                             $http.post('/order/saveOrder',$scope.orderInfo).then(function(response){
                               alert("order succesfully placed...check email for status or check in your order history");
                               console.log(response.data);
                                 store.set("orderObj",response.data);
                              console.log(store.get("orderObj"));                            
                              $scope.done = function(){
                                  
                                  var paymentInfo ={
                                  'orderId' : store.get("orderObj").orderId,
                                  'userId' : store.get("orderObj").userId,
                                   'status' : "Payed",
                                       'amountPayed' :store.get("orderObj").total
                                    };
                                    console.log(paymentInfo);
                                         $http.post('/order/payment',paymentInfo,config).then(function(response){
                                        alert("payment made");
                                       console.log(response.data);
                                   });

                                   // $window.location.href = '/';
                              };
                            });
                        }
                        else{
                            alert("Payment unsuccessfull...Wrong banking details provided verify and try again");
                        }
                    });
               };
                

    }]);

app.controller('PaymentController',['$scope','$http','store','$window',function($scope,$http,$window,store){
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
      // params: {accountNumber: $scope.accountNumber, pin: $scope.pin}
      
        $scope.orderReview = store.get("orderObj");
        console.log(store.get("orderObj"));
         console.log( $scope.orderReview );
//        $scope.showAccount = function(bank){
//            

//            
//        };
//     
       
        
        
        
        
}]);

 
