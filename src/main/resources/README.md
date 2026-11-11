## Phaser 

Phaser is a more flexible and powerful than CountDownLatch and CyclicBarrier.
Phaser lets us define synchronization object that wait until a specific phase 
has completed. 
The primary purpose of Phaser is to coordinate threads that must wait for a 
certain point to be reached before proceeding. 

when phaser is created:
- the first phase will be 0
- the second phase will be phase 1.
- the third phase 2 and so on...

A negative value is returned if the invoking phaser has terminated. 

### int register() : 
to register threads after a phaser has been constructed and it returns the registered phase number. 

### int arrive() : 
to signal that a thread has completed a phase. It returns current
phase number, if the phaser has been terminated, then it returns a negative value.
This method is called by registered party(thread).

### int arriveAndWaitAdvance() : 
It waits until all threads arrived. It returns next phase number or negative value if the phaser has been
terminated. This method should be called by registered party(thread).

### int arriveAndDeregister() :
A thread and arrive and deregister itself by calling this method. It returns the current phase number. 