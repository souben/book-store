# book-store
this project is baout a library System that contain the following services:

1. Customers service: you can get, add, update and delete customers. Customers have a customernumber, name, phone, email, street, city, zip.

2. BooksQuery service: you can get books. The book(s) that is/are returned by this service has an isbn, title, description, author name and all reviews of this book. Because this service is used a lot, we're using 2 instances of this booksQuery service. The API gateway load balance between these instances.

3. BooksCommand service: you can add, update and delete books. Books have an isbn,
title, description and author name.

4. Review service: you can add reviews for a certain book. Reviews have an isbn, review rating (number between 0 and 5), customer name and a description.

5. Borrowings service: you can get, add, update and delete a borrowing. This borrowing contains all the details of the borrowing including borrowingNumber, date,
customernumber, customerName, isbn and book title.

We're using a MongoDB databases for each service to achieve tight coupling between microservices .

To support the core functionalities of the system we have added :
 - a service registry : to make easy for service discovery, we did replicated the regitry to avoid single point of failure.
 - an API Gateway: to handle cross cutting concerns and to make easy for clients becuase they need to know only about API Gateway.

 - Zipkin : to monitor/ follow business processes.

 - Config server: to separate configuration for code.

