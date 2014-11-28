package com.ebay.happymock.core.binder;

import com.ebay.happymock.core.entity.MociResponse;
import com.ebay.happymock.core.entity.Response;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * User: jicui
 * Date: 14-9-2
 */
public class StatusBinder implements ResponseBinder {
    private static final Logger LOG = LoggerFactory.getLogger(StatusBinder.class);
    private Integer status;
    @Override
    public void write(Response response) {
          checkNotNull(status);
          response.setCode(status);
    }

    @Override
    public boolean bind(MociResponse response) {
        if(response.getStatus()!=null){
            this.status=Integer.valueOf(response.getStatus());
            return true;
        }
        return false;
    }
}
