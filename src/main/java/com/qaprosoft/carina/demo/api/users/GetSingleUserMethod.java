package com.qaprosoft.carina.demo.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/users/1", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/restapiexample/_get/user/snglrs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetSingleUserMethod extends AbstractApiMethodV2 {

    public GetSingleUserMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}