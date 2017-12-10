package com.example.liaoli.officedemo;

/**
 * Created by liaoli on 2017/12/10.
 */

import com.google.protobuf.ExtensionRegistry;

import org.junit.Rule;

import java.io.IOException;
import java.util.List;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import okio.ByteString;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.protobuf.PhoneProtos;
import retrofit2.converter.protobuf.ProtoConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static retrofit2.converter.protobuf.PhoneProtos.Phone;

public class manager {
    interface Service {
        @GET("/")
        Call<Phone> get();

        @POST("/")
        Call<Phone> post(@Body Phone impl);

        @GET("/")
        Call<String> wrongClass();

        @GET("/")
        Call<List<String>> wrongType();
    }

    interface ServiceWithRegistry {
        @GET("/")
        Call<Phone> get();
    }

    @Rule
    public MockWebServer server = new MockWebServer();

    private Service service;
    private ServiceWithRegistry serviceWithRegistry;

    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(ProtoConverterFactory.create())
                .build();
        service = retrofit.create(Service.class);

        ExtensionRegistry registry = ExtensionRegistry.newInstance();
        PhoneProtos.registerAllExtensions(registry);
        Retrofit retrofitWithRegistry = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(ProtoConverterFactory.createWithRegistry(registry))
                .build();
        serviceWithRegistry = retrofitWithRegistry.create(ServiceWithRegistry.class);
    }

    public void serializeAndDeserialize() throws IOException, InterruptedException {
        ByteString encoded = ByteString.decodeBase64("Cg4oNTE5KSA4NjctNTMwOQ==");
        server.enqueue(new MockResponse().setBody(new Buffer().write(encoded)));

        Call<Phone> call = service.post(Phone.newBuilder().setNumber("(519) 867-5309").build());
        Response<Phone> response = call.execute();
        Phone body = response.body();

        RecordedRequest request = server.takeRequest();
        request.getBody().readByteString().equals(encoded);
        request.getHeader("Content-Type").equals("application/x-protobuf");
    }
}