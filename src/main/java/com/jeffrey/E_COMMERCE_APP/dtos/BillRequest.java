package com.jeffrey.E_COMMERCE_APP.dtos;

import java.util.List;

public record BillRequest(
    Long customerID,
    List <ProducItemRequest> productItems
) {
}