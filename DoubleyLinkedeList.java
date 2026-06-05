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

class DoubleyLinkedList{
    Node head=null;

    void insertfront(int data){
        Node newnode=new Node(data);
        if (head!=null) {
            head.prev=newnode;
        }
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
            newnode.prev=temp;
        }
    }

    void insertatpos(int index,int data){
        Node newnode=new Node(data);
        if(index==0){
            insertfront(data);
            return;
        }
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            if(count==index){
                if(temp.next!=null){
                    newnode.next=temp.next;
                    temp.next.prev=newnode;
                    temp.next=newnode;
                    newnode.prev=temp;
                    break;
                }else{
                    temp.next=newnode;
                    newnode.prev=temp;
                    break;
                }
            }
            temp=temp.next;
        }
    }

    void deleteelement(int data){
        Node temp=head;
        if(temp.data==data){
            head=head.next;
            head.prev=null;
            return;
        }
        while(temp.next!=null){
            if(temp.next.data==data){
                if(temp.next.next!=null){
                    temp.next=temp.next.next;
                    temp.next.prev=temp;
                    break;
                }else{
                    temp.next=null;
                    break;
                }
            }
            temp=temp.next;
        }

    }

    void deleteatpos(int index){
        int count=0;
        if(index==0){
                head=head.next;
                head.prev=null;
                return;
            }
        Node temp=head;
        while(temp.next!=null){
            count++;
            if(count==index){
                if(temp.next.next!=null){
                    temp.next=temp.next.next;
                    temp.next.prev=temp;
                    break;
                }else{
                    temp.next=null;
                    break;
                }
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
        DoubleyLinkedList list=new DoubleyLinkedList();
        list.insertfront(55);
        list.insertfront(35);
        list.insertfront(78);
        list.insertfront(47);
        
        list.insertlast(22);
        list.insertlast(33);
        
        list.insertatpos(6,8);
        
        list.deleteelement(8);
        
        list.deleteatpos(5);
        
        list.display();
    }
}