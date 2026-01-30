// PROBLEM : Implement k Queues in a Single Array

// SOLUTION :

class kQueues {
private:
    int n, k;
    int *arr;
    int *front;
    int *rear;
    int *next;
    int freeSpot;

public:
    kQueues(int n, int k) {
        this->n = n;
        this->k = k;

        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        // Initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }

        // Initialize free list
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        freeSpot = 0;
    }

    void enqueue(int x, int i) {
        // Check if array is full
        if (freeSpot == -1) return;

        int index = freeSpot;
        freeSpot = next[index];

        // First element in queue i
        if (front[i] == -1) {
            front[i] = index;
        } else {
            next[rear[i]] = index;
        }

        next[index] = -1;
        rear[i] = index;
        arr[index] = x;
    }

    int dequeue(int i) {
        // Check if queue is empty
        if (front[i] == -1) return -1;

        int index = front[i];
        front[i] = next[index];

        // Add index back to free list
        next[index] = freeSpot;
        freeSpot = index;

        return arr[index];
    }

    bool isEmpty(int i) {
        return front[i] == -1;
    }

    bool isFull() {
        return freeSpot == -1;
    }
};
