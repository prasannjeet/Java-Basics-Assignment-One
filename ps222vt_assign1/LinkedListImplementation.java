package ps222vt_assign1;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LinkedListImplementation {
	
	public static void displayQueue(LinkedListOperations q){
		Object o = q.head;
		if (q.isEmpty()){
			System.out.println("Queue is Empty!");
			return;
		}
		System.out.print("[");
		while (o.next!=q.tail){
			System.out.print(o.next.a);
			o = o.next;
			if (o.next!=q.tail)System.out.print(",");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		LinkedListOperations Q = new LinkedListOperations();
		System.out.println("A queue has been initialized which has been implemented via linked list.");
		int choice;
		try {
			while (true) {
				System.out.print("====================================================================\n"
						+ "Following are the operations that you can do: \n"
						+ "1. Find the size of queue.\n"
						+ "2. Is the queue empty?\n"
						+ "3. Enqueue the queue with an element\n"
						+ "4. Dequeue the queue with an element\n"
						+ "5. Find out the first element\n"
						+ "6. Find out the last element\n"
						+ "7. Check whether a particular integer is present in the queue\n"
						+ "8. Display the contents of the queue\n"
						+ "9. Exit\n"
						+ "Enter your choice: ");
				choice = scan.nextInt();
				switch (choice){
				case 1: System.out.println("Current size of the queue is: "+Q.size());
						break;
				case 2:	if(Q.isEmpty())System.out.println("The queue is empty!");
						else System.out.println("No, the queue is not empty!");
						break;
				case 3: System.out.print("Enter an integer you want to enqueue");
						Object o = new Object(scan.nextInt());
						Q.enqueue(o);
						break;
				case 4:	if(Q.isEmpty())System.out.println("Sorry, the queue is empty!");
						//Exception has also been handled in the QueueInterface.java file
						else {
							System.out.println("Successfully dequeued. The removed element is: "+Q.dequeue().a);
						}
						break;
				case 5: if(Q.isEmpty())System.out.println("Sorry, the queue is empty!");
						else {
							System.out.println("The first element is: "+Q.first().a);
						}
						break;
				case 6:	if(Q.isEmpty())System.out.println("Sorry, the queue is empty!");
						else {
							System.out.println("The last element is: "+Q.last().a);
						}
						break;
				case 7: System.out.print("Enter the number you want to check: ");
						int checkInt = scan.nextInt();
						if (Q.contains(new Object (checkInt)))System.out.println("Object Found!");
						else System.out.println("Object not found!");
						break;
				case 8:	System.out.println("Current structure of the queue is:\n");
						displayQueue(Q);
						break;
				case 9: System.out.println("Thank you for using the program. It will now terminate.");
						System.exit(-1);
						break;
				default:	System.out.println("Wrong choice selected. Try again...");
				 			break;
				}
			}
		}
		catch (InputMismatchException e){
			System.out.println("Error. Enter only integer values. Program will now terminate: "+e);
			System.exit(-1);
		}
		finally {
			scan.close();
		}
	}
}
