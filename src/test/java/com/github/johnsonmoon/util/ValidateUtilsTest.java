package com.github.johnsonmoon.util;

import com.github.johnsonmoon.entity.TestModel;
import com.github.johnsonmoon.entity.ValidateResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Create by xuyh at 2019/9/23 10:25.
 */
public class ValidateUtilsTest {
    @Test
    public void test() {
        List<TestModel> testModels = new ArrayList<>();
        int type = 0;
        for (int i = 0; i < 100; i++) {
            TestModel model = new TestModel();
            switch (type) {
                case 0:
                    model.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    model.setName("name_" + i);
                    model.setDescription("desc_" + i);
                    model.setColor("RED");
                    break;
                case 1:
                    model.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    model.setName("");
                    model.setDescription("desc_" + i);
                    model.setColor("RED");
                    break;
                case 2:
                    model.setId(null);
                    model.setName("name_" + i);
                    model.setDescription("");
                    model.setColor("ABCDEFGHIJKLMN");
                    break;
                default:
                    model.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    model.setName("name_" + i);
                    model.setDescription("desc_" + i);
                    break;
            }
            testModels.add(model);
            type++;
            if (type == 3) {
                type = 0;
            }
        }

        List<ValidateResult<TestModel>> results = new ArrayList<>();
        testModels.forEach(testModel -> results.add(ValidateUtils.validate(testModel)));


        results.forEach(System.out::println);
    }
}
