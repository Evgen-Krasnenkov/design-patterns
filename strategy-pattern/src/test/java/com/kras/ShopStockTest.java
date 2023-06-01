package com.kras;

import com.kras.impl.ManufactureFilteringStrategy;
import com.kras.impl.MaxPriceFilteringStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ShopStockTest {
    @Test
    void givenShopStock_whenFilter_thenCorrectStrategyApply() {
        Product product0 = Product.builder()
                .manufacture("lg")
                .price(100)
                .name("lg100")
                .build();
        Product product1 = Product.builder()
                .manufacture("kia")
                .price(200)
                .name("kia200")
                .build();
        Product product2 = Product.builder()
                .manufacture("lg")
                .price(220)
                .name("lg220")
                .build();
        Product product3 = Product.builder()
                .manufacture("kia")
                .price(190)
                .name("kia190")
                .build();
        List<Product> products = List.of(product0, product2, product3, product1);
        ShopStock shopStock = new ShopStock(products);
        FilteringStrategy kiaStrategy = new ManufactureFilteringStrategy("kia");
        FilteringStrategy maxPriceStrategy = new MaxPriceFilteringStrategy(200);
        List<Product>  listAllKia = shopStock.executeFilteringStrategy(kiaStrategy);
        List<Product> listUpTo200Usd = shopStock.executeFilteringStrategy(maxPriceStrategy);

        Assertions.assertEquals(2, listAllKia.size());
        Assertions.assertEquals(3, listUpTo200Usd.size());

    }
}