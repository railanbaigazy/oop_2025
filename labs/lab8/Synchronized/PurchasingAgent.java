package lab8.Synchronized;

public class PurchasingAgent {
    public PurchasingAgent() {
        System.out.println("PurchasingAgent is created");
    }

    public void purchase() {
        Thread thread = Thread.currentThread();
        System.out.println("Thread: " + thread.getName() + ", " + thread.threadId());

        Store store = Store.getInstance();
        synchronized (store) {
            boolean canPurchase = (store.getShirtCount() > 0) && store.authorizeCreditCard("1234", 15.00);

            if (canPurchase) {
                Shirt shirt = store.takeShirt();
                System.out.println("Purchase successful: " + shirt.toString());
            } else {
                System.out.println("Purchase failed");
            }
        }
    }
}
