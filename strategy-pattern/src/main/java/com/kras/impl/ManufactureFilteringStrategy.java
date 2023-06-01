package com.kras.impl;


import com.kras.FilteringStrategy;
import com.kras.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ManufactureFilteringStrategy implements FilteringStrategy {
    private String manufacture;

    @Override
    public boolean filter(Product product) {
        return manufacture.equals(product.getManufacture());
    }
}
