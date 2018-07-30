package ordersample.ordertest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
         POS pos=POS.getInstance();
         POS pos2=POS.getInstance();
        Order order=pos.createOrder();
        
        order.addProductByCode("ORANGE");
        order.addProductByCode("ORANGE");
        order.addProductByCode("ORANGE");
        order.addProductByCode("ORANGE");//4  --3
        order.addProductByCode("APPLE");
        order.addProductByCode("APPLE");
        order.addProductByCode("APPLE");
        order.addProductByCode("APPLE");
        order.addProductByCode("APPLE");
        order.addProductByCode("APPLE");
        order.addProductByCode("APPLE");   //7     --3     
        order.addProductByCode("RICE");
        order.addProductByCode("RICE"); 
        order.addProductByCode("RICE"); 
        order.addProductByCode("RICE"); 
        order.addProductByCode("RICE"); 
        order.addProductByCode("RICE"); 
        order.addProductByCode("RICE"); //7  --11
        
       /* order.addProductByCode("ORANGE");
        order.addProductByCode("ORANGE");
        order.addProductByCode("ORANGE");
        order.addProductByCode("ORANGE");*/
        System.out.println("$"+order.placeOrder());
        order.addProductByCode("ORANGE");
        
        try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream("test");
            ObjectInputStream in = new ObjectInputStream(file);
             
            // Method for deserialization of object
            List< Product>  object1 = (List<Product>)in.readObject();
             
            in.close();
            file.close();
             
            System.out.println("Object has been deserialized ");
            object1.forEach(i->System.out.println(i));
            
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
         
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        
        Order order1=pos2.createOrder();
        
        order1.addProductByCode("ORANGE");
        order1.addProductByCode("ORANGE");
        order1.addProductByCode("ORANGE"); //3
        order1.addProductByCode("APPLE");
        order1.addProductByCode("APPLE"); 
        order1.addProductByCode("APPLE");  //3      
        order1.addProductByCode("RICE");
        order1.addProductByCode("MANGO");
        order1.addProductByCode("RICE");	//2
        
        System.out.println("$"+order1.placeOrder());
        

    }
}
