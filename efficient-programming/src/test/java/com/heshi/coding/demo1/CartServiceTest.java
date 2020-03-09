package com.heshi.coding.demo1;


import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class CartServiceTest {

    List<Sku> list = null;

    @Before
    public void before() {
        list = CartService.getCartSkuList();
    }

    @Test
    public void filterElectronicsSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> result = CartService.filterElectronicsSkus(cartSkuList);
        result.forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void filterElectronicsSkusByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        CartService.filterElectronicsSkusByCategory(cartSkuList)
                .forEach((key, value) -> System.out.println(JSON.toJSONString(value, true)));
    }

    @Test
    public void filterTest() {
        list.stream().filter(sku -> SkuCategoryEnum.ELECTRONICS.equals(sku.getSkyCategory()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void mapTest() {
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(name -> System.out.println(JSON.toJSONString(name, true)));
    }

    @Test
    public void flatMapTest() {
        list.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(name -> System.out.println(JSON.toJSONString(name, true)));
    }

    @Test
    public void peek() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));

    }

    @Test
    public void sortTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    @Test
    public void allMatchTest() {
        boolean match = list.stream().allMatch(sku -> sku.getTotalPrice() > 10);
        System.out.println(match);
    }

    @Test
    public void anyMatchTest() {
        boolean match = list.stream().anyMatch(sku -> sku.getTotalPrice() > 1000);
        System.out.println(match);
    }

    @Test
    public void noneMatchTest() {
        boolean match = list.stream().noneMatch(sku -> sku.getTotalPrice() > 1000);
        System.out.println(match);
    }

    @Test
    public void findFirstTest() {
        System.out.println(JSON.toJSONString(list.stream().findFirst(), true));
    }

    @Test
    public void findAnyTest() {
        System.out.println(JSON.toJSONString(list.stream().findAny(), true));
    }

    @Test
    public void maxTest() {
        OptionalDouble optionalDouble = list.stream().mapToDouble(Sku::getTotalPrice).max();
        System.out.println(JSON.toJSONString(optionalDouble.getAsDouble(), true));
    }
}