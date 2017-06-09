### TODO


- Para TP terminar el flujo de un pago ok 
- cubrir el flujo de cancel de mp
- hacer parametria de colas para habilitar y no 
- integracion de TP
- integrar rabitMQ
- Parametrizar datos de los gateways
- endpoint de vuelta de pagos
	- collection_id=2754549626&collection_status=approved&preference_id=257953849-5e7eeb65-37af-4ec2-b2bc-e91a7ca91ce2&external_reference=null&payment_type=credit_card&merchant_order_id=505448717


### urls
- https://www.mercadopago.com.ar/developers/es/related/test-local-cards/
- https://www.mercadopago.com/mla/account/credentials?type=basic

### usuarios
 #{"id":257953849,"nickname":"TETE5813279","password":"qatest1533","site_status":"active","email":"test_user_2634434@testuser.com"}
 #{"id":257956135,"nickname":"TETE5610508","password":"qatest1966","site_status":"active","email":"test_user_81310653@testuser.com"

#### TP 
https://developers.todopago.com.ar/site/datos-de-prueba
Nro. de Comercio (Merchant ID) 27117
Credenciales (API Keys) TODOPAGO f80bd88960a54b2cbc0241c882fdf856
{
URL_Request=https://developers.todopago.com.ar/formulario/commands?command=formulario&m=t8e4f44f3-1377-f663-4946-667f0da4bd57, 
RequestKey=e462d909-39fe-2b5a-c2cc-ca07b12db5f8, 
PublicRequestKey=t8e4f44f3-1377-f663-4946-667f0da4bd57, 
StatusCode=-1, 
StatusMessage=Solicitud de Autorizacion Registrada
}

 
 ### Pruebas
 
 http://localhost:8080/v1/api/payment/MPResponse?collection_id=2754949631&collection_status=approved&preference_id=257953849-0ab3dfea-e1e5-4bd0-9a78-59f4a2593310&external_reference=null&payment_type=credit_card&merchant_order_id=505546410
 
 {
  "callbackUrl": "string",
  "currency": "ARS",
  "description": "pago de prueba",
  "email": "test_user_81310653@testuser.com",
  "mount": 150
}


{
    "status":201,
    "response":{
        "collector_id":257953849,
        "operation_type":"regular_payment",
        "items":[
            {
                "id":"",
                "picture_url":"",
                "title":"pago de prueba",
                "description":"",
                "category_id":"",
                "currency_id":"ARS",
                "quantity":1,
                "unit_price":150
            }
        ],
        "payer":{
            "name":"",
            "surname":"",
            "email":"",
            "date_created":"",
            "phone":{
                "area_code":"",
                "number":""
            },
            "identification":{
                "type":"",
                "number":""
            },
            "address":{
                "street_name":"",
                "street_number":null,
                "zip_code":""
            }
        },
        "back_urls":{
            "success":"http:\/\/localhost:8080\/v1\/api\/payment\/MPResponse",
            "pending":"http:\/\/localhost:8080\/v1\/api\/payment\/MPResponse",
            "failure":"http:\/\/localhost:8080\/v1\/api\/payment\/MPResponse"
        },
        "auto_return":"all",
        "payment_methods":{
            "excluded_payment_methods":[
                {
                    "id":""
                }
            ],
            "excluded_payment_types":[
                {
                    "id":""
                }
            ],
            "installments":null,
            "default_payment_method_id":null,
            "default_installments":null
        },
        "client_id":"963",
        "marketplace":"NONE",
        "marketplace_fee":0,
        "shipments":{
            "receiver_address":{
                "zip_code":"",
                "street_number":null,
                "street_name":"",
                "floor":"",
                "apartment":""
            }
        },
        "notification_url":null,
        "external_reference":"",
        "additional_info":"",
        "expires":false,
        "expiration_date_from":null,
        "expiration_date_to":null,
        "date_created":"2017-05-26T10:35:29.472-04:00",
        "id":"257953849-394a11e5-5ad7-425c-85f6-740bb3209d66",
        "init_point":"https:\/\/www.mercadopago.com\/mla\/checkout\/start?pref_id=257953849-394a11e5-5ad7-425c-85f6-740bb3209d66",
        "sandbox_init_point":"https:\/\/sandbox.mercadopago.com\/mla\/checkout\/pay?pref_id=257953849-394a11e5-5ad7-425c-85f6-740bb3209d66"
    }
}