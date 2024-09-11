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
    private ArrayList<User> usersJson;
    private ArrayList<User> usersYaml;
    @Test
    public void test() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       usersJson = new ArrayList<>();
        try {
           usersJson = mapper.readValue(new File(sourceToData), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(usersJson.size() > 1, "is not array");
        usersJson.stream().forEach(x -> Assert.assertNotNull(x.getName(),"array is empty"));
        Assert.assertTrue(usersJson.stream().allMatch(user -> user.getClass().isAssignableFrom(User.class)), "array doesn't consist from users ");
        for (User user : usersJson) {
            if (user.getAddress() != null) {
                Assert.assertNotNull(user.getAddress().getBuilding(), "building is empty in " + user.getName());
                Assert.assertNotNull(user.getAddress().getStreet(), "street is empty in " + user.getName());
                Assert.assertNotNull(user.getAddress().getCity(), "city is empty in " + user.getName());
            }
        }

    }
    @Test
    public void test2(){
        yamlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         usersYaml = new ArrayList<>();
        try {
            usersYaml = yamlMapper.readValue(new File(sourceToData2), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(usersYaml.size() > 1, "is not array");
        usersYaml.stream().forEach(x -> Assert.assertNotNull(x.getName(),"array is empty"));
        Assert.assertTrue(usersYaml.stream().allMatch(user -> user.getClass().isAssignableFrom(User.class)), "array doesn't consist from users ");
        for (User user : usersYaml) {
            if (user.getAddress() != null) {
                Assert.assertNotNull(user.getAddress().getBuilding(), "building is empty in " + user.getName());
                Assert.assertNotNull(user.getAddress().getStreet(), "street is empty in " + user.getName());
                Assert.assertNotNull(user.getAddress().getCity(), "city is empty in " + user.getName());
            }
        }

    }
}
