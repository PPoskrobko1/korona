package io.github.mat3e.pc;

public class ProductService {

   // private ProductRepository productRepository = new DummyProductRepository();
    private ProductRepository productRepository = new DummyProductRepository();


    public boolean isProductAvailable(String productCode, Long number) {
        return productRepository.availableProducts().get(productCode) >= number;
    }
}
