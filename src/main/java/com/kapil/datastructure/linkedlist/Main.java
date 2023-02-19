package com.kapil.datastructure.linkedlist;

public class Main {
    public static void main(String[] args) {
        //Singlely LinkedList
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertLast(99);
        list.display();
        list.insertRec(100, 2);
        list.display();

//        System.out.println(list.deleteFirst());
//        list.display();
//
//        System.out.println(list.deleteLast());
//        list.display();
//
//        System.out.println(list.delete(1));
//        list.display();
//
//        System.out.println(list.find(100));

/*        //Doublely LinkedList
        DLL list = new DLL();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
//        list.display();

        list.insertLast(16);
//        list.display();

        list.insert(100, 16);
        list.display();*/

      /*  //Circular LinkedList
        CLL list = new CLL();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        list.display();

        list.delete(5);
        list.display();*/
    }
}
