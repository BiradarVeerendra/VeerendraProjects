package com.veerendra.biradar.api_req_res.response;

import com.veerendra.biradar.constants.VeerAppConstants;
import com.veerendra.biradar.exception.VeerAppException;

public class VeerAppResponseBody {

    public static ResponseDTO successResponse(Object object){
       return new ResponseDTO(VeerAppConstants.OK, VeerAppConstants.SUCCESS, object);
    }

    public static ResponseDTO catchVeerAppError(VeerAppException e){
       return new ResponseDTO(e.getStatusCode(), e.getStatusMessage(), e.getResult());
    }

    public static ResponseDTO internalServerError(Object object){
        return new ResponseDTO(VeerAppConstants.INTERNAL_SERVER_ERROR, VeerAppConstants.ERROR, object);
    }

    public static ResponseDTO badRequestError(Object object){
        return new ResponseDTO(VeerAppConstants.BAD_REQUEST, VeerAppConstants.ERROR, object);
    }

    public static ResponseDTO standardError(Object object){
        return new ResponseDTO(VeerAppConstants.INTERNAL_SERVER_ERROR, VeerAppConstants.DEFAULT_MESSAGE, object);
    }

}
