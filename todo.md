### TODO
- mandar el procesamiento de la respuesta al servicio en Mp para que quede como la de TP
- agregar un id externo al pago
- seguir con smart payment, para ver con que criterios mandar a uno o al otro
- hacer parametria de colas para habilitar y no 
- integrar rabitMQ
- Parametrizar datos de los gateways
- cubrir el flujo de cancel de mp
- cubrir el flujo de cancel de tp



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




