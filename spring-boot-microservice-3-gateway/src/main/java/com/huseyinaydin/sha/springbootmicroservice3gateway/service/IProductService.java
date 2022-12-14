package com.huseyinaydin.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;

import java.util.List;

/**
 * @author Hüseyin Aydın
 * @date 18.04.2021
 * @time 14:08
 */
public interface IProductService
{
    JsonElement saveProduct(JsonElement requestBody);

    void deleteProduct(Long productId);

    List<JsonElement> getAllProducts();
}
