class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data=data;
        this.next=null;
    }

}

class LinkedList{
    Node head=null;

    void insertfront(int data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
    }

    void insertlast(int data){
        if(head==null){
            insertfront(data);
        }else{
            Node newnode = new Node(data);
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
        }
    }

    void insertatpos(int index,int data){
        Node newnode=new Node(data);
        Node temp=head;
        if(index==0){
            insertfront(data);
            return;
        }
        int count=0;
        while(temp!=null){
            count++;
            if(count==index){
                newnode.next=temp.next;
                temp.next=newnode;
                break;
            }
            temp=temp.next;
        }
    }

    void deleteelement(int data){
        Node temp=head;
        if(temp.data==data){
            head=head.next;
            return;
        }
        while(temp.next!=null){
            if(temp.next.data==data){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }

    }

    void deleteatpos(int index){
        int count=0;
        Node temp=head;
        if(index==0){
            head=head.next;
            return;
        }
        while(temp.next!=null){
            count++;
            if(count==index){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
    }

    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args){
        LinkedList list=new LinkedList();
        list.insertfront(55);
        list.insertfront(35);
        list.insertfront(78);
        list.insertfront(47);
        
        list.insertlast(22);
        
        list.insertatpos(2,8);
        
        list.deleteelement(47);
        
        list.deleteatpos(0);
        
        list.display();
    }
}