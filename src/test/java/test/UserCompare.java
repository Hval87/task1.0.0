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
    public void test(){
  //  ObjectMapper mapper = new ObjectMapper();
   mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    List<User> list=new ArrayList<>();
      try {
         list= mapper.readValue(new File("src/test/resources/admin_users.json"),new TypeReference<>(){});
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
    Assert.assertTrue(list.size()>1,"проверка что это массив");
    list.stream().forEach(x->Assert.assertNotNull(x.getName()));
    Assert.assertTrue(list.stream().allMatch(user->user.getClass().isAssignableFrom(User.class)),"проверка являются ли элементы юзерами");
  }
}
