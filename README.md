# InventoryManagementSystem

Mongo config - 

application.properties

server.port = 8080
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=inventoryDB


Pls setup and run mongo server before starting the application using above mongo config
Clone Git Repo in your local system using below Git command - 

**Git Branch Name which you need to check out- "main"**

git clone https://github.com/Nishu175/InventoryManagementSystem.git

This is spring boot application based on Maven.

Import project as Maven project or open directly and add as maven project after right clicking on pom.xml
    Pom.xml -> Right Click -> Add as Maven project
mvn clean
mvn package

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
--data-raw '{ "inventoryName" : "MaladInv", "supplierId":1714405371, "pincode":400010 }'


Response - 

{
    "inventoryId": 1714407141,
    "inventoryName": "MaladInv",
    "createdAt": 1714407141475,
    "supplierId": 1714405372,
    "pincode": 400010
}


4 - create catagory of product - 

curl --location --request POST 'http://localhost:8080/category' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "categoryName" : "seaFood",
    "categoryDescription":"All seaFood"
}'

Response - 

{
    "categoryId": 1714407283,
    "categoryName": "seaFood",
    "categoryDescription": "All seaFood"
}

5 - Add Product with items into above inventory - 


curl --location --request POST 'http://localhost:8080/inventory/1714407141/products' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "product": {
        "productName": "prawn",
        "productDescription": "juicy and tasty",
        "categoryId": 1714407283
    },
    "items": [
        {
            "itemName": "small prawns",
            "itemDescription": "10-12 pieces",
            "unitPriceInINR": 12,
            "quantityInGram": 100
        },
        {
            "itemName": "large prawn",
            "itemDescription": "10-12 pieces",
            "unitPriceInINR": 15,
            "quantityInGram": 200
        }
    ]
}'

Response -

{
    "product": {
        "productId": 1714410088,
        "productName": "prawn",
        "productDescription": "juicy and tasty",
        "categoryId": 1714407283
    },
    "items": [
        {
            "itemId": 1714410088194,
            "itemName": "small prawns",
            "itemDescription": "10-12 pieces",
            "productId": 1714410088,
            "unitPriceInINR": 12.0,
            "quantityInGram": 100
        },
        {
            "itemId": 1714410088201,
            "itemName": "large prawn",
            "itemDescription": "10-12 pieces",
            "productId": 1714410088,
            "unitPriceInINR": 15.0,
            "quantityInGram": 200
        }
    ]
}


6 - Add items quantity ,given inventoryId,productId and itemId
for every Item max quantity is fixed 1000 KG

curl --location --request PUT 'http://localhost:8080/inventory/1714407141/products/1714410088/items/1714410088194/add?quantityToBeAdded=12' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw ''

curl --location --request PUT 'http://localhost:8080/inventory/{invId}/products/{productId}/items/{itemId}/add?quantityToBeAdded=12'


7 - Remove items quantity ,given inventoryId,productId and itemId

curl --location --request PUT 'http://localhost:8080/inventory/1714407141/products/1714410088/items/1714410088194/remove?quantityToBeRemoved=12' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw ''

curl --location --request PUT 'http://localhost:8080/inventory/{invId}/products/{productId}/items/{itemId}/remove?quantityToBeRemoved=12'


8 - Place a order

curl --location --request POST 'http://localhost:8080/orders' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "order": {
        "shippedToPincode": 400010,
        "orderedBy": 1714405564
    },
    "items": [
        {
            "itemId": 1714410088194,
            "productId":1714410088,
            "unitPriceInINR": 121,
            "quantityInGram": 10
        }
    ]
}'

response -
{
    "orderId": 1714410824,
    "orderedTs": 1714410824914,
    "lastUpdatedTs": 0,
    "orderedBy": 1714405564,
    "transactionType": 1,
    "orderStatus": 0,
    "shippedToPincode": 400010
}


9 - Return a item from an order

curl --location --request POST 'http://localhost:8080/orders/1714410824/return' \
--header 'Content-Type: application/json' \
--header 'Cookie: WSESSIONID=GDTVI8JizNLVgpcc8t%5Q2bCB613j84YvrpvLsb8bVOkWduhCTl%2c2TpBEm7BXbzoCaKpJ2GvIESxxOAm5iWJF74djFPGpuuoG8hx2BF97U1uAzfkuc6HWvq91uQqqSH5jOsTjEdeBNXLLdakdEhO8kz%7f3EJDus' \
--data-raw '{
    "itemId": 1714410088194,
    "orderId":1714410824,
    "productId": 1714410088,
    "quantityInGram": 10
}'

response -
return placed of given items

Info:- SQL will more sutable database for this, because of relation between database, but I am using company's laptop in which I cannot install it. Hence I moved forward with mongo only.


