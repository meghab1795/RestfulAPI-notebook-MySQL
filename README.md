# RestfulAPI-notebook-MySQL
please import the application as a "maven project" in Eclipse IDE

please update the "application.properties" file to match the database configurations in your machine.

once the project is up and running in the port 8080, please provide the HTTP requests via postmaster as

Get:
http://localhost:8080/api/notes

Get(by ID):
http://localhost:8080/api/notes/{id}

Post:(create notes)
http://localhost:8080/api/notes
(provide body as raw JSON object)

Put:(update notes)
http://localhost:8080/api/notes/{id}
(provide body as raw JSON object)

Delete:(delete notes)
http://localhost:8080/api/notes/{id}
