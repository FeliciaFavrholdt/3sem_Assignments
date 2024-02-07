Java Synchronization Interview Questions
========================================

### What is synchronization of threads?
Synchronization of threads is used to control the access of multiple threads to shared resources.

### Can you give an example of a synchronized block?

    private void add(int value) {
    synchronized(this) {
        this.count += value;
    }
    
### Can a static method be synchronized?
Yes a static method can be synchronized. The lock is on the class object.

### What is the use of join method in threads?
A join method is used to wait for a thread to finish. 
It is used to pause the current thread until the specified thread is dead.

### Describe a few other important methods in Threads?
- `sleep()` - Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.
- `yield()` - A hint to the scheduler that the current thread is willing to yield its current use of a processor.

### What is a deadlock?
A deadlock is a situation where two or more threads are blocked forever, each waiting on the other.

### What are the important methods in java for inter-thread communication?
- `wait()` - Causes the current thread to wait until another thread invokes the `notify()` method or the `notifyAll()` method for this object.
- `notify()` - Wakes up a single thread that is waiting on this object's monitor.
- `notifyAll()`- Wakes up all threads that are waiting on this object's monitor.

### What is the use of wait method?
Wait method is defined in the Object class. This causes the thread to wait until it is notified.

    synchronized(thread) {
    thread.start();
    thread.wait();
    }

### What is the use of notify method?
Notify method is defined in the Object class. This causes the object to notify other waiting threads.

    synchronized (this) {
    calculateSumUptoMillion();
    notify();
    }

### What is the use of notifyAll method?
f more than one thread is waiting for an object, we can notify all the threads by using notifyAll method.

    thread.notifyAll();

### Can you write a synchronized program with wait and notify methods?
See solution in 'Ex_5.java' via path: src/main/java/ThreadsExercise/MondayTuesday/Ex_5.java

### What are alternatives to synchronization in java?
There are several alternatives to synchronization in Java, including:

**Thread-Safe Data Structures**: Java provides thread-safe implementations of various data structures in the java.util.concurrent package, such as ConcurrentHashMap, ConcurrentLinkedQueue, and CopyOnWriteArrayList. These data structures internally handle synchronization and provide safe concurrent access without the need for explicit synchronization.


**Atomic Variables**: The java.util.concurrent.atomic package provides classes like AtomicInteger, AtomicLong, and AtomicReference, which allow atomic operations on primitive types and references. These classes use lock-free algorithms and provide a high level of concurrency without the need for explicit synchronization.


**Locks**: Java provides explicit lock objects like ReentrantLock and ReadWriteLock, which offer more fine-grained control over synchronization compared to synchronized blocks/methods. Locks allow for more sophisticated concurrency patterns such as try-locking, interruptible locking, and fairness policies.


**Futures and Executors**: Java's java.util.concurrent package includes facilities for asynchronous computation and task execution. Executors and futures allow you to manage concurrency without explicitly dealing with threads and synchronization primitives.


**Immutable Objects**: Immutable objects are inherently thread-safe since their state cannot be modified after creation. By designing classes to be immutable, you eliminate the need for synchronization when accessing instances of those classes concurrently.


**Message Passing**: Instead of sharing mutable state, you can design your application to use message passing between threads. This approach is used in actor-based concurrency models like Akka, where actors communicate by passing immutable messages.


**Software Transactional Memory (STM)**: STM allows multiple threads to perform transactions on shared data without explicit locking. Java doesn't have built-in support for STM, but libraries like Multiverse provide STM implementations for Java applications.

Choosing the appropriate alternative depends on factors such as performance requirements, complexity, and the nature of the shared resources in your application.
