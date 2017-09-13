package ps222vt_assign1;
/* This is the object which will make a queue. Since we are implementing a
 * doubly pointed linked list, we have two pointers, next and previous. Next
 * pointing to the next object to be inserted, and previous pointing to the
 * object which was inserted previous to the current object.
 */
public class Object {
	public int a;
	public Object next;
	public Object previous;
	public Object (int x){
		this.a = x;
	}
}
