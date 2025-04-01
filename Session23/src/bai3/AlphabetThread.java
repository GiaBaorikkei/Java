package bai3;

class AlphabetThread implements Runnable {
    private final SharedResource sharedResource;
    private final String threadName;

    public AlphabetThread(SharedResource sharedResource, String threadName) { // Đổi tên constructor cho đúng
        this.sharedResource = sharedResource;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        sharedResource.printAlphabet(threadName);
    }
}
