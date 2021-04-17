# DrriveApi
 RESTful API for a fleet car management system




<h1>GET</h1>

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
`/login-data` - get a list of adresses<br />
`/login-data/{id}` - get a specific login-data of a user<br />
`/refueling` - get a list of refuelings<br />
`/refueling/{id}` - get a specific refueling<br />
`/services` - get a list of services<br />
`/services/{id}` - get specific service<br />
`/user` - get a list of users<br />
`/user/{id}` - get specific User<br />

<h1>POST</h1>

`/address` - add adress<br />
`/car` - add cars<br />
`/company` - add companies<br />
`/damage` - add damages<br />
`/login-data` - create account<br />
`/refueling` - add refueling<br />
`/services` - add service<br />
`/photo`- add photos(created damage first)<br />
`/user` - add users personal data(create login-data first)<br />

<h1>DELETE</h1>

`/address/{id}` - delete specific address<br />
`/car/{id}` - delete specific car<br />
`/company/{id}` - deletet specific company<br />
`/damage/{id}` - delete specific damage<br />
`/photo/{id}` - delete specific photo<br />
`/login-data/{id}` - delete specific login-data of a user<br />
`/refueling/{id}` - delete specific refueling<br />
`/services/{id}` - delete specific service<br />
`/user/{id}` - get specific User<br />
