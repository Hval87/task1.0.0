package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected ObjectMapper mapper;
    @BeforeTest
    public void setUp() {
        mapper = new ObjectMapper();

    }
}
