package com.buydeem.booksserver.config;

import com.buydeem.common.constant.ResponseCode;
import com.buydeem.common.error.BaseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class IgnoreResponseWrapperDecoder implements Decoder {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        Type newType = createType(type);
        JavaType javaType = TypeFactory.defaultInstance().constructType(newType);
        com.buydeem.common.dto.Response<?> resp = mapper.readValue(response.body().asInputStream(), javaType);
        if (!ResponseCode.OK.getCode().equals(resp.getCode())){
            throw new BaseException(resp.getMessage());
        }
        return resp.getData();
    }

    private ParameterizedType createType(Type type){
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{type};
            }

            @Override
            public Type getRawType() {
                return com.buydeem.common.dto.Response.class;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }


}
