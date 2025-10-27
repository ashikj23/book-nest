📖 BookNest Microservice

Base URL (direct) → http://localhost:8081/books
Base URL (via API Gateway) → http://localhost:8080/books

Endpoints
Method	Endpoint	Description	Example Output
GET	/books	Get all books	[{"id":1,"title":"Java 101","author":"John","genre":"Tech"}]
GET	/books/test	Health check endpoint	"BookController is working!"
GET	/books/{id}	Get book by ID	{"id":1,"title":"Java 101","author":"John","genre":"Tech"}
GET	/books/library/{libraryId}	Get all books belonging to a specific library	[{"id":3,"title":"Spring Boot","libraryId":1}]
GET	/books/genre/{genre}	Get books by genre	[{"id":4,"title":"Python","genre":"Programming"}]
GET	/books/author/{author}	Get books by author	[{"id":2,"title":"Microservices","author":"Smith"}]
GET	/books/title/{title}	Get books by title	[{"id":5,"title":"Spring Boot","author":"Ashik"}]
POST	/books	Add new book	Input → {"title":"React","author":"Dan","genre":"Frontend"}
PUT	/books/{id}	Update existing book	Output → Updated book details
DELETE	/books/{id}	Delete book	204 No Content
🏛 Library Microservice

Base URL (direct) → http://localhost:8082/library
Base URL (via API Gateway) → http://localhost:8080/library

Endpoints
Method	Endpoint	Description	Example Output
GET	/library/getAll	Get all libraries	[{"id":1,"name":"Central Library"}]
GET	/library/{id}	Get library by ID	{"id":1,"name":"Central Library"}
POST	/library/add	Add new library	Input → {"name":"City Library"}
PUT	/library/update/{id}	Update library	Output → "Library updated successfully"
DELETE	/library/delete/{id}	Delete library	Output → "Library deleted successfully"
GET	/library/books/{libraryId}	Get books from this library (via Library DB)	[{"id":3,"title":"Spring Boot"}]
GET	/library/all-books-from-booknest	Get all books from BookNest using RestTemplate	[{"id":1,"title":"Java 101"}, {"id":2,"title":"Spring Boot"}]


library/library
