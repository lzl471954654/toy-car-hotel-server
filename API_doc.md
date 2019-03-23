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

    url ： /hotel/room/findByDate
    
    参数 ：
    
        roomOrder
        
     例子 ：
     
        hotel/staff/room/findByDate?start=2019-05-05&2019-05-15
        
     返回值 ：
     
        {"code":1,"data":[{"roomId":"1002","roomFloor":1,"roomType":1,"roomPrice":150,"roomStatus":0},{"roomId":"1003","roomFloor":1,"roomType":1,"roomPrice":120,"roomStatus":0},{"roomId":"1004","roomFloor":1,"roomType":2,"roomPrice":130,"roomStatus":1},{"roomId":"1005","roomFloor":2,"roomType":1,"roomPrice":200,"roomStatus":2},{"roomId":"1006","roomFloor":2,"roomType":2,"roomPrice":150,"roomStatus":1},{"roomId":"1007","roomFloor":2,"roomType":1,"roomPrice":150,"roomStatus":1}]}
     
     描述 ：
     
     根据输入日期查找时间不冲突的房间，roomOrder中start和end字段不能为空
     
     
- ### updateRoom
    
    url：/hotel/staff/room/updateRoom
    
    参数 ：
    
        room
        
     例子 ：
     
        hotel/staff/room/update?roomId=1001&roomFloor=2&roomType=1&roomPrice=199&roomStatus=1
        
     返回值 ：
     
        {"code":1,"data":{"roomId":"1001","roomFloor":2,"roomType":1,"roomPrice":199,"roomStatus":1}}
     
     描述：
     
     传入room对象，根据roomId修改room表中内容，room各项参数不能为空
     

- ### addRoom

    url：/hotel/staff/room/add
    
    参数 ：
    
        room
        
    例子 ：
    
        hotel/staff/room/add?roomId=1010&roomFloor=2&roomType=1&roomPrice=199&roomStatus=1
        
    返回值 ：
    
        {"code":1,"data":""}
        
    描述 ：
    
    传入room对象，增加到room表中，room的各项参数不能为空
    
    
- ### deleteRoom

    url：/hotel/staff/room/delete
    
    参数 ：
    
        room
        
    例子 ：
    
        hotel/staff/room/delete?roomId=1001
        
    返回值 ：
    
        {"code":1,"data":""}
        
     描述 ：
     
     传入roomId 根据roomId查找对应房间并删除，当房间有订单时不能删除
     
     
## Stock API

- ### addStockTpe

    url ：/hotel/staff/stock/add
    
    参数 ：
        
        stock
        
    例子 ：
    
        hotel/staff/stock/add?stockName=测试
        
    返回值 ：
    
        {"code":1,"data":{"stockName":"测试","stockCount":0}}
        
    描述 ：
    
    根据输入stockName 增加stock表中的内容 ，stockCount默认为0
    
    
    
- ### inOrOutStock

    url ： /hotel/staff/stock/inOrOutStock
    
    参数：
        
        stockInOutInfo
        
    例子 ：
    
        hotel/staff/stock/inOrOutStock?stockName=测试&stockType=1&stockCount=100
        
    返回值 ：
    
        {"code":1,"data":{"stockCount":100,"stockType":1,"stockDate":"2019-03-23","stockId":"e52629a2052156d7938d370e2ad81c74b981103f","stockName":"测试"}}
        
    描述 ：
    
    根据输入stockName，stockType，stockCount进行出入库操作，stockId，stockDate为自动生成，当库存表中无相应stockName时，自动添加，当库存不足时出库失败
    
    
- ### findAll

    url ：/hotel/staff/stock/findAll
    
    参数 ：
        
        无
        
    例子 ：
    
        /hotel/staff/stock/findAll 
        
    返回值 ：
    
        {"code":-1,"data":[{"stockCount":100,"stockType":1,"stockDate":"2019-03-12","stockId":"001","stockName":"中性笔"},{"stockCount":50,"stockType":2,"stockDate":"2019-03-13","stockId":"002","stockName":"床单"},{"stockCount":130,"stockType":1,"stockDate":"2019-03-14","stockId":"003","stockName":"毛巾"},{"stockCount":100,"stockType":1,"stockDate":"2019-03-15","stockId":"004","stockName":"牙刷"},{"stockCount":200,"stockType":1,"stockDate":"2019-03-16","stockId":"005","stockName":"矿泉水"},{"stockCount":170,"stockType":2,"stockDate":"2019-03-17","stockId":"006","stockName":"被套"},{"stockCount":160,"stockType":1,"stockDate":"2019-03-18","stockId":"007","stockName":"香皂"},{"stockCount":100,"stockType":2,"stockDate":"2019-03-22","stockId":"2970a0ce66ddc322a57c8d3a08420dd5e6da32bd","stockName":"避孕套"},{"stockCount":100,"stockType":1,"stockDate":"2019-03-22","stockId":"3b6b3b70aedeedef50b38a31e0058132b2c83326","stockName":"避孕套"},{"stockCount":200,"stockType":2,"stockDate":"2019-03-22","stockId":"3e5abe64b7724c5aeb7e1387d2b51e0e7775d5c6","stockName":"避孕套"},{"stockCount":100,"stockType":2,"stockDate":"2019-03-22","stockId":"94207f384165818d9ad4311cb808dcdb1426f443","stockName":"避孕套"},{"stockCount":100,"stockType":1,"stockDate":"2019-03-23","stockId":"d6467fb956f4ab08f2e82a2f9fff914246cf07c4","stockName":"测试"},{"stockCount":100,"stockType":1,"stockDate":"2019-03-23","stockId":"e52629a2052156d7938d370e2ad81c74b981103f","stockName":"测试"}]}
        
    描述 ：
    
        返回所有出入库记录
        