package Linked_Lists;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class basic {

    Node head = null;
    Node tail = null;
    int size = 0;

    // Insert at Head
    public void InsertAtHead(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void InsertAtTail(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    
    public void DeleteAtHead(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        
    }
    // Display the list
    public void Display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public boolean hasCycle(){
        Node slow =head;
        Node fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    void InsertAtGivenPosition(int position, int data) {
       if(position <0 ||position > size){
        System.out.println("Invalid Position");
        return;
       }
       if(position ==0){
        InsertAtHead(data);
       }
       if(position == size){
        InsertAtTail(data);
       }
       else{
        Node newNode = new Node(data);
        Node temp =head;
        for(int i =0;i<position-1;i++){
            temp=temp.next;
        } 
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
       }
       
    }
    public void DeleteAtTAil(){
        if(head==null || head.next==null){
            head=tail.next=null;
            return;}

        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        size--;
    }

    public boolean Search(int key){
        Node temp =head;
        while(temp!=null){
            if(temp.data==key) return true;
            temp=temp.next;
        }
        return false;
    }
    public void DeleteAtpos(int pos){
        if(pos<0 || pos >= size){
            System.out.println("Invaid position");
            return;
        }
        if(pos==0){
            DeleteAtHead();
            return;
        }
        Node temp = head;
        for(int i=1;i<pos;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
    public int LengthIterative(){
        int count =0;
        Node temp =head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public int lengthRecursive(Node node){
        if(node==null) return 0;
        return 1+ lengthRecursive(node.next);
    }
    // B. Recursive Method (Very Important)
     
    public Node reverseRecursive(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node newHead = reverseRecursive(node.next);
        node.next.next=node;
        node.next=null;
        return newHead;
    }
    public void reverseIterative(){
        Node prev =null;
        Node curr = head;
        Node next =null;
        while(curr!=null){
            next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public Node findMiddle(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public void DeletByValue(int val){
        if(head==null){
            System.out.println("List is empty");
        }
        if(head.data==val){
            head=head.next;
            size--;
            return;
        }
        Node temp =head;
        while(temp.next!=null){
            if(temp.next.data==val){
                temp.next=temp.next.next;
                size--;
            }
            temp=temp.next;
        }

    }
    
    public void removeDupicates(){
        Node temp =head;
        while(temp!=null && temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next=temp.next.next;
                size--;
            }
            else{
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args) {
        basic list = new basic();
        list.InsertAtHead(10);
        list.InsertAtHead(20);
        list.InsertAtHead(30);
        list.InsertAtHead(30);
        list.Display();   
        list.InsertAtHead(600);
        list.Display();   // Output: 600 30 20 10
        list.InsertAtTail(40);
        list.Display();   // Output: 600 30 20 10 40
        list.DeleteAtHead();
        list.Display();   // Output: 30 20 10 40
        list.InsertAtGivenPosition(2, 99);
        list.Display();   // Output: 30 20 99 10 40
        list.InsertAtGivenPosition(0, 77);
        list.Display();   // Output: 77 30 20 99 10 40
        list.InsertAtGivenPosition(6, 88);
        list.Display();   // Output: 77 30 20 99 10
        list.DeleteAtTAil();
        list.Display();   // Output: 77 30 20 99 10
        list.DeleteAtpos(2);
        list.Display();   // Output: 77 30 99 10
        System.out.println( list.Search(90));
        System.out.println( list.Search(99));
        System.out.println(list.LengthIterative());
        System.out.println(list.lengthRecursive(list.head));
        list.reverseIterative();
        list.Display();
        list.head = list.reverseRecursive(list.head);
        list.Display();
        System.out.println(list.hasCycle());
        list.Display();
        Node ans=list.findMiddle(list.head);
        System.out.println("Middle Node is: "+ ans.data);
        list.DeletByValue(99);
        list.Display();
        list.removeDupicates();
        list.Display();
    }
}
