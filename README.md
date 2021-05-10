# DrriveApi

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
`/car/available` - get a list of available cars<br />
`/car/taken` - get a list of taken cars<br />
`/company` - get a list of companies<br />
`/company/{id}/cars` - get a list of cars on a specific company<br />
`/company/{id}/employees` - get a list of employees on a specific company<br />
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
`/user/{userId}/usersdata` - users data of an user<br />

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

<h2>DELETE</h2>

`/address/{id}` - delete specific address<br />
`/car/{id}` - delete specific car<br />
`/company/{id}` - delete specific company<br />
`/damage/{id}` - delete specific damage<br />
`/photo/{id}` - delete specific photo<br />
`/refueling/{id}` - delete specific refueling<br />
`/services/{id}` - delete specific service<br />
`/usersData/{id}` - delete specific UsersData<br />
