package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.products.*;
import com.qaprosoft.carina.demo.api.users.DeleteUserMethod;
import com.qaprosoft.carina.demo.api.users.GetSingleUserMethod;
import com.qaprosoft.carina.demo.api.users.GetUsersMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MyAPITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String name = "VladZhu";

    @Test()
    @MethodOwner(owner = name)
    public void mock200Test(){
        MockMethod200 mockMethod = new MockMethod200();
        mockMethod.callAPIExpectSuccess();
        mockMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = name)
    public void mock400Test(){
        MockMethod400 mockMethod = new MockMethod400();
        mockMethod.callAPIExpectSuccess();
        mockMethod.validateResponse();
    }



    @Test()
    @MethodOwner(owner = name)
    public void testCreateProduct() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostProductMethod api = new PostProductMethod();
        api.setProperties("api/users/user.properties");

        api.callAPIExpectSuccess();
        api.validateResponse();
    }


    @Test()
    @MethodOwner(owner = name)
    public void testGetSingleProduct(){
        GetSingleProductMethod getUsersMethods = new GetSingleProductMethod();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        //getUsersMethods.validateResponseAgainstSchema("api/restapiexample/_get/rs.schema");
    }


    @Test()
    @MethodOwner(owner = name)
    public void testGetProducts() {
        GetProductsMethod getUsersMethods = new GetProductsMethod();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/restapiexample/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = name)
    @TestPriority(Priority.P1)
    public void testDeleteProduct() {
        DeleteProductMethod deleteProductMethod = new DeleteProductMethod();
        deleteProductMethod.setProperties("api/users/user.properties");
        deleteProductMethod.callAPIExpectSuccess();
        deleteProductMethod.validateResponse();
    }


    @Test()
    @MethodOwner(owner = name)
    public void testGetUsers(){
        GetUsersMethod postUserMethod = new GetUsersMethod();
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();
        postUserMethod.validateResponseAgainstSchema("api/restapiexample/_get/user/rs.schema");
    }

    @Test()
    @MethodOwner(owner = name)
    public void testGetSingleUser(){
        GetSingleUserMethod postUserMethod = new GetSingleUserMethod();
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = name)
    public void testDeleteUser() {
        DeleteUserMethod deleteProductMethod = new DeleteUserMethod();
        deleteProductMethod.callAPIExpectSuccess();
        deleteProductMethod.validateResponse();
    }

    public static void main(String[] args) {
        LOGGER.info("HELLO WORLD");
    }

}
