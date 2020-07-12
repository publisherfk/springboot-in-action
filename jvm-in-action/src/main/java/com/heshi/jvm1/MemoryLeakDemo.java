package com.heshi.jvm1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fukun
 * @Date: 2020/6/10 8:34
 * @since
 */
public class MemoryLeakDemo {

    static class Key {
        Integer id;

        public Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
//            return Objects.hash(id);
            return id.hashCode();
        }
    }

    public static void main(String args[]) {
        Map map = new HashMap();
        while (true) {
            for (int i = 0; i < 10000; i++) {
                if (map.containsKey(new Key(i))) {
                    map.put(new Key(i), "Number:" + i);
                }
            }
        }
    }
}
