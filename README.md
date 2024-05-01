## Features implemented 
1) Get ALL end point with pagination and sorting
     example of api call  : GET localhost:8081/employee?size=2&page=0&sort=employeeName
2) Post end point which save a data in database and sends email to 1st level manager
     example  :
    POST  localhost:8081/employee
   
     payload  :    {
        "employeeName": "Nameer kumar",
        "phoneNumber": "1234567890",
        "email": "discoverwithabhi@gmail.com",
        "reportsTo": "66313b594e3f845288bbb5b4",
        "profileImage": "https://images.app.goo.gl/L3sehUbiR9huEQKR6"
    }
   
4) Put end point to update
     payload :
          {
        "id": "66313b594e3f845288bbb5b4",
        "employeeName": "Isra",
        "phoneNumber": "1234567890",
        "email": "israqaiser16@gmail.com",
        "reportsTo": "66313b184e3f845288bbb5b3",
        "profileImage": "https://images.app.goo.gl/L3sehUbiR9huEQKR6"
    },
5) Delete end point to delete any employee  localhost:8081/employee/{employeeid}
  
6) end point to retrive nth level manager of a employee
     localhost:8081/employee/{employeeId}/{n}

## tools used 
Java , SpringBoot  , Mongo Db , Swagger UI , docker 

# setup instruction
## Using docker-compose
1) install docker and have docker-demon running
2) install docker-compose if using any older version of docker desktop
3) run command  :  docker-compose up --build
4) the application is running at port 8081
   
## screen Shots
![Screenshot 2024-05-01 230135](https://github.com/Abhijeet103/employeeApi/assets/93581505/277b193d-27b5-4a87-9d98-bd040c5d08dd)
![Screenshot 2024-05-01 230807](https://github.com/Abhijeet103/employeeApi/assets/93581505/47e30dc3-2fad-4854-9c60-e672c9e7cd69)
![Screenshot 2024-05-01 230830](https://github.com/Abhijeet103/employeeApi/assets/93581505/8244168a-ad9c-4d11-a74a-c1038e022a39)

![Screenshot 2024-05-01 230448](https://github.com/Abhijeet103/employeeApi/assets/93581505/2089f777-6a07-4430-ac1e-9adf1af9204e)
![WhatsApp Image 2024-05-01 at 23 07 10_f74c1ff3](https://github.com/Abhijeet103/employeeApi/assets/93581505/6ca56ecd-6da3-4300-bafb-d8cca07dff70)

