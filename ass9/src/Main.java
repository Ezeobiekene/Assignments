public class Main {


        public static void main (String[] args)
        {
            AVLTree<Integer> tree = new AVLTree<Integer>();

            tree.addElement (50);
            tree.addElement (25);
            tree.addElement (75);
            tree.addElement (12);
            tree.addElement (37);
            tree.addElement (6);
            tree.addElement (18);
            tree.addElement (31);
            tree.addElement (43);
            tree.addElement (56);
            tree.addElement (62);
            tree.addElement (87);

            System.out.println (tree);
            System.out.println ("Size: " + tree.size());
            System.out.println ("Empty: " + tree.isEmpty());
            System.out.println ("Tree Height: " + tree.getHeight());

            System.out.println ("Contains 37: " + tree.contains (37));
            System.out.println ("Contains 87: " + tree.contains (87));

            System.out.println ("Find 25: " + tree.find (25));
            System.out.println ("Find 62: " + tree.find (62));

            System.out.println ("Find Min: " + tree.findMin());
            System.out.println ("Find Max: " + tree.findMax());

            System.out.println (tree.removeElement (25));
            System.out.println (tree.removeElement (6));
            System.out.println (tree.removeElement (87));
            System.out.println (tree.removeElement (62));
            System.out.println (tree.removeElement (12));
            System.out.println (tree.removeElement (50));

            System.out.println (tree);
            System.out.println ("Size: " + tree.size());
            System.out.println ("Empty: " + tree.isEmpty());
            System.out.println ("Tree Height: " + tree.getHeight());

            tree.clear();

            System.out.println (tree);
            System.out.println ("Size: " + tree.size());
            System.out.println ("Empty: " + tree.isEmpty());
            System.out.println ("Tree Height: " + tree.getHeight());



    }
