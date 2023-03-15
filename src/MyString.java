class MyString {
    private char[] arr;
    
    public static void main(String[] args) {
        MyString str = new MyString("this is a test");
        System.out.println("original text:");
        str.print();
        System.out.println("erasing \"is a \"");
        str = str.erase(5,5);
        str.print();
        
        System.out.println("inserting \"big \"");
        str = str.insert(5, "big ");
        str.print();
    }
    
    MyString(String text) {
        arr = text.toCharArray();
    }
    MyString(char[] charArray) {
        arr = charArray;
    }

    MyString change(String text) {
        return new MyString(text);
    }

    void print() {
        
        for(char i: arr) {
            System.out.print(i);
        }
        System.out.print('\n');
    }
    int indexOf(char c) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == c) return i;
        }
        return -1;
    }

    int length() {
        return arr.length;
    }

    MyString erase(int index, int length) {
        if(index > arr.length) return this; // if index more than arr length, cancel
        if(length > arr.length - index) length = arr.length - index; // if length exceeds arr boundry, clip it
        
        int size = arr.length - length;
        char[] newArr = new char[size];
        for(int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        for(int oldIter = index + length, newIter = index; oldIter < arr.length; oldIter++, newIter++) {
            newArr[newIter] = arr[oldIter];
        }
        
        return new MyString(newArr);
    }
    
    MyString insert(int index, String str) {
        if(index > arr.length) index = arr.length;
        int insertionLength = str.length();
        
        char[] strArr = str.toCharArray();
        
        int size = arr.length + insertionLength;
        char[] newArr = new char[size];
        int i = 0;
        for(i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        
        for(i = index; i < index + insertionLength; i++) {
            newArr[i] = strArr[i - index];
        }
        
        int oldIter;
        for(i = index + insertionLength, oldIter = index; oldIter < arr.length; i++, oldIter++) {
            newArr[i] = arr[oldIter];
        }
        
        return new MyString(newArr);
    }
    
    // woah -- length = 4;
    // insert(1, "hhh") -- length = 3;
    // insertLength = 7
}
