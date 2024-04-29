# InventoryManagementSystem




Mongo config - 

server.port = 8080

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=inventoryDB


Pls setup and run mongo server before starting the application

This is spring boot application.

Run application from main class - 
com.example.inventorymanagementsystem.InventoryManagementSystemApplication



1- create supplier using admin options

curl --location --request POST 'http://localhost:8080/admin/supplier' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "userName": "ashok",
    "userEmail": "abc@gmail.com"
}'

Response - 

{
    "userId": 1714363122,
    "userName": "ashok",
    "userEmail": "abc@gmail.com",
    "userRole": 0,
    "createdTs": 1714363122408,
    "updatedTs": 0
}




1- create buyer using admin options


curl --location --request POST 'http://localhost:8080/admin/buyers' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    
    "userName":"buyer",
    "userEmail":"buyer@gmail.com"
    
}'

Response - 

{
    "userId": 1714363093,
    "userName": "buyer",
    "userEmail": "buyer@gmail.com",
    "userRole": 1,
    "createdTs": 1714363093800,
    "updatedTs": 0
}


3 - create inventory for above supplier

curl --location --request POST 'http://localhost:8080/inventory' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "inventoryName" : "myInv",
    "supplierId":1714362645,
    "pincode":123
}'


Respnse - 

{
    "inventoryId": 1714363155,
    "inventoryName": "myInv",
    "createdAt": 1714363155434,
    "supplierId": 1714362645,
    "pincode": 123
}


4 - create catagory of product - 

curl --location --request POST 'http://localhost:8080/category' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "categoryName" : "Electornos",
    "categoryDescription":"Electornos Electornos"
}'

Response - 

{
    "categoryId": 1714362993,
    "categoryName": "Electornos",
    "categoryDescription": "Electornos Electornos"
}

5 - Add Product with items into above inventory - 


curl --location --request POST 'http://localhost:8080/inventory/1714363155/products' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "product": {
        "productName": "Samsumng ss",
        "productDescription": "new Samsumng 12",
        "categoryId": 1714362993
    },
    "items": [
        {
            "itemName": "s5",
            "itemDescription": "s1 des",
            "unitPriceInINR": 12,
            "quantityInGram": 10
        },
        {
            "itemName": "s6",
            "itemDescription": "s2 des",
            "unitPriceInINR": 12,
            "quantityInGram": 20
        }
    ]
}'


6 - Add items quantity ,given inventoryId,productId and itemId

curl --location --request PUT 'http://localhost:8080/inventory/1714363155/products/1714363218/items/1714363218/add?quantityToBeAdded=12' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw ''

curl --location --request PUT 'http://localhost:8080/inventory/{invId}/products/{productId}/items/{itemId}/add?quantityToBeAdded=12'


7 - Remove items quantity ,,given inventoryId,productId and itemId

curl --location --request PUT 'http://localhost:8080/inventory/1714363155/products/1714363218/items/1714363218/remove?quantityToBeRemoved=12' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw ''

curl --location --request PUT 'http://localhost:8080/inventory/{invId}/products/{productId}/items/{itemId}/remove?quantityToBeRemoved=12'


8 - Place a order

curl --location --request POST 'http://localhost:8080/orders' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "order": {
        "shippedToPincode": 123,
        "orderedBy": 123
    },
    "items": [
        {
            "itemId": 1714357644,
            "productId":1714357566,
            "unitPriceInINR": 121,
            "quantityInGram": 10
        }
    ]
}'


9 - Return a item from an order

curl --location --request POST 'http://localhost:8080/orders/1714361863/return' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "itemId": 1714357644,
    "orderId":1714361863,
    "productId": 1714357566,
    "quantityInGram": 10
}'



