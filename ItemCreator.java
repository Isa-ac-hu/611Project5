//File Name: ItemCreator.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description:An interface that specifies that all the more specific factory classes must have a retrieveItem() method for their particular type of item.
public interface ItemCreator {
    public Item retrieveItem();
}
