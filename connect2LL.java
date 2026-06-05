class Node{
    Node prev;
    int data;
    Node next;
    Node(int data){
        this.prev=null;
        this.data=data;
        this.next=null;
    }
}

class DoubleLinkedList{

    Node head=null;

    void insertfront1(int data){
        Node newnode=new Node(data);
        if(head==null){
            newnode.next=head;
            head=newnode;
        }else{
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
        }
    }

    void merge(DoubleLinkedList list1,DoubleLinkedList list2){
        Node temp1=list1.head;
        Node temp2=list2.head;
        Node dummy=new Node(0);
        Node temphead=dummy;
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                Node addnode=new Node(temp1.data);
                addnode.prev=temphead;
                temphead.next=addnode;
                temphead=addnode;
                temp1=temp1.next;
            }else{
                Node addnode=new Node(temp2.data);
                addnode.prev=temphead;
                temphead.next=addnode;
                temphead=addnode;
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            Node addnode=new Node(temp1.data);
            addnode.prev=temphead;
            temphead.next=addnode;
            temphead=addnode;
            temp1=temp1.next;
        }
        while(temp2!=null){
            Node addnode=new Node(temp2.data);
            addnode.prev=temphead;
            temphead.next=addnode;
            temphead=addnode;
            temp2=temp2.next;
        }
        head=dummy.next;
        // if(head != null){
        //     head.prev = null;
        // }
    }

    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args){
        DoubleLinkedList list1=new DoubleLinkedList();
        DoubleLinkedList list2=new DoubleLinkedList();
        DoubleLinkedList finallist=new DoubleLinkedList();
        list1.insertfront1(5);
        list1.insertfront1(3);
        list1.insertfront1(1);
        
        list2.insertfront1(6);
        list2.insertfront1(4);
        list2.insertfront1(2);
        
        finallist.merge(list1,list2);

        list1.display();
        list2.display();

        finallist.display();
    }
}