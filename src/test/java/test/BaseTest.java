package test;

import Pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.annotations.BeforeTest;
import utils.MyJsonParser;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected ObjectMapper mapper;
    protected ObjectMapper yamlMapper;
    protected String sourceToData;
    protected String sourceToData2;

    @BeforeTest
    public void setUp() {
        mapper = new ObjectMapper();
        yamlMapper=new ObjectMapper(new YAMLFactory());
        sourceToData= MyJsonParser.getSourceFromTestData("src/test/resources/testData.json");
        sourceToData2= MyJsonParser.getSourceFromTestData("src/test/resources/testData.yaml");
        System.out.println(sourceToData);
        System.out.println(sourceToData2);


    }
}
