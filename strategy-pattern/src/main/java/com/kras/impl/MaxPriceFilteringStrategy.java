package com.kras.impl;


import com.kras.FilteringStrategy;
import com.kras.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MaxPriceFilteringStrategy implements FilteringStrategy {
    private double maxPrice;

    @Override
    public boolean filter(Product product) {
        return maxPrice >= product.getPrice();
    }
}
