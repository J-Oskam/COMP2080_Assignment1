public class HugeInteger {
    boolean isPositive;
    Node head;
    Node tail;
    int length;

    public HugeInteger()
    {
        this.isPositive = true;
        this.head=null;
        this.tail=null;
        this.length = 0;

    }
    public HugeInteger(String number)
    {
        this();
        for(int i = number.length() -1 ; i>= 0; i--)
        {
            char digitChar = number.charAt(i);
            if(Character.isDigit(digitChar))
            {
                int digit = Character.getNumericValue(digitChar);
                addLast(digit);
            }
            else if (digitChar == '-' && i == 0 )
            {
                isPositive = false;
            }
        }
    }
    private void addLast(int digit){
        Node newNode = new Node(digit);
        if(head==null){
            head= newNode;
            tail= newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length ++;
    }

    public String toString(){
        if (length == 0){
            return  "0";
        }
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null){
            result.insert(0,current.digit);
            current = current.next;
        }
        if (!isPositive){
            result.insert(0, '-');
        }
        return result.toString();
    }

    public int compareTo(HugeInteger num2){
        if(){

        }
    }

}
