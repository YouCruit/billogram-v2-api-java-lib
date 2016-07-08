Billogram v2 API for Java [![Build Status](https://travis-ci.org/YouCruit/billogram-v2-api-java-lib.svg?branch=master)](https://travis-ci.org/YouCruit/billogram-v2-api-java-lib)
=========================

Library for connecting to the Billogram v2 HTTP API.

Limitations
===========

Currently only provides access to Billogram, Customer, Reports and Items, ie. Settings and
Logotype are NOT implemented, but should be trivial if anybody needs it.


Using the API
=============================

The exact dependencies depends on which http-implementation you want to use, okhttp is faster/better and has async mode, but adds an extra
dependency compared to HttpURLConnectionBillogramClient.

Implementing another one (such as apache-httpcomponents based) is just a matter of implementing the
two methods "sync" and "async" from AbstractHttpClient.


With Gradle
-----------

        compile 'com.youcruit:billogram-v2-api-java-lib:0.99.3'
        compile 'com.squareup.okhttp:okhttp:2.5.0' // optional

With Maven
----------

        <dependency>
                <groupId>com.youcruit</groupId>
                <artifactId>billogram-v2-api-java-lib</artifactId>
                <version>0.99.3</version>
        </dependency>
        <!-- optional -->
        <dependency>
                <groupId>com.squareup.okhttp</groupId>
                <artifactId>okhttp</artifactId>
                <version>2.5.0</version>
        </dependency>

Creating a client
-----------------

        // The HttpClient is just an implementation agnostic Http client
        HttpClient httpClient;
        httpClient = new OkHttpBillogramClient(username, password); // Needs the dependency above
        httpClient = new HttpURLConnectionBillogramClient(username, password); // only sync (no async) and may be a bit slower
        
        // These are for handling customers and billograms
        CustomerClient customerClient = new CustomerClient(httpClient);
        BillogramClient billogramClient = new BillogramClient(httpClient);

Creating a new customer
-----------------------

        Customer customer = new Customer().withName("").withOrgNo("")......
        Customer customerWithAssignedId = customerClient.create(customer);

Searching for a customer
------------------------

        Search<CustomerFilterField, CustomerOrderField> search = new Search<>();
        search.withFilter(FilterType.FIELD, CustomerFilterField.CUSTOMER_NO, customer.getCustomerNo().toString());
        search.withOrder(SortDirection.ASCENDING, CustomerOrderField.CREATED_AT);
        final CustomerSearchResponse response = customerClient.search(search);

Developing the API
================

Build
-----

    ./gradlew build

Please note that the tests will *NOT* work unless `BILLOGRAM_USERNAME` and `BILLOGRAM_PASSWORD` environment variables (or java properties) are set to valid *sandbox api* credentials.

Release
-------

**Prerequisites:**

* gpg key *that exists on public pgp keyserver*.
* $HOME/.gradle/gradle.properties with environment variables (if they don't exist
  the release process will stop with an error detailing them)

**Actually releasing**

Release with gradle (builds, uploads, closes and relerases archive)

        ./gradlew release
