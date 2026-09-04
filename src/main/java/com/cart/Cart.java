package com.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItems> items;

    public Cart() {
        items = new HashMap<>();
    }

    public Map<Integer, CartItems> getItems() {
        return items;
    }
    public void addItem(CartItems cartitem) {

        int menuid = cartitem.getMenuid();

        if (items.containsKey(menuid)) {

            CartItems existing = items.get(menuid);
            existing.setQuanity(existing.getQuanity() + cartitem.getQuanity());

        } else {

            items.put(menuid, cartitem);

        }
    }

	public void updateItem(int itemId , int quantity) {
		
		if(items.containsKey(itemId)) {
			if(quantity > 0) {
				
				CartItems existingItem = items.get(itemId);
				existingItem.setQuanity(quantity);
				
			}
			else {
				items.remove(itemId);
			}
		}
		
		
	}

	public void removeItem(int itemId ) {		// TODO Auto-generated method stub
		
		items.remove(itemId);
	}
    
    
    
    
    
}