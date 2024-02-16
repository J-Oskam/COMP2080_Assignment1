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
    public void addLast(int digit){
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
        if(this.isPositive != num2.isPositive){ //
            if(this.isPositive){
                return 1;
            }else{
                return -1;
            }
        }

        if(this.length > num2.length){ //checks if stored number's length is greater than num2
            if(this.isPositive){ //consider if positive or negative. Stored number is positive, so it remains value 1
                return 1;
            }else{ // stored value is negative, so it is smaller than num2 and therefore value -1
                return -1;
            }
        }else if(this.length < num2.length) { //checks if stored number's length is less than num2
            if(num2.isPositive){ //same positive/negative logic case as above
                return 1;
            }else{
                return -1;
            }
        }else{ //if number lengths are the same compare each digit individually until a greater or lesser value is found
            Node value1 = this.head;//starting at each linked lists head for traversal
            Node value2 = num2.head;

            while(value1 != null && value2 != null){
                if(value1.digit > value2.digit){
                    if(this.isPositive){
                        return 1;
                    }else{
                        return -1;
                    }
                }else if(value1.digit < value2.digit){
                    if(num2.isPositive){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                value1=value1.next; //traverse to next elements if head digits are the same until differing values are found if at all
                value2=value2.next;
            }
            return 0;
        }
    }
}