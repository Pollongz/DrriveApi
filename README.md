# DrriveApi(still in development)

 Backend created with Spring boot and Spring security for Fleet management system used in Web app and Mobile app. 

<h1>Feautures</h1>

- JWT Authentication
- Role based Authorization
- REST API

<h1>Api requests</h1>
<h2>GET</h2>

`/address` - get a list of adresses<br />
`/address/{id}` - get specific address<br />
`/car` - get a list of cars<br />
`/car/{id}` - get specific car<br />
`/car/{id}/damages` - get a list of damages on a specific car<br />
`/car/{id}/refuelings` - get a list of refuelings on a specific car<br />
`/car/{id}/services` - get a list of services on a specific car<br />
`/car/{id}/planned` - get a list of planned services on a specific car<br />
`/car/available` - get a list of available cars<br />
`/car/taken` - get a list of taken cars<br />
`/company` - get a list of companies<br />
`/company/{id}/cars` - get a list of cars from a specific company<br />
`/company/{id}/employees` - get a list of employees from a specific company<br />
`/company/{id}/posts` - get a list of posts from a specific company<br />
`/damage` - get a list of damages<br />
`/damage/{id}` - get a specific damage<br />
`/damage/{id}/photos` - get a list of photos on a specific damage<br />
`/refueling` - get a list of refuelings<br />
`/refueling/{id}` - get a specific refueling<br />
`/services` - get a list of services<br />
`/services/{id}` - get specific service<br />
`/usersData` - get a list of users<br />
`/usersData/{id}` - get a specific user<br />
`/user` - username of currently logged user<br />
`/user/{username}` - get user by username<br />
`/user/{id}/usersdata` - users data of an user<br />
`/user/{username}/usersdata` - users data of an user<br />
`/posts` - get a list of posts<br />
`/posts/{id}` - get a specific post<br />
`/planned` - get a list of planned services<br />
`/reports` - get a list of reports<br />
`/insurance` - get a list of insurances<br />
`/planned/{id}` - get a specific planned service<br />
`/reports/{id}` - get a specific report<br />
`/insurance/{id}` - get a specific report<br />

<h2>POST</h2>

`/address` - add adress<br />
`/car` - add cars<br />
`/company` - add companies<br />
`/damage` - add damages<br />
`/refueling` - add refueling<br />
`/services` - add service<br />
`/photo`- add photos(create damage first)<br />
`/usersData` - add users personal data(create user first)<br />
`/user`- add user<br />
`/posts`- add user<br />
`/planned`- add planned service<br />
`/reports`- add report<br />
`/insurance`- add report<br />

<h2>DELETE</h2>

`/address/{id}` - delete specific address<br />
`/car/{id}` - delete specific car<br />
`/company/{id}` - delete specific company<br />
`/damage/{id}` - delete specific damage<br />
`/photo/{id}` - delete specific photo<br />
`/refueling/{id}` - delete specific refueling<br />
`/services/{id}` - delete specific service<br />
`/usersData/{id}` - delete specific UsersData<br />
`/posts/{id}` - delete specific post<br />
`/planned/{id}` - delete specific planned service<br />
`/reports/{id}` - delete specific report<br />
`/insurance/{id}` - delete specific insurance<br />
