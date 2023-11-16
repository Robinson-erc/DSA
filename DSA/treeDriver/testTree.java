package treeDriver;
import tree.*;
public class testTree {
    public static void main(String args[]){
        BinaryTree<String> family=new EmptyBinarySearchTree<>();
        family = family.add("nancy");
        family = family.add("phil");
        family = family.add("bob");
        family = family.add("pat");
        family = family.add("paul");
        family = family.add("al");
        family = family.add("rob");
        family = family.add("bob");
        family = family.add("sarah");
        family = family.add("aaron");
        family = family.remove("nancy");
        System.out.println(family);
        Test();
    }
    public static void Test(){
        BinaryTree<String> animals = new EmptyBinarySearchTree<String>();
        BinaryTree<String> names;
        BinaryTree<String> people = new EmptyBinarySearchTree<String>();
        animals = animals.add("bat");
        animals = animals.add("rat");
        animals = animals.add("mouse");
        animals = animals.remove("bat");
        System.out.println(animals);
    }
}
