package issnumberofppl;

import okhttp3.*;

public class ISSNumberOfPeople_API {
    private final static String BASE_URL = "http://api.open-notify.org/astros.json";

    public static void main(String[] args) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);

        Response response = call.execute();


    }

    public static String getJSON() throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);

        Response response = call.execute();

        return response.body().string();
    }
}
