package gh.funthomas424242.webapp.books.domain;
import gh.funthomas424242.webapp.books.domain.types.ISBN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

//    @Autowired
//    private SystemService systemService;
//
//    @Autowired
//    private ShoppingCartRepository shoppingCartRepository;
//
//    @Autowired
//    private PriceDao priceRepository;
//
//    public void createEmptyShoppingCart() {
//        ISBN isbn = systemService.identifiedISBN();
//
//        ShoppingCart emptyShoppingCart = new ShoppingCart(isbn);
//        shoppingCartRepository.add(emptyShoppingCart);
//    }
//
//    public void legeBuchInsRegal(StockKeepingUnit sku, int quantity) {
//        CustomerIdentifier customerIdentifier = systemService.authenticatedCustomer();
//        Money price = priceRepository.findBySku(sku);
//
//        ShoppingCart shoppingCart = shoppingCartRepository.load(customerIdentifier);
//        shoppingCart.addItem(new ShoppingCartItem(sku, quantity, price));
//    }
//
//    public ShoppingCart getShoppingCart() {
//        CustomerIdentifier customerIdentifier = systemService.authenticatedCustomer();
//        return shoppingCartRepository.load(customerIdentifier);
//    }

}
