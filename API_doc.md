# Hotel Server API 

BaseURL

``
yanglei.duckdns.org:9999
``

- RoomOrder
- Room
- User
- Staff
- ServiceOrder
- Stock

## RoomOrder API 

- ### findAll

    url : /roomOrder/findAll
    
    param :
    
        orderId
    
    example :
    
        /roomOrder/findById?orderId=d6e88e93c8f8abe5ae09203ea4c87c8037db33c3
    
    response :  
    
        {"code":1,"data":{"orderId":"d6e88e93c8f8abe5ae09203ea4c87c8037db33c3","start":"2019-02-05","end":"2019-02-15","userAccount":"lzl","roomId":"1001","orderPrice":100}}
        
        
        
        
## Room API

- ### findByDate

    url ： /room/findByDate
    
    参数 ：
    
        roomOrder
        
     例子 ：
     
        /room/findByDate?start=2019-05-05&2019-05-15
        
     返回值 ：
     
        {"code":1,"data":[{"roomId":"1002","roomFloor":1,"roomType":1,"roomPrice":150,"roomStatus":0},{"roomId":"1003","roomFloor":1,"roomType":1,"roomPrice":120,"roomStatus":0},{"roomId":"1004","roomFloor":1,"roomType":2,"roomPrice":130,"roomStatus":1},{"roomId":"1005","roomFloor":2,"roomType":1,"roomPrice":200,"roomStatus":2},{"roomId":"1006","roomFloor":2,"roomType":2,"roomPrice":150,"roomStatus":1},{"roomId":"1007","roomFloor":2,"roomType":1,"roomPrice":150,"roomStatus":1}]}
     
     描述 ：
     
     根据输入日期查找时间不冲突的房间，roomOrder中start和end字段不能为空
     
     
- ### updateRoom
    
    url：/room/updateRoom
    
    参数 ：
    
        room
        
     例子 ：
     
        /room/update?roomId=1001&roomFloor=2&roomType=1&roomPrice=199&roomStatus=1
        
     返回值 ：
     
        {"code":1,"data":{"roomId":"1001","roomFloor":2,"roomType":1,"roomPrice":199,"roomStatus":1}}
     
     描述：
     
     传入room对象，根据roomId修改room表中内容，room各项参数不能为空
     

- ### addRoom

    url：/room/add
    
    参数 ：
    
        room
        
    例子 ：
    
        /room/add?roomId=1010&roomFloor=2&roomType=1&roomPrice=199&roomStatus=1
        
    返回值 ：
    
        {"code":1,"data":""}
        
    描述 ：
    
    传入room对象，增加到room表中，room的各项参数不能为空
    
    
- ### deleteRoom

    url：/room/delete
    
    参数 ：
    
        room
        
    例子 ：
    
        /room/delete?roomId=1001
        
    返回值 ：
    
        {"code":1,"data":""}
        
        
    