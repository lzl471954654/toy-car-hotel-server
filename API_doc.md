# Hotel Server API 

BaseURL

``
yanglei.duckdns.org:9999
``

- Login and Register
- IncomeExp
- RoomOrder
- Room
- Staff
- ServiceOrder
- Stock


## 注意

- 登陆成功后，返回参数中将出现 token

    后续所有请求中 参数都要带token  进行验证

    除了

    /hotel/login

    /hotel/register

    /hotel/staffLogin

    这三个接口不需要token ， 其他都需要token

    其中 /hotel/staff 开头的 API 需要 staff类型的token ，用户不可以访问，只能员工访问

    /hotel/user 开头的API 需要User类型的token

    /hotel/ 开头的API ，staff ， user 的 token都可以使用 ， 为共有API

    如果访问以上API 不带 token ，将会返回 错误代码 -10 权限拒绝。
    
- 返回代码
  
    -10 代表权限拒绝、token类型不符合、或者没有token
    
    -5 服务器内部异常，通常带有 message参数，里面存有异常信息
    
    -1 请求错误
    
    0  请求失败，例如用户名密码不正确等，或者请求无数据
    
    1  请求成功，可以从 data 字段中取出

## Login and Register API

登陆注册API

- ### login

    用户登录

    url : /hotel/login

    参数 :
    
        userAccount , userPass
    
    示例 :
    
        /hotel/login?userAccount=lzl&userPass=lzl
    
    返回值 :  
    
        {"code":1,"data":{"userAccount":"lzl","userNickname":"mumu","userPass":"","userVip":1},"token":"0ed5ea9bfa21fd636f1200b7d4a078763fcfb57b"}
        
        登陆成功后 会返回用户信息  并且包含一个token

- ### register

    用户注册

    url : /hotel/register

    参数 :
    
        User的所有参数
    
    示例 :
    
        /hotel/register?userAccount=zwq&userPass=zwq&userNickname=dididi
    
    返回值 :  
    
        {"code":1,"data":{"userAccount":"zwqa","userNickname":"dididi","userPass":"","userPhone":"19191","userVip":1},"token":"7b999dfbf79ed8feeddadf5906fac6706cfbbc09"}
        
        注册成功后 会返回用户信息  并且包含一个token

- ### staffLogin

    员工登录

    url : /hotel/staffLogin

    参数 :
    
        staffAccount , staffPass
    
    示例 :
    
        /hotel/staffLogin?staffAccount=lzl&staffPass=123
    
    返回值 :  
    
        {"code":1,"data":{"staffAccount":"lzl","staffName":"mumu","staffPhone":"18189112265","staffPermission":1,"staffDept":"房务部","staffPass":"","staffSalary":5000},"token":"a5fd83d5b4ea4fc4923c358f1c5cf29db7d0b25d"}
        
        登陆成功后 会返回员工信息  并且包含一个token



## IncomeExp API

收入支出查询API

- ### getAllIncome

    查询所有收入

    url : /hotel/staff/getIncome/all

    参数 :
    
        无
    
    示例 :
    
        /hotel/staff/getIncome/all
    
    返回值 :  
    
        {"code":1,"data":[{"orderId":"101","orderType":1,"incomePrice":150,"incomeDate":"2019-03-14"},{"orderId":"102","orderType":1,"incomePrice":130,"incomeDate":"2019-03-14"},{"orderId":"103","orderType":2,"incomePrice":100,"incomeDate":"2019-03-15"},{"orderId":"104","orderType":1,"incomePrice":200,"incomeDate":"2019-03-15"},{"orderId":"105","orderType":2,"incomePrice":150,"incomeDate":"2019-03-16"},{"orderId":"106","orderType":2,"incomePrice":100,"incomeDate":"2019-03-16"},{"orderId":"7c3c41a436e8777389253e3f3da2bae998e1a3e7","orderType":2,"incomePrice":100,"incomeDate":"2019-03-25"}]}

- ### getAllExp

    查询所有支出

    url : /hotel/staff/getExp/all

    参数 :
    
        无
    
    示例 :
    
        /hotel/staff/getExp/all
    
    返回值 :  
    
        {"code":1,"data":[{"expId":"10001","expDate":"2019-03-14","expPrice":1000,"expType":1},{"expId":"10002","expDate":"2019-03-14","expPrice":1500,"expType":1},{"expId":"10003","expDate":"2019-03-14","expPrice":1500,"expType":1},{"expId":"10004","expDate":"2019-03-15","expPrice":2000,"expType":2},{"expId":"10005","expDate":"2019-03-16","expPrice":3000,"expType":2},{"expId":"10006","expDate":"2019-03-17","expPrice":2000,"expType":2},{"expId":"10007","expDate":"2019-03-18","expPrice":1500,"expType":2}]}




## RoomOrder API 

- ### findAll

    查找所有房间订单

    url : /hotel/staff/roomOrder/findAll

    参数 :
    
        无
    
    示例 :
    
        /hotel/staff/roomOrder/findAll
    
    返回值 :  
    
        {"code":1,"data":[{"orderId":"8e5b89f4243b557f61844ec24f43a37e1d91135c","start":"2019-05-05","end":"2019-05-15","userAccount":"lzl","roomId":"1001","orderPrice":500},{"orderId":"d6e88e93c8f8abe5ae09203ea4c87c8037db33c3","start":"2019-02-05","end":"2019-02-15","userAccount":"lzl","roomId":"1002","orderPrice":100}]}
        
        
- ### findById

    查找特定编号的订单

    url : /hotel/roomOrder/findById
    
    参数 :
    
        orderId
    
    示例 :
    
        /hotel/roomOrder/findById?orderId=8e5b89f4243b557f61844ec24f43a37e1d91135c
    
    返回值 :  
    
        {"code":1,"data":{"orderId":"8e5b89f4243b557f61844ec24f43a37e1d91135c","start":"2019-05-05","end":"2019-05-15","userAccount":"lzl","roomId":"1001","orderPrice":500}}
        
        

- ### addOrder

    添加订单

    url : /hotel/roomOrder/add

    参数 :
    
        RoomOrder 中除orderId 之外的所有字段（orderId 由服务端自动生成）
    
    示例 :
    
        /hotel/roomOrder/add?roomId=1001&start=2019-09-09&end=2019-11-11&userAccount=lzl
    
    返回值 :  
    
        {"code":1,"data":{"orderId":"29718932e15d0a56de404a50d00eb6f903a21a97","start":"2019-09-09","end":"2019-11-11","userAccount":"lzl","roomId":"1001"}}
        
        请求成功之后 会将订单编号  orderId  一起返回
        


- ### deleteOrder

    删除订单

    url : /hotel/roomOrder/delete
    
    参数 :
    
        orderId 订单编号
    
    示例 :
    
        /hotel/roomOrder/delete?orderId=29718932e15d0a56de404a50d00eb6f903a21a97
    
    返回值 :  
    
        {"code":1,"data":null}
        


- ### updateOrder

    更新订单

    url : /hotel/roomOrder/update

    参数 :
    
        新生成的RoomOrder的所有参数，orderId 继续沿用旧的订单Id
    
    示例 :
    
        /hotel/roomOrder/update?orderId=d6e88e93c8f8abe5ae09203ea4c87c8037db33c3&start=2019-02-05&end=2019-02-06&userAccount=lzl&roomId=1002&orderPrice=200
        
    返回值 :  
    
        {"code":1,"data":{"orderId":"d6e88e93c8f8abe5ae09203ea4c87c8037db33c3","start":"2019-02-05","end":"2019-02-06","userAccount":"lzl","roomId":"1002","orderPrice":200}}
        
        请求成功后，新的订单的信息会被返回
        


## ServiceOrder API 

- ### addServiceOrder

    添加服务订单

    url : /hotel/serviceOrder/add

    参数 :
    
        ServiceOrder中除了 orderId 以外的所有参数
    
    示例 :
    
        /hotel/serviceOrder/add?userAccount=lzl&roomId=1001&serviceType=1&serviceInfo=维修
        
    返回值 :  
    
        {"code":1,"data":{"serviceId":"7c3c41a436e8777389253e3f3da2bae998e1a3e7","userAccount":"lzl","roomId":"1001","serviceType":1,"serviceInfo":"维修房间","servicePrice":100}}
        
        请求成功后，订单的serviceId 一起会被返回
        

- ### findAll

    查找所有服务订单

    url : /hotel/staff/serviceOrder/findAll
    
    参数 :
    
        无
    
    示例 :
    
        /hotel/staff/serviceOrder/findAll
        
    返回值 :  
    
        {"code":1,"data":[{"serviceId":"7c3c41a436e8777389253e3f3da2bae998e1a3e7","userAccount":"lzl","roomId":"1001","serviceType":1,"serviceInfo":"维修房间","servicePrice":100}]}
        
       
        


- ### findByOrderId

    查找特定的订单

    url : /hotel/staff/serviceOrder/findByOrderId
    
    参数 :
    
        serviceId
    
    示例 :
    
        /hotel/staff/serviceOrder/findByOrderId?serviceId=7c3c41a436e8777389253e3f3da2bae998e1a3e7
        
    返回值 :  
    
        {"code":1,"data":[{"serviceId":"7c3c41a436e8777389253e3f3da2bae998e1a3e7","userAccount":"lzl","roomId":"1001","serviceType":1,"serviceInfo":"维修房间","servicePrice":100}]}
        
        
       
- ### updateOrder

    更新服务订单

    url : /hotel/serviceOrder/update
    
    参数 :
    
        新的ServiceOrder所有参数，serviceId 沿用旧订单的
    
    示例 :
    
        /hotel/serviceOrder/update?serviceId=7c3c41a436e8777389253e3f3da2bae998e1a3e7&userAccount=lzl&serviceType=2&serviceInfo=订餐&servicePrice=100&roomId=1001
        
    返回值 :  
    
        {"code":1,"data":{"serviceId":"7c3c41a436e8777389253e3f3da2bae998e1a3e7","userAccount":"lzl","roomId":"1001","serviceType":2,"serviceInfo":"订餐","servicePrice":100}}
     
     

- ### deleteOrder

    更新服务订单

    url : /hotel/serviceOrder/delete
    
    参数 :
    
        serviceId
    
    示例 :
    
        /hotel/serviceOrder/delete?serviceId=7c3c41a436e8777389253e3f3da2bae998e1a3e7
        
    返回值 :  
    
        {"code":1,"data":null}
     


## Staff API

员工表API



- ### findAll

    查找所有的员工

    url : /hotel/staff/findAll
    
    参数 :
    
        无
    
    示例 :
    
        /hotel/staff/findAll
        
    返回值 :  
    
        {"code":1,"data":[{"staffAccount":"0001","staffName":"zhangsan","staffPhone":"13113150943","staffPermission":1,"staffDept":"房务部","staffPass":"123","staffSalary":5000},{"staffAccount":"0002","staffName":"lisi","staffPhone":"13113150945","staffPermission":2,"staffDept":"房务部","staffPass":"134","staffSalary":2000},{"staffAccount":"0003","staffName":"lihua","staffPhone":"13113150132","staffPermission":2,"staffDept":"房务部","staffPass":"154","staffSalary":2000},{"staffAccount":"0004","staffName":"zhanghua","staffPhone":"13413140341","staffPermission":3,"staffDept":"房务部","staffPass":"132","staffSalary":1500},{"staffAccount":"0005","staffName":"liguang","staffPhone":"13141345613","staffPermission":3,"staffDept":"房务部","staffPass":"154","staffSalary":1500},{"staffAccount":"0006","staffName":"likun","staffPhone":"13114151839","staffPermission":4,"staffDept":"房务部","staffPass":"132","staffSalary":1300},{"staffAccount":"0007","staffName":"zhangmiao","staffPhone":"13113212123","staffPermission":4,"staffDept":"房务部","staffPass":"147","staffSalary":1300},{"staffAccount":"0008","staffName":"fengjie","staffPhone":"12232454621","staffPermission":5,"staffDept":"采购部","staffPass":"187","staffSalary":1500},{"staffAccount":"0009","staffName":"liwei","staffPhone":"13231242423","staffPermission":6,"staffDept":"餐饮部","staffPass":"178","staffSalary":1600}]}
        
     
- ### findByStaffAccount

    查找特定的员工

    url : /hotel/staff/findByStaffAccount
    
    参数 :
    
        staffAccount
    
    示例 :
    
        /hotel/staff/findByStaffAccount?staffAccount=0001
        
    返回值 :  
    
        {"code":1,"data":{"staffAccount":"0001","staffName":"zhangsan","staffPhone":"13113150943","staffPermission":1,"staffDept":"房务部","staffPass":"123","staffSalary":5000}}
     

- ### deleteStaff

    删除特定的员工

    url : /hotel/staff/delete
    
    参数 :
    
        staffAccount
    
    示例 :
    
        /hotel/staff/delete?staffAccount=0001
        
    返回值 :  
    
        {"code":1,"data":null}
     
- ### updateStaff

    删除特定的员工

    url : /hotel/staff/update
    
    参数 :
    
        新Staff全部参数
    
    示例 :
    
        /hotel/staff/update?staffAccount=0001&staffName=zhangsan&staffPhone=13355577889&staffPermission=2&staffDept=服务部&staffPass=aabbcc&staffSalary=6500
        
    返回值 :  
    
        {"code":1,"data":{"staffAccount":"0001","staffName":"zhangsan","staffPhone":"13113150943","staffPermission":1,"staffDept":"房务部","staffPass":"123","staffSalary":5000}}


- ### addStaff

    添加员工

    url : /hotel/staff/update
    
    参数 :
    
        Staff 全部参数
    
    示例 :
    
        /hotel/staff/add?staffAccount=lzl&staffName=mumu&staffPhone=18189112265&staffSalary=5000&staffPermission=1&staffDept=房务部&staffPass=123
        
    返回值 :  
    
        {"code":1,"data":{"staffAccount":"lzl","staffName":"mumu","staffPhone":"18189112265","staffPermission":1,"staffDept":"房务部","staffPass":"123","staffSalary":5000}}
          

        
## Room API

- ### findAll

    url ： /hotel/staff/room/findAll
    
    参数 ：
    
       无
       
    例子 ：
        
        /hotel/staff/room/findAll
    
    返回值 ：
        
        {"code":1,"data":[{"roomId":"1001","roomFloor":2,"roomType":1,"roomPrice":199,"roomStatus":1},{"roomId":"1002","roomFloor":1,"roomType":1,"roomPrice":150,"roomStatus":0},{"roomId":"1003","roomFloor":1,"roomType":1,"roomPrice":120,"roomStatus":0},{"roomId":"1004","roomFloor":1,"roomType":2,"roomPrice":130,"roomStatus":1},{"roomId":"1005","roomFloor":2,"roomType":1,"roomPrice":200,"roomStatus":2},{"roomId":"1006","roomFloor":2,"roomType":2,"roomPrice":150,"roomStatus":1},{"roomId":"1007","roomFloor":2,"roomType":1,"roomPrice":150,"roomStatus":1},{"roomId":"1010","roomFloor":2,"roomType":1,"roomPrice":199,"roomStatus":1}]}
        
    描述 ：
    
    管理员可以查看所有房间信息
    
    
- ### findById
    
    url ： /hotel/room/findById
    
    例子 ：
        
        /hotel/room/findById?roomId=1001
        
    返回值 ：
    
        {"code":1,"data":{"roomId":"1001","roomFloor":2,"roomType":1,"roomPrice":199,"roomStatus":1}}
        
    描述 ：
    根据roomId查找房间
    
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
        
## Comments API

- ### findAll

    url ： /hotel/comments/findAll
    
    参数 ：
    
        无
        
    例子 ：
    
        /hotel/comments/findAll
        
    返回值 ：
    
        {"code":1,"data":[{"orderId":"0dd9cfd07a039486e964b287703af69863592a3e","text":"123"}]}
        
    描述 ：
    返回所有评论
    
- ### add

    url ： /hotel/comments/add
    
    参数 ：
    
        orderId，text
        
    例子 ：
    
        /hotel/comments/add?orderId=4bd51cf6a07f8b3e038eeb40a45e662cd5a9f520&text=1235456
        
    返回值 ：
    
        {"code":1,"data":{"orderId":"4bd51cf6a07f8b3e038eeb40a45e662cd5a9f520","text":"User :lzl&1235456"}}
        
    描述 ：
    根据订单编号填写评论信息
    
- ### delete

    url ： /hotel/staff/comments/delete
    
    参数 ：
        
        orderId
        
    例子 ：
    
    /hotel/staff/comments/delete?orderId=4bd51cf6a07f8b3e038eeb40a45e662cd5a9f520
    
    返回值 ：
    
        {"code":1,"data":null}
        
    描述 ：
    
    根据orderId删除评论