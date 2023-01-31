import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class ISSPass {



        private final static String BASE_URL = "https://open-notify-api.readthedocs.io/en/latest/iss_pass.html";

        public static void main(String[] args) throws Exception {
            Request request = new Request.Builder()
                    .url(BASE_URL)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Call call = client.newCall(request);

            Response response = call.execute();
            System.out.println(response.body().string());
        }
    }

