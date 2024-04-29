package com.example.inventorymanagementsystem.services;

import com.example.inventorymanagementsystem.exceptions.InvalidDataException;
import com.example.inventorymanagementsystem.exceptions.InventoryNotFoundException;
import com.example.inventorymanagementsystem.exceptions.ItemCapacityExceedException;
import com.example.inventorymanagementsystem.models.Inventory;
import com.example.inventorymanagementsystem.models.Item;
import com.example.inventorymanagementsystem.models.Product;
import com.example.inventorymanagementsystem.repositories.InventoryRepository;
import com.example.inventorymanagementsystem.requests.ProductItemRequest;
import java.util.List;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private InventoryProductService inventoryProductService;
    public Inventory createInventory(Inventory inventory){
        if(inventory == null){
            throw new InvalidDataException("bad data");
        }

        if(!inventory.isValid()){
            throw new InvalidDataException("invalid data");
        }
        int supplierId = userService.getUserById(inventory.getSupplierId()).getUserId();

        if(supplierId == 0){
            throw new InvalidDataException("invalid supplier");
        }

        inventory.setCreatedAt(System.currentTimeMillis());
        inventory.setInventoryId((int)(System.currentTimeMillis()/1000L));
        return inventoryRepository.save(inventory);
    }

    public Inventory getInventoryById(int inventoryId){
        return inventoryRepository.findById(inventoryId).orElseThrow(()-> new InventoryNotFoundException("Not found"));
    }


    //@Transactional

    /**
     * @Transactional giving error on due to no repilca set as mongo transation management only
     * work on repilca set
     * so inconsistense state due to any operation failure in below method must be solve by transaction manager

     * @return
     */
    public void addProductWithItems(@NonNull ProductItemRequest productItemRequest,int inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId).orElseThrow(()-> new InventoryNotFoundException("No inv found"));

        Product product = productItemRequest.getProduct();
        if(product == null ||  product.getProductName().isEmpty() || product.getProductDescription().isEmpty()){
            throw new InvalidDataException("invalid prod details");
        }
        int productId = product.getProductId();
        List<Item> items = productItemRequest.getItems();
        // adding new product
        if(productId == 0){
            product = productService.addNewProduct(product);
        }
        int i = 0;
        for(Item item : items){
            i+=item.getQuantityInGram();
            int itemId = item.getItemId();
            item.setProductId(product.getProductId());

            if(i> Item.MAX_ITEMS_ALLOWED_IN_GRAM){
                throw new ItemCapacityExceedException("item capacity exceeded,you need to reupload all items");
            }

            // new items,
            if(itemId == 0){
                itemService.createNewItem(item);
            }
        }
        inventoryProductService.addProductIntoInventoryIfNotExists(inventory.getInventoryId(),product.getProductId());
    }

   // @Transactional

    /**
     * @Transactional giving error on due to no repilca set as mongo transation management only
     * work on repilca set
     * so inconsistense state due to any operation failure in below method must be solve by transaction manager

     * @return
     */
    public void addItemsQuantityToExistingProduct(int invId, int productId, int itemId,int quantityToBeAdded) {
        Inventory inventory = inventoryRepository.findById(invId).orElseThrow(()-> new InventoryNotFoundException("No inv found"));

        boolean productExists = productService.isProductExists(productId);

        if(!productExists){
            throw new InvalidDataException("no product exists");
        }

        itemService.increaseItems(itemId,productId,quantityToBeAdded);

    }

    //@Transactional

    /**
     * @Transactional giving error on due to no repilca set as mongo transation management only
     * work on repilca set
     * so inconsistense state due to any operation failure in below method must be solve by transaction manager

     * @return
     */
    public void removeItemsQuantityToExistingProduct(int invId, int productId, int itemId,int quantityToBeRemoved) {
        Inventory inventory = inventoryRepository.findById(invId).orElseThrow(()-> new InventoryNotFoundException("No inv found"));

        boolean productExists = productService.isProductExists(productId);

        if(!productExists){
            throw new InvalidDataException("no product exists");
        }

        itemService.decreaseItems(itemId,productId,quantityToBeRemoved);

    }
}
