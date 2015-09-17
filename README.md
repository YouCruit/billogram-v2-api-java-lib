Billogram v2 API for Java
=========================

Library for connecting to the Billogram v2 HTTP API.

Limitations
===========

Currently only provides access to Billogram, Customer, Reports and Items, ie. Settings and
Logotype are NOT implemented, but should be trivial if anybody needs it.


Using the API
=============================

The exact dependencies will in the future depend on which http-implementation you want to use,
but for now, okhttp is the only one implented. Implementing a new one is just a matter of implementing the
two methods "sync" and "async" from AbstractHttpClient.


With Gradle:
	compile 'com.youcruit:billogram-v2-api-java-lib:0.0.1' 
	compile 'com.squareup.okhttp:okhttp:2.5.0' 

With Maven:
	<dependency>
		<groupId>com.youcruit</groupId>
		<artifactId>billogram-v2-api-java-lib</artifactId>
		<version>0.0.1</version>
	</dependency>
	<dependency>
		<groupId>com.squareup.okhttp</groupId>
		<artifactId>okhttp</artifactId>
		<version>2.5.0</version>
	</dependency>


Creating a client:

	// The HttpClient is just for Http
	HttpClient httpClient = new OkHttpBillogramClient(username, password);
	// These are for handling customers and billograms
	CustomerClient customerClient = new CustomerClient(httpClient);
	BillogramClient billogramClient = new BillogramClient(httpClient);

Creating a new customer:
	
	Customer customer = new Customer().withName("").withOrgNo("")......
	Customer customerWithAssignedId = customerClient.create(customer);

Searching for a customer:
        Search<CustomerFilterField, CustomerOrderField> search = new Search<>();
        search.withFilter(FilterType.FIELD, CustomerFilterField.CUSTOMER_NO, customer.getCustomerNo().toString());
        search.withOrder(SortDirection.ASCENDING, CustomerOrderField.CREATED_AT);
        final CustomerSearchResponse response = customerClient.search(search);

Building the API
================

./gradlew build

