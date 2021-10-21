import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * A container class that allows you to store an arbitrary number of objects
 * @author Mokhammad Nadzhim
 * @version 1.0
 *
 *
 */
class List
{
    /** The pointer to the beginning of the list field*/
    List head;
    /** The pointer to the end of the list field*/
    List last;
    /** The field is a pointer to the next item in the list*/
    List next;
    /** Element Value field*/
    int value;
    /** A field that stores the dimension of the list*/
    int Size=0;
    /**
     * Method that removes an item from the list
     * @param data element value
     */
    void delete_element_position(int data)
    {
        List q=this.head;
        if (q==null) return;

        if ((head == last)&&(head.value==data)) {
            head=null;
            last=null;
            Size--;
            return;


        }

        if (q.value==data)
        {
            head=head.next;
            Size--;
            return;
        }
        while (q.next != null) {
            if (q.next.value == data) {

                q.next = q.next.next;
                Size--;
                return;
            }
            q = q.next;
        }
        System.out.println("Такого числа нету");
    }
    /**
     * Method that adds an item to the end of the list
     * @param data the value of the element being added
     */
    void add_in_back(int data)
    {
        List a = new List();
        a.value = data;
        if (last == null)
        {
            head = a;
            last = a;
            Size++;
        } else {
            last.next = a;
            last = a;
            Size++;
        }
    }
    /**
     * The method that displays the list on the screen
     */
    void printList() {
        List q = this.head;
        if (q == null) {
            System.out.println("Список пуст, добавьте в него элементы.");
            return;
        }

        while (q != null) {
            System.out.print(q.value);
            System.out.print(" ");
            q = q.next;
        }
    }
    /**
     * Method of inserting an element in an arbitrary place
     * @param num position of the new item in the list
     * @param value the value of the new element
     */
    public void add(int num, int value)
    {
        List t = this.head;
        int i=0;
        if(num>0 && num<get_Size()) {
            while (t != null) {
                if (i + 1 == num) {
                    List e = new List();
                    e.value = value;
                    e.next = t.next;
                    t.next = e;
                    //t = e;
                    Size++;
                    return;
                }
                t = t.next;
                i++;
            }
        }
        else
        if (num==get_Size())
        {
            add_in_back(value);

            return;
        }
        else
        if (num==0)
        {
            add_in_front(value);
            return;
        }
        else return;

    }
    /**
     * A method that returns the value of an element
     * @param pos index of the returned element
     * @return the value of an int type element
     */
    public int get_element(int pos)
    {
        List q=this.head;
        if (pos<0||pos>get_Size())
            return 0;
        else {
            for (int i = 0; i < get_Size(); i++) {
                if (i == pos) return q.value;
                q = q.next;
            }
        }
        return 0;
    }
    /**
     * Method that gets the dimension of the list
     * @return dimension of an int type list
     * */
    public int get_Size()
    {
        return Size;

    }

    /**
     * Method that adds an item to the top of the list
     * @param value the value of the element being added
     */
    void add_in_front(int value)
    {
        List a = new List();
        a.value = value;

        if(head == null)
        {
            head = a;
            last = a;
            Size++;
        }
        else {
            a.next = head;
            head = a;
            Size++;
        }
    }

    /**
     * Redefined toString method
     * @return list items
     */
    @Override
    public String toString(){
        String result=new String(" ");
        if(get_Size()==0)
        {
            return result;
        }
        for(int i=0;i<get_Size();i++)
        {
            String t=Integer.toString(get_element(i));
            result+=t.toString()+ " ";
        }
        result=result.substring(0,result.length()-1);
        return result;
    }
}

/**
 * The main part of the program
 */
class Main {
    public static void main(String[] args) {
        List l = new List();
        System.out.println("Введите количество элементов");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i=0;i<n;i++)
        {
            System.out.println((i+1)+")");
            int val=in.nextInt();
            l.add_in_back(val);
        }
        System.out.println(l.toString());
        int option;
        int quit=1;
        int y;
        while(quit!=0)
        {
            System.out.println("1.Добавление");
            System.out.println("2.Удаление");
            System.out.println("3.Вывод");
            System.out.println("4.Размерность");

            System.out.println("0.Выход");
            option=in.nextInt();
            if (option==1)
            {
                System.out.println("Значение добавляемого элемента");
                int data=in.nextInt();
                System.out.println("1.Добавить в начало");
                System.out.println("2.Добавить в конец");
                System.out.println("3.Добавить в произвольное место");

                y=in.nextInt();
                if(y==1) l.add_in_front(data);
                else if(y==2) l.add_in_back(data);
                else if(y==3)
                {
                    System.out.println("На какую позицию вы хотите поставить новый элемент?");
                    int pos=in.nextInt();
                    l.add(pos,data);
                }
            }
            else if (option==2)
            {
                System.out.println("Значение удаляемого элемента");
                int data=in.nextInt();
                l.delete_element_position(data);
            }
            else if (option==3)
            {
                System.out.println(l.toString());
            }
            else if (option==4)
            {
                System.out.println(l.get_Size());
            }


            else if (option==0) quit=0;
            else quit =0;
        }
    }
}
