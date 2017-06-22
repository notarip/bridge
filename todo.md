### TODO
- mandar el procesamiento de la respuesta al servicio en Mp para que quede como la de TP
- agregar un id externo al pago
- seguir con smart payment, para ver con que criterios mandar a uno o al otro
- hacer parametria de colas para habilitar y no 
- integrar rabitMQ
- Parametrizar datos de los gateways
- cubrir el flujo de cancel de mp
- cubrir el flujo de cancel de tp


### MP
 #{"id":257953849,"nickname":"TETE5813279","password":"qatest1533","site_status":"active","email":"test_user_2634434@testuser.com"}
 #{"id":257956135,"nickname":"TETE5610508","password":"qatest1966","site_status":"active","email":"test_user_81310653@testuser.com"

Naranja 				5895 6278 2345 3005
Nativa Mastercard 5465 5326 8384 0176
Tarjeta Shopping	6034 8800 0094 4555
Cencosud				6034 9372 7286 2830
Cabal					6035 2277 1642 7021

#### urls
- https://www.mercadopago.com.ar/developers/es/related/test-local-cards/
- https://www.mercadopago.com/mla/account/credentials?type=basic


#### TP 
https://developers.todopago.com.ar/site/datos-de-prueba
Nro. de Comercio (Merchant ID) 27117
Credenciales (API Keys) TODOPAGO f80bd88960a54b2cbc0241c882fdf856

Nro de Tarjeta				Tipo de Tarjeta			CCV	Vencimiento
376411234531007		American Express		123	10/18
5896570000000008	Cabal						123	02/17
36463664750005		Diners						123	07/18
5323601111111112	Mastercard				123	09/18
4507990000000010	Visa							123	09/18


#### Rabbit

rabbitmq-plugins enable rabbitmq_web_stomp

http://localhost:8080/rabbit/echo.html?ws

#### Boostrap

{"name" : "criteria",
    "criteriaName" : "date",
    "from" : ISODate("2015-01-01T21:21:20.201Z"),
    "to" : ISODate("2050-06-12T12:50:00.000Z")}

{"name" : "date",
    "gatewayName" : "TP",
    "gatewayAlternativeName" : "MP",
    "from" : ISODate("2015-01-01T21:21:20.201Z"),
    "to" : ISODate("2017-06-12T12:50:00.000Z")}

{"name" : "mount",
    "gatewayName" : "TP",
    "gatewayAlternativeName" : "MP",
    "fromMount" :0,
    "toMount": 100,
    "from" : ISODate("2015-01-01T21:21:20.201Z"),
    "to" : ISODate("2050-06-12T12:50:00.000Z")}




