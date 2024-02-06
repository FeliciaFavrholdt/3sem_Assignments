# Learning objectives

### JSON & DTO
1. Understand what a DTO is and how it is used
2. Understand what JSON is and how it is used
3. Understand how to use Jackson or Gson to convert between JSON and DTOs
4. Understand how to use DTOs to represent complex data structures

### Threads
1. Understand how to use threads to perform multiple tasks concurrently
2. Understand how to use threads in java
3. Understand the Executor framework
4. Know the purpose of Runnable and Callable interfaces plus Future

## Notes 

#### DTO - Data Transfer Object
- It is an object that carries data between processes and is used to transfer data between clients and servers
- The data is transferred between the layers of the application
- DTOs are often used in the context of object-oriented programming
- DTOs are often used with data access objects (DAOs) and remote interfaces

#### JSON - also see Part1.md
- JSON is a lightweight data interchange format
- JSON is language independent
- JSON is "self-describing" and easy to understand
- JSON is built on two structures:
  - A collection of name/value pairs. In various languages, this is realized as an object, record, struct, dictionary, hash table, keyed list, or associative array.
  - An ordered list of values. In most languages, this is realized as an array, vector, list, or sequence.

#### Jackson - JSON Processor
- Jackson is a high-performance JSON processor for Java
- Jackson is a multi-purpose Java library for processing JSON data format. 
- It is used for reading and writing JSON ans also to convert Java objects to JSON and vice-versa.

#### Gson - Google's JSON library
- Gson is an open-source Java library to serialize and deserialize Java objects to (and from) JSON
- It can also be used to convert a JSON string to an equivalent Java object
- Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of
- It is a lightweight library with simple to use APIs and powerful features

#### THREADS
- A thread is a lightweight sub-process, the smallest unit of processing
- Threads are independent, if an exception occurs in one thread, it doesn't affect other threads. It shares a common memory area
- Threads are used to utilize the CPU to the maximum extent
- Threads are used to perform multiple tasks at the same time
- Threads are independent, they can be stopped, started, and interrupted
- Threads are used to develop games, animations, etc.
- Threads are used to develop concurrent applications like a chat application, etc.
- Threads are used to perform time-consuming tasks like database operations, etc.