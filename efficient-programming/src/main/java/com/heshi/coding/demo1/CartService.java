package com.heshi.coding.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartService {
    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(654032, "无人机", 4999.00, 1, 4999.00, SkuCategoryEnum
                    .ELECTRONICS));
            add(new Sku(6323032, "纯色衬衫", 409.00, 3, 409.00, SkuCategoryEnum
                    .SPRORTS));
            add(new Sku(623032, "VR一体机", 2299.00, 1, 2299.00, SkuCategoryEnum
                    .ELECTRONICS));
        }
    };

    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    public static List<Sku> filterElectronicsSkus(List<Sku> cartSkuList) {
        return cartSkuList.stream().filter(sku -> SkuCategoryEnum.ELECTRONICS.equals(sku.getSkyCategory())).collect(Collectors.toList());
    }

    public static Map<Enum<SkuCategoryEnum>, List<Sku>> filterElectronicsSkusByCategory(List<Sku> cartSkuList) {
        return cartSkuList.stream().collect(Collectors.groupingBy( Sku::getSkyCategory));
    }
}
