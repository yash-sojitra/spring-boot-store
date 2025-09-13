package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.*;
import com.codewithmosh.store.exceptions.CartNotFoundException;
import com.codewithmosh.store.exceptions.ProductNotFoundException;
import com.codewithmosh.store.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/carts")
@Tag(name = "Carts")
public class CartController {

    private final CartService cartService;

    @PostMapping
    @Operation(summary = "Creates a new cart.")
    public ResponseEntity<CartDto> createCart(
            UriComponentsBuilder uriBuilder
    ) {
        var cartDto = cartService.createCart();
        var uri  = uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId()).toUri();

        return ResponseEntity.created(uri).body(cartDto);
//        return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
    }

    @PostMapping("/{cartId}/items")
    @Operation(summary = "Adds Product to cart.")
     public ResponseEntity<CartItemDto> addToCart(
//             @Parameter(description = "the ID of the cart.")
             @PathVariable UUID cartId,
             @RequestBody AddItemToCartRequest request
     ) {
        var cartItemDto = cartService.addToCart(cartId, request.getProductId());
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto) ;
     }

     @GetMapping("/{cartId}")
     @Operation(summary = "Fetches cart.")
     public ResponseEntity<CartDto> getCart(
             @PathVariable UUID cartId
     ) {
        var cartDto = cartService.getCart(cartId);
        return ResponseEntity.ok(cartDto);
     }

     @PutMapping("/{cartId}/items/{productId}")
     @Operation(summary = "Updates Cart Item.")
     public ResponseEntity<?> updateCartItem(
             @PathVariable("cartId") UUID cartId,
             @PathVariable("productId") Long productId,
             @Valid @RequestBody UpdateCartItemRequest request
     ) {

        var cartItemDto = cartService.updateCartItem(cartId, productId, request.getQuantity());
        return ResponseEntity.ok(cartItemDto);
     }

     @DeleteMapping("/{cartId}/items/{productId}")
     @Operation(summary = "Deletes a cart item.")
     public ResponseEntity<?> deleteCartItem(
             @PathVariable("cartId") UUID cartId,
             @PathVariable("productId") Long productId
     ) {
        cartService.deleteCart(cartId, productId);
        return ResponseEntity.noContent().build();
     }

     @DeleteMapping("/{cartId}/items")
     @Operation(summary = "Clears the cart")
     public ResponseEntity<Void> clearCart(
             @PathVariable("cartId") UUID cartId
     ) {
        cartService.clearCart(cartId);
        return ResponseEntity.noContent().build();
     }


     //Handling Exceptions
     @ExceptionHandler(CartNotFoundException.class)
     public ResponseEntity<ErrorDto> handleCartNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Cart not found"));
     }

     @ExceptionHandler(ProductNotFoundException.class)
     public ResponseEntity<ErrorDto> handleProductNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Product not found in cart."));
     }

}
