package se.kth.ict.iv1350.vehicleInspection.model;

/**
 * Controls the queue flow. Manages queue numbers. This, incomplete, version has
 * no notion of the highest number that has been handed out. That is currently
 * ignored, but should be fixed in a future version.
 */
public class Queue {
    public static final int MAX_QUEUE_NUM = 999;
    public static final int MIN_QUEUE_NUMBER = 0;
    private static final int INIT_QUEUE_NUMBER = MIN_QUEUE_NUMBER - 1;

    private int currentQueueNumber;

    /**
     * Creates a new instance, who's next number will be zero.
     */
    public Queue() {
        currentQueueNumber = INIT_QUEUE_NUMBER;
    }

    /**
     * @return The queue number that shall be shown next time the display is
     *         updated.
     */
    public int getNextQueueNumberToDisplay() {
        if (currentQueueNumber == MAX_QUEUE_NUM) {
            currentQueueNumber = INIT_QUEUE_NUMBER;
        }
        return ++currentQueueNumber;
    }
}
