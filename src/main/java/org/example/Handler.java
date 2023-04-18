package org.example;

import com.amazonaws.services.s3.model.ObjectListing;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.util.List;


public class Handler {
    private final S3Client s3Client;

    public Handler() {
        s3Client = DependencyFactory.s3Client();
    }

    public void sendRequest() {
        // TODO: invoking the api calls using s3Client.
        ListObjectsRequest listObjects = ListObjectsRequest.builder()
                .bucket("security-assignment")
                .build();
//                s3Client.listObjects("security-assignment");
        System.out.println("-----------------------START------------------------");
        System.out.println("The objects in the S3 bucket are as follows: ");
        ListObjectsResponse res = s3Client.listObjects(listObjects);
        List<S3Object> objects = res.contents();
        for(S3Object obj : objects){
            System.out.println(obj.key());
        }
        System.out.println("----------------------END---------------------------");
    }
}
