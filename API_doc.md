# Hotel Server API 

BaseURL

``
yanglei.duckdns.org:9999
``

- RoomOrder
- Room
- User
- Staff

## RoomOrder API 

- ### findAll

    url : /roomOrder/findAll
    
    param ：
    
        orderId
    
    example ：
    
        /roomOrder/findById?orderId=d6e88e93c8f8abe5ae09203ea4c87c8037db33c3
    
    response :  
    
        {"code":1,"data":{"orderId":"d6e88e93c8f8abe5ae09203ea4c87c8037db33c3","start":"2019-02-05","end":"2019-02-15","userAccount":"lzl","roomId":"1001","orderPrice":100}}