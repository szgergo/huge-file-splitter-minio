import io.minio.MinioClient;
import okhttp3.OkHttpClient;

public class Main {

    public static void main(String... args)  {
        OkHttpClient okHttpClient = new OkHttpClient();
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://localhost:9000")
                        .httpClient(okHttpClient)
                        .credentials("nwldeyhEqmW6MGFx", "arXM8G1Y9IogGxLPuNhtss2mS2qXGNAF")
                        .build();

        try {
            minioClient.listBuckets();

            //If I uncomment the line below the applications shuts down correctly,
            // without waiting 10-20 seconds for ThreadPoolExecutors#Worker.run to exit.

            //okHttpClient.dispatcher().executorService().shutdown();

        } catch (Throwable e) {
            //Just an example app, don't care...
            throw new RuntimeException(e);
        }
    }
}
