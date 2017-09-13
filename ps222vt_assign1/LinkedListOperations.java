package ps222vt_assign1;
import java.util.Iterator;
/* Since this is a doubly linked list, any adding or removing of objects will
 * require breaking of two links, next and previous. This class has a constructor
 * which makes two different object at the start. One is head and the other is tail.
 * In this linked list implementation, head and tail objects are never changed and
 * operated with. Also head and tail objects never contain any data. They are just
 * empty objects pointing to the first and last elements respectively. In an empty
 * linked list (queue), there will be two objects head and tail pointing to each other
 * and containing no value.
 */
public class LinkedListOperations implements QueueInterface{
	
	public Object head = new Object (0);
	public Object tail = new Object (0);
	
	LinkedListOperations () {
		head.next = tail;
		head.previous = null;
		tail.next = null;
		tail.previous = head;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		Object o = head;
		int i;
		for (i=0; ;i++){
			o = o.next;
			if (o == tail)break;
		}
		return i;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head.next == tail);
	}

	@Override
	public void enqueue(Object element) {
		// TODO Auto-generated method stub
		element.previous = tail.previous;
		element.next = tail;
		tail.previous = element;
		element.previous.next = element;
		
		
	}

	@Override
	public Object dequeue() throws IndexOutOfBoundsException {
		try {
			// TODO Auto-generated method stub
			if (this.isEmpty())throw new IndexOutOfBoundsException();
			Object o = head.next;
			head.next = o.next;
			o.next.previous = head;
			return o;
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, no more elements to remove. Program will now terminate.");
			System.exit(-1);
		}
		return head;
		
	}

	@Override
	public Object first() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		try {
			if (this.isEmpty())throw new IndexOutOfBoundsException();
			return head.next;
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, the queue is empty. Program will now terminate.");
			System.exit(-1);
		}
		return head;
	}

	@Override
	public Object last() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		try {
			if (this.isEmpty())throw new IndexOutOfBoundsException();
			return tail.previous;
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, the queue is empty. Program will now terminate.");
			System.exit(-1);
		}
		return head;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Object current = head;
		while (current.next != tail){
			current = current.next;
			if (current.a == o.a)
				flag = true;
		}
		return flag;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
		//return null;
	}
	
	class ListIterator implements Iterator<Object>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return(!(head.next == tail));
			//return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			Object o = head.next;
			head.next = o.next;
			o.next.previous = head;
			return o;
		}
		
	}
	
	
	/*
	public static void main (String[] args){
		LinkedListOperations o = new LinkedListOperations();
	}
	*/
}
