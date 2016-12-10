package com.olszi.model;

/**
 * Created by Siny on 2016-12-10.
 */
public class SearchRequest {

    private long initialStop;
    private long finalStop;

    public SearchRequest(){}

    public long getInitialStop() {
        return initialStop;
    }

    public void setInitialStop(int initialStop) {
        this.initialStop = initialStop;
    }

    public long getFinalStop() {
        return finalStop;
    }

    public void setFinalStop(int finalStop) {
        this.finalStop = finalStop;
    }
}
