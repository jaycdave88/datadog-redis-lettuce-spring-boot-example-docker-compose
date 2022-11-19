package com.rkdevblog.interceptors;

import datadog.trace.api.interceptor.TraceInterceptor;
import datadog.trace.api.interceptor.MutableSpan;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class RedisTraceInterceptor implements TraceInterceptor{    
    @Override
    public Collection<? extends MutableSpan> onTraceComplete(
        Collection<? extends MutableSpan> trace) {
        
        List<MutableSpan> filteredTrace = new ArrayList<>();
        for (final MutableSpan span : trace ){
            String redis_resource = (String) span.getResourceName().toString();

            if (!redis_resource.equals("EXISTS")){
                filteredTrace.add(span);
            }
        }

        return filteredTrace;
    }

    @Override
    public int priority() {
        // some high unique number so this interceptor is last
        return 1;
    }
}
