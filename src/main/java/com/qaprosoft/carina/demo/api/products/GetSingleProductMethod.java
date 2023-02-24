package com.qaprosoft.carina.demo.api.products;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/products/1", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/restapiexample/_get/snglrs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetSingleProductMethod extends AbstractApiMethodV2 {

    public GetSingleProductMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
