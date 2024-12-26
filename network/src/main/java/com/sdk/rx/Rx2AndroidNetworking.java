package com.sdk.rx;

public class Rx2AndroidNetworking {

    private Rx2AndroidNetworking() {
    }

    public static Rx2ANRequest.GetRequestBuilder get(String url) {
        return new Rx2ANRequest.GetRequestBuilder(url);
    }

    public static Rx2ANRequest.HeadRequestBuilder head(String url) {
        return new Rx2ANRequest.HeadRequestBuilder(url);
    }

    public static Rx2ANRequest.OptionsRequestBuilder options(String url) {
        return new Rx2ANRequest.OptionsRequestBuilder(url);
    }

    public static Rx2ANRequest.PostRequestBuilder post(String url) {
        return new Rx2ANRequest.PostRequestBuilder(url);
    }

    public static Rx2ANRequest.PutRequestBuilder put(String url) {
        return new Rx2ANRequest.PutRequestBuilder(url);
    }

    public static Rx2ANRequest.DeleteRequestBuilder delete(String url) {
        return new Rx2ANRequest.DeleteRequestBuilder(url);
    }

    public static Rx2ANRequest.PatchRequestBuilder patch(String url) {
        return new Rx2ANRequest.PatchRequestBuilder(url);
    }

    public static Rx2ANRequest.DownloadBuilder download(String url, String dirPath, String fileName) {
        return new Rx2ANRequest.DownloadBuilder(url, dirPath, fileName);
    }

    public static Rx2ANRequest.MultiPartBuilder upload(String url) {
        return new Rx2ANRequest.MultiPartBuilder(url);
    }

    public static Rx2ANRequest.DynamicRequestBuilder request(String url, int method) {
        return new Rx2ANRequest.DynamicRequestBuilder(url, method);
    }
}
