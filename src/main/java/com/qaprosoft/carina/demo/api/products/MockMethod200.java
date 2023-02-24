package com.qaprosoft.carina.demo.api.products;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/http/200", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/restapiexample/_get/mockrs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class MockMethod200 extends AbstractApiMethodV2 {
    public MockMethod200() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}