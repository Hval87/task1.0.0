package test;

import Pojo.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCompare extends BaseTest {
    @Test
    public void test() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<User> list = new ArrayList<>();
        try {
            list = mapper.readValue(new File(sourceToData), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(list.size() > 1, "is not array");
        list.stream().forEach(x -> Assert.assertNotNull(x.getName(),"array is empty"));
        Assert.assertTrue(list.stream().allMatch(user -> user.getClass().isAssignableFrom(User.class)), "array doesn't consist from users ");
        for (User user : list) {
            if (user.getAddress() != null) {
                Assert.assertNotNull(user.getAddress().getBuilding(), "building is empty in " + user.getName());
                Assert.assertNotNull(user.getAddress().getStreet(), "street is empty in " + user.getName());
                Assert.assertNotNull(user.getAddress().getCity(), "city is empty in " + user.getName());
            }
        }

    }
    @Test
    public static void test2(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<User> list = new ArrayList<>();
        try {
            list = mapper.readValue(new File(sourceToData), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(list.size() > 1, "is not array");
        list.stream().forEach(x -> Assert.assertNotNull(x.getName(),"array is empty"));
        Assert.assertTrue(list.stream().allMatch(user -> user.getClass().isAssignableFrom(User.class)), "array doesn't consist from users ");
        for (User user : list) {
            if (user.getAddress() != null) {
                Assert.assertNotNull(user.getAddress().getBuilding(), "building is empty in " + user.getName());
                Assert.assertNotNull(user.getAddress().getStreet(), "street is empty in " + user.getName());
                Assert.assertNotNull(user.getAddress().getCity(), "city is empty in " + user.getName());
            }
        }

    }
}
