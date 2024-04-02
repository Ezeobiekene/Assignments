public class BlueRayCollection
{

    private Node head;
    public BlueRayCollection() {
        head = null;
    }

    public void add(String title, String director,int yearOfRelease,double cost)
    {
        try {
            BlueRayDisk myBlueRay = new BlueRayDisk(title,director,yearOfRelease,cost);

            if(head == null)
            {
                Node newNode = new Node();
                newNode.disk = myBlueRay;
                newNode.next = null;
                head = newNode;
            }else {

                Node temp = new Node();
                temp.disk = myBlueRay;
                temp.next = null;
                Node current = head;

                while (current.next != null) {
                    current = current.next;
                }
                current.next = temp;
            }

        }catch (NullPointerException npe){
            System.out.println(npe.getMessage());
        }
    }

    public void show_all()
    {
        Node current = head;


        while(current != null)
        {
            System.out.println(current.disk.toString());
            current = current.next;
        }

    }
}
